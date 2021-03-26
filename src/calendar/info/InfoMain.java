package calendar.info;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

public class InfoMain extends AnchorPane {
	
	public InfoMain() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Info.fxml"));
		Parent root = this;
		loader.setRoot(this);
		loader.setController(this);
		try {
			loader.load();
		} catch (IOException e) {
			e.printStackTrace();		
		}
	}
	
	public void confirm() {
		System.out.println("확인");
	}
	public void cancel() {
		
	}
	public void modify() {
		
	}
}
