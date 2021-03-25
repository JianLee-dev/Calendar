package calendar.service;

import javafx.scene.Parent;
import javafx.scene.control.Alert.AlertType;

public interface ICommonService {
	
	//Parent root 받아 창 닫기
	void close(Parent root);
	
	// 경고창 띄우기
	void alert(AlertType alertType, String message);

}
