package calendar.common;

import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class CommonService {

	public static void close(Parent root) {
		((Stage)root.getScene().getWindow()).close();
	}
	
	public static void alert(AlertType alertType, String message) {
		new Alert(alertType,message).show();
	}
}
