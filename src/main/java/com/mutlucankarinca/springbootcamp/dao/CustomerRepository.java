package com.mutlucankarinca.springbootcamp.dao;

import com.mutlucankarinca.springbootcamp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer findByUsername(String username);
    Customer findByNameAndSurname(String name,String surname);
    List<Customer> findAllByIdBetween(Long first,Long last);
    List<Customer> findAllByIdGreaterThan(Long id);
    List<Customer> findAllByIdGreaterThanEqual(Long id);
}
