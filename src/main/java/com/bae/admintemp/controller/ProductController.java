package com.bae.admintemp.controller;

import com.bae.admintemp.common.Constants;
import com.bae.admintemp.common.exception.AroundHubException;
import com.bae.admintemp.data.dto.ProductDto;
import com.bae.admintemp.service.ProductService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // http://localhost:/product/product/{productId}
    @GetMapping(value = "/product/{productId}")
    public ProductDto getProduct(@PathVariable String productId) {

        long startTime = System.currentTimeMillis();
        LOGGER.info("[getProduct] perform {} of Around Hub API.", "getProduct");

        ProductDto productDto = productService.getProduct(productId);

        LOGGER.info(
                "[getProduct] Response :: productId = {}, productName = {}, productPrice = {}, productStock = {}, Response Time = {}ms",
                productDto.getProductId(), productDto.getProductName(), productDto.getProductPrice(), productDto.getProductStock(),
                (System.currentTimeMillis() - startTime));
        return productDto;
    }

    // http://localhost/product/product
    @PostMapping(value = "/product")
    public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto productDto) {

        LOGGER.info("[createProduct] perform {} of Around Hub API.", "createProduct");

        // Validation Code Example
        if (productDto.getProductId().equals("") || productDto.getProductId().isEmpty()) {
            LOGGER.error("[createProduct] failed Response :: productId is Empty");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(productDto);
        }

        ProductDto response = productService.saveProduct(productDto.getProductId(), productDto.getProductName(),
                productDto.getProductPrice(), productDto.getProductStock());

        LOGGER.info(
                "[createProduct] Response >> productId : {}, productName : {}, productPrice : {}, productStock : {}",
                response.getProductId(), response.getProductName(), response.getProductPrice(),
                response.getProductStock());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // http://localhost/product/product/{productId}
    @DeleteMapping(value = "/product/{productId}")
    public ProductDto deleteProduct(@PathVariable String productId) {
        return null;
    }

    @PostMapping(value = "/exception")
    public void exceptionTest() throws AroundHubException {
        throw new AroundHubException(Constants.ExceptionClass.PRODUCT, HttpStatus.FORBIDDEN, "접근이 금지되었습니다.");
    }

}