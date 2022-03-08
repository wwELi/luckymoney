package com.example.luckymoney.controller;

import com.example.luckymoney.config.LimitConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class HelloWordController {

    @Value("${desc}")
    private String desc;

    @Autowired
    private LimitConfig limitConfig;

    @GetMapping("/hello")
    private String say() {
        return "say：" + desc + limitConfig.getMax();
    }

    @GetMapping("/test")
    private void testValid(@RequestParam String id) {
        System.out.println("id is:" + id);
    }
}
