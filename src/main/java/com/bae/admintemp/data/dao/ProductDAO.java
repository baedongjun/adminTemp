package com.bae.admintemp.data.dao;


import com.bae.admintemp.data.entity.Product;

public interface ProductDAO {

    Product saveProduct(Product product);

    Product getProduct(String productId);

}