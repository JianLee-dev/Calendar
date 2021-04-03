package calendar.calendar.info;

import java.net.URL;
import java.util.ResourceBundle;

import calendar.calendar.CService;
import calendar.calendar.CalendarController;
import calendar.calendar.CalendarMain;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class CalendarInfoController implements Initializable {

	@FXML TableView<ViewTableModel> tableView;
	@FXML TableColumn<ViewTableModel, String> category; 
	@FXML TableColumn<ViewTableModel, String> name; 
	@FXML TableColumn<ViewTableModel, Integer> price; 
	@FXML Button cancel;
	@FXML Button add;
	CalendarInfoService cis;
	
	
	public void add () {
		//setTable();
	}
	
	public void cancel() {
		CService.bp.setCenter(new CalendarMain().getRoot()); 
		((DatePicker)CalendarController.root.lookup("#dp")).setValue(CalendarController.date);
		new CService().setCalendar(CalendarController.date, CalendarController.labelList);
	}
	
	public void setTable() {

		tableView.setItems(cis.setTable(category,name,price));
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cis = new CalendarInfoService();
		tableView.setPlaceholder(new Label("등록된 가계가 없습니다"));
	

		
		
	}
	
}
