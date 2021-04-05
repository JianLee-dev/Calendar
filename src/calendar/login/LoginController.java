package calendar.login;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import calendar.calendar.CalendarController;
import calendar.common.CommonService;
import calendar.datadase.UserVO;
import calendar.main.MainForm;
import calendar.member.MemberMain;
import calendar.member.findId.FindIdMain;
import calendar.member.findPwd.FindPwdMain;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class LoginController implements Initializable{

	@FXML ImageView imageView;
	@FXML Button confirm;
	@FXML Button cancel;
	@FXML Button register;
	@FXML TextField userId;
	@FXML PasswordField userPw;
	@FXML CheckBox ckId;
	private Parent root;
	public static UserVO user;
	private ILoginService ls;

	private String savedUser;


	public void setRoot(Parent root) {
		this.root = root;						
		ls.setStyle(root,this);					//스타일 
	}



	public void confirm() {

		if(ckId.isSelected()==true) {
			saveUserId(userId.getText());
		}else {
			saveUserId("");
		}

		if(ls.loginCheck(root)) { 				//비밀번호 확인
			ls.setLogin(root);					//로그인 사용자정보 저장 
			new MainForm(); 					// MainForm 오픈
			CalendarController.setdpNow();	 
			CommonService.close(root); 			//로그인창 닫기
		}else { //아이디또는 비밀번호 틀릴시 진입 	
			CommonService.alert(AlertType.WARNING, "없는 사용자 이거나 잘못된 비밀번호 입니다."); 
			((PasswordField)root.lookup("#userPw")).clear(); 								//비밀번호 오류시 비밀번호 삭제
		}


	}
	public void cancel() {
		CommonService.close(root);				//취소 누를시 로그인창 닫기
	}
	public void register() {
		new MemberMain(); 						//회원가입 누를시 회원가입창 오픈
	}

	private void saveUserId(String userId) {
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

	private void setLoginText() {
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

			savedUser = dis.readUTF();


		}catch(Exception e) {
			System.out.println("savedUser 실패");
		}finally {
			try {
				dis.close(); bis.close(); fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
		System.out.println(savedUser);
		if(savedUser != null && !savedUser.equals("")) {

			userId.setText(savedUser);
			ckId.setSelected(true);

		}
	}

	public void findId() {
		System.out.println("아이디찾기");
		new FindIdMain();
	}

	public void findPwd() {
		System.out.println("비밀번호찾기");
		new FindPwdMain();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ls = new LoginService();
		setLoginText();
	}
}
