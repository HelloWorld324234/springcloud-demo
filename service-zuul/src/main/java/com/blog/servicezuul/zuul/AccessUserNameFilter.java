package com.blog.servicezuul.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: yule
 * @Date: 2018/8/16 0016 14:50
 * @Description:
 */
public class AccessUserNameFilter extends ZuulFilter {
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
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        System.out.println(String.format("%s AccessTokenFilter request to %s", request.getMethod(),
                request.getRequestURL().toString()));

        String username = request.getParameter("username");

        if (null != username && username.equals("admin")) {
            ctx.setSendZuulResponse(true);
            ctx.setResponseStatusCode(200);
            ctx.set("isSuccess", true);
            return null;
        } else {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.set("isSuccess", false);
            System.err.println(ctx.toString());
            ctx.setResponseBody("{\"result\":\"username is not correct!\"}");
            return null;
        }

    }
}
