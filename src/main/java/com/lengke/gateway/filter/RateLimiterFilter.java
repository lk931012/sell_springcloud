package com.lengke.gateway.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.lengke.gateway.exception.RateLimiterException;
import com.netflix.zuul.ZuulFilter;
import org.springframework.stereotype.Component;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SERVLET_DETECTION_FILTER_ORDER;

/**
 * @Auther : 冷科
 * @Date : 2019/4/18 02:06
 */
@Component
public class RateLimiterFilter extends ZuulFilter {
    private static final RateLimiter RATE_LIMITER = RateLimiter.create(100);   //每秒放100个令牌
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return SERVLET_DETECTION_FILTER_ORDER -1;  //限流的过滤顺序要是最高级别
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run(){
        if(!RATE_LIMITER.tryAcquire()){
            throw new RateLimiterException();      //如果未拿到令牌则抛出一个异常
        }
        return null;
    }
}
