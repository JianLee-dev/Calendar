package calendar.add;

import calendar.calendar.info.CalendarInfoService;
import calendar.common.CommonService;
import calendar.datadase.CalendarVO;
import calendar.datadase.DatabaseService;
import calendar.datadase.IDatabaseService;
import calendar.login.LoginController;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class CAddService {

	
	IDatabaseService ds = new DatabaseService();
	
	public void addCalendar(Parent root){
		
		CalendarVO calendar = new CalendarVO();
		calendar.setcId(LoginController.user.getUserId());
		calendar.setcDate(CalendarInfoService.date);
		//calendar.setcCategory(((ComboBox<String>)root.lookup("#category")).getValue()); 
		//calendar.setcName(((TextField)root.lookup("#name")).getText());
		//calendar.setcPrice(Integer.parseInt(((TextField)root.lookup("#price")).getText()));
		calendar.setcCategory("테스트카테");
		calendar.setcName("테스트이름");
		calendar.setcPrice(1000);
		ds.addCalendar(calendar);
		CommonService.close(root);
	}
}
