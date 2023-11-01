package com.bae.admintemp.data.handler.impl;


import com.bae.admintemp.data.dao.CustomerDAO;
import com.bae.admintemp.data.entity.Customer;
import com.bae.admintemp.data.handler.CustomerDataHandler;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CustomerDataHandlerImpl implements CustomerDataHandler {

    private final Logger LOGGER = LoggerFactory.getLogger(CustomerDataHandlerImpl.class);

    CustomerDAO customerDAO;

    @Autowired
    public CustomerDataHandlerImpl(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    public Customer saveCustomerEntity(String customerId, String customerName, int customerPrice, int customerStock) {

        LOGGER.debug("[saveCustomerEntity] 매개변수를 통해 Entity 객체 생성");
        Customer customer = new Customer(customerId, customerName, customerPrice, customerStock);

        LOGGER.info("[saveCustomerEntity] customerDAO로 Customer 정보 저장 요청. customerId : {}", customerId);
        return customerDAO.saveCustomer(customer);
    }

    @Override
    public Customer getCustomerEntity(String customerId) {
        LOGGER.info("[saveCustomerEntity] customerDAO로 Customer 정보 요청. customerId : {}", customerId);
        return customerDAO.getCustomer(customerId);
    }
}