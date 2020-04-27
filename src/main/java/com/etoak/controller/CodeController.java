package com.etoak.controller;

import com.etoak.commons.VerifyCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
public class CodeController {
    @GetMapping("/code")
    public void code(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //创建验证码对象
        VerifyCode verifyCode = new VerifyCode();
        //huoqv tupian  写道前端页面
        BufferedImage image = verifyCode.getImage();
        //图片表达式结果
        int result = verifyCode.getResult();
        //将验证码图片上得计算结果保存到session中
        request.getSession().setAttribute("code",result);
        //向前段些图片
        response.setHeader("Pragma","No-Cache");
        response.setHeader("Cache-Control","No-Cache");
        response.setDateHeader("Expires",0);


        response.setContentType("image/jpeg");
        ImageIO.write(image,"JPEG",response.getOutputStream());
    }
}
