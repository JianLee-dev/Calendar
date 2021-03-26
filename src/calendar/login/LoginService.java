package calendar.login;

import calendar.datadase.DatabaseService;
import calendar.datadase.IDatabaseService;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginService implements ILoginService {

	IDatabaseService ds = new DatabaseService();
	
	@Override
	public void loginCheck(Parent root) {
		String userId = ((TextField)root.lookup("#userId")).getText();
		String userPw = ((PasswordField)root.lookup("#userPw")).getText();
		
		
		

	}

}
