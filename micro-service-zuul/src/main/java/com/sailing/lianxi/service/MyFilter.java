package com.sailing.lianxi.service;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;


/**
 * 
 * @author Administrator
 * run：过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
 */
@Component
public class MyFilter extends ZuulFilter{

	private static Logger logger = LoggerFactory.getLogger(MyFilter.class);
	
	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		 
		System.out.println("通过自定义过滤器:"+String.format("%s AccessTokenFilter request to %s", request.getMethod(),
				request.getRequestURL().toString()));
		
		logger.info("通过自定义MyFilter过滤器{},{}", request.getMethod(),request.getRequestURL().toString());
		String accessToken =  request.getParameter("token");
		if(null==accessToken) {
			logger.warn("token is empty");
			ctx.setSendZuulResponse(false);//令zuul过滤该请求，不对其进行路由
			ctx.setResponseStatusCode(401);//设置了其返回的错误码
			ctx.setResponseBody("token is empty");//返回body内容
		    ctx.set("isSuccess", false);
			try {
				ctx.getResponse().getWriter().write("token is empty");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			ctx.setSendZuulResponse(true); //对请求进行路由
            ctx.setResponseStatusCode(200);
            ctx.set("isSuccess", true);
		}
		return null;
	}

	/**
	 这里可以写逻辑判断，是否要过滤，本文true,永远过滤
	 * @return
	 */
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * filterOrder：过滤的顺序
	 * filter执行顺序，通过数字指定 ,优先级为0，数字越大，优先级越低
	 * @return
	 */
	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
	 * pre：路由之前
	 * routing：路由之时
	 * post： 路由之后
	 * error：发送错误调用
	 * @return
	 */
	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

	
	/**
     * 获取Ip地址
     * @param request
     * @return
     */
    public  String getIpAddr(HttpServletRequest request){
 
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
