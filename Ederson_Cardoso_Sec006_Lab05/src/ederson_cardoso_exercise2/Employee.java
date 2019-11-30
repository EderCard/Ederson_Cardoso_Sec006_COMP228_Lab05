package ederson_cardoso_exercise2;

import java.time.LocalDate;

public class Employee {
	private int employeeID;
	private String name;
	private LocalDate dateJoin;
	private double salary = 0.0;

	// Getters and Setters
	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		// validate empty Name
		if (employeeID == 0) {
			throw new IllegalArgumentException("ID cannot be null");
		} else if (String.valueOf(employeeID).length() != 3) {
			throw new IllegalArgumentException("ID must have 3 digits");
		} else {
			this.employeeID = employeeID;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		// validate empty Name
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Name cannot be null");
		} else {
			this.name = name;
		}
	}

	public LocalDate getDateJoin() {
		return dateJoin;
	}

	public void setDateJoin(LocalDate dateJoin) {
		if (dateJoin == null) {
			throw new IllegalArgumentException("Date cannot be null");
		} else {
			this.dateJoin = dateJoin;
		}
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		// Validate negative value
		if (salary < 0) {
			throw new IllegalArgumentException("Salary cannot be negative");
		} else {
			this.salary = salary;
		}
	}

	/**
	 * This is the default constructor with all parameters
	 * 
	 * @param employeeID
	 * @param name
	 * @param dateJoin
	 * @param salary
	 */
	public Employee(int employeeID, String name, LocalDate dateJoin, double salary) {
		setEmployeeID(employeeID);
		setName(name);
		setDateJoin(dateJoin);
		setSalary(salary);
	} // end constructor

	/***
	 * This is the override of toString method
	 */
	@Override
	public String toString() {

		return String.format("%d \t%-15s \t%-10s \t%-10.2f \n", employeeID, name, dateJoin, salary);

	}

	/**
	 * This method set a new employee
	 * 
	 * @param employeeID
	 * @param name
	 * @param dateJoin
	 * @param salary
	 */
	public void setEmployee(int employeeID, String name, LocalDate dateJoin, double salary) {
		setEmployeeID(employeeID);
		setName(name);
		setDateJoin(dateJoin);
		setSalary(salary);
	}

} // end class
