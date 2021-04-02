package calendar.calendar;

import java.net.URL;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
public class CalendarController implements Initializable {
	
	@FXML GridPane grid; // 달력을 표시할 그리드 입니다.
	@FXML DatePicker dp;
	Parent root;
	
	
	
	
	
		@FXML
		private HBox hbox1, hbox2, hbox3, hbox4, hbox5, hbox6, hbox7, hbox8, hbox9, hbox10, hbox11, hbox12, hbox13, hbox14,
				hbox15, hbox16, hbox17, hbox18, hbox19, hbox20, hbox21, hbox22, hbox23, hbox24, hbox25, hbox26, hbox27,
				hbox28, hbox29, hbox30, hbox31, hbox32, hbox33, hbox34, hbox35;
		// 일자별 데이터를 표시할 HBox 입니다.
	
		
		@FXML
		private Label lbl00, lbl01, lbl02, lbl03, lbl04, lbl05, lbl06, lbl10, lbl11, lbl12, lbl13, lbl14, lbl15, lbl16,
				lbl20, lbl21, lbl22, lbl23, lbl24, lbl25, lbl26, lbl30, lbl31, lbl32, lbl33, lbl34, lbl35;
		// 날자를 표시할 레이블 입니다.
	
		
		public Label[] labelList;
		public HBox[] hboxList;
		// 레이블과 hbox를 배열로 정합니다.
		
		
		@FXML
		private Button btnBMonth;
		// 월단위를 이전달로 가는 버튼

		
		
		@FXML
		private Button btnNMonth;
		// 월단위를 다음달로 가는 버튼
		
		//데이터피커에서 날짜 데이터 받아오는 부분
		// 현재의 년과 월을 구합니다.
	
		private LocalDate date;   
		
		int currentYear; 
		int currentMonthInt; //수정요망*/
	
		// 월의 첫번째 요일과 마지막 요일을 저장할부분
		YearMonth firstAndLastDay;
		
		// 첫번째날의 요일 
		String strFirstWeek;
		
		// 마지막날의 요일
		String strLastWeek;
		
		// -----------------날짜의 칸을 클릭했을때 값을 받아오는
		String clickDate;

		public void setRoot(Parent root)
		{
			this.root = root;
			
		}
		
		public void setdp(){
		
			dp.setValue(LocalDate.now());
			 date = dp.getValue(); 
				System.out.println(dp.getValue());
				 currentYear = date.getYear();
				 currentMonthInt = date.getMonthValue(); 	
			return;
		}

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			
						
			// hbox를 리스트로 만들어 일자별 데이터를 표시할때 사용합니다.
			hboxList = new HBox[] { hbox1, hbox2, hbox3, hbox4, hbox5, hbox6, hbox7, hbox8, hbox9, hbox10, hbox11, hbox12,
					hbox13, hbox14, hbox15, hbox16, hbox17, hbox18, hbox19, hbox20, hbox21, hbox22, hbox23, hbox24, hbox25,
					hbox26, hbox27, hbox28, hbox29, hbox30, hbox31, hbox32, hbox33, hbox34, hbox35};

			// 라벨을 리스트로 만들어 날자를 표시할때 사용합니다.
			labelList = new Label[] { lbl00, lbl01, lbl02, lbl03, lbl04, lbl05, lbl06, lbl10, lbl11, lbl12, lbl13, lbl14,
					lbl15, lbl16, lbl20, lbl21, lbl22, lbl23, lbl24, lbl25, lbl26, lbl30, lbl31, lbl32, lbl33, lbl34, lbl35
					};
	
	}
		
		
}


