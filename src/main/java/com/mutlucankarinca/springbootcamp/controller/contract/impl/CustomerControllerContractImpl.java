package com.mutlucankarinca.springbootcamp.controller.contract.impl;

import com.mutlucankarinca.springbootcamp.controller.contract.CustomerControllerContract;
import com.mutlucankarinca.springbootcamp.dto.CustomerDTO;
import com.mutlucankarinca.springbootcamp.dto.CustomerSaveRequest;
import com.mutlucankarinca.springbootcamp.entity.Customer;
import com.mutlucankarinca.springbootcamp.errorMessages.CustomerErrorMessage;
import com.mutlucankarinca.springbootcamp.general.BusinessException;
import com.mutlucankarinca.springbootcamp.general.ItemNotFoundException;
import com.mutlucankarinca.springbootcamp.mapper.CustomerMapper;
import com.mutlucankarinca.springbootcamp.service.entityService.CustomerEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerControllerContractImpl implements CustomerControllerContract {
    private final CustomerEntityService customerEntityService;
    @Override
    public CustomerDTO save(CustomerSaveRequest request) {

        Customer customer = CustomerMapper.INSTANCE.convertToCustomer(request);

        //throw new BusinessException(CustomerErrorMessage.CUSTOMER_NOT_FOUND );

        customer = customerEntityService.save(customer);

        CustomerDTO customerDTO = CustomerMapper.INSTANCE.convertToCustomerDTO(customer);
        return customerDTO;
    }

    @Override
    public List<CustomerDTO> findAll() {
       List<Customer> customerList = customerEntityService.findAll();
       return CustomerMapper.INSTANCE.convertToCustomerDtoList(customerList);
    }

    @Override
    public void delete(Long id) {
        Optional<Customer> customer=customerEntityService.findById(id);
        if(customer.isEmpty()){
            throw new ItemNotFoundException(CustomerErrorMessage.CUSTOMER_NOT_FOUND );
        }
        customerEntityService.delete(id);
    }
}
