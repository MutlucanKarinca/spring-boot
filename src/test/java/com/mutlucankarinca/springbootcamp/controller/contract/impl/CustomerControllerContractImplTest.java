package com.mutlucankarinca.springbootcamp.controller.contract.impl;

import com.mutlucankarinca.springbootcamp.controller.contract.CustomerControllerContract;
import com.mutlucankarinca.springbootcamp.dto.CustomerDTO;
import com.mutlucankarinca.springbootcamp.entity.Customer;
import com.mutlucankarinca.springbootcamp.service.entityService.CustomerEntityService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CustomerControllerContractImplTest {
    @Mock
    private  CustomerEntityService customerEntityService;

    @InjectMocks
    private CustomerControllerContractImpl customerControllerContract;



    @Test
    void shouldSave() {
    }

    @Test
    void shouldNotSaveWhenIdDoesNotExist() {
    }

    @Test
    void shouldFindAll() {
        List<CustomerDTO> customerDTOList = customerControllerContract.findAll();
        System.out.println(customerDTOList);
        Assertions.assertEquals(0,customerDTOList.size());
    }
    @Test
    void shouldFindAllWhenReturnCustomer() {

        Customer customer1 = Mockito.mock(Customer.class);
        Customer customer2 = Mockito.mock(Customer.class);

        List<Customer> customerList=new ArrayList<>();
        customerList.add(customer1);
        customerList.add(customer2);

        Mockito.when(customerEntityService.findAll()).thenReturn(customerList);

        List<CustomerDTO> customerDTOList = customerControllerContract.findAll();
        System.out.println(customerDTOList);
        Assertions.assertEquals(2,customerDTOList.size());
    }
    @Test
    void shouldDelete() {
    }
}