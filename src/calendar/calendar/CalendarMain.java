package calendar.calendar;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

public class CalendarMain {
	
	Parent root;
	
	
	public CalendarMain() {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("calendar.fxml"));

		try {
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();		
		}
		CalendarController cc = loader.getController();
		cc.setRoot(root); 
	}
	
	
	public Parent getRoot() {
		return root;
	}
	
}
