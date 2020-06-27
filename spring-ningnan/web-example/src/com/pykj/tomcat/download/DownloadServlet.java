package com.pykj.tomcat.download;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OutputStream outputStream = null;
        InputStream inputStream = null;
        try {
            //设置响应方式
            resp.setContentType("application/X-msdownload");
            String fileName = "20200303205702.jpg";
            //设置下载之后的文件名
            resp.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            //获取输出流
            outputStream = resp.getOutputStream();
            String path = req.getServletContext().getRealPath("/file/" + fileName);
            inputStream = new FileInputStream(path);
            byte[] bytes = new byte[1024];
            int count = inputStream.read(bytes);
            while (count != -1) {
                outputStream.write(bytes, 0, count);
                outputStream.flush();
                count = inputStream.read(bytes);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            outputStream.close();


        }

    }
}
