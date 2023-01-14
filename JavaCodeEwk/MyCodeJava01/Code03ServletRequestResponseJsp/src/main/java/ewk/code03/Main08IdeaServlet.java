package ewk.code03;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/*  创建Servlet的子类
    1.按模板创建Servlet的子类,修改以下代码:
    @WebServlet("/${Entity_Name}")
    this.doGet(request,response);
    2.模板位置: 设置-编辑器-文件与代码模板-其他-web-servlet annotated class.java
    3.新建servlet子类: 文件-项目结构-facet-源根打勾
 */

@WebServlet("/tests1")
public class Main08IdeaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
