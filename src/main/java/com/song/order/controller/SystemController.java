package com.song.order.controller;

import com.song.order.common.VerifyCodeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.OutputStream;

@Controller
@RequestMapping("/sys")
public class SystemController {

    @RequestMapping("/vcode")
    public void verifyCode(HttpServletRequest request, HttpServletResponse response) {
        OutputStream os = null;
        try {
            os=response.getOutputStream();
            response.setContentType("image/png");
            String vCode = VerifyCodeUtils.generateVerifyCode(4,"0123456789");
            VerifyCodeUtils.outputImage(69,28,os,vCode, new Color(255, 224, 189));
            if(os!=null){
                os.close();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
