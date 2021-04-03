package calendar.add;

import java.net.URL;
import java.util.ResourceBundle;

import calendar.calendar.info.CalendarInfoMain;
import calendar.common.CommonService;
import calendar.datadase.IDatabaseService;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert.AlertType;

public class CAddController implements Initializable {
	Parent root;

	CAddService cas;
	IDatabaseService ds;
	
	public void setRoot(Parent root) {
		this.root = root;
		cas.setComboBox(root);
		System.out.println("setcombobox");
	}



	
	public void close() {
		CommonService.close(root);
	}

	public void save() {

		cas.addCalendar(root);
		CalendarInfoMain.calendarInfoController.setTable();
		 CommonService.alert(AlertType.INFORMATION, "저장이 되었습니다.");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		cas = new CAddService();
		

	}


	


}
