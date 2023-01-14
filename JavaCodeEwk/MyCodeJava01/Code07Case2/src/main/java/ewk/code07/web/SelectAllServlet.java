package ewk.code07.web;

import com.alibaba.fastjson.JSON;
import ewk.code07.data.Brand;
import ewk.code07.service.BrandServiceInterface;
import ewk.code07.service.serviceclass.BrandServiceClass;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {
    private BrandServiceInterface brandService = new BrandServiceClass();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.调用service查询数据库
        List<Brand> brands = brandService.selectAll();
        // 2,转为JSON字符串
        String s = JSON.toJSONString(brands);
        // 3,写数据到客户端
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(s);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
