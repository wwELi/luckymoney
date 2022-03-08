package com.example.luckymoney;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class WebConfigController {

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("title", "login");
        System.out.println("--------------------");
        return "index";
    }
}
