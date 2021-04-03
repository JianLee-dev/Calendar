package calendar.add;

import calendar.calendar.info.CalendarInfoService;
import calendar.common.CommonService;
import calendar.datadase.CalendarVO;
import calendar.datadase.UserVO;
import calendar.login.LoginController;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class CAddSurvice {
	Parent root;
	@FXML TextField Tprice = null;
	@FXML TextField Tname = null;
	@FXML ComboBox<String> CBCategory;
	ComboBox<String> cmb;
	UserVO userDB = LoginController.user;
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	public void setComboBox() {
		cmb = (ComboBox<String>) root.lookup("#CBCategory");
		if(cmb != null) {
			cmb.getItems().addAll("식비", "생활", "쇼핑", "교육", "교통", "건강", "금융", "문화활동", "여가/숙박", "기타");
		}
				 
	}
	
	public CalendarVO save() {
		
		Tname = (TextField) root.lookup("#Tname");
		Tprice = (TextField) root.lookup("#Tprice");
		cmb = (ComboBox<String>) root.lookup("#CBCategory");
		String category = cmb.getValue();
		if(category == null) {
			CommonService.alert(AlertType.WARNING, "카테고리를 선택해주세요");
		}
		//System.out.println(Tname.getText());
		//System.out.println(Tprice.getText());
		//System.out.println(cmb.getValue());
		String price;
		
		price = Tprice.getText();
				
		CalendarVO vo = new CalendarVO();
		vo.setcCategory(cmb.getValue());
		vo.setcName(Tname.getText());
		vo.setcPrice(Integer.parseInt(price)); //텍스트 값 인트로 형 변환
		vo.setcId(userDB.getUserId());
		vo.setcDate(CalendarInfoService.date);
		//vo.setcDate();
		//System.out.println(Integer.parseInt(price));
		
		//CommonService.alert(AlertType.INFORMATION, "저장 되었습니다.");
		CommonService.close(root);
		
		return vo;
	}

	

}








