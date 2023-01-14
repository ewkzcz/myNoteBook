package ewk.code05;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/hello.jsp")  // 拦截所有资源
public class Main05过滤器链 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("2.Filter...");
        filterChain.doFilter(servletRequest,servletResponse);  // 放行
        System.out.println("3.Filter...");
    }

    @Override
    public void destroy() {

    }
}