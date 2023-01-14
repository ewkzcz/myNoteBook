package ewk.code05;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/*
session原理: 基于cookie实现
session钝化: 服务器正常关闭后,tomcat自动将session数据写入磁盘
session活化: 再次启动服务器后,从文件中加载数据到session中(浏览器不能关闭)
session销毁: 默认30分钟无操作销毁,可以在web.xml中修改,可以调用invalidate方法
  <session-config>
    <session-timeout>30</session-timeout>
  </session-config>
 */
@WebServlet("/session1")
public class Main02SessionA extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取session对象
        HttpSession session = req.getSession();
        System.out.println(session);
        // 储存数据
        session.setAttribute("username","zs");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
