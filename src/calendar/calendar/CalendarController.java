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
import javafx.scene.layout.HBox;

public class CalendarController implements Initializable {

	@FXML
	GridPane grid; // 달력을 표시할 그리드 입니다.
	@FXML
	DatePicker dp;
	Parent root;
	Calendar cal = Calendar.getInstance();

	@FXML
	private HBox hbox1, hbox2, hbox3, hbox4, hbox5, hbox6, hbox7, hbox8, hbox9, hbox10, hbox11, hbox12, hbox13, hbox14,
			hbox15, hbox16, hbox17, hbox18, hbox19, hbox20, hbox21, hbox22, hbox23, hbox24, hbox25, hbox26, hbox27,
			hbox28, hbox29, hbox30, hbox31, hbox32, hbox33, hbox34, hbox35;
	// 일자별 데이터를 표시할 HBox 입니다.

	@FXML
	private Label lbl00, lbl01, lbl02, lbl03, lbl04, lbl05, lbl06, lbl07, lbl08, lbl09, lbl10, lbl11, lbl12, lbl13,
			lbl14, lbl15, lbl16, lbl17, lbl18, lbl19, lbl20, lbl21, lbl22, lbl23, lbl24, lbl25, lbl26, lbl27, lbl28,
			lbl29, lbl30, lbl31, lbl32, lbl33, lbl34, lbl35, lbl36, lbl37, lbl38, lbl39, lbl40, lbl41;
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

	private LocalDate date; // 데이트피커의 값을 저장할 변수
	private LocalDate date_first; // 그달의 1일 날짜를 저장할 변수
	int currentYear; // 년도를 저장할 변수
	int currentMonthInt; // 월 저장 변수
	int length_of_month; // 그달의 일수
	DayOfWeek first_date; // 첫날의 요일
	int datenum; // 요일을 숫자로환산
	int minus; // 라벨 채우는 반복문에서 사용할 변수

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
		setdp_now();
	}

	public void setdp_now() {// 데이트피커의 디폴트 값을 현재날짜로 바꿔주는, 작동은 잘되는데 적용방법 수정필요
		LocalDate now = LocalDate.now();
		dp.setValue(now); // 데이트 피커의 값을 현재로
		currentYear = now.getYear(); // 년도저장
		currentMonthInt = now.getMonthValue(); // 월저장
		length_of_month = now.lengthOfMonth(); // 그달의 일수

		date_first = LocalDate.of(currentYear, currentMonthInt, 1); // 해당월의 첫요일을 구하기위해
		first_date = date_first.getDayOfWeek(); // 첫요일구함
		datenum = first_date.getValue() % 7; // 첫요일을 숫자로 변환
		set_date(datenum);

	}

	public void setdp_pick(ActionEvent pick) // 유저가 데이터피커를 선택했을때 작동
	{
		date = dp.getValue(); // 데이트피커에서 선택한 값을 date로
		System.out.println(date);
		currentYear = date.getYear(); // 년도저장
		currentMonthInt = date.getMonthValue(); // 월저장
		length_of_month = date.lengthOfMonth(); // 그달의 일수

		date_first = LocalDate.of(currentYear, currentMonthInt, 1); // 해당월의 첫요일을 구하기위해
		first_date = date_first.getDayOfWeek(); // 첫요일구함
		datenum = first_date.getValue() % 7; // 첫요일을 숫자로 변환
		System.out.println("년,월,그달의일수,그달의 첫요일:" + currentYear + " " + currentMonthInt + " " + length_of_month + " "
				+ first_date + " " + datenum);
		set_date(datenum);
	}

	// 날자표시 따로 뺴서 매소드로 구현
	public void set_date(int datenum) {
		// 라벨을 리스트로 만들어 날자를 표시할때 사용합니다.
		labelList = new Label[] { lbl00, lbl01, lbl02, lbl03, lbl04, lbl05, lbl06, lbl07, lbl08, lbl09, lbl10, lbl11,
				lbl12, lbl13, lbl14, lbl15, lbl16, lbl17, lbl18, lbl19, lbl20, lbl21, lbl22, lbl23, lbl24, lbl25, lbl26,
				lbl27, lbl28, lbl29, lbl30, lbl31, lbl32, lbl33, lbl34, lbl35, lbl36, lbl37, lbl38, lbl39, lbl40,
				lbl41 };

		for (int j = 0; j < labelList.length; j++) // 캘린더 모든칸을 빈칸으로
		{
			labelList[j].setText(" ");
		}

		int dd = datenum - 1; // 요일변수에서 이걸 빼서 날짜를 계산

		for (int i = datenum; i < length_of_month + datenum; i++) {
			labelList[i].setText("" + (i - dd));
		}
	}

	// 선택 날짜 가져오기
	public void getdate() {
	
		int selectYear;
		int selectMonth;
		String selectdate;
		System.out.println("날짜 클릭");
		date = dp.getValue();
		selectYear = date.getYear();
		selectMonth = date.getMonthValue(); 
		
		for (int i=0;i<labelList.length;i++) {
			labelList[i].setOnMouseClicked(e -> {
			
			});
			
			
		}
		
		System.out.println(selectYear + "  " + selectMonth + "  ");

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// hbox를 리스트로 만들어 일자별 데이터를 표시할때 사용합니다.
		hboxList = new HBox[] { hbox1, hbox2, hbox3, hbox4, hbox5, hbox6, hbox7, hbox8, hbox9, hbox10, hbox11, hbox12,
				hbox13, hbox14, hbox15, hbox16, hbox17, hbox18, hbox19, hbox20, hbox21, hbox22, hbox23, hbox24, hbox25,
				hbox26, hbox27, hbox28, hbox29, hbox30, hbox31, hbox32, hbox33, hbox34, hbox35 };

	}

}
