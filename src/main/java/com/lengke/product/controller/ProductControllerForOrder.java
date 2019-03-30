package com.lengke.product.controller;

import com.lengke.product.entity.ProductInfo;
import com.lengke.product.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther : 冷科
 * @Date : 2019/3/26 00:19
 */
@RestController
@RequestMapping("product")
public class ProductControllerForOrder {

    @Autowired
    private ProductInfoService productInfoService;
    @GetMapping("/findById")
    public ProductInfo findById(@RequestParam(value = "id") String id){
        return productInfoService.findById(id);
    }

    @PostMapping("/save")
    public void save(@RequestBody ProductInfo productInfo){
        productInfoService.save(productInfo);
    }
    @GetMapping("/msg")
    public String msg(){
        return "我是product服务的msg";
    }
}
