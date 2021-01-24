/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.demo.web.spring01.controllers;

import com.java.demo.web.spring01.dto.Product;
import com.java.demo.web.spring01.model.ProductModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author hoangnghiem
 */
@Controller
public class ProductController {

    @RequestMapping("/product/{id}")
    public String showProductDetail(@PathVariable(name = "id") String id, Model model, @SessionAttribute("user") String user) {
        try {
            
            // kiểm tra session user có tồn tài kho?
            // nếu tồn tại thì ok
            // nếu không tồn tịa thì bay về trang login
            
            if (user != null && !user.equals("")) { // tức là ng dùng đã login
                System.out.println("VIEW PRODUCT " + id);
    //            System.out.println("USER", );
                System.out.println(user);
                ProductModel prodModel = new ProductModel();
                Product prod = prodModel.findById(Integer.parseInt(id));
                model.addAttribute("prod", prod);    
                return "product";
            } else {
                return "redirect:/login";
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "redirect:/";
    }
}
