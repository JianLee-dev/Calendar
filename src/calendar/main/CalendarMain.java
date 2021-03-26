package calendar.main;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CalendarMain {
	
	
	public CalendarMain() {
		Stage stage = new Stage();
		Parent root = null;
		CalendarController cc = null;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("mainForm.fxml"));
		try {
			root = loader.load();
			cc = loader.getController();
		} catch (IOException e) {
			e.printStackTrace();
		}
		cc.setRoot(root);
		stage.setScene(new Scene(root));
		stage.show();
	}
}
