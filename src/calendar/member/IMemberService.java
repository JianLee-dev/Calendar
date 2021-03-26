package calendar.member;

import calendar.datadase.UserVO;
import javafx.scene.Parent;

public interface IMemberService {
	
	//회원추가
	void addMember(UserVO userVO);
	
	//회원삭제
	void delMember(String userId);
	
	//회원수정
	void modifyMember(Parent root);
	
	//로그인 검사
	UserVO checkMember(Parent root);
	
	
	

}
