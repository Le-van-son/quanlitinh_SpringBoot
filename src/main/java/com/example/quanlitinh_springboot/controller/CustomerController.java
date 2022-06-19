package com.example.quanlitinh_springboot.controller;

import com.example.quanlitinh_springboot.model.Customer;
import com.example.quanlitinh_springboot.model.Province;
import com.example.quanlitinh_springboot.service.CustomerServiceImpl;
import com.example.quanlitinh_springboot.service.ProvinceServiceImpl;
import com.sun.tracing.dtrace.ModuleAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    CustomerServiceImpl customerService;
    @Autowired
    ProvinceServiceImpl provinceService;
    @ModelAttribute("provincess")
    public Iterable<Province> findAll() {
        return provinceService.findAll();
    }    @GetMapping("")
    public ModelAndView findAll(@PageableDefault(value = 2) Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("list");
        Page<Customer> customers = customerService.findAll(pageable);
        modelAndView.addObject("customers",customers);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView formCreate(){
        ModelAndView modelAndView = new ModelAndView("create");
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView createCustomer( Customer customer){
        ModelAndView modelAndView = new ModelAndView("redirect:/customers");
        customerService.save(customer);
        return modelAndView;
    }
    @GetMapping("/{id}/edit")
    public ModelAndView formEdit(@PathVariable int id) {
        Customer customer = customerService.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("customers", customer);
        return modelAndView;
    }
    @PostMapping("/{id}/edit")
    public ModelAndView editCustomer(Customer customer){
        ModelAndView modelAndView = new ModelAndView("redirect:/customers");
        customerService.save(customer);
        return modelAndView;
    }
    @GetMapping("/{id}/delete")
    public ModelAndView deleteCustomers(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("redirect:/customers");
        customerService.remove(id);
        return modelAndView;
    }
    @GetMapping("/search")
    public ModelAndView searchCustomer(@RequestParam String input ){
    ModelAndView modelAndView = new ModelAndView("findname");
    Iterable<Customer>customers = customerService.findAllByNameContaining(input);
    modelAndView.addObject("customers", customers);
    return modelAndView;
    }
}
