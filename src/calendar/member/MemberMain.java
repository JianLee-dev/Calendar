package calendar.member;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MemberMain {
	
	Parent root;
	MemberController mc;
	

	
	public MemberMain() {
	Stage stage = new Stage();
			
		FXMLLoader loader = new FXMLLoader(getClass().getResource("MemberStage.fxml"));
		
		try {
			root = loader.load();
			mc = loader.getController();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		mc.setRoot(root);
		
		
		stage.setScene(new Scene(root));
		stage.show();
	}
		
	
}
