package com.foodAdda.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="addresses")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	//Address name(e.g, Home, Office)
	@NotBlank(message="Address name should not be empty")
	private String addressName;
	
	//Line 1 must contain building/plot/street
	@NotBlank(message="Address line 1 is required (e.g., plot no./street/buliding name")
	private String line1;
	
	//Line 2 must contain landmark/location
	@NotBlank(message="Address line 2 (landmark/location) is required")	
	private String line2;

	//Area must contain only alphabets and spaces
	@NotBlank(message="Area is required")
	@Pattern(regexp= "^[A-Za-z ]+$", message="Area must contain only alphabets")
	private String area;
	
	//City should contain only alphabets
	@NotBlank(message="City is required")
	@Pattern(regexp= "^[A-Za-z ]+$", message="City should contain only alphabets")
	private String city;
	
	//
	@NotBlank(message="State is required")
	@Pattern(regexp= "^[A-Za-z ]+$", message="State should contain only alphabets")
	private String state;
	
	//
	@NotBlank(message="Pin code is required")
	@Pattern(regexp= "^[0-9]{6}$", message="Pincode should be 6 digits only") //change regexp
	private String pincode;

	
	//Getters And Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	//hashcode
	@Override
	public int hashCode() {
		return Objects.hash(addressName, area, city, id, line1, line2, pincode, state);
	}
	
	//equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(addressName, other.addressName) && Objects.equals(area, other.area)
				&& Objects.equals(city, other.city) && id == other.id && Objects.equals(line1, other.line1)
				&& Objects.equals(line2, other.line2) && Objects.equals(pincode, other.pincode)
				&& Objects.equals(state, other.state);
	}

	//toString
	@Override
	public String toString() {
		return "Address [id=" + id + ", addressName=" + addressName + ", line1=" + line1 + ", line2=" + line2
				+ ", area=" + area + ", city=" + city + ", state=" + state + ", pincode=" + pincode + "]";
	}
	
	
	
	
}
