package calendar.main;

import java.net.URL;
import java.util.ResourceBundle;

import calendar.calendar.CalendarMain;
import calendar.info.InfoMain;
import calendar.login.LoginController;
import calendar.login.LoginMain;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainFromController implements Initializable{
	Parent root;
	

	@FXML BorderPane borderPane;

	

	public void setRoot(Parent root) {
		
		this.root = root;
		
	}

	public void btn01() {
		borderPane.setCenter(new CalendarMain());
		System.out.println("캘린더 화면으로 이동");

	}

	public void btn02() {
		System.out.println("그래프로 화면 이동");

	}

	public void btn03() {
		borderPane.setCenter((new InfoMain()).getRoot());
		System.out.println("회원 정보 화면으로 이동");
	
	}
	
	public void logout() {
		LoginController.user = null;
		((Stage)root.getScene().getWindow()).close();
		new LoginMain().start(new Stage());
		}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {


	}
}
