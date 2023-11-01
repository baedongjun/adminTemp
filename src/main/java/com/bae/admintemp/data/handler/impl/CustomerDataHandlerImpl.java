package com.bae.admintemp.data.handler.impl;


import com.bae.admintemp.data.dao.ProductDAO;
import com.bae.admintemp.data.entity.Product;
import com.bae.admintemp.data.handler.ProductDataHandler;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CustomerDataHandlerImpl implements ProductDataHandler {

    private final Logger LOGGER = LoggerFactory.getLogger(CustomerDataHandlerImpl.class);

    ProductDAO productDAO;

    @Autowired
    public CustomerDataHandlerImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public Product saveProductEntity(String productId, String productName, int productPrice,
                                     int productStock) {

        LOGGER.debug("[saveProductEntity] 매개변수를 통해 Entity 객체 생성");
        Product product = new Product(productId, productName, productPrice,
                productStock);

        LOGGER.info("[saveProductEntity] productDAO로 Product 정보 저장 요청. productId : {}", productId);
        return productDAO.saveProduct(product);
    }

    @Override
    public Product getProductEntity(String productId) {
        LOGGER.info("[saveProductEntity] productDAO로 Product 정보 요청. productId : {}", productId);
        return productDAO.getProduct(productId);
    }
}