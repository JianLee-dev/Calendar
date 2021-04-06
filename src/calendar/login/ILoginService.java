package calendar.login;

import javafx.scene.Parent;

public interface ILoginService {
	
	//로그인 성공 유무 확인
	boolean loginCheck(Parent root);
	
	//로그인 성공시 로그인 정보 유지 
	void setLogin(Parent root);
	
	//스타일 + action
	void setStyle(Parent root, LoginController lc);
	
	//아이디 기억하기 체크 -> new File 를 이용해 아이디 기억하는 text file 생성
	void saveUserId(String userId);
	
	//만약 text file에 저장된 아이디가 있으면 세팅
	void setLoginText(LoginController loginController);

}
