package com.foodAdda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodAdda.entity.Address;
import com.foodAdda.entity.User;
import com.foodAdda.exception.InvalidCredentials;
import com.foodAdda.exception.UserAlreadyExistsException;
import com.foodAdda.repository.AddressRepository;
import com.foodAdda.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	// Register new user
    public String registerUser(User user) {
        User existingUser = userRepository.findByContactNumber(user.getContactNumber());
 
        if (existingUser != null && existingUser.getUserRole().equalsIgnoreCase(user.getUserRole())) {
        	throw new UserAlreadyExistsException("User already exists with this role");
        }
 
        
        Address address = addressRepository.save(user.getAddress());
        
        user.setAddress(address);
        
        userRepository.save(user);
        
        return "Congratulations! You have registered successfully.";
    }
    
    //Login existing user
    public String loginUser(String contactNumber, String password) {
    	User user = userRepository.findByContactNumber(contactNumber);
    	
    	if(user == null || ! user.getPassword().equals(password)) {
    		throw new InvalidCredentials("The entered contact number or password is wrong. Please enter valid credentials");
//    		return "The entered contact number or password is wrong. Please enter valid credentials";
    	}
    	
    	return "Login Successfully. Welcome " + user.getName() + " ("+ user.getUserRole() + ")";
    }
    
    //Logout user
    public String logoutUser() {
    	return "You have been logged out successfully.";
    }

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
}
