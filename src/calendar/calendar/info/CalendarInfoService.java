package calendar.calendar.info;

import java.util.ArrayList;
import java.util.List;

import calendar.datadase.CalendarVO;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;

public class CalendarInfoService {

	
	
	public ObservableList<ViewTableModel> setTable(TableColumn<ViewTableModel, String> category, TableColumn<ViewTableModel, String> name, TableColumn<ViewTableModel, Integer> price) {
		
		ObservableList<ViewTableModel> myList = FXCollections.observableArrayList();
		//나중에 DB 연동하면 필요함 
		List<CalendarVO> list = new ArrayList();
		for(CalendarVO vo : list) {
			myList.add(new ViewTableModel(new SimpleStringProperty("#"), new SimpleStringProperty("#"), new SimpleIntegerProperty(3)));
		};
		
		new ViewTableModel(new SimpleStringProperty("##"), new SimpleStringProperty("##"), new SimpleIntegerProperty(4));
		myList.add(new ViewTableModel(new SimpleStringProperty("###"), new SimpleStringProperty("###"), new SimpleIntegerProperty(5)));
		
		
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
