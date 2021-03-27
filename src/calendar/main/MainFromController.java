package calendar.main;

import java.net.URL;
import java.util.ResourceBundle;

import calendar.calendar.CalendarMain;
import calendar.info.InfoMain;
import calendar.info.InfoMain;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class MainFromController implements Initializable{
	Parent root;
	

	@FXML BorderPane borderPane;

	ImainFormSurvice cs;
	

	public void setRoot(Parent root) {
		
		this.root = root;
		cs.setRoot(root);
	}

	public void btn01() {
		System.out.println("캘린더 화면으로 이동");
		cs.showCalendar();
	}

	public void btn02() {
		System.out.println("그래프로 화면 이동");
		cs.showGraph();
	}

	public void btn03() {
		borderPane.setCenter((new InfoMain()).getRoot());
		System.out.println("회원 정보 화면으로 이동");
		cs.showInfo();

	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		cs = new MainFormSurvice();
	}
}
