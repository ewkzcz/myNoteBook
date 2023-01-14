package ewk.code03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/* Servlet urlPattern配置规则
    1.精确匹配
    2.目录匹配: "/user/*"
    3.扩展名匹配: "*.do"
    4.任意匹配: "/","/*"
    优先级: 精确路径>目录路径>扩展名路径>"/*">"/"
    可以多个规则一起配置
 */

@WebServlet(urlPatterns = {"/test3","/test4"})
// @WebServlet(urlPatterns = "/user/*")
// @WebServlet(urlPatterns = "/*.html")
// @WebServlet(urlPatterns = "/*")
// @WebServlet(urlPatterns = "/")
public class Main04urlPattern配置 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get more...");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post more...");
    }
}
