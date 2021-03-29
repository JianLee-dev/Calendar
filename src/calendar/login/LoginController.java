package calendar.login;

import java.net.URL;
import java.util.ResourceBundle;

import calendar.common.CommonService;
import calendar.datadase.UserVO;
import calendar.main.FormMain;
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
		setStyle();		
	}
	
	public void setStyle() {
		Image img1 = new Image("/calendar/resources/img/calendar.jpg");
		imageView.setImage(img1);
		confirm.setStyle("-fx-base: #8F98FF;");
		cancel.setStyle("-fx-base: #8F98FF;");
		register.setStyle("-fx-base: #8F98FF;");
		userId.setPromptText("아이디");
		userPw.setPromptText("비밀번호");
		//입력후 enter -> 로그인 버튼 클릭
		userId.setOnKeyPressed(new EventHandler<KeyEvent>() {
		public void handle(KeyEvent event) {
			if(event.getCode().equals(KeyCode.ENTER)) {
				confirm();
			}
			};
		});
		//입력후 enter -> 로그인 버튼 클릭
		userPw.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if(event.getCode().equals(KeyCode.ENTER)) {
					confirm();
				}
				};
			});
	}
	
	
	public void confirm() {
		if(ls.loginCheck(root)) {
			ls.setLogin(root);
			new FormMain();
			((Stage)root.getScene().getWindow()).close();
			CommonService.close(root);
		}else {
			CommonService.alert(AlertType.WARNING, "없는 사용자 이거나 잘못된 비밀번호 입니다.");
		}
		
		
	}
	public void cancel() {
		CommonService.close(root);
	}
	public void register() {
		new MemberMain();
	}
	
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ls = new LoginService();
		
	}
}
