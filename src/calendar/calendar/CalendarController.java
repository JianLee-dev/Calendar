package calendar.calendar;

import java.net.URL;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import calendar.calendar.CService;

public class CalendarController implements Initializable {

	@FXML
	GridPane grid; // 달력을 표시할 그리드 입니다.
	@FXML
	DatePicker dp;
	Parent root;
	Calendar cal = Calendar.getInstance();
	CService cs;


	@FXML
	private Label lbl00, lbl01, lbl02, lbl03, lbl04, lbl05, lbl06, lbl07, lbl08, lbl09, lbl10, lbl11, lbl12, lbl13,
	lbl14, lbl15, lbl16, lbl17, lbl18, lbl19, lbl20, lbl21, lbl22, lbl23, lbl24, lbl25, lbl26, lbl27, lbl28,
	lbl29, lbl30, lbl31, lbl32, lbl33, lbl34, lbl35, lbl36, lbl37, lbl38, lbl39, lbl40, lbl41;
	// 날자를 표시할 레이블 입니다.

	public Label[] labelList;
	// 레이블를 배열로 정합니다.

	@FXML
	private Button btnBMonth;
	// 월단위를 이전달로 가는 버튼

	@FXML
	private Button btnNMonth;
	// 월단위를 다음달로 가는 버튼

	private LocalDate date; // 데이트피커의 값을 저장할 변수
	private LocalDate date_first; // 그달의 1일 날짜를 저장할 변수
	int currentYear; // 년도를 저장할 변수
	int currentMonthInt; // 월 저장 변수
	int currentDay; //일 저장 변수

	int length_of_month; // 그달의 일수
	DayOfWeek first_date; // 첫날의 요일
	int datenum; // 요일을 숫자로환산
	int count=0; //데이터피커 사용횟수 

	// 월의 첫번째 요일과 마지막 요일을 저장할부분
	YearMonth firstAndLastDay;

	// 첫번째날의 요일
	String strFirstWeek;

	// 마지막날의 요일
	String strLastWeek;

	// -----------------날짜의 칸을 클릭했을때 값을 받아오는
	String clickDate;

	public void setRoot(Parent root) {
		this.root = root;
	}


	public void setdp_now() {// 데이트피커의 디폴트 값을 현재날짜로 바꿔주는, 작동은 잘되는데 적용방법 수정필요
		LocalDate now = LocalDate.now();
		dp.setValue(now); // 데이트 피커의 값을 현재로

		cs.setCalendar(now, labelList);
		System.out.println("setdp_now 메서드 동작 => 시작시 현재 날짜로 세팅");

	}

	public void setdp_pick(ActionEvent pick) // 유저가 데이터피커를 선택했을때 작동
	{		
		date = dp.getValue(); // 데이트피커에서 선택한 값을 date로

		cs.setCalendar(date, labelList);
		System.out.println("setdp_pick 메서드 동작 => 데이터피커를 선택했을때 작동" );

	}


	// 선택 날짜 가져오기
	public void mouseOnClicked() {

		for (int i=0;i<labelList.length;i++) {
			int l = i;
			labelList[i].setOnMouseClicked(e -> {

				cs.mouseOnClicked(labelList[l],dp);
			});	
		}





	}

	public void countup() //데이트피커 사용횟수up
	{
		count++;
	}
	public void btnBMonth (ActionEvent btnBMonth)
	{
		if(count==0) //데이트픽커 한번도 안썼으면 현재 날짜로 date변수 저장
		{
			date= LocalDate.now();
		}

		if(currentMonthInt==1) //1월달일경우 12월로, 연도 -1
		{
			currentMonthInt=12;
			currentYear --;
		}
		else
			currentMonthInt --; //월-1

		date = LocalDate.of(currentYear, currentMonthInt, currentDay); //일저장); //
		length_of_month = date.lengthOfMonth(); //그달의 일수

		date_first = LocalDate.of(currentYear, currentMonthInt, 1); //해당월의 첫요일을 구하기위해
		first_date = date_first.getDayOfWeek(); //첫요일구함
		datenum = first_date.getValue()%7; //첫요일을 숫자로 변환
		dp.setValue(date); //dp값을 이전달 같은날로 변화

		cs.setCalendar(date, labelList);; //이부분 서비스쪽으로 넘어갔습니다 !!!!!!!!!!@@@@ 중요@@@@@
		countup();
	}

	public void btnNMonth (ActionEvent btnNMonth)
	{
		if(count==0) //데이트피 한번도 안썼으면 현재 날짜로 date변수 저장
		{
			date= LocalDate.now();
		}

		if(currentMonthInt==12) //12월달일경우 1월로, 연도 +1
		{
			currentMonthInt=1;
			currentYear ++;
		}
		else
			currentMonthInt ++; //월+1

		date = LocalDate.of(currentYear, currentMonthInt, currentDay); //일저장); //
		length_of_month = date.lengthOfMonth(); //그달의 일수

		date_first = LocalDate.of(currentYear, currentMonthInt, 1); //해당월의 첫요일을 구하기위해
		first_date = date_first.getDayOfWeek(); //첫요일구함
		datenum = first_date.getValue()%7; //첫요일을 숫자로 변환
		dp.setValue(date); //dp값을 이전달 같은날로 변화

		cs.setCalendar(date, labelList);
		countup();
	}



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		labelList = new Label[] { lbl00, lbl01, lbl02, lbl03, lbl04, lbl05, lbl06, lbl07, lbl08, lbl09, lbl10, lbl11,
				lbl12, lbl13, lbl14, lbl15, lbl16, lbl17, lbl18, lbl19, lbl20, lbl21, lbl22, lbl23, lbl24, lbl25, lbl26,
				lbl27, lbl28, lbl29, lbl30, lbl31, lbl32, lbl33, lbl34, lbl35, lbl36, lbl37, lbl38, lbl39, lbl40,
				lbl41 };

		cs = new CService();
		setdp_now();
		dp.setValue(LocalDate.now());
		mouseOnClicked();
	}




}
