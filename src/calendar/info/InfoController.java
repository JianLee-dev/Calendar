package calendar.info;

import javafx.scene.Parent;

public class InfoController {
	
	Parent root = null;
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	
	public void confirm(){
		System.out.println("리얼 확인");
	}

}
