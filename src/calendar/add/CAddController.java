package calendar.add;

import java.net.URL;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.ResourceBundle;

import calendar.calendar.info.CalendarInfoController;
import calendar.calendar.info.CalendarInfoMain;
import calendar.common.CommonService;
import calendar.datadase.CalendarVO;
import calendar.datadase.DatabaseService;
import calendar.datadase.IDatabaseService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class CAddController implements Initializable {
	Parent root;
	CAddSurvice cs;
	IDatabaseService ds;
	
	public void setRoot(Parent root) {
		this.root = root;
		cs.setRoot(root);
		cs.setComboBox();
	}


	
	public void close() {
		CommonService.close(root);
	}

	public void save() {
		CalendarVO vo = cs.save();
		 ds.saveCalendar(vo);
		 CommonService.alert(AlertType.INFORMATION, "저장이 되었습니다.");
		
	
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cs = new CAddSurvice();
		ds = new DatabaseService();
	}


	


}
