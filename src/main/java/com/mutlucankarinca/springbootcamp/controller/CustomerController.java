package com.mutlucankarinca.springbootcamp.controller;

import com.mutlucankarinca.springbootcamp.controller.contract.CustomerControllerContract;
import com.mutlucankarinca.springbootcamp.dto.CustomerDTO;
import com.mutlucankarinca.springbootcamp.dto.CustomerSaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerControllerContract customerControllerContract;

    @PostMapping
    public CustomerDTO save(@RequestBody CustomerSaveRequest customerSaveRequest){
    return customerControllerContract.save(customerSaveRequest);
    }
    @GetMapping
    public List<CustomerDTO> findAll(){
        return customerControllerContract.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
    customerControllerContract.delete(id);
    }

}
