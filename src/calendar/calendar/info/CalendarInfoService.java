package calendar.calendar.info;

import java.util.ArrayList;
import java.util.List;

import calendar.datadase.CalendarVO;
import calendar.datadase.DatabaseService;
import calendar.datadase.IDatabaseService;
import calendar.login.LoginController;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;

public class CalendarInfoService {

	IDatabaseService ds = new DatabaseService();
	public static Integer date;
	


	public ObservableList<ViewTableModel> setTable(TableColumn<ViewTableModel, String> category, TableColumn<ViewTableModel, String> name, TableColumn<ViewTableModel, Integer> price) {
	
		ObservableList<ViewTableModel> myList = FXCollections.observableArrayList();
		List<CalendarVO> list = new ArrayList<>();
		list = ds.getCalendar(LoginController.user.getUserId(), date); //캘린더 정보 db에서 불러오기
	
		for(CalendarVO vo : list) {
			myList.add(new ViewTableModel(new SimpleStringProperty(vo.getcCategory()), new SimpleStringProperty(vo.getcName()), new SimpleIntegerProperty(vo.getcPrice())));
		};

		category.setCellValueFactory( cellData -> cellData.getValue().getCategory());
		name.setCellValueFactory( cellData -> cellData.getValue().getName());
		price.setCellValueFactory(cellData -> cellData.getValue().getPrice().asObject()); //JavaFX의 잘못된 디자인 결정 -> Integer & Double 은 .asObject() 필수 


		/*
		 Callback 의 Interface가 가지고있는 하나의 메서드 call 
		 을 lamda 식으로 구현한것
		 
		 */
		//		new Callback<CellDataFeatures<ViewTableModel,String>, ObservableList<ViewTableModel>>(){
		//			
		//			@Override
		//			public ObservableList<ViewTableModel> call(CellDataFeatures<ViewTableModel, String> cellData) {
		//				return (ObservableList<ViewTableModel>) cellData.getValue().getCategory();
		//				
		//			}
		//		});
		
		
		return myList;
	}
}
