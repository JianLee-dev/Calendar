package calendar.add;

import java.io.IOException;
import java.lang.ModuleLayer.Controller;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CAddMain {
	
	Parent root;
	
	
	public CAddMain() {
		
Stage stage = new Stage();
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("add.fxml"));
		Parent root = null;
		try {
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		
		CAddController controller = loader.getController();
		controller.setRoot(root);
		
		stage.setScene(scene);
		stage.show();
	}
	
	
	
}
