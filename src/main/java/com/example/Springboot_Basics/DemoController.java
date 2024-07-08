package com.example.Springboot_Basics;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class DemoController {
    @GetMapping("/test")
    public String test(){
        return "<html><body bgcolor = cyan> test route </body></html>";
    }

    @GetMapping("/test2")
    public Student test2(){
        Student student = new Student(12, "abhay");

        return student;
    }

    // http://localhost:8080/test3/abhay
    @GetMapping("/test3/{name}")
    public String test3(@PathVariable String name){
        return "path variable ".concat(name);
    }

    // http://localhost:8080/test4?name=abhay
    @GetMapping("/test4")
    public String test4(@RequestParam("name") String name){
        return "query param ".concat(name);
    }

    // http://localhost:8080/test5/dynamic/abhay
    @GetMapping("/test5/dynamic/{name}")
    public ModelAndView test5(@PathVariable String name){
        ModelAndView mv = new ModelAndView("dynamicContent.html");
        mv.addObject("dynamic_name", name);

        return mv;
    }
}
