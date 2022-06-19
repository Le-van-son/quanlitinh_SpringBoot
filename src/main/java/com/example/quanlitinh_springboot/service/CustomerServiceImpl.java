package com.example.quanlitinh_springboot.service;

import com.example.quanlitinh_springboot.model.Customer;
import com.example.quanlitinh_springboot.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements IGeneralService<Customer> {
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Optional<Customer> findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void remove(int id) {
    customerRepository.deleteById(id);
    }

    @Override
    public Iterable<Customer> findAllByNameContaining(String name) {
        return customerRepository.findAllByNameContaining(name);
    }


    @Override
    public Iterable<Customer> getTop4New() {
        return null;
    }

    @Override
    public Iterable<Customer> getLikes() {
        return null;
    }
}
