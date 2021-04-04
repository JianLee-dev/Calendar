package calendar.calendar;

import java.net.URL;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.ResourceBundle;

import calendar.calendar.info.CalendarInfoController;
import calendar.calendar.info.CalendarInfoMain;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class CalendarController implements Initializable {


	
	

	@FXML GridPane grid; // 달력을 표시할 그리드 입니다.
	@FXML Button btnBMonth;   // 월단위를 이전달로 가는 버튼
	@FXML Button btnNMonth;   // 월단위를 다음달로 가는 버튼
	@FXML DatePicker dp;
	@FXML Label lbl00, lbl01, lbl02, lbl03, lbl04, lbl05, lbl06, lbl07, lbl08, lbl09, lbl10, lbl11, lbl12, lbl13,
	lbl14, lbl15, lbl16, lbl17, lbl18, lbl19, lbl20, lbl21, lbl22, lbl23, lbl24, lbl25, lbl26, lbl27, lbl28,
	lbl29, lbl30, lbl31, lbl32, lbl33, lbl34, lbl35, lbl36, lbl37, lbl38, lbl39, lbl40, lbl41;
	// 날자를 표시할 레이블 입니다.

	public static Label[] labelList; // 레이블를 배열로 정합니다.
	public static LocalDate date; 
	public static Parent root;
	
	static CService cs;
	//Calendar cal = Calendar.getInstance();

	


	

	public void setRoot(Parent root) {
		CalendarController.root = root;
		
	}


	public static void setdpNow() {// 데이트피커의 디폴트 값을 현재날짜로 세팅
		LocalDate now = LocalDate.now();
		((DatePicker)root.lookup("#dp")).setValue(now);
		//dp.setValue(now); // 데이트 피커의 값을 현재로
		cs.setCalendar(now, labelList);
		System.out.println("setdpnow 메서드 동작 => 시작시 현재 날짜로 세팅");

	}

	public void setdpPick(ActionEvent pick) // 유저가 데이터피커를 선택했을때 작동
	{		
		date = dp.getValue(); // 데이트피커에서 선택한 값을 date로
		cs.setCalendar(date, labelList);
		System.out.println("setdp_pick 메서드 동작 => 데이터피커를 선택했을때 작동 or 데이터피커 값 변경" );
	

	}


	// 선택 날짜 가져오기
	public void mouseOnClicked() {

		for (int i=0;i<labelList.length;i++) {
			int l = i;
			labelList[i].setOnMouseClicked(e -> {

				cs.mouseOnClicked(labelList[l],dp);
				CalendarInfoMain.calendarInfoController.setTable(); //테이블 세팅
				
			});	
		}
	}


	//이전버튼
	public void btnBMonth (ActionEvent btnBMonth)
	{
		LocalDate date = dp.getValue().minusMonths(1);
		dp.setValue(date);
	
		
	}
	//다음버튼
	public void btnNMonth (ActionEvent btnNMonth)
	{
		LocalDate date = dp.getValue().plusMonths(1);
		dp.setValue(date);
	}



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		labelList = new Label[] { lbl00, lbl01, lbl02, lbl03, lbl04, lbl05, lbl06, lbl07, lbl08, lbl09, lbl10, lbl11,
				lbl12, lbl13, lbl14, lbl15, lbl16, lbl17, lbl18, lbl19, lbl20, lbl21, lbl22, lbl23, lbl24, lbl25, lbl26,
				lbl27, lbl28, lbl29, lbl30, lbl31, lbl32, lbl33, lbl34, lbl35, lbl36, lbl37, lbl38, lbl39, lbl40,
				lbl41 };
		date = LocalDate.now(); // 초기 날짜 설정
		cs = new CService();    //서비스 객체 생성
		mouseOnClicked();		//마우스 클릭 이벤트 시작
	}



}
