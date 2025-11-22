package com.foodAdda.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//Full name of user
	@NotBlank(message = "Name cannot be Blank or Null")
	@Pattern(regexp = "^(?! )[A-Za-z ]+(?<! )$", message = "Invalid name format")
	private String name;
	
	//Email should be example@domain.com or example@domain.in
	@NotBlank(message = "Email cannot be Blank or Null")
	@Pattern(regexp = "^[A-Za-z0-9]+@[A-Za-z]+\\.(com|in)$", message = "Invalid email id")
	private String email;
	
	//Contact number must be valid 10-digit starting with 6,7,8,9
	@NotBlank(message = "Contact Number cannot be blank or Null")
	@Pattern(regexp="^[6-9][0-9]{9}$", message="Invalid contact number")
	private String contactNumber;
	
	// Password rules
	@NotBlank(message = "Password cannot be blank or Null")
    @Pattern(
        regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[-!@#$%^&*]).{7,20}$",
        message = "Password must contain uppercase, lowercase, digit, and special character"
    )
	private String password;
    
    //Either "customer" or "vendor"
	@NotBlank(message = "User Role cannot be Blank or Null")
	private String userRole;
	
	//Address only for customers
	@OneToOne
	@JoinColumn(name = "address_id")
	private Address address;
 
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, contactNumber, email, id, name, password, userRole);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(address, other.address) && Objects.equals(contactNumber, other.contactNumber)
				&& Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(password, other.password)
				&& Objects.equals(userRole, other.userRole);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", contactNumber=" + contactNumber
				+ ", password=" + password + ", userRole=" + userRole + ", address=" + address + "]";
	}
	
	
	

}
