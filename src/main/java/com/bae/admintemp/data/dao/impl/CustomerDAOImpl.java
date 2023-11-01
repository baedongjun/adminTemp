package com.bae.admintemp.data.dao.impl;

import com.bae.admintemp.data.dao.CustomerDAO;
import com.bae.admintemp.data.entity.Customer;
import com.bae.admintemp.data.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerDAOImpl implements CustomerDAO {

    private final Logger LOGGER = LoggerFactory.getLogger(CustomerDAOImpl.class);

    CustomerRepository customerRepository;

    @Autowired
    public CustomerDAOImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        LOGGER.info("[saveCustomer] customer 정보 저장. customerId : {}", customer.getUserId());
        Customer customer1 = customerRepository.save(customer);
        LOGGER.info("[saveCustomer] customer 정보 저장완료. customerId : {}", customer1.getUserId());
        return customer1;
    }

    @Override
    public Customer getCustomer(String userId) {
        LOGGER.info("[getCustomer] customer 정보 요청. customerId : {}", userId);
        Customer customer = customerRepository.getById(userId);
        LOGGER.info("[getCustomer] customer 정보 요청 완료. customerId : {}", customer.getUserId());
        return customer;
    }

    /**
     * Repository에서 기본적으로 제공하는 대표적인 메소드
     */
    private void testRepositoryMethod() {
/*    customerRepository.save();
    customerRepository.getById();
    customerRepository.delete();
    customerRepository.deleteAll();
    customerRepository.findAll();
    customerRepository.saveAll();*/
    }
}