package calendar.login;

import java.net.URL;
import java.util.ResourceBundle;

import calendar.member.MemberMain;
import calendar.service.CommonService;
import calendar.service.ICommonService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class LoginController implements Initializable{

	@FXML ImageView imageView;
	
	Parent root;
	ICommonService cs;
	
	
	public void setRoot(Parent root) {
		this.root = root;
		setImage();
	
	}
	
	public void setImage() {
		Image img = new Image("/calendar/resources/img/calendar.png");
		imageView.setImage(img);
	}
	
	
	public void confirm() {
		//cs.close(root);
		
	}
	public void cancel() {
		cs.close(root);
	}
	public void register() {
		new MemberMain();
	}
	
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cs = new CommonService();
		
	}
}
