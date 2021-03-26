package calendar.main;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class MainFromController implements Initializable{
	Parent root;
	
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
		System.out.println("회원 정보 화면으로 이동");
		cs.showInfo();
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		cs = new MainFormSurvice();
	}
}
