package ewk.code05;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

@WebServlet("/cookie2")
public class Main01CookieB extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取Cookie
        Cookie[] cookies = req.getCookies();
        for(Cookie cookie1:cookies){
            String name = cookie1.getName();
            if("username".equals(name)){
                String value = cookie1.getValue();
                value = URLDecoder.decode(value,"UTF-8");  // 对于中文需要解码
                System.out.println(name+"="+value);
                break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
