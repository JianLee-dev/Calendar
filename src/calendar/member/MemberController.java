package calendar.member;

import java.net.URL;
import java.util.ResourceBundle;

import calendar.common.CommonService;
import calendar.datadase.UserVO;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert.AlertType;

public class MemberController implements Initializable {

	Parent root;
	IMemberService ms;
	
	
	
	public void setRoot(Parent root) {
		this.root = root;
		ms.setImg(root);
		ms.setStyle(root, this);
	}
	
	
	public void confirm() {
		UserVO userVO = ms.checkMember(root); //회원가입창 정보입력 확인
		if(userVO != null) { 
			if(ms.duplicateMember(userVO.getUserId()).getUserId()==null) { //회원가입 중복 아이디 판별
				ms.addMember(userVO);
				CommonService.close(root);		
			}else{ 
				CommonService.alert(AlertType.WARNING, "이미 등록된 아이디 입니다.");
			};
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
