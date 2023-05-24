package com.mutlucankarinca.springbootcamp.controller;

import com.mutlucankarinca.springbootcamp.entity.Customer;
import com.mutlucankarinca.springbootcamp.service.entityService.CustomerEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerEntityService customerEntityService;

    @PostMapping
    public Customer save(@RequestBody Customer customer){
    return customerEntityService.save(customer);
    }
    @GetMapping
    public List<Customer> findAll(){
        return customerEntityService.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
    customerEntityService.delete(id);
    }

}
