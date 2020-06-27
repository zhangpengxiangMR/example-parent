package com.pykj.tomcat.upload;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@WebServlet("/upload")
public class UploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       /* //通过输入流获取客户端传来的数据流
        InputStream inputStream = req.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        //通过输入流将数据流保存到本地磁盘
        //获取文件夹的绝对路径
        String path = req.getServletContext().getRealPath("/file");

        FileOutputStream outputStream = new FileOutputStream(new File(path,"copy.txt"));
        Writer writer = new OutputStreamWriter(outputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        String str = "";
        while ((str = bufferedReader.readLine()) != null) {
            bufferedWriter.write(str);
        }
        bufferedWriter.close();
        writer.close();
        outputStream.close();
        bufferedReader.close();
        inputStreamReader.close();
        inputStream.close();*/
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
            List<FileItem> fileItemList = servletFileUpload.parseRequest(req);
            for (FileItem fileItem : fileItemList) {
                if (fileItem.isFormField()) {
                    String name = fileItem.getFieldName();
                    String value = fileItem.getString("UTF-8");
                    System.out.println(name + "-" + value);
                } else {
                    String fileName = fileItem.getName();
                    inputStream = fileItem.getInputStream();
                    String path = req.getServletContext().getRealPath("/file/" + fileName);
                    outputStream = new FileOutputStream(path);
                    byte[] bytes = new byte[1024];
                    int count = inputStream.read(bytes);
                    while (count != -1) {
                        outputStream.write(bytes, 0, count);
                        outputStream.flush();
                        count = inputStream.read(bytes);
                    }
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
