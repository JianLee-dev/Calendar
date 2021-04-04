package calendar.member.findId;

import java.io.IOException;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FindIdMain{

	Parent root;
	FindIdController fic;
	
	public FindIdMain() {
		Stage stage = new Stage();
			
		FXMLLoader loader = new FXMLLoader(getClass().getResource("findId.fxml"));
		
		try {
			root = loader.load();
			fic = loader.getController();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		fic.setRoot(root);
		
		
		stage.setScene(new Scene(root));
		stage.show();
	}
}
