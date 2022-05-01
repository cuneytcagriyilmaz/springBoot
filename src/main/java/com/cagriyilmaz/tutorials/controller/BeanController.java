package com.cagriyilmaz.tutorials.dto.controller;

import com.cagriyilmaz.tutorials.bean.BeanConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class BeanController {

    @Autowired //Inject yapısıdır.
    BeanConfig beanConfig;



    @GetMapping("/bean/beanDto") // url yapısıdır. //http://localhost:8001/bean/beanDto
    @ResponseBody // HTML olmadan direkt ekranda göster.
    public String getBeanDto(){

        return  beanConfig.beanDto() +".";
    }

}
