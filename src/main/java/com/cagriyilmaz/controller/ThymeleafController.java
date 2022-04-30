package com.cagriyilmaz.controller;


import com.cagriyilmaz.dto.ProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ThymeleafController {

    // http://localhost:8001
    // hem index yazınca hemde hiçbirşe yazmayınca index sayfasına gider. Opsiyonel yapı
    @GetMapping({"/", "index"})
    public String index() {
        return "index";
    }


    // http://localhost:8001/thymeleaf1
    @GetMapping("/thymeleaf1")
//    @ResponseBody //kodlarımızı yaparken herhangi bir sayfaya yönlendirmeyi sağlar.
    public String getThymeleaf1() {
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

    //http://localhost:8001/thymeleaf4
    @GetMapping("/thymeleaf4")
    public String getThymeleaf4Model(Model model) {
        model.addAttribute("key_model1", "Ben Modelden geldim-1");
        model.addAttribute("key_model2", "Ben Modelden geldim-4");
        return "thymeleaf4";
    }

    /////////////////////////////////
    // Modelde Object Göndermek
    //http://localhost:8001/thymeleaf5
    @GetMapping("/thymeleaf5")
    public String getThymeleaf5ModelObject(Model model) {
        model.addAttribute("key_model1", "text");
        ProductDto productDto =
                ProductDto
                        .builder()
                        .productId(0L)
                        .productName("Ürün Adı")
                        .productPrice(2500)
                        .build();
        model.addAttribute("key_model2", productDto);
        return "thymeleaf5";
    }

    // Modelde Objkect List Göndermek
    //http://localhost:8001/thymeleaf6
    @GetMapping("/thymeleaf6")
    public String getThymeleaf6ModelObjectList(Model model) {
        model.addAttribute("key_model1", "text");
        List<ProductDto> Listem = new ArrayList<>();
        Listem.add(ProductDto.builder().productId(1L).productName("Ürün Adı1").productPrice(1500).build());
        Listem.add(ProductDto.builder().productId(2L).productName("Ürün Adı2").productPrice(2500).build());
        Listem.add(ProductDto.builder().productId(3L).productName("Ürün Adı3").productPrice(3500).build());
        Listem.add(ProductDto.builder().productId(4L).productName("Ürün Adı4").productPrice(4500).build());


        model.addAttribute("product_liste", Listem);
        return "thymeleaf6";
    }

    //http://localhost:8001/thymeleaf7/4
    @GetMapping({"/thymeleaf7", "/thymeleaf7/{id}"})
    public String getThymeleaf7ModelObjectList(Model model, @PathVariable(name = "id", required = false) Long id) {
        if (id != null) {
            model.addAttribute("key_model1", "id" + id);

        } else {
            model.addAttribute("key_model1", "id Bulunamadı" + id);

        }
        return "thymeleaf7";
    }

    //RequestParam
    //http://localhost:8001/thymeleaf8?id=4&name=cagriyilmaz
    @GetMapping("/thymeleaf8")
    public String getThymeleaf8ModelObjectList(Model model,
                                               @RequestParam(name = "id", defaultValue = "0") Long id,
                                               @RequestParam(name = "name") String adi

                                               ) {
        if (id != null) {
            model.addAttribute("key_model1", "id: " + id+ "adı soyadı: " +adi);

        } else {
            model.addAttribute("key_model1", "id Bulunamadı" + id);

        }

        return "thymeleaf8";
    }

}

