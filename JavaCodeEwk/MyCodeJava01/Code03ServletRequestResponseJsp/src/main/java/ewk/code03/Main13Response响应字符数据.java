package ewk.code03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*  Response响应字符/字节数据
resp.getWriter(): 获取字符流(Response获取的字符流默认编码为ISO-8859-1)
resp.setContentType(): 设置获取流的解析格式/编码
 */
@WebServlet("/C")
public class Main13Response响应字符数据 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.设置获取字符流的编码
        resp.setContentType("text/html;charset=utf-8");

        // 2.获取字符输出流
        PrintWriter writer = resp.getWriter();  // 自动关闭
        // resp.setHeader("content-type","text/html");  // 将获取解析为HTML
        writer.write("你好");
        writer.write("<h1>hello</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
