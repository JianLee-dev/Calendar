package calendar.login;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginMain extends Application {
	public static Parent root;
	public static LoginController loginController;
	@Override
	public void start(Stage primaryStage) {
		root = null;
		loginController = null;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginStage.fxml"));
		try {
			root = loader.load();
			loginController = loader.getController();
		} catch (IOException e) {
			e.printStackTrace();
		}
		loginController.setRoot(root);
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
