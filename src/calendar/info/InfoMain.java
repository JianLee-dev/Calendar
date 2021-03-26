package calendar.info;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class InfoMain {
	
	Parent root = null;
	
public InfoMain() {
	
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Info.fxml"));
		
		
	
		try {
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();		
		}
		
		InfoController ic = loader.getController();
		ic.setRoot(root);
		
	}

	
	public Parent getRoot() {
		return root;
	}

}
