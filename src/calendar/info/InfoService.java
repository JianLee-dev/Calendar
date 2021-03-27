package calendar.info;

import java.time.LocalDate;

import calendar.common.CommonService;
import calendar.datadase.UserVO;
import calendar.login.LoginController;
import javafx.scene.Parent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class InfoService {
	
	
	private TextField userId;
	private TextField userPw;
	private TextField userPwChk;
	private TextField userName;
	private DatePicker userBirth;
	private TextField userPhone;
	UserVO userInfo = LoginController.user;
	
	//setInfo
	public void setInfo(Parent root) {
		
		
		userId = ((TextField)root.lookup("#userId"));
		userPw = ((PasswordField)root.lookup("#userPw"));
		userName = ((TextField)root.lookup("#userName"));
		userBirth =((DatePicker)root.lookup("#userBirth"));
		userPhone = ((TextField)root.lookup("#userPhone"));

		userId.setText(userInfo.getUserId()); 
		userPw.setText(userInfo.getUserPw());  
		userName.setText(userInfo.getUserName());	
		userPhone.setText("0"+userInfo.getUserPhone());	
		int birth = userInfo.getUserBirth();
		int year = birth/10000;
		int month = (birth-(year*10000))/100;
		int day = birth-((year*10000)+(month*100));
		System.out.println("생일 : " + birth ); 
		userBirth.setValue(LocalDate.of(year, month, day));
		
		disable();
	}
	
	
	//check Info 
	public UserVO checkInfo(Parent root) {

		if (userId == null || userId.getText().equals("")) {
			CommonService.alert(AlertType.WARNING, "아이디를 입력하세요");
			return null;
		}
		if (userPw == null || userPw.getText().equals("")) {
			CommonService.alert(AlertType.WARNING, "비밀번호를 입력하세요");
			return null;
		}
		
		if (userName == null || userName.getText().equals("")) {
			CommonService.alert(AlertType.WARNING, "이름을 입력하세요");
			return null;
		}
		if (userBirth == null || userBirth.getValue() == null) {
			CommonService.alert(AlertType.WARNING, "생일을 입력하세요");
			return null;
		}
		if (userPhone == null || userPhone.getText().equals("")) {
			CommonService.alert(AlertType.WARNING, "핸드폰 번호를 입력하세요");
			return null;
		}
		
		UserVO userVO = new UserVO();
		userVO.setUserId(userId.getText());
		userVO.setUserPw(userPw.getText());
		userVO.setUserName(userName.getText());
		LocalDate date =userBirth.getValue();
		String year = date.getYear()+"";
		String month = null;
		if(date.getMonthValue()<10) {
			month = "0" + date.getMonthValue();
		}else{
			month = "" + date.getMonthValue();
		};
		String day = null;
		if(date.getDayOfMonth()<10) {
			day = "0" + date.getMonthValue();
		}else{
			day = "" + date.getMonthValue();
		};
		userVO.setUserBirth(Integer.parseInt(year + month + day));
		userVO.setUserPhone(Integer.parseInt(userPhone.getText()));
		return userVO;
	}
	
	//update info
	
	//enable 
	public void enable() {
		userId.setDisable(true);
		userPw.setDisable(false);
		userName.setDisable(false);
		userBirth.setDisable(false);
		userPhone.setDisable(false);
	}
	//disable
	public void disable() {
		userId.setDisable(true);
		userPw.setDisable(true);
		userName.setDisable(true);
		userBirth.setDisable(true);
		userPhone.setDisable(true);
	}
	
	
	

}
