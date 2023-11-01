package com.bae.admintemp.service.impl;

import com.bae.admintemp.data.dto.ProductDto;
import com.bae.admintemp.data.entity.Product;
import com.bae.admintemp.data.handler.ProductDataHandler;
import com.bae.admintemp.service.MemberService;
import com.bae.admintemp.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    private final Logger LOGGER = LoggerFactory.getLogger(MemberServiceImpl.class);

    MemberDataHandler memberDataHandler;

    @Autowired
    public ProductServiceImpl(ProductDataHandler productDataHandler) {
        this.productDataHandler = productDataHandler;
    }

    @Override
    public ProductDto saveProduct(String productId, String productName, int productPrice,
                                  int productStock) {

        LOGGER.info("[saveProduct] productDataHandler 로 상품 정보 저장 요청");
        Product product = productDataHandler.saveProductEntity(productId, productName,
                productPrice, productStock);

        LOGGER.info("[saveProduct] Entity 객체를 DTO 객체로 변환 작업. productId : {}",
                product.getId());
        ProductDto productDto = new ProductDto(product.getId(),
                product.getName(), product.getPrice(),
                product.getStock());

        return productDto;
    }

    @Override
    public ProductDto getProduct(String productId) {

        LOGGER.info("[getProduct] productDataHandler 로 상품 정보 조회 요청");
        Product product = productDataHandler.getProductEntity(productId);

        LOGGER.info("[getProduct] Entity 객체를 DTO 객체로 변환 작업. productId : {}",
                product.getId());
        ProductDto productDto = new ProductDto(product.getId(),
                product.getName(), product.getPrice(),
                product.getStock());

        return productDto;
    }
}
