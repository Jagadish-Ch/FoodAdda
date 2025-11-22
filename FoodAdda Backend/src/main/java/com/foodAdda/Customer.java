package com.foodAdda;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
 
@Entity
@Table(name = "customer")
public class Customer {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
 
    private String emailId;
    private String name;
    private LocalDate dateOfBirth;
 
    // Constructors
    public Customer() {}
 
    public Customer(String emailId, String name, LocalDate dateOfBirth) {
        this.emailId = emailId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }
 
    // Getters and Setters
    public Integer getCustomerId() {
        return customerId;
    }
 
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
 
    public String getEmailId() {
        return emailId;
    }
 
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
 
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
 
    @Override
    public String toString() {
        return "Customer [customerId=" + customerId +
               ", emailId=" + emailId +
               ", name=" + name +
               ", dateOfBirth=" + dateOfBirth + "]";
    }
}