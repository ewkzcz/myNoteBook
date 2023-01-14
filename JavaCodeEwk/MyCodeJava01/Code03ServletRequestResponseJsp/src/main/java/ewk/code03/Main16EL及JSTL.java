package ewk.code03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*  EL表达式
1.JavaWeb四大域对象:
page,request,session,application(EL表达式获取数据,依次从4个域中寻找,直到找到为止)

2.EL乱码的解决(JSP文件中): isELIgnored="false"

3.<c:if>标签的使用
3.1 导入坐标jstl
    <!-- jstl标签库(c:if,c:forEach...) -->
    <dependency>
      <groupId>jstl</groupId>
      <artifactId>jstl</artifactId>
      <version>1.2</version>
    </dependency>
    <!-- taglib库: 始终与jstl一起 -->
    <dependency>
      <groupId>taglibs</groupId>
      <artifactId>standard</artifactId>
      <version>1.1.2</version>
    </dependency>
3.2 JSP页面上引入JSTL标签库
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
3.3 JSP页面上使用<c:if>
(standard.jar和jstl.jar: 标准标签库,用于EL表达式和JSTL标签使用)

4. <c:forEach>(相当于for循环)
items: 被遍历的容器
var: 遍历产生的临时变量
 */

@WebServlet("/main")
public class Main16EL及JSTL extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.模拟数据库中的数据
        List<Data> dataList = new ArrayList<Data>();
        dataList.add(new Data(1001,"张三",20,"2002-01-01"));
        dataList.add(new Data(1002,"李四",21,"2001-01-01"));
        dataList.add(new Data(1003,"王五",22,"2000-01-01"));
        // 2.存储到request对象中
        req.setAttribute("dataList",dataList);
        req.setAttribute("status",1);
        // 3.转发到jsp页面上
        req.getRequestDispatcher("/dataShow.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
