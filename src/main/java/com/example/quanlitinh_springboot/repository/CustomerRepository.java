package com.example.quanlitinh_springboot.repository;

import com.example.quanlitinh_springboot.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Page<Customer> findAll(Pageable pageable);
    Iterable<Customer>findAllByNameContaining(String name);
}
