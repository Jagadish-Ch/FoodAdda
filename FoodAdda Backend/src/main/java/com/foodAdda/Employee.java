package com.foodAdda;

import java.util.Optional;

class Employee {
	private String name;

	public Employee(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static void main(String[] args) {

		Employee emp = getEmployeeTraditional(true);
		Optional<Employee> empOpt = getOptionalEmployee(false);
//		System.out.print(empOpt.get().name); //error

		//optional way	
		if(empOpt.isPresent()) {
			System.out.println("Employee Name: " + empOpt.get().getName());
		}

		//traditional way
		if (emp != null) {
			System.out.println("Employee Name: " + emp.getName());
		} else {
			System.out.println("Employee not found.");
		}
	}

	public static Employee getEmployeeTraditional(boolean isPresent) {
		if (isPresent) {
			return new Employee("Aditya");
		} else {
			return null;
		}
	}

	public static Optional<Employee> getOptionalEmployee(boolean isPresent) {
		if (isPresent) {
			return Optional.of(new Employee("Aditya")); // wrap object in Optional
		} else {
			return Optional.empty(); //return empty Optional
		}
	}
}