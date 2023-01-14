package ewk.code03;

import org.apache.commons.io.IOUtils;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/D")
public class Main14Response响应字节数据 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.读取文件
        FileInputStream fileInputStream = new FileInputStream("E:\\CodeJava\\MyCodeJava01\\Code03\\src\\main\\webapp\\html\\1.jpg");

        // 2.获取response字节输出流
        ServletOutputStream outputStream = resp.getOutputStream();

        // 3.完成流的copy
        /*
        byte[] bytes = new byte[1024 * 1024];
        int len = 0;
        while ((len = fileInputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, len);
        }
         */
        // apache IOUtils.copy(I/O便捷工具类方法): 将输入字节流拷贝到字节输出流
        IOUtils.copy(fileInputStream,outputStream);  // 使用坐标依赖,注意导包apache
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
