package com.lengke.product.controller;

import com.lengke.product.entity.ProductInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * 接收产品服务的接口
 * @Auther : 冷科
 * @Date : 2019/3/26 00:10
 */
//@FeignClient(name = "product"),product为配置文件里配置的服务的名字 application: name: product
@FeignClient(name = "product")
public interface ProductController {

    //*坑: 这里一定要用@RequestParam指定参数名称,不然接收不到 会报错.
    @GetMapping("product/findById")
    ProductInfo findById(@RequestParam(value = "id") String id);

    @PostMapping("product/save")
    ProductInfo save(@RequestBody ProductInfo productInfo);

    @GetMapping("product/msg")
    String msg();
}
