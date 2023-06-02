package com.mutlucankarinca.springbootcamp.controller.contract.impl;

import com.mutlucankarinca.springbootcamp.controller.contract.CustomerControllerContract;
import com.mutlucankarinca.springbootcamp.dto.CustomerDTO;
import com.mutlucankarinca.springbootcamp.dto.CustomerSaveRequest;
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
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerControllerContractImplTest {
    @Mock
    private  CustomerEntityService customerEntityService;

    @InjectMocks
    private CustomerControllerContractImpl customerControllerContract;



    @Test
    void shouldSave() {
        String name="mutlucan";
        Long id= 18L;

        CustomerSaveRequest request= mock(CustomerSaveRequest.class);
        Customer customer = mock(Customer.class);
        when(customer.getId()).thenReturn(id);

        when(request.name()).thenReturn(name);
        when(customerEntityService.save(any())) .thenReturn(customer);

        CustomerDTO result = customerControllerContract.save(request);

        verify(customerEntityService).save(any());
        assertEquals(name,result.name());
        assertEquals(id,result.id());
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
        String name="mutlucan";
        Customer customer1 = mock(Customer.class);
        when(customer1.getName()).thenReturn(name);
        //Customer customer2 = Mockito.mock(Customer.class);

        List<Customer> customerList=new ArrayList<>();
        customerList.add(customer1);
       // customerList.add(customer2);

        when(customerEntityService.findAll()).thenReturn(customerList);

        List<CustomerDTO> customerDTOList = customerControllerContract.findAll();
        System.out.println(customerDTOList);
        Assertions.assertEquals(1,customerDTOList.size());
        Customer result=customerList.get(0);
        Assertions.assertEquals(name,result.getName());
    }
    @Test
    void shouldDelete() {
        Long id =18L;
        doNothing().when(customerEntityService).delete(id);
        customerControllerContract.delete(id);
        verify(customerEntityService).delete(id);
    }

    @Test
    void shouldNotDeleteWhenDeleteMethodThrowsException(){

        doThrow(NoSuchElementException.class).when(customerEntityService).delete(anyLong());

        Assertions.assertThrows(NoSuchElementException.class,()->customerControllerContract.delete(18L));

        //customerControllerContract.delete(18L);
    }
}