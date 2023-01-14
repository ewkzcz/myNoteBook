package ewk.code04.web;

import ewk.code04.data.Brand;
import ewk.code04.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {
    private BrandService service = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // POST乱码
        request.setCharacterEncoding("utf-8");

        // 1.接收表单提交的数据,封装为Brand对象
        String id = request.getParameter("id");
        String brandName = request.getParameter("brandName");
        String enterpriseName = request.getParameter("enterpriseName");
        String introduce = request.getParameter("introduce");
        Brand brand = new Brand(Integer.parseInt(id),brandName,enterpriseName,introduce);

        // 2.调用service,完成修改
        service.update(brand);

        // 3.转发到查询所有
        request.getRequestDispatcher("/selectAllServlet").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
