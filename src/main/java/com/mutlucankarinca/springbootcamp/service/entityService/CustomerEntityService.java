package com.mutlucankarinca.springbootcamp.service.entityService;

import com.mutlucankarinca.springbootcamp.dao.CustomerRepository;
import com.mutlucankarinca.springbootcamp.entity.Customer;
import com.mutlucankarinca.springbootcamp.general.BaseEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerEntityService extends BaseEntityService<Customer,CustomerRepository> {
public CustomerEntityService(CustomerRepository repository){
    super(repository);
}


}
