package com.lengke.controller;

import com.lengke.entity.ProductCategory;
import com.lengke.entity.ProductInfo;
import com.lengke.common.object.vo.BaseResultVO;
import com.lengke.common.object.vo.ProductCategoryVO;
import com.lengke.product.service.ProductCategoryService;
import com.lengke.product.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther : 冷科
 * @Date : 2019/3/10 01:45
 */
@RestController
@RequestMapping("buyer")
public class ProductController {
    @Autowired
    private ProductCategoryService productCategoryService;
    @Autowired
    private ProductInfoService productInfoService;

    /**
     * 商品展示
     */
    @GetMapping("/list")
    @Cacheable(cacheNames = "productList", key = "666666")
    public BaseResultVO list() {
        //查询所有上架商品
        List<ProductInfo> productInfoList = productInfoService.findUpAll();
        //通过上架商品查询到所有不为空的分类
        List<Integer> types = new ArrayList<>();
        for (ProductInfo productInfo : productInfoList) {
            types.add(productInfo.getCategoryType());
        }
        List<ProductCategory> productCategoryList = productCategoryService.findByCategoryTypes(types);
        //转换ProductCategoryVO对象并填充foods
        List<ProductCategoryVO> categoryVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductCategoryVO categoryVO = new ProductCategoryVO();
            categoryVO.setCategoryName(productCategory.getCategoryName());
            categoryVO.setCategoryType(productCategory.getCategoryType());
            categoryVO.setFoods(productInfoService.findByCategotyType(categoryVO.getCategoryType()));
            categoryVOList.add(categoryVO);
        }
        return BaseResultVO.success("success", categoryVOList);
    }

}
