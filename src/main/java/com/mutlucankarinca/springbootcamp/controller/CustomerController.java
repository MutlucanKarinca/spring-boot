package com.mutlucankarinca.springbootcamp.controller;

import com.mutlucankarinca.springbootcamp.controller.contract.CustomerControllerContract;
import com.mutlucankarinca.springbootcamp.dto.CustomerDTO;
import com.mutlucankarinca.springbootcamp.dto.CustomerSaveRequest;
import com.mutlucankarinca.springbootcamp.general.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerControllerContract customerControllerContract;

    @PostMapping
    public ResponseEntity<RestResponse<CustomerDTO>> save(@RequestBody CustomerSaveRequest customerSaveRequest){
    CustomerDTO customerDTO= customerControllerContract.save(customerSaveRequest);
    return ResponseEntity.ok(RestResponse.of(customerDTO));
    }
    @GetMapping
    public ResponseEntity<RestResponse<List<CustomerDTO>>> findAll(){
        List<CustomerDTO> customerDTOList = customerControllerContract.findAll();
        return ResponseEntity.ok(RestResponse.of(customerDTOList));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RestResponse<Object>> delete(@PathVariable Long id){
    customerControllerContract.delete(id);
    return ResponseEntity.ok(RestResponse.empty());
    }
    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<CustomerDTO>> findById(@PathVariable Long id){
        CustomerDTO customerDTO =customerControllerContract.findById(id);
        return ResponseEntity.ok(RestResponse.of(customerDTO));
    }

}
