package com.yux.shoppingmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebPageController {
    @GetMapping("/order-detail")
    public String OrderDetailPage() {
        return "orderPage";
    }
    @GetMapping("/hello-page")
    public String HelloPage() {
        return "hello";
    }
}
