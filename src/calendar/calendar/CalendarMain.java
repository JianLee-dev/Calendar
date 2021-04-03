package calendar.calendar;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

public class CalendarMain {
	
	public static Parent root;
	public static CalendarController calednarController;
	
	public CalendarMain() {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("calendar.fxml"));

		try {
			root = loader.load();
			calednarController = loader.getController();
		} catch (IOException e) {
			e.printStackTrace();		
		}
		
		calednarController.setRoot(root); 
	}
	
	
	public Parent getRoot() {
		return root;
	}
	
}
