package ewk.code05;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/*
cookie原理: 基于HTTP协议(请求头cookie,响应头set-cookie)
cookie存活时间: 默认存储在浏览器内存中,当浏览器关闭时内存释放并销毁
设置cookie存活时间: setMaxAge(int seconds)  // 正数持久化存储,负数默认关闭时销毁,0表示删除对应cookie
cookie存储中文: cookie不支持直接储存中文,可以通过转码储存
 */
@WebServlet("/cookie1")
public class Main01CookieA extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置cookie
        Cookie cookie = new Cookie("username", "lisa");

        // 设置最大存活时间
        cookie.setMaxAge(60*60*24*7);  // 7days

        // 设置编码
        String value = "张三";
        value = URLEncoder.encode(value,"UTF-8");
        cookie = new Cookie("username", value);
        System.out.println("储存数据"+value);

        // 发送cookie
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
