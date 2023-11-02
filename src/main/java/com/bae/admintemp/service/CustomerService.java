package com.bae.admintemp.service;

import com.bae.admintemp.data.dto.CustomerDto;

import java.util.Date;


public interface CustomerService {
    CustomerDto saveCustomer(String userId, String userPw, String userName, String mobile, String email, String provider,
                             String grade, String zip, String addr, String addr2, String smsYn, String emailYn,
                             Date expirationAt, Date secessionAt, String secessionReason);

    CustomerDto getCustomer(String userId);

}