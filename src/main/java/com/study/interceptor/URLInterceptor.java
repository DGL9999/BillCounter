package com.study.interceptor;


import com.study.sys.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * URL拦截器
 * @author Deja wu
 * */
public class URLInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flag = true;
        String loginname = request.getParameter("loginname");
        //从request中获取前端传来的表单数据
        String pwd = request.getParameter("pwd");
        String uri = request.getRequestURI();
        User user = (User) request.getSession().getAttribute("user");
        if (!uri.contains("login")){
            //如果请求页面不是login,且session中没有user，重定向回登录页面
            if (user == null){
                response.sendRedirect("/login/toLogin");
                flag = false;
            }
        }else if (uri.contains("login/login")){
            //如果客户直接请求登录，直接重定向回登录页面
            if (loginname==null||pwd==null){
                 response.sendRedirect("/login/toLogin");
                flag = false;
            }
        }else {
            //如果session中有user，直接放行
            if (user!=null){
                response.sendRedirect("/bills/toBillsList");
                flag =true;
            }
        }
        return flag;
    }

}
