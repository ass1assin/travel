package com.example.controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;

@RestController
public class UploadController {

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "请选择要上传的文件";
        }
        try {
            // 获取静态资源目录的绝对路径
            String staticPath = ResourceUtils.getFile("classpath:static").getAbsolutePath();
            // 构建文件保存路径
            String filePath = staticPath + File.separator + "img" + File.separator + file.getOriginalFilename();
            File dest = new File(filePath);
            // 将文件保存到指定路径
            file.transferTo(dest);
            return "图片上传成功";
        } catch (IOException e) {
            e.printStackTrace();
            return "图片上传失败";
        }
    }
}
