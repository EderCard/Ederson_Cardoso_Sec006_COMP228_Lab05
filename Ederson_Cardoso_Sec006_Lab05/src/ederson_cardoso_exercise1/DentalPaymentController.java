package ederson_cardoso_exercise1;

import java.net.URL;
import java.text.NumberFormat;
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
	private Label OutputLabel;

	@FXML
	private TextField NameTextField;

	@FXML
	private TextField AddressTextField;

	@FXML
	private CheckBox FlossingCheckBox;

	@FXML
	private CheckBox FillingCheckBox;

	@FXML
	private CheckBox RootCanalCheckBox;

	@FXML
	private Button CalculateButton;

	@FXML
	private RadioButton SeniorRadioButton;

	@FXML
	private ToggleGroup AgeToggleGroup;

	@FXML
	private RadioButton KidsRadioButton;

	@FXML
	private RadioButton AdultRadioButton;

	@FXML
	private ComboBox<String> ProvinceComboBox = new ComboBox<String>();

	@FXML
	void CalculateButonClick(ActionEvent event) {
		try {
			double total = 0, discount = 0, hst = 0;

			// Set total value
			if (FlossingCheckBox.isSelected()) {
				total += 20;
			}
			if (FillingCheckBox.isSelected()) {
				total += 75;
			}
			if (RootCanalCheckBox.isSelected()) {
				total += 150;
			}

			// Calculate discount
			if (SeniorRadioButton.isSelected()) {
				discount = total * 0.1;
			} else {
				if (KidsRadioButton.isSelected()) {
					discount = total * 0.15;
				}
			}

			// Set HST percentage value
			if (ProvinceComboBox.getValue() == "Alberta") {
				hst = 0.07;
			} else if (ProvinceComboBox.getValue() == "Ontario") {
				hst = 0.13;
			} else if (ProvinceComboBox.getValue() == "Quebec") {
				hst = 0.06;
			}

			NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();

			// Build string output
			String output = String.format("%12s %8s %n%12s %8s %n%12s %8s %n%12s %n%12s %8s", 
					"Before tax:", currencyFormat.format(total).toString(), 
					"Discount:", currencyFormat.format(discount).toString(),
					"HST:", currencyFormat.format((total - discount) * hst).toString(),
					"---------------------",
					"Total:", currencyFormat.format(total - discount + ((total - discount) * hst))).toString();
			
			OutputLabel.setText(output);
			
		} catch (Exception ex) {
			OutputLabel.setText("Error: " + ex.getMessage());
		}

	}

	@FXML
	void initialize() {
		ProvinceComboBox.getItems().addAll("Alberta", "Ontario", "Quebec");
		ProvinceComboBox.setValue("---Select---");
		AdultRadioButton.setSelected(true);

	}
}