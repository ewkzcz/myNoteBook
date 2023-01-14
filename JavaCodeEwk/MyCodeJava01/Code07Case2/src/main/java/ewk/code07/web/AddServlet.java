package ewk.code07.web;

import com.alibaba.fastjson.JSON;
import ewk.code07.data.Brand;
import ewk.code07.service.BrandServiceInterface;
import ewk.code07.service.serviceclass.BrandServiceClass;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
    private BrandServiceInterface brandService = new BrandServiceClass();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.接收JSON数据
        req.setCharacterEncoding("UTF-8");
        BufferedReader bufferedReader =req.getReader();
        String params = bufferedReader.readLine();
        // 2.转为Brand对象
        Brand brand = JSON.parseObject(params,Brand.class);
        // 3.调用service添加到数据库
        brandService.add(brand);
        // 4.响应成功标识
        resp.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
