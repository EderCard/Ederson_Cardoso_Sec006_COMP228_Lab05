package ederson_cardoso_exercise2;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class EmployeeInformationController extends EmployeeRepository {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField IdTextField;

	@FXML
	private TextField NameTextField;

	@FXML
	private TextField SalaryTextField;

	@FXML
	private DatePicker DateDatePicker;

	@FXML
	private TextArea EmployeesListTextArea;

	@FXML
	private Button AddButton;

	@FXML
	private Button DisplayAllButton;

	@FXML
	private Button ClearButton;

	@FXML
	private TextField SearchTextField;

	@FXML
	private Button SearchButton;

	@FXML
	private Label OutputLabel;

	/**
	 * This method checks if and Employee exist based on ID or Name (inputSearch)
	 * 
	 * @param inputSearch
	 * @return
	 */
	private Boolean existEmployee(String inputSearch) {
		Boolean result = false;
		for (int counter = 0; counter < getEmployeeList().size(); counter++) {
			if ((inputSearch.equals(Integer.toString(getEmployeeList().get(counter).getEmployeeID())))
					|| (inputSearch.equals(getEmployeeList().get(counter).getName().toLowerCase()))) {
				result = true;
			}
		}
		return result;
	} // end existEmployee

	@FXML
	void AddButtonClick(ActionEvent event) {
		try {
			// Include a new employee only if not exist
			if ((existEmployee(IdTextField.getText()) == false)) {
				addEmployee(Integer.parseInt(IdTextField.getText()), NameTextField.getText(), DateDatePicker.getValue(),
						Double.parseDouble(SalaryTextField.getText()));
				OutputLabel.setText("Employee " + NameTextField.getText() + " registered successfully.");
			} else {
				OutputLabel.setText("ERROR: ID " + IdTextField.getText() + " already exist.");
			}

		} catch (Exception e) {
			OutputLabel.setText("ERROR: " + e.getMessage());
		}

	} // end AddButtonClick

	@FXML
	void ClearButtonClick(ActionEvent event) {
		EmployeesListTextArea.clear();
		try {
			EmployeesListTextArea.clear();
			SearchTextField.clear();
			OutputLabel.setText(null);
		} catch (Exception e) {
			EmployeesListTextArea.setText("Error: " + e.getMessage());
		}
	} // end ClearButtonClick

	@FXML
	void DisplayAllButtonClick(ActionEvent event) {
		try {
			EmployeesListTextArea.setText(employeeString());
		} catch (Exception e) {
			OutputLabel.setText("Error: " + e.getMessage());
		}
	} // end DisplayAllButtonClick

	@FXML
	void SearchButtonClick(ActionEvent event) {
		try {
			if (SearchTextField.getText().equals("")) {
				OutputLabel.setText("Please, inform ID or Name");
			} else if (existEmployee(SearchTextField.getText().toLowerCase())) {
				OutputLabel.setText("Employee Exists.");
			} else {
				OutputLabel.setText("Employee does not Exists.");

			}
		} catch (Exception e) {
			OutputLabel.setText("Error: " + e.getMessage());
		}
	} // end

	@FXML
	void initialize() {
		// Create initial list of employees
		addEmployee(101, "John", LocalDate.of(2000, 02, 20), 68_000.00);
		addEmployee(102, "Susan", LocalDate.of(2005, 04, 12), 55_000.00);
		addEmployee(103, "Bob", LocalDate.of(2010, 12, 10), 92_000.00);
		addEmployee(104, "Robert", LocalDate.of(2015, 11, 02), 55_000.00);
		addEmployee(105, "Rose", LocalDate.of(2017, 06, 24), 77_000.00);
	}
}
