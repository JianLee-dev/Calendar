package calendar.calendar;

import javafx.scene.Parent;

public class CalenderController {
	Parent root;

	public void setRoot(Parent root) {

		this.root = root;
	}

	public void btn01() {
		System.out.println("캘린더 화면으로 이동");
	}

	public void btn02() {
		System.out.println("그래프로 화면 이동");
	}

	public void btn03() {
		System.out.println("회원 정보 화면으로 이동");
	}
}
