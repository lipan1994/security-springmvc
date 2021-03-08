package com.llicat.interceptor;

import com.llicat.model.UserDto;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author: lipan
 * @date: 2021/2/17 20:06
 */
@Component
public class SimpleAuthenticationInterceptor implements HandlerInterceptor {


    /**
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if(null==request.getSession().getAttribute(UserDto.SESSION_USER_KEY)){
              writeContent(response,"请登录!");
              return false;
        }
        UserDto user = (UserDto) request.getSession().getAttribute(UserDto.SESSION_USER_KEY);
        //请求的url
        String requestURI = request.getRequestURI();
        if (user.getAuthorities().contains("p1") && requestURI.contains("/r1")) {
            return true;
        }
        if (user.getAuthorities().contains("p2") && requestURI.contains("/r2")) {
            return true;
        }
        writeContent(response, "权限不足，拒绝访问");
        return false;
    }


    //响应输出
    private void writeContent(HttpServletResponse response, String msg) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print(msg);
        writer.close();
        response.resetBuffer();
    }
}
