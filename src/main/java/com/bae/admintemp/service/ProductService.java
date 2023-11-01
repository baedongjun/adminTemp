package com.bae.admintemp.service;


import com.bae.admintemp.data.dto.ProductDto;

public interface ProductService {

    ProductDto saveProduct(String productId, String productName, int productPrice, int productStock);

    ProductDto getProduct(String productId);

}