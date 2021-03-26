package calendar.login;

import java.net.URL;
import java.util.ResourceBundle;

import calendar.calendar.CalendarMain;
import calendar.common.CommonService;
import calendar.datadase.UserVO;
import calendar.member.MemberMain;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class LoginController implements Initializable{

	@FXML ImageView imageView;
	
	private Parent root;
	private UserVO user;
	private ILoginService ls;
	
	public void setUser(UserVO user) {
		this.user = user;
	}
	public UserVO getUser() {
		return user;
	}
	public void setRoot(Parent root) {
		this.root = root;
		setImage();
	}
	
	public void setImage() {
		Image img = new Image("/calendar/resources/img/calendar.png");
		imageView.setImage(img);
	}
	
	
	public void confirm() {
		//ls.loginCheck(root);
		new CalendarMain();
		CommonService.close(root);
		
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
