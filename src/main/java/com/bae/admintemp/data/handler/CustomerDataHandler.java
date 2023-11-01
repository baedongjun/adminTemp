package com.bae.admintemp.data.handler;


import com.bae.admintemp.data.entity.Customer;

public interface CustomerDataHandler {

    Customer saveCustomerEntity(String customerId, String customerName, int customerPrice, int customerStock);

    Customer getCustomerEntity(String customerId);

}