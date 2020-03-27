package com.pykj.exemple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/file")
public class FileHandler {

    @RequestMapping("/upload")
    public String upload(MultipartFile img, HttpServletRequest request){
        if(img.getSize() > 0 ){
            //获取保存上传文件的feil路径
            String path  = request.getServletContext().getRealPath("file");
            //获取上传的文件名
            String name = img.getOriginalFilename();
            File file = new File(path,name);
            try {
                img.transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "upload";
    }

    @RequestMapping("/uploads")
    public String uploads(MultipartFile[] imgs, HttpServletRequest request){
        List<String> list = new ArrayList<String>();
        for (MultipartFile img :imgs) {
            if(img.getSize() > 0 ){
                //获取保存上传文件的feil路径
                String path  = request.getServletContext().getRealPath("file");
                //获取上传的文件名
                String name = img.getOriginalFilename();
                File file = new File(path,name);
                try {
                    img.transferTo(file);
                    list.add("/file/" + name);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        request.setAttribute("files",list);
        return "uploads";
    }

}
