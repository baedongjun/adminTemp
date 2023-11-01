package com.bae.admintemp.data.dao;


import com.bae.admintemp.data.entity.Customer;

public interface CustomerDAO {

    Customer saveCustomer(Customer customer);

    Customer getCustomer(String userId);

}