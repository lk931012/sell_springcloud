package com.lengke.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * @Auther : 冷科
 * @Date : 2019/4/18 01:19
 */
@Component
public class TokenFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return PRE_TYPE;       //类型 pre
    }

    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER -1;    //过滤顺序
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 具体过滤逻辑
     * 如果路径路径中没有token参数就访问失败
     */
    @Override
    public Object run() throws ZuulException {
        //获取当前请求
        RequestContext requestContext =  RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        //获取路径中的token参数,一般可以从路径 ,head,   cookies 中获取
        String token = request.getParameter("token");
        if(StringUtils.isEmpty(token)){
            requestContext.setSendZuulResponse(false);   //响应失败
            requestContext.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);//设置状态码401
        }
        return null;
    }
}
