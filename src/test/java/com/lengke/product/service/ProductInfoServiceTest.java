package com.lengke.product.service;

import com.lengke.product.common.utils.RandomID;
import com.lengke.product.controller.ProductController;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 * @Auther : 冷科
 * @Date : 2019/3/24 19:04
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class ProductInfoServiceTest {

    @Autowired
    private ProductController productController;
    @Test
    public void findUpAll() {
    }

    @Test
    public void findByCategotyType() {
    }

    @Test
    public void save() {
        /*ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId(RandomID.getID());
        productInfo.setProductName("商品3号");
        productInfo.setProductPrice(new BigDecimal(25));
        productInfo.setDiscount((short) 1);
        productInfo.setDiscountValue(productInfo.getProductPrice().multiply(new BigDecimal(productInfo.getDiscount())));
        productInfo.setProductStock(1000);
        productInfo.setProductDescription("商品3号的描述");
        productInfo.setProductIcon("商品1号的图片");
        productInfo.setCategoryType(1);
        productInfo.setProductStatus(0);
        productController.save(productInfo);*/
        log.info("msg={}",productController.msg());
/*      ProductInfo productInfo1 = productController.findById("1553436221753777");
        log.info("productInfo={}",productInfo1);*/
    }

    @Test
    public void findById() {
    }

    @Test
    public void findAll() {
    }
}