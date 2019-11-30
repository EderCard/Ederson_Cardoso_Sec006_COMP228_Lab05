package ederson_cardoso_exercise2;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class EmployeeInformationController {

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
		for (int counter = 0; counter < EmployeeRepository.getEmployeesList().size(); counter++) {
			if ((inputSearch
					.equals(Integer.toString(EmployeeRepository.getEmployeesList().get(counter).getEmployeeID())))
					|| (inputSearch
							.equals(EmployeeRepository.getEmployeesList().get(counter).getName().toLowerCase()))) {
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
				EmployeeRepository.addEmployee(Integer.parseInt(IdTextField.getText()), NameTextField.getText(),
						DateDatePicker.getValue(), Double.parseDouble(SalaryTextField.getText()));

				OutputLabel.setText("Employee " + NameTextField.getText() + " registered successfully.");
			} else {
				OutputLabel.setText("ID " + IdTextField.getText() + " already exist.");
			}

		} catch (Exception e) {
			OutputLabel.setText("Error: " + e.getMessage());
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
			EmployeesListTextArea.setText(EmployeeRepository.getString());
		} catch (Exception e) {
			OutputLabel.setText("Error: " + e.getMessage());
		}
	} // end DisplayAllButtonClick

	@FXML
	void SearchButtonClick(ActionEvent event) {
		try {
			if (SearchTextField.getText() == null) {
				OutputLabel.setText("Please, inform Id or Name");
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

	}
}
