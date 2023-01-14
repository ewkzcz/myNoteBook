package ewk.code07.web;

import com.alibaba.fastjson.JSON;
import ewk.code07.service.BrandServiceInterface;
import ewk.code07.service.serviceclass.BrandServiceClass;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {
    private BrandServiceInterface brandService = new BrandServiceClass();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.接收JSON数据
        request.setCharacterEncoding("UTF-8");
        BufferedReader bufferedReader =request.getReader();
        String params = bufferedReader.readLine();
        // 2.转为int[]对象
        int[] ids = JSON.parseObject(params,int[].class);
        // 3.调用service添加到数据库
        brandService.deleteByIds(ids);
        // 4.响应成功标识
        response.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
