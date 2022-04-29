package com.cagriyilmaz.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ThymeleafController {

    @GetMapping({"/", "index"})
    public String index() {
        return "index";
    }


    // http://localhost:8001/thymeleaf1
    @GetMapping("/thymeleaf1")
//    @ResponseBody //kodlarımızı yaparken herhangi bir sayfaya yönlendirmeyi sağlar.
    public String getThymeleaf1(){
        return "thymeleaf1";
    }

    //Model
    //http://localhost:8001/thymeleaf2
    @GetMapping("/thymeleaf2")
    public String getThymeleaf2Model(Model model) {
        model.addAttribute("key_model1", "Ben Modelden geldim-1");
        model.addAttribute("key_model2", "Ben Modelden geldim-2");
        return "thymeleaf1";
    }

    //Model birden fazla göndermek
    //http://localhost:8001/thymeleaf3
    @GetMapping("/thymeleaf3")
    public String getThymeleaf3Model(Model model) {
        model.addAttribute("key_model1", "Ben Modelden geldim-1");
        model.addAttribute("key_model2", "Ben Modelden geldim-2");
        return "thymeleaf_file/thymeleaf3";
    }

}

