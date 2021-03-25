package calendar.member;

import java.time.LocalDate;

import calendar.datadase.DatabaseService;
import calendar.datadase.UserVO;
import javafx.scene.Parent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class MemberService implements IMemberService {
	
	private String userId;
	private String userPw;
	private String userName;
	private Integer userBirth;
	private Integer userPhone;
	DatabaseService ds;
	
	@Override
	public void addMember(Parent root) {
		userId = ((TextField)root.lookup("#userId")).getText();
		userPw = ((PasswordField)root.lookup("#userPw")).getText();
		userName = ((TextField)root.lookup("#userName")).getText();
		LocalDate date =(((DatePicker)root.lookup("#userBirth")).getValue());
		userBirth = date.getYear() + date.getMonthValue() + date.getDayOfMonth();
		String phone = ((TextField)root.lookup("#userPhone")).getText();
		userPhone = Integer.parseInt(phone.strip());
		UserVO userVO = new UserVO();
		userVO.setUserId(userId);
		userVO.setUserPw(userPw);
		userVO.setUserName(userName);
		userVO.setUserBirth(userBirth);
		userVO.setUserPhone(userPhone);
		ds = new DatabaseService();
		ds.addMember(userVO);
		
	}

	@Override
	public void delMember(String userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyMember(Parent root) {
		// TODO Auto-generated method stub
		
	}

}
