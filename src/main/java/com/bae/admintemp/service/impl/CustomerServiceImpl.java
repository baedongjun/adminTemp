package com.bae.admintemp.service.impl;

import com.bae.admintemp.data.dto.CustomerDto;
import com.bae.admintemp.data.entity.Customer;
import com.bae.admintemp.data.handler.CustomerDataHandler;
import com.bae.admintemp.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);

    CustomerDataHandler customerDataHandler;

    @Autowired
    public CustomerServiceImpl(CustomerDataHandler customerDataHandler) {
        this.customerDataHandler = customerDataHandler;
    }

    @Override
    public CustomerDto saveCustomer(String userId, String userPw, String userName, String mobile, String email, String provider
            , String grade, String zip, String addr, String addr2, String smsYn, String emailYn, Date createAt, Date updateAt
            , Date expirationAt, Date secessionAt, String secessionReason) {

        LOGGER.info("[saveCustomer] customerDataHandler 로 상품 정보 저장 요청");
        Customer customer = customerDataHandler.saveCustomerEntity(userId, userPw, userName, mobile, email, provider
                , grade, zip, addr, addr2, smsYn, emailYn, createAt, updateAt
                , expirationAt, secessionAt, secessionReason);

        LOGGER.info("[saveCustomer] Entity 객체를 DTO 객체로 변환 작업. userId : {}", customer.getUserId());
        CustomerDto customerDto = new CustomerDto(customer.getUserId(), customer.getUserPw(), customer.getUserName(),
                customer.getMobile(), customer.getEmail(), customer.getProvider(), customer.getGrade(), customer.getZip(),
                customer.getAddr(), customer.getAddr2(), customer.getSmsYn(), customer.getEmailYn(), customer.getCreateAt(),
                customer.getUpdateAt(), customer.getExpirationAt(), customer.getSecessionAt(), customer.getSecessionReason()
                );

        return customerDto;
    }

    @Override
    public CustomerDto getCustomer(String userId) {

        LOGGER.info("[getCustomer] customerDataHandler 로 상품 정보 조회 요청");
        Customer customer = customerDataHandler.getCustomerEntity(userId);

        LOGGER.info("[getCustomer] Entity 객체를 DTO 객체로 변환 작업. userId : {}", customer.getUserId());
        CustomerDto customerDto = new CustomerDto(customer.getUserId(), customer.getUserPw(), customer.getUserName(),
                customer.getMobile(), customer.getEmail(), customer.getProvider(), customer.getGrade(), customer.getZip(),
                customer.getAddr(), customer.getAddr2(), customer.getSmsYn(), customer.getEmailYn(), customer.getCreateAt(),
                customer.getUpdateAt(), customer.getExpirationAt(), customer.getSecessionAt(), customer.getSecessionReason()
        );

        return customerDto;
    }
}