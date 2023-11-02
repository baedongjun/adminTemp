package com.bae.admintemp.data.handler.impl;


import com.bae.admintemp.data.dao.CustomerDAO;
import com.bae.admintemp.data.entity.Customer;
import com.bae.admintemp.data.handler.CustomerDataHandler;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

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
    public Customer saveCustomerEntity(String userId, String userPw, String userName, String mobile, String email, String provider
            , String grade, String zip, String addr, String addr2, String smsYn, String emailYn, Date expirationAt,
                                       Date secessionAt, String secessionReason) {

        LOGGER.debug("[saveCustomerEntity] 매개변수를 통해 Entity 객체 생성");
        Customer customer = new Customer(userId, userPw, userName, mobile, email, provider
                , grade, zip, addr, addr2, smsYn, emailYn, expirationAt, secessionAt, secessionReason);

        LOGGER.info("[saveCustomerEntity] customerDAO로 Customer 정보 저장 요청. userId : {}", userId);
        return customerDAO.saveCustomer(customer);
    }

    @Override
    public Customer getCustomerEntity(String userId) {
        LOGGER.info("[saveCustomerEntity] customerDAO로 Customer 정보 요청. userId : {}", userId);
        return customerDAO.getCustomer(userId);
    }
}