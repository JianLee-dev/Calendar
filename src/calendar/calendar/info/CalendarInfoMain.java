package calendar.calendar.info;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class CalendarInfoMain {
	Parent root = null;

	
	
	public CalendarInfoMain() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("calendarInfo.fxml"));
		try {
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Parent getRoot() {
		return root;
	}
	
	
}
