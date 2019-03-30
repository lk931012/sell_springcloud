package com.lengke.product.service.impl;

import com.lengke.product.common.enums.ProductStatusEnum;
import com.lengke.product.common.utils.RandomID;
import com.lengke.product.entity.ProductInfo;
import com.lengke.product.repostory.ProductInfoRepostroy;
import com.lengke.product.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Auther : 冷科
 * @Date : 2019/3/10 00:15
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoRepostroy productInfoRepostroy;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepostroy.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public List<ProductInfo> findByCategotyType(Integer integer) {
        return productInfoRepostroy.findByCategoryType(integer);
    }

    @Override
    public void save(ProductInfo productInfo) {
        if (productInfo.getProductId() == "") {
            productInfo.setProductId(RandomID.getID());
        }
        productInfo.setDiscountValue(productInfo.getProductPrice().multiply(new BigDecimal(productInfo.getDiscount())));
        productInfoRepostroy.save(productInfo);
    }

    @Override
    public ProductInfo findById(String string) {
        return productInfoRepostroy.findById(string).get();
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoRepostroy.findAll(pageable);
    }
}
