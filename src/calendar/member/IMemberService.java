package calendar.member;

import calendar.datadase.UserVO;

public interface IMemberService {
	
	//회원추가
	void addMember(UserVO userVO);
	
	//회원삭제
	void delMember(String userId);
	
	//회원수정
	void modifyMember(UserVO userVO);
	
	
	

}
