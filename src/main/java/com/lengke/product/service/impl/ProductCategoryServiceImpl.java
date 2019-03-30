package com.lengke.product.service.impl;

import com.lengke.product.entity.ProductCategory;
import com.lengke.product.repostory.ProductCategoryRepostory;
import com.lengke.product.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther : 冷科
 * @Date : 2019/3/9 23:18
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryRepostory productCategoryRepostory;


    @Override
    public ProductCategory findById(Integer integer) {
        return productCategoryRepostory.findById(integer).get();
    }

    @Override
    public ProductCategory findByCategoryName(String string) {
        return productCategoryRepostory.findByCategoryName(string);
    }

    @Override
    public ProductCategory findByCategoryType(Integer integer) {
        return productCategoryRepostory.findByCategoryType(integer);
    }

    @Override
    public List<ProductCategory> findByCategoryTypes(List<Integer> types) {
        return productCategoryRepostory.findByCategoryTypeIn(types);
    }

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryRepostory.findAll();
    }

    @Override
    public void save(ProductCategory productCategory) {
        productCategoryRepostory.save(productCategory);
    }
}
