package com.foodAdda;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
@Service
public class CustomerService {
 
    @Autowired
    private CustomerRepository customerRepository;
 
    // 🔹 Create or Update Customer
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
 
    // 🔹 Get All Customers
    public Iterable<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
 
    // 🔹 Get Customer by ID
    public Optional<Customer> getCustomerById(Integer id) {
        return customerRepository.findById(id);
    }
 
    // 🔹 Delete Customer
    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }
    
    
    
    
    
 
    // 🔹 Derived Query Methods
    public Optional<Customer> findByEmailId(String emailId) {
        return customerRepository.findByEmailId(emailId);
    }
 
    public Optional<Customer> findByEmailIdAndName(String emailId, String name) {
        return customerRepository.findByEmailIdAndName(emailId, name);
    }
 
    public List<Customer> findByEmailIdOrName(String emailId, String name) {
        return customerRepository.findByEmailIdOrName(emailId, name);
    }
 
    public List<Customer> findByDateOfBirthBetween(LocalDate from, LocalDate to) {
        return customerRepository.findByDateOfBirthBetween(from, to);
    }
 
    public List<Customer> findByDateOfBirthLessThan(LocalDate date) {
        return customerRepository.findByDateOfBirthLessThan(date);
    }
 
    public List<Customer> findByDateOfBirthGreaterThan(LocalDate date) {
        return customerRepository.findByDateOfBirthGreaterThan(date);
    }
 
    public List<Customer> findByDateOfBirthAfter(LocalDate date) {
        return customerRepository.findByDateOfBirthAfter(date);
    }
 
    public List<Customer> findByDateOfBirthBefore(LocalDate date) {
        return customerRepository.findByDateOfBirthBefore(date);
    }
 
    public List<Customer> findByEmailIdNull() {
        return customerRepository.findByEmailIdNull();
    }
 
    public List<Customer> findByNameLike(String pattern) {
        return customerRepository.findByNameLike(pattern);
    }
 
    public List<Customer> findByNameOrderByDateOfBirth(String name) {
        return customerRepository.findByNameOrderByDateOfBirth(name);
    }
 
    public List<Customer> findByNameOrderByDateOfBirthDesc(String name) {
        return customerRepository.findByNameOrderByDateOfBirthDesc(name);
    }
}