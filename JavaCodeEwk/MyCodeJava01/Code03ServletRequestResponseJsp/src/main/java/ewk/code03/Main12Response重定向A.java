package ewk.code03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*  重定向特点
浏览器地址栏路径发生变化
可以重定向到任意位置(服务器内部外部均可)
两次请求,不能在多个资源使用request共享数据
 */

/* 路径问题
服务器使用: 不需要加虚拟目录
浏览器使用: 需要加虚拟目录
<path>/</path>: 设置后插件tomcat不再需要虚拟目录
动态获取虚拟目录: req.getContextPath()
 */
@WebServlet("/A1")
public class Main12Response重定向A extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("A...");

        // 1.设置响应状态码302: 表示当前资源无法处理,需要重定向
        resp.setStatus(302);

        // 2.设置响应状态头: resp.setHeader("Location","/B1");
        resp.sendRedirect(req.getContextPath() + "/B1");  // 动态获取虚拟目录
        resp.sendRedirect("http://www.baidu.com");  // 重定向到服务器外部
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
