package com.spring.datasource.datasourceparent.configration;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName Interceptor
 * @Description TODO
 * @Author 刘海飞
 * @Date 2018/9/19 11:37
 * @Version 1.0
 **/
public class Interceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //1.获取请求路径
        String uri=request.getRequestURI();
        //2.获取请求参数(数据库编号)
        String code=request.getParameter("code");

        if (StringUtils.isEmpty(code)){
            throw new Exception("参数异常");
        }

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }
}
