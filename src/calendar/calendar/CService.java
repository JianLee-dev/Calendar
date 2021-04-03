package calendar.calendar;

import java.time.LocalDate;

import calendar.calendar.info.CalendarInfoMain;
import calendar.calendar.info.CalendarInfoService;
import calendar.datadase.DatabaseService;
import calendar.login.LoginController;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;


public class CService {
	
	public static BorderPane bp;
	DatabaseService ds = new DatabaseService();


	public void setCalendar(LocalDate date, Label[] labelList) {

		// 라벨을 리스트로 만들어 날자를 표시할때 사용합니다.
		int datenum =  (LocalDate.of(date.getYear(), date.getMonthValue(), 1).getDayOfWeek().getValue())%7;

		for (int j = 0; j < labelList.length; j++){ // 캘린더 모든칸을 빈칸으로
			labelList[j].setText(" ");
		}

		for (int i = datenum; i < date.lengthOfMonth() + datenum; i++) {
			labelList[i].setText("" + (i - (datenum - 1))); // 요일변수에서 이걸 빼서 날짜를 계산
		}
	}

	// 선택 날짜 가져오기
	public void mouseOnClicked(Label label, DatePicker dp) {
		
		int selectDate = 0;
		
		try {
			selectDate = Integer.parseInt(label.getText());
		} catch (Exception e) {
			return;
		}
		LocalDate date = dp.getValue();
		int selectYear = date.getYear();
		int selectMonth = date.getMonthValue();
		Parent root = new CalendarInfoMain().getRoot();
		bp.setCenter(root); 
		BorderPane.setMargin(root, new Insets(0,0,0,15));
		
		//데이터베이스에 맞게 가공
		String month = null, day = null;
		if (selectMonth < 10 ) {
			month = "0"+selectMonth; 
		}else {
			month = ""+selectMonth;
		}
		if(selectDate < 10) {
			day = "0"+selectDate;
		}else {
			day =""+selectDate;
		}
	
		Integer fDate = Integer.parseInt(selectYear + month + day);
		System.out.println("fdate : " + fDate );
		System.out.println("라벨 클릭 : " + selectYear + selectMonth + selectDate );
		CalendarInfoService.date= fDate; //CalendarInfoService 에 날짜정보 저장




	}


}




