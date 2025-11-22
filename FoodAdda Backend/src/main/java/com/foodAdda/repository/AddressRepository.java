package com.foodAdda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodAdda.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

}
