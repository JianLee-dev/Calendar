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
		String userId = ((TextField)root.lookup("#userId")).getText();
		String userPw = ((PasswordField)root.lookup("#userPw")).getText();
		UserVO userVO = new UserVO();
		userVO.setUserId(userId);
		userVO.setUserPw(userPw);
		return ds.loginCheck(userVO);
	}

}
