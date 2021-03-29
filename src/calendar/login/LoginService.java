package calendar.login;

import calendar.datadase.DatabaseService;
import calendar.datadase.IDatabaseService;
import calendar.datadase.UserVO;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginService implements ILoginService {

	IDatabaseService ds = new DatabaseService();
	
	@Override
	public boolean loginCheck(Parent root) {
		TextField userId = ((TextField)root.lookup("#userId"));
		PasswordField userPw = ((PasswordField)root.lookup("#userPw"));
		UserVO userVO = new UserVO();
		userVO.setUserId(userId.getText());
		userVO.setUserPw(userPw.getText());
		return ds.loginCheck(userVO);
	}

	@Override
	public void setLogin(Parent root) {
		LoginController.user = ds.getMember(((TextField)root.lookup("#userId")).getText());
		
	}
}
