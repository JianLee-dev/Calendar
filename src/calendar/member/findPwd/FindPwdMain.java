package calendar.member.findPwd;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FindPwdMain {

	Parent root;
	FindPwdController fpc;
	
	public FindPwdMain() {
		Stage stage = new Stage();
			
		FXMLLoader loader = new FXMLLoader(getClass().getResource("findPwd.fxml"));
		
		try {
			root = loader.load();
			fpc = loader.getController();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		fpc.setRoot(root);
		
		
		stage.setScene(new Scene(root));
		stage.show();
	}

}
