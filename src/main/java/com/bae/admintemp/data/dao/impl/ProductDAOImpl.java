package com.bae.admintemp.data.dao.impl;

import com.bae.admintemp.data.dao.ProductDAO;
import com.bae.admintemp.data.entity.Product;
import com.bae.admintemp.data.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDAOImpl implements ProductDAO {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductDAOImpl.class);

    ProductRepository productRepository;

    @Autowired
    public ProductDAOImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product) {
        LOGGER.info("[saveProduct] product 정보 저장. productId : {}", product.getId());
        Product product1 = productRepository.save(product);
        LOGGER.info("[saveProduct] product 정보 저장완료. productId : {}", product1.getId());
        return product1;
    }

    @Override
    public Product getProduct(String productId) {
        LOGGER.info("[getProduct] product 정보 요청. productId : {}", productId);
        Product product = productRepository.getById(productId);
        LOGGER.info("[getProduct] product 정보 요청 완료. productId : {}", product.getId());
        return product;
    }

    /**
     * Repository에서 기본적으로 제공하는 대표적인 메소드
     */
    private void testRepositoryMethod() {
/*    productRepository.save();
    productRepository.getById();
    productRepository.delete();
    productRepository.deleteAll();
    productRepository.findAll();
    productRepository.saveAll();*/
    }
}