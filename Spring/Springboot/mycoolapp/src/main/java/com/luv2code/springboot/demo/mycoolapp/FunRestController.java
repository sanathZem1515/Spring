package com.luv2code.springboot.demo.mycoolapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class FunRestController
{
    @GetMapping("/")
    public String sayHello()
    {
        return "hello world Time on server is "+ LocalDateTime.now();
    }
}
