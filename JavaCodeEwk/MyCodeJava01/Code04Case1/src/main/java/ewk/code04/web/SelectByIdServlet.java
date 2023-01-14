package ewk.code04.web;

import ewk.code04.data.Brand;
import ewk.code04.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectByIdServlet")
public class SelectByIdServlet extends HttpServlet {
    private BrandService brandService = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.接收id
        String id = request.getParameter("id");
        // 2.调用service查询
        Brand brand = brandService.selectById(Integer.parseInt(id));
        // 3.存储到request对象中
        request.setAttribute("brand",brand);
        // 4.转发
        request.getRequestDispatcher("/update.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
