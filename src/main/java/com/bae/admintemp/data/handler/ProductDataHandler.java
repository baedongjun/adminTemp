package com.bae.admintemp.data.handler;


import com.bae.admintemp.data.entity.Product;

public interface ProductDataHandler {

    Product saveProductEntity(String productId, String productName, int productPrice, int productStock);

    Product getProductEntity(String productId);

}