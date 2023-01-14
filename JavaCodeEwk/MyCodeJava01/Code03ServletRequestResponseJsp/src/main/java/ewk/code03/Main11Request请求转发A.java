package ewk.code03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
请求转发实现方式: getRequestDispatcher,forward
请求转发资源间共享数据: setAttribute,getAttribute,removeAttribute
请求转发特点: 路径不变,转发发生在服务器内部,转发是一次请求
 */
@WebServlet("/A")
public class Main11Request请求转发A extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("A");
        req.setAttribute("msg", "hello");
        req.getRequestDispatcher("/B").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
