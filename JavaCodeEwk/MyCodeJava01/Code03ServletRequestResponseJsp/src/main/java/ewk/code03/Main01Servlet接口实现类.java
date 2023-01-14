package ewk.code03;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;

// @WebServlet("/test1")
@WebServlet(urlPatterns = "/test1",loadOnStartup = 1)
public class Main01Servlet接口实现类 implements Servlet {
    ServletConfig servletConfig;

    /* 1.初始化方法
    调用时机: Servlet被第一次访问时调用
    调用次数: 一次
    (刷新后不会被重复调用)
    初始化方法调用时机的修改:
    1.1 @WebServlet(urlPatterns = "/test",loadOnStartup = 1)
    1.2 默认值-1(负整数)表示第一次被访问时调用,1(非负整数)表示服务器启动时调用
     */
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
        System.out.println("init...");
    }

    /* 2.提供服务
    调用时机: Servlet每一次被访问时调用
    调用次数: 多次
    (刷新后会被重复调用)
     */
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("servlet hello world...");

        // 根据请求方式的不同分别处理
        //1.获取请求方式
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String method = httpServletRequest.getMethod();
        //2.判断并分别执行
        if("GET".equals(method)){

        }else if("POST".equals(method)){

        }
    }

    /* 3.销毁方法
    调用时机: 内存释放或服务器关闭(正常关闭而不是强制关闭)
    调用次数: 一次
    通过命名行窗口启动tomcat服务并关闭,观察输出:
    E:
    cd 当前项目目录
    mvn tomcat7:run
    Ctrl+C: 正常关闭
     */
    public void destroy() {
        System.out.println("destroy...");
    }

    // 获取ServletConfig对象
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    // 获取Servlet信息,返回Servlet配置对象
    public String getServletInfo() {
        return null;
    }
}
