package com.example.quanlitinh_springboot.repository;

import com.example.quanlitinh_springboot.model.Customer;
import com.example.quanlitinh_springboot.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepository extends JpaRepository<Province,Integer> {

    Page<Province> findAll(Pageable pageable);
}
