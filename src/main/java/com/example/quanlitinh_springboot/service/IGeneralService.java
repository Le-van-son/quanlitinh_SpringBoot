package com.example.quanlitinh_springboot.service;

import com.example.quanlitinh_springboot.model.Customer;
import com.example.quanlitinh_springboot.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.Currency;
import java.util.Optional;

public interface IGeneralService<T>{
    Iterable<T> findAll();
    Page<T> findAll(Pageable pageable);
    Optional<T> findById(int id);

    T save(T t);

    void remove(int id);

    Iterable<T>findAllByNameContaining(String name);
    @Query(value = "select * from post order by id desc LIMIT 4", nativeQuery = true)
    Iterable<T> getTop4New();
    @Query(value = "select * from post where likes > 6",nativeQuery = true)
    Iterable<T> getLikes();
}
