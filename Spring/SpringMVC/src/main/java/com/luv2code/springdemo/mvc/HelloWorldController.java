package com.luv2code.springdemo.mvc;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/hello")
public class HelloWorldController
{
    @RequestMapping("/showForm")
    public String showForm()
    {
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String processForm()
    {
        return "helloworld";
    }

    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model)
    {
//        read the request parameter from html form and convert to upper case
        String theName = request.getParameter("studentName");

        theName = theName.toUpperCase();

//        create the message and add to the model
        String result = "Yo! "+theName;

        model.addAttribute("message",result);

        return "helloworld";
    }

    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String theName, Model model)
    {
//      convert to uppercase
        theName = theName.toUpperCase();

//      create the message and add to the model
        String result = "Hey My Friend ! "+theName;

        model.addAttribute("message",result);

        return "helloworld";
    }
}
