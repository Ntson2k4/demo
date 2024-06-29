package com.example.demo.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ScopeController {
    @Autowired
    HttpServletRequest request;
    @Autowired
    HttpSession session;
    @Autowired
    ServletContext servletContext;
    @RequestMapping("/scope")
    public String scope(Model model){
        model.addAttribute("a","I am in model");
        request.setAttribute("b","I am in request scope");
        session.setAttribute("c","I am in Session scope");
        servletContext.setAttribute("d","I am in Application Scope");
        return "scope/index";
    }
}
