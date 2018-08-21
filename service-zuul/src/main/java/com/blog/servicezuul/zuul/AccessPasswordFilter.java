package com.blog.servicezuul.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: yule
 * @Date: 2018/8/16 0016 16:17
 * @Description:
 */
public class AccessPasswordFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return (boolean) RequestContext.getCurrentContext().get("isSuccess");
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();

        System.out.println(String.format("%s AccessTokenFilter request to %s", request.getMethod(),
                request.getRequestURL().toString()));

        String password = request.getParameter("password");

        if (null != password && password.equals("123456")) {
            currentContext.setSendZuulResponse(true);
            currentContext.setResponseStatusCode(200);
            currentContext.set("isSuccess", true);
            return null;
        } else {
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(401);
            currentContext.set("isSuccess", false);
            currentContext.setResponseBody("{\"result\":\"password is not correct!\"}");
            return null;
        }
    }
}
