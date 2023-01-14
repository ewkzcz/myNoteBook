package ewk.code07.web;

import com.alibaba.fastjson.JSON;
import ewk.code07.data.Brand;
import ewk.code07.data.Page;
import ewk.code07.service.BrandServiceInterface;
import ewk.code07.service.serviceclass.BrandServiceClass;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/selectByPageServlet")
public class SelectByPageServlet extends HttpServlet {
    private BrandServiceInterface brandService = new BrandServiceClass();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.接收: 当前页码和每页展示条数
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);
        // 2.查询
        Page<Brand> page = brandService.selectByPage(currentPage,pageSize);
        // 3.转为JSON对象
        String jsonStr = JSON.toJSONString(page);
        // 4.写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonStr);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
