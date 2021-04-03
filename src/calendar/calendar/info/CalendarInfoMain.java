package calendar.calendar.info;

import java.io.IOException;

import calendar.calendar.CalendarController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class CalendarInfoMain {
	public static Parent root;
	public static CalendarInfoController calendarInfoController;
	
	
	public CalendarInfoMain() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("calendarInfo.fxml"));
		try {
			root = loader.load();
			calendarInfoController = loader.getController();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Parent getRoot() {
		return root;
	}
	
	
}
