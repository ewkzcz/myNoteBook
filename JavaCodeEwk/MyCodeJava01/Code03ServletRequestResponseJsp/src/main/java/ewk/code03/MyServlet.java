package ewk.code03;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class MyServlet implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        // 根据请求方式的不同分别处理
        //1.获取请求方式
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String method = httpServletRequest.getMethod();
        //2.判断并分别执行
        if("GET".equals(method)){
            doGet(servletRequest,servletResponse);
        }else if("POST".equals(method)){
            doPost(servletRequest,servletResponse);
        }
    }

    protected void doGet(ServletRequest servletRequest, ServletResponse servletResponse) {

    }

    protected void doPost(ServletRequest servletRequest, ServletResponse servletResponse) {

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
