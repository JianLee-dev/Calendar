package calendar.main;

import java.net.URL;
import java.util.ResourceBundle;

import calendar.info.InfoMain;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class CalendarController implements Initializable{
	Parent root;
	
	@FXML BorderPane borderPane;
	public void setRoot(Parent root) {

		this.root = root;
	}

	public void btn01() {
		System.out.println("캘린더 화면으로 이동");
	}

	public void btn02() {
		System.out.println("그래프로 화면 이동");
	}

	public void btn03() {
		borderPane.setCenter(new InfoMain());
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
