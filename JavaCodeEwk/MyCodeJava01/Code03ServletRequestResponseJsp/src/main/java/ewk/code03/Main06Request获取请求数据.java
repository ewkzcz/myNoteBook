package ewk.code03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/test6")
public class Main06Request获取请求数据 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* 请求行,请求头
        获取虚拟目录/项目访问路径: 此处无
        获取GET请求参数: 例如 http://localhost:1234/test6?username=zhangsan 返回 username=zhangsan
         */

        // 获取虚拟目录/项目访问路径
        // String contextPath = req.getContextPath();
        // System.out.println(contextPath);

        // 获取请求方式
        String method = req.getMethod();
        System.out.println(method);

        // 获取统一资源定位符(URL)
        StringBuffer url = req.getRequestURL();
        System.out.println(url);

        // 获取统一资源标识符(URI)
        String uri = req.getRequestURI();
        System.out.println(uri);

        // 获取GET请求参数(username等): 与post不同
        String queryString = req.getQueryString();
        System.out.println(queryString);

        // 获取请求头(user-agent浏览器版本信息)
        String agent = req.getHeader("user-agent");
        System.out.println(agent);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求方式
        String method = req.getMethod();
        System.out.println(method);

        // 获取统一资源定位符(URL)
        StringBuffer url = req.getRequestURL();
        System.out.println(url);

        // 获取统一资源标识符(URI)
        String uri = req.getRequestURI();
        System.out.println(uri);

        // 获取请求头(user-agent浏览器版本信息)
        String agent = req.getHeader("user-agent");
        System.out.println(agent);

        // 获取post请求体: 与get不同
        BufferedReader bufferedReader = req.getReader();
        String line = bufferedReader.readLine();
        System.out.println(line);
    }
}
