package calendar.graph;


import java.net.URL;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import calendar.datadase.CalendarVO;
import calendar.datadase.DatabaseService;
import calendar.datadase.UserVO;
import calendar.login.LoginController;
import calendar.login.LoginService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;



public class GraphController implements Initializable{

	@FXML PieChart pieChart;
	@FXML AreaChart<Integer, Integer> areaChart;
	@FXML Label labelYM; //0000년 00월
	@FXML Label labelCompare; //이번 달, 가가 님은 00대 평균과 비교했을 때, +00원을 지출하고 있습니다.
	UserVO currentUserDB = LoginController.user;
	DatabaseService db = new DatabaseService();
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println(db.getMonthTotal("abc", 20210300)); ///////LOG DB TEST 
		labelYM.setText(getCurrentYear()+". "+getCurrentMonth());
		
		if(db.getMonthTotal(currentUserDB.getUserId(), (getCurrentYear()*10000)+(getCurrentMonth()*100)) != 0) {
			pieChart.setData(FXCollections.observableArrayList(
//					new PieChart.Data("카테고리",db.getCatAvg("가가가",(getCurrentYear()*10000)+(getCurrentMonth()*100),"카테고리")) :테스트
					new PieChart.Data("식비",db.getCatAvg(currentUserDB.getUserId(),(getCurrentYear()*10000)+(getCurrentMonth()*100),"식비")),
					new PieChart.Data("생활",db.getCatAvg(currentUserDB.getUserId(),(getCurrentYear()*10000)+(getCurrentMonth()*100),"생활")),
					new PieChart.Data("쇼핑",db.getCatAvg(currentUserDB.getUserId(),(getCurrentYear()*10000)+(getCurrentMonth()*100),"쇼핑")),
					new PieChart.Data("교육",db.getCatAvg(currentUserDB.getUserId(),(getCurrentYear()*10000)+(getCurrentMonth()*100),"교육")),
					new PieChart.Data("교통",db.getCatAvg(currentUserDB.getUserId(),(getCurrentYear()*10000)+(getCurrentMonth()*100),"교통")),
					new PieChart.Data("건강",db.getCatAvg(currentUserDB.getUserId(),(getCurrentYear()*10000)+(getCurrentMonth()*100),"건강")),
					new PieChart.Data("금융",db.getCatAvg(currentUserDB.getUserId(),(getCurrentYear()*10000)+(getCurrentMonth()*100),"금융")),
					new PieChart.Data("문화활동",db.getCatAvg(currentUserDB.getUserId(),(getCurrentYear()*10000)+(getCurrentMonth()*100),"문화활동")),
					new PieChart.Data("여가/숙박",db.getCatAvg(currentUserDB.getUserId(),(getCurrentYear()*10000)+(getCurrentMonth()*100),"여가/숙박")),
					new PieChart.Data("기타",db.getCatAvg(currentUserDB.getUserId(),(getCurrentYear()*10000)+(getCurrentMonth()*100),"기타"))
					));
		}
		
		XYChart.Series series1 = new XYChart.Series();
		series1.setData(FXCollections.observableArrayList(
//				new XYChart.Data("1월",db.getMonthTotal("가가가", (getCurrentYear()*10000)+100)) :테스트
				new XYChart.Data("1월",db.getMonthTotal(currentUserDB.getUserId(), (getCurrentYear()*10000)+100)),
				new XYChart.Data("2월",db.getMonthTotal(currentUserDB.getUserId(), (getCurrentYear()*10000)+200)),
				new XYChart.Data("3월",db.getMonthTotal(currentUserDB.getUserId(), (getCurrentYear()*10000)+300)),
				new XYChart.Data("4월",db.getMonthTotal(currentUserDB.getUserId(), (getCurrentYear()*10000)+400)),
				new XYChart.Data("5월",db.getMonthTotal(currentUserDB.getUserId(), (getCurrentYear()*10000)+500)),
				new XYChart.Data("6월",db.getMonthTotal(currentUserDB.getUserId(), (getCurrentYear()*10000)+600)),
				new XYChart.Data("7월",db.getMonthTotal(currentUserDB.getUserId(), (getCurrentYear()*10000)+700)),
				new XYChart.Data("8월",db.getMonthTotal(currentUserDB.getUserId(), (getCurrentYear()*10000)+800)),
				new XYChart.Data("9월",db.getMonthTotal(currentUserDB.getUserId(), (getCurrentYear()*10000)+900)),
				new XYChart.Data("10월",db.getMonthTotal(currentUserDB.getUserId(), (getCurrentYear()*10000)+1000)),
				new XYChart.Data("11월",db.getMonthTotal(currentUserDB.getUserId(), (getCurrentYear()*10000)+1100)),
				new XYChart.Data("12월",db.getMonthTotal(currentUserDB.getUserId(), (getCurrentYear()*10000)+1200))
				));
		areaChart.getData().add(series1);
		
		int comparePrice = getMemberMonthAvg(getCurrentYear(), getCurrentMonth()) - db.getMonthTotal(currentUserDB.getUserId(), (getCurrentYear()*10000)+(getCurrentMonth()*100));
		
		if(db.getMonthTotal(currentUserDB.getUserId(), (getCurrentYear()*10000)+(getCurrentMonth()*100)) == 0) {
			labelCompare.setText(" ");
		}else if(comparePrice == 0) {
			labelCompare.setText("현재 "+currentUserDB.getUserId()+" 님은 평균적으로 지출하고 있습니다.");
		}else if(comparePrice > 0) {
			labelCompare.setText("현재 "+currentUserDB.getUserId()+" 님은 "+(calcAge(currentUserDB.getUserId())*10)+"대 평균과 비교했을 때, "+comparePrice+"원을 더 소비하고 있습니다.");
		}else {
			comparePrice *= -1;
			labelCompare.setText("현재 "+currentUserDB.getUserId()+" 님은 "+(calcAge(currentUserDB.getUserId())*10)+"대 평균과 비교했을 때, "+comparePrice+"원을 절약하고 있습니다.");
		}
		
		
	}
	
	
	
	private int getCurrentYear() {
		SimpleDateFormat format1 = new SimpleDateFormat ("yyyy");
		Date time = new Date();
		String year = format1.format(time);
		return Integer.parseInt(year);
	}
	
	private int getCurrentMonth() {
		SimpleDateFormat format2 = new SimpleDateFormat ("MM");
		Date time = new Date();
		String month = format2.format(time);
		return Integer.parseInt(month);
	}
	private int calcAge(String userId) {
		
		int CurrentY = getCurrentYear();
		int userBirthY = currentUserDB.getUserBirth() / 10000;
//		int userBirthY = 19990101 / 10000;   : 테스트
		int age = (CurrentY - userBirthY)/10; //연령대 (10대 :1 20대 :2)
		
		return age;
	}
	
	private int getMemberMonthAvg(int year, int mon) {
		
		ArrayList<String> getMatchUser = new ArrayList<String>();
		int sum = 0;
		int avg = 0;
		for(String usersId : db.getMembers()) {
			if(calcAge(usersId) == calcAge(currentUserDB.getUserId())) {
//			if(calcAge(usersId) == calcAge("가가가")) {   : 테스트
				getMatchUser.add(usersId);
			}
		}

		for(String userId : getMatchUser) {
			sum += db.getMonthTotal(currentUserDB.getUserId(), (year*10000)+(mon*100));
//			sum += db.getMonthTotal("가가가", (year*10000)+(mon*100));  : 테스트
		}

		if(getMatchUser.size() != 0) {
			avg = sum /(getMatchUser.size());
		}

		return avg;		
	}

	
	
}
