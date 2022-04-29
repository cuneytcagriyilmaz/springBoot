package com.cagriyilmaz.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.util.logging.Logger;


@Controller
public class PostContructorTutorials {
/*
    @Autowired
    Logger LOG;

 */
    //Direkt olarak contructer çağırılırsa bean henüz başlamadığından null döndürür.
    // bu yüzden gata verir. Bunun yerie bir arttaki'nin yerine onun altındakini kullanılır.
    /*
    public BeanController() {
        LOG.info("Log info çağırıldı");
    }
    */

// PostConstruct Bir bean nesnesi oluşturulduğunda hemen oluşturulur
    /*
    @PostConstruct
    public void init(){
        LOG.info("Log dosyası Çağırıldı");
    }


     */

    /*
    public static void main(String[] args) {
        PostContructorTutorials postContructorTutorials = new PostContructorTutorials();
        System.out.println(postContructorTutorials);
    }

     */

}
