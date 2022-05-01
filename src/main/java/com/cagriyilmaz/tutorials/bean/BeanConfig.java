package com.cagriyilmaz.tutorials.bean;

import com.cagriyilmaz.tutorials.dto.BeanDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanConfig {

    //başlangıç ve bitiş bean metotlarını ayarlar
    @Bean(initMethod = "initialBeanMethod",destroyMethod ="destroylBeanMethod" )
    @Scope("singleton") // proje ile başlar ve ölür
    //@Scope("request") // sadece bir istek boyunca
    //@Scope("session") // sadece otorum boyunca
    public BeanDto beanDto(){

        return BeanDto.builder().id(0L).beanName("bean adı").beanData("bean data").build();
    }
}
