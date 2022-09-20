/**
 * Class to control number of requests per second from one user
 * @author Ryhor Pishchyk
 * */

package com.epam.controller.filter;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Component
public class RequestFilter implements Filter {

    /*Field number of requests per second*/
    private static final int MAX_REQUESTS_PER_SECOND = 0;

    /**Field number of requests*/
    private final LoadingCache<String, Integer> requestCountsPerIpAddress;

    /**
     * Constructor for creating object
     * */
    public RequestFilter() {
        super();
        requestCountsPerIpAddress = Caffeine.newBuilder()
                .expireAfterWrite(1, TimeUnit.SECONDS)
                .build(key -> 0);
    }

    @Override
    public void init(FilterConfig filterConfig) {}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        String clientIpAddress = getClientIP((HttpServletRequest) servletRequest);
        if (isMaximumRequestsPerSecondExceeded(clientIpAddress)){
            httpServletResponse.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
            httpServletResponse.getWriter().write("Too many requests");
            return;
        }
        filterChain.doFilter(request, servletResponse);
    }

    /**
     * Method to check number of maximum requests
     * @param clientIpAddress - current IP of user
     * */
    private boolean isMaximumRequestsPerSecondExceeded(String clientIpAddress){
        Integer requests = requestCountsPerIpAddress.get(clientIpAddress);
        if(requests != null){
            if(requests > MAX_REQUESTS_PER_SECOND) {
                requestCountsPerIpAddress.asMap().remove(clientIpAddress);
                requestCountsPerIpAddress.put(clientIpAddress, requests);
                return true;
            }
        } else {
            requests = 0;
        }

        requests++;
        requestCountsPerIpAddress.put(clientIpAddress, requests);
        return false;
    }

    /**
     * Getting user IP
     * @param request - HttpServletRequest
     * @return client IP
     * */
    public String getClientIP(HttpServletRequest request) {
        String xfHeader = request.getHeader("X-Forwarded-For");
        if (xfHeader == null){
            return request.getRemoteAddr();
        }
        return xfHeader.split(",")[0];
    }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException();
    }
}