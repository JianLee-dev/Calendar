package calendar.member;

import java.net.URL;
import java.util.ResourceBundle;

import calendar.common.CommonService;
import calendar.datadase.UserVO;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class MemberController implements Initializable {

	Parent root;
	IMemberService ms;
	
	
	
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	
	public void confirm() {
		UserVO userVO = ms.checkMember(root);
		if(userVO != null) {
			ms.addMember(userVO);
			CommonService.close(root);
		};
	}
	public void cancel(){
		CommonService.close(root);
	}
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	ms = new MemberService();
		
	}
}
