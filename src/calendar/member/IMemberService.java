package calendar.member;

import javafx.scene.Parent;

public interface IMemberService {
	
	//회원추가
	void addMember(Parent root);
	
	//회원삭제
	void delMember(String userId);
	
	//회원수정
	void modifyMember(Parent root);
	
	
	

}
