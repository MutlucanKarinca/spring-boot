package com.mutlucankarinca.springbootcamp.mapper;

import com.mutlucankarinca.springbootcamp.dto.CustomerDTO;
import com.mutlucankarinca.springbootcamp.dto.CustomerSaveRequest;
import com.mutlucankarinca.springbootcamp.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    Customer convertToCustomer(CustomerSaveRequest customerSaveRequest);

    CustomerDTO convertToCustomerDTO(Customer customer);

    List<CustomerDTO> convertToCustomerDtoList(List<Customer> customerList);
}
