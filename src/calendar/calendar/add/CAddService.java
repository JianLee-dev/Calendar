package calendar.calendar.add;

import calendar.calendar.info.CalendarInfoService;
import calendar.common.CommonService;
import calendar.datadase.CalendarVO;
import calendar.datadase.DatabaseService;
import calendar.datadase.IDatabaseService;
import calendar.login.LoginController;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;

public class CAddService {


	IDatabaseService ds = new DatabaseService();

	public void addCalendar(Parent root){

		CalendarVO calendar = new CalendarVO();
		calendar.setcId(LoginController.user.getUserId());
		calendar.setcDate(CalendarInfoService.date);

		ComboBox<String> category = ((ComboBox<String>)root.lookup("#category"));
		TextField name = ((TextField)root.lookup("#name"));
		TextField price = (TextField)root.lookup("#price");

		if (category==null) {
			CommonService.alert(AlertType.WARNING, "카테고리를 선택하세요");
			return;
		}
		if (name == null) {
			CommonService.alert(AlertType.WARNING, "이름을 입력하세요");
			return;
		}
		if (price == null) {
			CommonService.alert(AlertType.WARNING, "가격을 입력하세요");
			return;
		}

		calendar.setcCategory(category.getValue()); 
		calendar.setcName(name.getText());
		calendar.setcPrice(Integer.parseInt(price.getText()));
		ds.addCalendar(calendar);
		CommonService.close(root);
	}

	public void modifyCalendar(Parent root){

		CalendarVO calendar = new CalendarVO();
		calendar.setcId(LoginController.user.getUserId());
		calendar.setcDate(CalendarInfoService.date);
		ComboBox<String> category = ((ComboBox<String>)root.lookup("#category"));
		TextField name = ((TextField)root.lookup("#name"));
		TextField price = (TextField)root.lookup("#price");

		if (category==null) {
			CommonService.alert(AlertType.WARNING, "카테고리를 선택하세요");
			return;
		}
		if (name == null) {
			CommonService.alert(AlertType.WARNING, "이름을 입력하세요");
			return;
		}
		if (price == null) {
			CommonService.alert(AlertType.WARNING, "가격을 입력하세요");
			return;
		}
		calendar.setcNo(CAddController.cNo);
		calendar.setcCategory(category.getValue()); 
		calendar.setcName(name.getText());
		calendar.setcPrice(Integer.parseInt(price.getText()));
		ds.modifyCalendar(calendar);
		CommonService.close(root);
	}

	public void enterConfirm(Parent root) {
		TextField name = ((TextField)root.lookup("#name"));
		TextField price = (TextField)root.lookup("#price");
		name.setOnKeyPressed(e->{
			if(e.getCode().equals(KeyCode.ENTER)) {
				CAddMain.cAddController.confirm();
			}
		});
		price.setOnKeyPressed(e->{
			if(e.getCode().equals(KeyCode.ENTER)) {
				CAddMain.cAddController.confirm();
			}
		});
	}

	public void setComboBox(Parent root) {
		ComboBox<String> cmb;
		cmb = (ComboBox<String>) root.lookup("#category");
		if(cmb != null) {
			cmb.getItems().addAll("식비", "생활", "쇼핑", "교육", "교통", "건강", "금융", "문화활동", "여가/숙박", "기타");
		}

	}

}
