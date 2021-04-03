package calendar.login;

import java.net.URL;
import java.util.ResourceBundle;

import calendar.calendar.CalendarController;
import calendar.common.CommonService;
import calendar.datadase.UserVO;
import calendar.main.MainForm;
import calendar.member.MemberMain;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class LoginController implements Initializable{

	@FXML ImageView imageView;
	@FXML Button confirm;
	@FXML Button cancel;
	@FXML Button register;
	@FXML TextField userId;
	@FXML PasswordField userPw;
	private Parent root;
	public static UserVO user;
	private ILoginService ls;
	
	

	public void setRoot(Parent root) {
		this.root = root;						
		ls.setStyle(root,this);					//스타일 
	}
	
	
	
	public void confirm() {
		if(ls.loginCheck(root)) { 				//비밀번호 확인
			ls.setLogin(root);					//로그인 사용자정보 저장 
			new MainForm(); 					// MainForm 오픈
			CalendarController.setdpNow();	 
			CommonService.close(root); 			//로그인창 닫기
		}else { //아이디또는 비밀번호 틀릴시 진입 	
			CommonService.alert(AlertType.WARNING, "없는 사용자 이거나 잘못된 비밀번호 입니다."); 
			((PasswordField)root.lookup("#userPw")).clear(); 								//비밀번호 오류시 비밀번호 삭제
		}
		
		
	}
	public void cancel() {
		CommonService.close(root);				//취소 누를시 로그인창 닫기
	}
	public void register() {
		new MemberMain(); 						//회원가입 누를시 회원가입창 오픈
	}
	
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ls = new LoginService();
		
	}
}
