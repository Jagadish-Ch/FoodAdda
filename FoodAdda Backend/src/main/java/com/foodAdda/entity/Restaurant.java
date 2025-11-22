package com.foodAdda.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "restaurants")
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@Pattern(regexp = "^[A-Z][a-zA-Z]*(\\s[A-Z][a-zA-Z]*)*$",
			 message = "Restaurant name must start with uppercase and contain only alphabets and spaces")
	@Column(nullable = false)
	private String name;

	
	@Pattern(regexp = "^[0-9]{10}$",
			 message = "Contact number must be a valid 10-digit number")
	@Column(nullable = false)
	private String contactNo;
	

	@NotBlank(message = "Restaurant type is required")
	@Column(nullable = false)
	private String type;
	
	private double rating;
	
	private String status = "PENDING";
	
	@ManyToOne
	@JoinColumn(name= "vendor_id")
	private User vendor;
	
	@OneToOne
	@JoinColumn(name= "address_id")
	private Address address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getVendor() {
		return vendor;
	}

	public void setVendor(User vendor) {
		this.vendor = vendor;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", name=" + name + ", contactNo=" + contactNo + ", type=" + type + ", rating="
				+ rating + ", status=" + status + ", vendor=" + vendor + "]";
	}
	
	
	
	
}
