package calendar.login;

import java.net.URL;
import java.util.ResourceBundle;

import calendar.common.CommonService;
import calendar.datadase.UserVO;
import calendar.main.CalendarMain;
import calendar.member.MemberMain;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class LoginController implements Initializable{

	@FXML ImageView imageView;
	
	private Parent root;
	public static UserVO user;
	private ILoginService ls;
	
	

	public void setRoot(Parent root) {
		this.root = root;
		setImage();
	}
	
	public void setImage() {
		Image img = new Image("/calendar/resources/img/calendar.png");
		imageView.setImage(img);
	}
	
	
	public void confirm() {
//		if(ls.loginCheck(root)) {
//			ls.setLogin(root);
//			new CalendarMain();
//			CommonService.close(root);
//		}else {
//			CommonService.alert(AlertType.WARNING, "없는 사용자 이거나 잘못된 비밀번호 입니다.");
//		}
		new CalendarMain();
		
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
