package ederson_cardoso_exercise2;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class EmployeeRepository {
	private static List<Employee> employeeList = new LinkedList<>();

	public static void addEmployee(int employeeID, String name, LocalDate dateJoin, double salary) {
		Employee employee = new Employee(employeeID, name, dateJoin, salary);
		employee.setEmployee(employeeID, name, dateJoin, salary);
		employeeList.add(employee);
	}

	public static List<Employee> getEmployeesList() {
		return employeeList;
	}

	public static String getString() {

		String result = String.format("%s \t%-15s \t%-10s \t%-10s" + 
				"%n--------------------------------------------------%n", 
				"ID", "Name", "Date Join", "Salary");
	
		for (Employee employee : employeeList) {
			result += employee.toString();
		}

		return result;

	}

}
