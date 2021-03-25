package calendar.member;

import java.net.URL;
import java.util.ResourceBundle;

import calendar.service.CommonService;
import calendar.service.ICommonService;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class MemberController implements Initializable {

	Parent root;
	ICommonService ms;
	
	
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	
	public void confirm() {
		
	}
	public void cancel() {
		
	}
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ms = new CommonService();
		
	}
}
