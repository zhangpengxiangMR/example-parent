package com.pykj.springmvc.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/file")
public class FileHandler {

    @RequestMapping("/upload")
    public String upload(MultipartFile img, HttpServletRequest request) {
        if (img.getSize() > 0) {
            //获取保存上传文件的feil路径
            String path = request.getServletContext().getRealPath("file");
            //获取上传的文件名
            String name = img.getOriginalFilename();
            File file = new File(path, name);
            try {
                img.transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "upload";
    }

    @RequestMapping("/uploads")
    public String uploads(MultipartFile[] imgs, HttpServletRequest request) {
        List<String> list = new ArrayList<String>();
        for (MultipartFile img : imgs) {
            if (img.getSize() > 0) {
                //获取保存上传文件的feil路径
                String path = request.getServletContext().getRealPath("file");
                //获取上传的文件名
                String name = img.getOriginalFilename();
                File file = new File(path, name);
                try {
                    img.transferTo(file);
                    list.add("/file/" + name);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        request.setAttribute("files", list);
        return "uploads";
    }

    @GetMapping("/download/{name}")
    public void download(@PathVariable("name") String name, HttpServletRequest request, HttpServletResponse response) {
        if (!"".equals(name)) {
            name += ".png";
            String path = request.getServletContext().getRealPath("file");
            File file = new File(path, name);
            OutputStream outputStream = null;
            if (file.exists()) {
                response.setContentType("application/forc-download");
                response.setHeader("Content-Disposition", "attachment;filename=" + name);
                try {
                    outputStream = response.getOutputStream();
                    outputStream.write(FileUtils.readFileToByteArray(file));
                    outputStream.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }


}
