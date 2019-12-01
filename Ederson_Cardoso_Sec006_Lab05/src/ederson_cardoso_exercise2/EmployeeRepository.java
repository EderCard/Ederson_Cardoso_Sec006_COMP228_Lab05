package ederson_cardoso_exercise2;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class EmployeeRepository {
	private static List<Employee> employeeList = new LinkedList<>();

	/**
	 * This method add a new employee to the employeeList
	 * @param employeeID
	 * @param name
	 * @param dateJoin
	 * @param salary
	 */
	public static void addEmployee(int employeeID, String name, LocalDate dateJoin, double salary) {
		Employee employee = new Employee(employeeID, name, dateJoin, salary);
		employeeList.add(employee);
	}

	/**
	 * This method returns a employeeList
	 * @return
	 */
	public static List<Employee> getEmployeeList() {
		return employeeList;
	}

	/**
	 * This method returns a employee string
	 * @return
	 */
	public static String employeeString() {

		String result = String.format("%s \t%-15s \t%-10s \t%-10s" + 
				"%n--------------------------------------------------%n", 
				"ID", "Name", "Date Join", "Salary");
	
		for (Employee employee : employeeList) {
			result += employee.toString();
		}

		return result;

	} // end getString

} // end class
