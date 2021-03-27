package calendar.calendar;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

public class CalendarMain extends AnchorPane{
	public CalendarMain() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("calender.fxml"));
		Parent root = this;
		loader.setRoot(this);
		loader.setController(this);
		try {
			loader.load();
		} catch (IOException e) {
			e.printStackTrace();		
		}
	}
}
