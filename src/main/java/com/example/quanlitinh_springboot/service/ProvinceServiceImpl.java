package com.example.quanlitinh_springboot.service;

import com.example.quanlitinh_springboot.model.Province;
import com.example.quanlitinh_springboot.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ProvinceServiceImpl implements IGeneralService<Province>{
    @Autowired
    ProvinceRepository provinceRepository;
    @Override
    public Iterable<Province> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public Page<Province> findAll(Pageable pageable) {
        return provinceRepository.findAll(pageable);
    }

    @Override
    public Optional<Province> findById(int id) {
        return provinceRepository.findById(id);
    }

    @Override
    public Province save(Province province) {
        return provinceRepository.save(province);
    }

    @Override
    public void remove(int id) {
    provinceRepository.deleteById(id);
    }

    @Override
    public Iterable<Province> findAllByNameContaining(String name) {
        return null;
    }


    @Override
    public Iterable<Province> getTop4New() {
        return null;
    }

    @Override
    public Iterable<Province> getLikes() {
        return null;
    }
}
