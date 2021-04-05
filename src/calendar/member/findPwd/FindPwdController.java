package calendar.member.findPwd;

import calendar.common.CommonService;
import calendar.datadase.DatabaseService;
import calendar.datadase.IDatabaseService;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class FindPwdController {

	Parent root = null;
	String id = null;
	String name = null;
	int num = 0;
	
	IDatabaseService db = new DatabaseService();
	
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	public void closeFindPwd() {
		CommonService.close(root);
	}
	
	public void btnFindPwd() {
		try {
			TextField tmp = (TextField)root.lookup("#txtId");
			id = tmp.getText();
			tmp = (TextField)root.lookup("#txtName");
			name = tmp.getText();
			tmp = (TextField)root.lookup("#txtNum");
			num = Integer.parseInt(tmp.getText());
			
			String result = db.findPwd(id, name, num);
			
			if(result != null) {
				//alert로 아이디 알려주기
				CommonService.alert(AlertType.INFORMATION,name +"님의 비밀번호는 "+result+" 입니다.");
			}else {
				//alert : 해당 정보와 일치하는 정보 없습니다.
				CommonService.alert(AlertType.INFORMATION,"해당 정보와 일치하는 정보가 없습니다.");
			}
			
		}catch(Exception e) {
			CommonService.alert(AlertType.WARNING, "데이터를 올바르게 입력해주세요.");
		}
		
	
			
	}

}
