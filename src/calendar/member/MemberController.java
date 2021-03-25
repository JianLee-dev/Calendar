package calendar.member;

import java.net.URL;
import java.util.ResourceBundle;

import calendar.common.CommonService;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class MemberController implements Initializable {

	Parent root;
	IMemberService ms;
	
	
	
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	
	public void confirm() {
		ms.addMember(root);
		CommonService.close(root);
	}
	public void cancel(){
		CommonService.close(root);
	}
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	ms = new MemberService();
		
	}
}
