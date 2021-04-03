package calendar.add;

import java.net.URL;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.ResourceBundle;

import calendar.calendar.info.CalendarInfoController;
import calendar.calendar.info.CalendarInfoMain;
import calendar.common.CommonService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class CAddController implements Initializable {
	Parent root;

	public void setRoot(Parent root) {
		this.root = root;
		
	}
	public void close() {
		CommonService.close(root);
	}

	public void save() {
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}


	


}
