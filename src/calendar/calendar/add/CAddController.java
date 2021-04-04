package calendar.calendar.add;

import java.net.URL;
import java.util.ResourceBundle;

import calendar.calendar.info.CalendarInfoMain;
import calendar.common.CommonService;
import calendar.datadase.IDatabaseService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

public class CAddController implements Initializable {
	Parent root;

	CAddService cas;
	IDatabaseService ds;
	@FXML Button confirm;
	@FXML Button cancel;
	public static boolean flag;
	public static Integer cNo;
	
	
	public void setRoot(Parent root) {
		this.root = root;
		cas.setComboBox(root);
		cas.enterConfirm(root);
		System.out.println("setcombobox");
		System.out.println("setenterconfirm");
	}



	
	public void cancel() {

			CommonService.close(root);
	
	}

	public void confirm() {
			if(flag == true) {
				System.out.println("추가");
				cas.addCalendar(root);
			}else {
				System.out.println("수정");
				cas.modifyCalendar(root);
			}
			CalendarInfoMain.calendarInfoController.setTable();
			CommonService.alert(AlertType.INFORMATION, "저장이 되었습니다.");
		}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		cas = new CAddService();
		
		

	}


	


}
