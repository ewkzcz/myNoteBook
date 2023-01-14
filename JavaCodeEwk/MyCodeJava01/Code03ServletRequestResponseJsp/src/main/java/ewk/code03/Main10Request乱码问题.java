package ewk.code03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/* 乱码怎么解决
在pom文件的tomcat插件配置中，加上编码字符集的设置: <uriEncoding>UTF-8</uriEncoding>
设置-构建-构建工具-maven-运行程序: -DarchetypeCatalog=internal -Dfile.encoding=gbk
 */

@WebServlet("/tests2")
public class Main10Request乱码问题 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");  // 解决POST的乱码,设置流的编码
        String username = req.getParameter("username");
        System.out.println(username);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
