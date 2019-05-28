package com.wxy.controller;

import com.wxy.pojo.UploadUtils;
import com.wxy.pojo.Users;
import com.wxy.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class UploadController {
    @Autowired
    UsersService usersService;

    @PostMapping("/upload")
    public String upload(MultipartFile file, HttpSession session) throws IOException {

        //获取文件的内容
        InputStream is = file.getInputStream();
        //获取原始文件名
        String originalFilename = file.getOriginalFilename();

        //生成一个uuid名称出来
        String uuidFilename = UploadUtils.getUUIDName(originalFilename);

        //产生一个随机目录
        String randomDir = UploadUtils.getDir();

        File fileDir = new File("D:/uploadfiles" + randomDir);
        //若文件夹不存在,则创建出文件夹
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }
        //创建新的文件夹
        File newFile = new File("D:/uploadfiles" + randomDir, uuidFilename);
        //将文件输出到目标的文件中
        file.transferTo(newFile);

        //将保存的文件路径更新到用户信息headimg中
        String savePath = randomDir + "/" + uuidFilename;

        //获取当前的user
        Users users = (Users) session.getAttribute("users");
        //设置头像图片路径
        users.setAvatar(savePath);

        //调用业务更新user
        usersService.update(users);
        //生成响应 : 跳转去用户详情页面
        return "redirect:/student/userInfo";
    }

    @Autowired
    ResourceLoader resourceLoader;

    @GetMapping("/get/{dir1}/{dir2}/{filename:.+}")
    public ResponseEntity get(@PathVariable String dir1,
                              @PathVariable String dir2,
                              @PathVariable String filename)
    {
        System.out.println("进入到get方法000000000000000000");
        //1.根据用户名去获取相应的图片
        Path path = Paths.get("D:/uploadfiles" + "/" + dir1 + "/" + dir2, filename);
        //2.将文件加载进来
        Resource resource = resourceLoader.getResource("file:" + path.toString());
        //返回响应实体
        return ResponseEntity.ok(resource);
    }
}