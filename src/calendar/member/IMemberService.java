package calendar.member;

import calendar.datadase.UserVO;
import javafx.scene.Parent;

public interface IMemberService {
	
	//회원추가
	int addMember(UserVO userVO);
	
	//회원삭제
	void delMember(String userId);
	
	//회원수정
	void modifyMember(Parent root);
	
	//로그인 검사
	UserVO checkMember(Parent root);
	
	//중복회원 체크
	UserVO duplicateMember(String userId);
	
	//이미지 적용
	void setImg(Parent root);
	
	//스타일 적용
	void setStyle(Parent root, MemberController mc);
	

	
	

}
