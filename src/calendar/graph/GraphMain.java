package calendar.graph;


import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GraphMain extends Application{
	

	@Override
	public void start(Stage arg0) throws Exception {
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("graphView.fxml")); 
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Scene scene = new Scene(root);
		
		arg0.setScene(scene);
		arg0.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	public Parent getGraphScene() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("graphView.fxml"));
		Parent root = loader.load();
		//Scene scene = new Scene(root);
		
		return root;
	}

}
