package com.bae.admintemp.data.handler;


import com.bae.admintemp.data.entity.Customer;

import java.util.Date;

public interface CustomerDataHandler {

    Customer saveCustomerEntity(String userId, String userPw, String userName, String mobile, String email, String provider,
                                String grade, String zip, String addr, String addr2, String smsYn, String emailYn,
                                Date expirationAt, Date secessionAt, String secessionReason);

    Customer getCustomerEntity(String userId);

}