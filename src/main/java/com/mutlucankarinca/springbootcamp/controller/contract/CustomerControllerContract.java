package com.mutlucankarinca.springbootcamp.controller.contract;

import com.mutlucankarinca.springbootcamp.dto.CustomerDTO;
import com.mutlucankarinca.springbootcamp.dto.CustomerSaveRequest;

import java.util.List;

public interface CustomerControllerContract {

    CustomerDTO save(CustomerSaveRequest request);

    List<CustomerDTO> findAll();

    void delete(Long id);

}
