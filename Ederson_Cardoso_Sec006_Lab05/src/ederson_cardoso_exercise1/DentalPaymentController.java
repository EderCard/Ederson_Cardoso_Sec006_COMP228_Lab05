package ederson_cardoso_exercise1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class DentalPaymentController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Label lblOutput;

	@FXML
	private TextField txtName;

	@FXML
	private TextField txtAddress;

	@FXML
	private CheckBox cbxFlossing;

	@FXML
	private CheckBox cbxFilling;

	@FXML
	private CheckBox cbxRootCanal;

	@FXML
	private Button btnCalculate;

	@FXML
	private RadioButton rbtSenior;

	@FXML
	private ToggleGroup tglAge;

	@FXML
	private RadioButton rbtKids;

	@FXML
	private RadioButton rbtAdult;

	@FXML
	private ComboBox<String> cbbProvince = new ComboBox<String>();

	@FXML
	void btnCalculateClick(ActionEvent event) {
		

	}

	@FXML
	void initialize() {
		cbbProvince.getItems().addAll("Alberta", "Ontario", "Quebec");
		cbbProvince.setValue("---Select---");

	}
}