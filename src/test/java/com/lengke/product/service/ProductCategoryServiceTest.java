package com.lengke.product.service;

import com.lengke.product.ClientApplication;
import com.lengke.product.entity.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Auther : 冷科
 * @Date : 2019/3/24 22:30
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductCategoryServiceTest  {

    @Autowired
    private ProductCategoryService productCategoryService;
    @Test
    public void findById() {
    }

    @Test
    public void findByCategoryName() {
    }

    @Test
    public void findByCategoryType() {
    }

    @Test
    public void findByCategoryTypes() {
    }

    @Test
    public void findAll() {
    }

    @Test
    public void save() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("类目一");
        productCategory.setCategoryType(1);
        productCategoryService.save(productCategory);
    }
}