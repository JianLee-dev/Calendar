package calendar.member;

import java.time.LocalDate;

import calendar.common.CommonService;
import calendar.datadase.DatabaseService;
import calendar.datadase.UserVO;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class MemberService implements IMemberService {
	
	private String userId;
	private String userPw;
	private String userPwChk;
	private String userName;
	private Integer userBirth;
	private Integer userPhone;
	DatabaseService ds = new DatabaseService();
	
	@Override
	public int addMember(UserVO userVO) {
		return ds.addMember(userVO);
		
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
				day = "0" + date.getDayOfMonth();
			}else{
				day = "" + date.getDayOfMonth();
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

	@Override
	public UserVO duplicateMember(String userId) {
		return ds.getMember(userId);
		
	}
	


	@Override
	public void setStyle(Parent root, MemberController mc) {
		
		TextField userId = ((TextField)root.lookup("#userId"));
		PasswordField userPw = ((PasswordField)root.lookup("#userPw"));
		PasswordField userPwChk = ((PasswordField)root.lookup("#userPwChk"));
		TextField userName = ((TextField)root.lookup("#userName"));
		DatePicker userBirth =((DatePicker)root.lookup("#userBirth"));
		TextField userPhone = ((TextField)root.lookup("#userPhone"));
		
		userId.setPromptText("아이디");
		userPw.setPromptText("비밀번호");
		userPwChk.setPromptText("비밀번호 확인");
		userName.setPromptText("이름");
		userBirth.setPromptText("생일");
		userPhone.setPromptText("연락처");
		
		EventHandler<KeyEvent> enter = new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if(event.getCode().equals(KeyCode.ENTER)) {
					mc.confirm();
				} //if end
			}; //method handle end 
		}; // new end
				
		userId.setOnKeyPressed(enter);
		userPw.setOnKeyPressed(enter);
		userPwChk.setOnKeyPressed(enter);
		userName.setOnKeyPressed(enter);
		userBirth.setOnKeyPressed(enter);
		userPhone.setOnKeyPressed(enter);
		
	}
}
