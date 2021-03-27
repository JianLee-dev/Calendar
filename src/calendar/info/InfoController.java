package calendar.info;

import java.net.URL;
import java.util.ResourceBundle;

import calendar.common.CommonService;
import calendar.datadase.DatabaseService;
import calendar.datadase.IDatabaseService;
import calendar.datadase.UserVO;
import calendar.login.LoginController;
import calendar.member.IMemberService;
import calendar.member.MemberService;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert.AlertType;

public class InfoController implements Initializable {
	
	Parent root = null;
	IMemberService ms;
	InfoService is;
	IDatabaseService ds;
	public void setRoot(Parent root) {
		this.root = root;
		is.setInfo(root);
	}
	

	
	public void confirm(){
		UserVO user = is.checkInfo(root);
		if( user != null) {
			ds.modifyMember(user);
			LoginController.user = user;
			CommonService.alert(AlertType.INFORMATION, "회원정보가 수정되었습니다.");
			is.disable();
		}
	
	}
	public void modify() {
		is.enable();
	}
	
	public void cancel() {
		is.setInfo(root);
		is.disable();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ms = new MemberService();
		is = new InfoService();
		ds = new DatabaseService();
		
	}
}
