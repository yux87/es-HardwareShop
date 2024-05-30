package com.yux.shoppingmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebPageController {
    @GetMapping("/login")
    public String LoginPage() {
        return "login";
    }
    @GetMapping("/index2")
    public String Index2Page() {
        return "index2";
    }
    @GetMapping("/admin")
    public String AdminPage() {
        return "admin";
    }
    @GetMapping("/order-detail")
    public String OrderDetailPage() {
        return "orderPage";
    }
    @GetMapping("/hello-page")
    public String HelloPage() {
        return "hello";
    }
}
