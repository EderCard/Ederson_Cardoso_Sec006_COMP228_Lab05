package ederson_cardoso_exercise2;

import java.time.LocalDate;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("EmployeeInformation.fxml"));

			Scene scene = new Scene(root);

			primaryStage.setTitle("Employee Information System");

			primaryStage.setScene(scene);
			primaryStage.show();

			// Create initial list of employees
			EmployeeRepository.addEmployee(101, "John", LocalDate.of(2000, 02, 20), 68_000.00);
			EmployeeRepository.addEmployee(102, "Susan", LocalDate.of(2005, 04, 12), 55_000.00);
			EmployeeRepository.addEmployee(103, "Bob", LocalDate.of(2010,12, 10), 92_000.00);
			EmployeeRepository.addEmployee(104, "Robert", LocalDate.of(2015, 11, 02), 55_000.00);
			EmployeeRepository.addEmployee(105, "Rose", LocalDate.of(2017, 06, 24), 77_000.00);	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
