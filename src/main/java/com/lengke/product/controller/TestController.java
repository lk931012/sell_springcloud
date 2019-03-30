package com.lengke.product.controller;

import com.lengke.product.entity.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther : 冷科
 * @Date : 2019/3/26 01:27
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private ProductController productController;

    @GetMapping("/msg")
    public String msg(){
        return productController.msg();
    }

    @GetMapping("/get")
    public ProductInfo get(String id){
        return productController.findById(id);
    }
}
