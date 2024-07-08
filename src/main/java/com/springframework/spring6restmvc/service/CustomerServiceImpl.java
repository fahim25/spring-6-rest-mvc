package com.springframework.spring6restmvc.service;

import com.springframework.spring6restmvc.model.CustomerDTO;

import java.time.LocalDateTime;
import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl {
    private Map<UUID, CustomerDTO> customerMap;

    public CustomerServiceImpl() {
        CustomerDTO customerDTO1 = CustomerDTO.builder()
                .id(UUID.randomUUID())
                .name("Customer 1")
                .version(1)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        CustomerDTO customerDTO2 = CustomerDTO.builder()
                .id(UUID.randomUUID())
                .name("Customer 2")
                .version(1)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        CustomerDTO customerDTO3 = CustomerDTO.builder()
                .id(UUID.randomUUID())
                .name("Customer 3")
                .version(1)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        customerMap = new HashMap<>();
        customerMap.put(customerDTO1.getId(), customerDTO1);
        customerMap.put(customerDTO2.getId(), customerDTO2);
        customerMap.put(customerDTO3.getId(), customerDTO3);
    }

//    @Override
//    public void patchCustomerById(UUID customerId, Customer customer) {
//        Customer existing = customerMap.get(customerId);
//
//        if (StringUtils.hasText(customer.getName())) {
//            existing.setName(customer.getName());
//        }
//    }
//
//    @Override
//    public void deleteCustomerById(UUID customerId) {
//        customerMap.remove(customerId);
//    }
//
//    @Override
//    public void updateCustomerById(UUID customerId, Customer customer) {
//        Customer existing = customerMap.get(customerId);
//        existing.setName(customer.getName());
//    }
//
//    @Override
//    public Customer saveNewCustomer(Customer customer) {
//
//        Customer savedCustomer = Customer.builder()
//                .id(UUID.randomUUID())
//                .version(1)
//                .updateDate(LocalDateTime.now())
//                .createdDate(LocalDateTime.now())
//                .name(customer.getName())
//                .build();
//
//        customerMap.put(savedCustomer.getId(), savedCustomer);
//
//        return savedCustomer;
//    }
//
//    @Override
//    public Customer getCustomerById(UUID uuid) {
//        return customerMap.get(uuid);
//    }
//
//    @Override
//    public List<Customer> getAllCustomers() {
//        return new ArrayList<>(customerMap.values());
//    }
}
