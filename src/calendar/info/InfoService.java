package calendar.info;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class InfoService {
	
	public void check(Parent root) {
		String userId = ((TextField)root.lookup("#userId")).getText();
		
		System.out.println(userId);
	}

}
