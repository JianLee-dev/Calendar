package calendar.calendar;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CalendarMain extends Application {

	@Override
	public void start(Stage primaryStage) {
		Parent root = null;
		CalendarController cc = null;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("calender.fxml"));
		try {
			root = loader.load();
			cc = loader.getController();
		} catch (IOException e) {
			e.printStackTrace();
		}
		cc.setRoot(root);
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
