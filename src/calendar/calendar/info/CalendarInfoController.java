package calendar.calendar.info;

import java.net.URL;
import java.util.ResourceBundle;

import calendar.calendar.CService;
import calendar.calendar.CalendarController;
import calendar.calendar.CalendarMain;
import calendar.calendar.add.CAddController;
import calendar.calendar.add.CAddMain;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class CalendarInfoController implements Initializable {

	@FXML TableView<ViewTableModel> tableView;
	@FXML TableColumn<ViewTableModel, String> category; 
	@FXML TableColumn<ViewTableModel, String> name; 
	@FXML TableColumn<ViewTableModel, Integer> price; 
	@FXML Button cancel;
	@FXML Button add;
	@FXML Label date;

	CalendarInfoService cis;
	CAddMain cm;
	public static Integer cNo;
	
	public void add () {
		CAddController.flag=true;
		new CAddMain();
		

	}
	
	public void cancel() {
		CService.bp.setCenter(new CalendarMain().getRoot()); 
		((DatePicker)CalendarController.root.lookup("#dp")).setValue(CalendarController.date);
		new CService().setCalendar(CalendarController.date, CalendarController.labelList);
	}
	
	public void setTable() {

		
		date.setText(cis.getDate());
		tableView.setItems(cis.setTable(category,name,price));
		
	}
	

	
	public void click(MouseEvent event){
	    if (event.getClickCount() == 2) { //Checking double click
	    	String clickCategory = null;
	    	String clickName = null;
	    	Integer clickPrice = null; 
	    	Integer clickCNo = null;
	    	try {
	    		clickCategory = tableView.getSelectionModel().getSelectedItem().getCategory().get();
		    	clickName = tableView.getSelectionModel().getSelectedItem().getName().get();
		    	clickPrice = tableView.getSelectionModel().getSelectedItem().getPrice().get();
		    	clickCNo = tableView.getSelectionModel().getSelectedItem().getcNo();
			} catch (Exception e) {
				System.out.println("빈칸클릭");
		    	return;
			}
	 
	    	CAddController.flag=false; //수정을 나타내는 flag
	    	new CAddMain();
	    	ComboBox<String> combobox = (ComboBox<String>)CAddMain.root.lookup("#category");
	    	TextField name = (TextField) CAddMain.root.lookup("#name");
	    	TextField price = (TextField) CAddMain.root.lookup("#price");
	    	combobox.setValue(clickCategory);
	    	name.setText(clickName);
	    	price.setText(clickPrice+"");
	    	CAddController.cNo = clickCNo; //CAddController 에 현재 클릭한 캘린더 넘버 추가
	    	
	    	
	    	System.out.println("calendarInfoController - click 메서드 작동");
	    	System.out.println(clickCategory);
	    	System.out.println(clickName);
	    	System.out.println(clickPrice);
	    	System.out.println(clickCNo);
	    
		
	    }

	}
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cis = new CalendarInfoService();
		tableView.setPlaceholder(new Label("등록된 가계가 없습니다"));
		

		
		
	}
	
}
