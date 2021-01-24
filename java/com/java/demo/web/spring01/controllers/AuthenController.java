/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.demo.web.spring01.controllers;

import com.java.demo.web.spring01.db.DBConnector;
import com.java.demo.web.spring01.dto.Customers;
import com.java.demo.web.spring01.dto.RegisterInfo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author hoangnghiem
 */
@Controller
public class AuthenController {

    @RequestMapping("/register")
    public String register(Model model) {
        
        RegisterInfo registerInfo = new RegisterInfo("sample@gmail.com", "Nguyen Van A", "", "ha noi");
        model.addAttribute("registerInfo", registerInfo);
        return "register";
    }
    
    @RequestMapping("/handle_register")
    public String handleRegister(@ModelAttribute RegisterInfo registerInfo, Model model, HttpServletResponse response) {
        
        //TODO
        // - lấy dữ liệu từ form gửi lên.
        System.out.println("Email: " + registerInfo.getEmail());
        System.out.println("Passw: " + registerInfo.getPassword());
        
        // - xử lý dữ liệu
        //       xác thực dữ liêu, mã hóa dữ liệu, lưu vào db
        
        Cookie cookie = new Cookie("email", registerInfo.getEmail());
        response.addCookie(cookie);
        // - trả về view
        return "redirect:/login";
    }
}
