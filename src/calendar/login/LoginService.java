package calendar.login;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import calendar.datadase.DatabaseService;
import calendar.datadase.IDatabaseService;
import calendar.datadase.UserVO;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class LoginService implements ILoginService {

	IDatabaseService ds = new DatabaseService();

	//로그인 아이디 비밀번호 확인
	@Override
	public boolean loginCheck(Parent root) {
		TextField userId = ((TextField)root.lookup("#userId"));
		PasswordField userPw = ((PasswordField)root.lookup("#userPw"));
		UserVO userVO = new UserVO();
		userVO.setUserId(userId.getText());
		userVO.setUserPw(userPw.getText());
		return ds.loginCheck(userVO);
	}


	//로그성공시 로그인정보 저장 
	@Override
	public void setLogin(Parent root) {
		LoginController.user = ds.getMember(((TextField)root.lookup("#userId")).getText());

	}


	//스타일
	public void setStyle(Parent root, LoginController lc) {
		Button confirm = (Button)root.lookup("#confirm");
		Button cancel = (Button)root.lookup("#cancel");
		Button register = (Button)root.lookup("#register");
		TextField userId = (TextField)root.lookup("#userId");
		PasswordField userPw = (PasswordField)root.lookup("#userPw");

		confirm.setStyle("-fx-base:  #ECDEC3;");				//버튼 색깔 적용
		cancel.setStyle("-fx-base:  #ECDEC3;");
		register.setStyle("-fx-base:  #ECDEC3;");
		userId.setPromptText("아이디");						//아무것도 입력하지 않았을시 보이는 텍스트 || placeholder 
		userPw.setPromptText("비밀번호");

		//입력후 enter -> 로그인 버튼 클릭
		userId.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if(event.getCode().equals(KeyCode.ENTER)) {
					lc.confirm();
				}
			};
		});
		//입력후 enter -> 로그인 버튼 클릭
		userPw.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if(event.getCode().equals(KeyCode.ENTER)) {
					lc.confirm();
				}
			};
		});
	}




	public void saveUserId(String userId) {
		File path=null;
		FileOutputStream fos =null;
		BufferedOutputStream bos = null;
		DataOutputStream dos  = null;

		try {
			System.out.println("saveUserId 메서드 작동");
			path = new File("saveId.txt");
			fos = new FileOutputStream(path);
			bos = new BufferedOutputStream(fos);
			dos = new DataOutputStream(bos);

			dos.writeUTF(userId);


		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				dos.close(); bos.close(); fos.close();
			} catch (Exception e2) {
			}
		}
	}




	public void setLoginText(LoginController loginController) {
		File path=null;
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		DataInputStream dis = null;
		try {
			System.out.println("setLoginText 메서드 작동");
			path = new File("saveId.txt");
			path.createNewFile();
			System.out.println(	path.getCanonicalPath());
			System.out.println(path);
			fis = new FileInputStream(path);
			bis = new BufferedInputStream(fis);
			dis = new DataInputStream(bis);

			loginController.savedUser = dis.readUTF();


		}catch(Exception e) {
			System.out.println("savedUser 실패");
		}finally {
			try {
				dis.close(); bis.close(); fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
		System.out.println(loginController.savedUser + " = savedUser => setLoginText() 메서드 동작  ");
		if(loginController.savedUser != null && !loginController.savedUser.equals("")) {

			loginController.userId.setText(loginController.savedUser);
			loginController.ckId.setSelected(true);

		}
	}




}
