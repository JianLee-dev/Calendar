package calendar.service;

import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class CommonService implements ICommonService {

	@Override
	public void close(Parent root) {
		((Stage)root.getScene().getWindow()).close();

	}

	@Override
	public void alert(AlertType alertType, String message) {
		new Alert(alertType,message).show();
		
		
	}

}
