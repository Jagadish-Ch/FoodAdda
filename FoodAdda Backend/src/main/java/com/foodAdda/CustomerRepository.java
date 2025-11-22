package com.foodAdda;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer>{
	Optional<Customer> findByEmailId(String emailId);
	
    Optional<Customer> findByEmailIdAndName(String emailId, String name);
 
    List<Customer> findByEmailIdOrName(String emailId, String name);
 
    List<Customer> findByDateOfBirthBetween(LocalDate from, LocalDate to);
 
    List<Customer> findByDateOfBirthLessThan(LocalDate date);
 
    List<Customer> findByDateOfBirthGreaterThan(LocalDate date);
 
    List<Customer> findByDateOfBirthAfter(LocalDate date);
 
    List<Customer> findByDateOfBirthBefore(LocalDate date);
 
    List<Customer> findByEmailIdNull();
 
    List<Customer> findByNameLike(String pattern);
 
    List<Customer> findByNameOrderByDateOfBirth(String name);
 
    List<Customer> findByNameOrderByDateOfBirthDesc(String name);
    
    
    //SELECT * FROM customer WHERE email_id = 'email@123' AND name='name';
    //SELECT * FROM customer WHERE email_id = 'email@123' OR name='name';
    //SELECT * FROM customer WHERE data_of_birth BETWEEN('from','to');
    //SELECT * FROM customer WHERE data_of_birth < 'date';
    //SELECT * FROM customer WHERE data_of_birth < 'date';
    //
    //
    //
}
