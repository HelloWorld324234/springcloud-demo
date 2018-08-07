package com.cloud.servicezuul.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: yule
 * @Date: 2018/8/7 0007 16:35
 * @Description:
 *
 * filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
 *      pre：路由之前
 *      routing：路由之时
 *      post： 路由之后
 *      error：发送错误调用
 *      filterOrder：过滤的顺序
 *      shouldFilter：这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
 *      run：过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
 *
 */
@Component
@Slf4j
public class MyFilter extends ZuulFilter {

    private static final String pre = "pre";

    @Override
    public String filterType() {
        return pre;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 添加拦截器
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        Object token = request.getParameter("token");
        if (null == token) {
            log.warn("token is empty");
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(401);
            try {
                currentContext.getResponse().getWriter().write("token is emtpy");
            } catch (Exception e) {

            }
        }
        log.info("ok");
        return null;
    }
}
