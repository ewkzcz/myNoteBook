package ewk.code05;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/*
Filter拦截
 定义类,实现Filter接口
 配置Filter的拦截路径(注解方法)
 重新方法
Filter拦截路径配置
 拦截具体资源
 目录拦截
 后缀名拦截
 拦截所有
Filter过滤器链
 分层拦截
 */
@WebFilter("/*")  // 拦截所有资源
public class Main04Filter过滤器 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String url = request.getRequestURL().toString();
        if (url.equals("http://localhost:8080/")) {
            System.out.println("...");
            filterChain.doFilter(servletRequest, servletResponse);  // 放行
            return;
        }
        System.out.println("1.Filter...");
        filterChain.doFilter(servletRequest, servletResponse);  // 放行
        System.out.println("4.Filter...");
    }

    @Override
    public void destroy() {

    }
}
