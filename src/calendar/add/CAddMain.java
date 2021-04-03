package calendar.add;

import java.io.IOException;
import java.lang.ModuleLayer.Controller;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CAddMain {
	
	public static Parent root;
	public static CAddController cAddController;
	
	public CAddMain() {
		

		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("add.fxml"));
		
		try {
			root = loader.load();
			cAddController = loader.getController();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		cAddController.setRoot(root);
		
		Stage stage = new Stage();
		stage.setScene(new Scene(root));
		stage.show();
	}
	
	
	
}
