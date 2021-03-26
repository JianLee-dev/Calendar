package calendar.member;

import java.time.LocalDate;

import calendar.common.CommonService;
import calendar.datadase.DatabaseService;
import calendar.datadase.UserVO;
import javafx.scene.Parent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class MemberService implements IMemberService {
	
	private String userId;
	private String userPw;
	private String userPwChk;
	private String userName;
	private Integer userBirth;
	private Integer userPhone;
	DatabaseService ds = new DatabaseService();
	
	@Override
	public void addMember(UserVO userVO) {
		ds.addMember(userVO);
		
	}

	@Override
	public void delMember(String userId) {
		ds.delMember(userId);
		
	}

	@Override
	public void modifyMember(Parent root) {
		UserVO userVO = null;
		ds.modifyMember(userVO);
		
	}

	//회원가입시 입력확인
	@Override
	public UserVO checkMember(Parent root) {
		
		try {
			userId = ((TextField)root.lookup("#userId")).getText();
			userPw = ((PasswordField)root.lookup("#userPw")).getText();
			userPwChk = ((PasswordField)root.lookup("#userPwChk")).getText();
			userName = ((TextField)root.lookup("#userName")).getText();
			LocalDate date =(((DatePicker)root.lookup("#userBirth")).getValue());
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
			userBirth = Integer.parseInt(year + month + day);
			System.out.println(userBirth + "사용자 생일 로그 ");
			System.out.println(date.getYear()+"년");
			System.out.println(date.getMonthValue()+"월");
			System.out.println( date.getDayOfMonth()+"일");
			String phone = ((TextField)root.lookup("#userPhone")).getText();
			userPhone = Integer.parseInt(phone.strip());
			
		} catch (Exception e) {
		}

		if (userId == null || userId.equals("")) {
			CommonService.alert(AlertType.WARNING, "아이디를 입력하세요");
			return null;
		}
		if (userPw == null || userPw.equals("")) {
			CommonService.alert(AlertType.WARNING, "비밀번호를 입력하세요");
			return null;
		}
		if (!userPw.equals(userPwChk)) {
			CommonService.alert(AlertType.WARNING, "비밀번호가 일치하지 않습니다");
			return null;
		}
		if (userName == null || userName.equals("")) {
			CommonService.alert(AlertType.WARNING, "이름을 입력하세요");
			return null;
		}
		if (userBirth == null || userBirth.equals("")) {
			CommonService.alert(AlertType.WARNING, "생일을 입력하세요");
			return null;
		}
		if (userPhone == null || userPhone.equals("")) {
			CommonService.alert(AlertType.WARNING, "핸드폰 번호를 입력하세요");
			return null;
		}
		
		UserVO userVO = new UserVO();
		userVO.setUserId(userId);
		userVO.setUserPw(userPw);
		userVO.setUserName(userName);
		userVO.setUserBirth(userBirth);
		userVO.setUserPhone(userPhone);
		return userVO;
	
	}
}
