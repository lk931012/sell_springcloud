package com.lengke.product.service;

import com.lengke.product.common.utils.RandomID;
import com.lengke.product.entity.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @Auther : 冷科
 * @Date : 2019/3/24 19:04
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductInfoServiceTest {

    @Autowired
    private ProductInfoService productInfoService;
    @Test
    public void findUpAll() {
    }

    @Test
    public void findByCategotyType() {
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId(RandomID.getID());
        productInfo.setProductName("商品1号");
        productInfo.setProductPrice(new BigDecimal(20));
        productInfo.setDiscount((short) 1);
        productInfo.setDiscountValue(productInfo.getProductPrice().multiply(new BigDecimal(productInfo.getDiscount())));
        productInfo.setProductStock(1000);
        productInfo.setProductDescription("商品1号的描述");
        productInfo.setProductIcon("商品1号的图片");
        productInfo.setCategoryType(1);
        productInfo.setProductStatus(0);
        productInfoService.save(productInfo);
    }

    @Test
    public void findById() {
    }

    @Test
    public void findAll() {
    }
}