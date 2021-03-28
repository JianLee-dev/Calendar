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
	@FXML Label labelYM; //0000�� 00��
	@FXML Label labelCompare; //�̹� ��, ���� ���� 00�� ��հ� ������ ��, 00���� �� �����ϰ� �ֽ��ϴ�.
	UserVO currentUserDB = LoginController.user;
	DatabaseService db = new DatabaseService();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		labelYM.setText(getCurrentYear()+"�� "+getCurrentMonth()+"��");
		
		pieChart.setData(FXCollections.observableArrayList(
				new PieChart.Data("�ĺ�",db.getCatAvg(currentUserDB.getUserId(),(getCurrentYear()*10000)+(getCurrentMonth()*100),"�ĺ�")),
				new PieChart.Data("��Ȱ",db.getCatAvg(currentUserDB.getUserId(),(getCurrentYear()*10000)+(getCurrentMonth()*100),"��Ȱ")),
				new PieChart.Data("����",db.getCatAvg(currentUserDB.getUserId(),(getCurrentYear()*10000)+(getCurrentMonth()*100),"����")),
				new PieChart.Data("����",db.getCatAvg(currentUserDB.getUserId(),(getCurrentYear()*10000)+(getCurrentMonth()*100),"����")),
				new PieChart.Data("����",db.getCatAvg(currentUserDB.getUserId(),(getCurrentYear()*10000)+(getCurrentMonth()*100),"����")),
				new PieChart.Data("�ǰ�",db.getCatAvg(currentUserDB.getUserId(),(getCurrentYear()*10000)+(getCurrentMonth()*100),"�ǰ�")),
				new PieChart.Data("����",db.getCatAvg(currentUserDB.getUserId(),(getCurrentYear()*10000)+(getCurrentMonth()*100),"����")),
				new PieChart.Data("��ȭȰ��",db.getCatAvg(currentUserDB.getUserId(),(getCurrentYear()*10000)+(getCurrentMonth()*100),"��ȭȰ��")),
				new PieChart.Data("����/����",db.getCatAvg(currentUserDB.getUserId(),(getCurrentYear()*10000)+(getCurrentMonth()*100),"����/����")),
				new PieChart.Data("��Ÿ",db.getCatAvg(currentUserDB.getUserId(),(getCurrentYear()*10000)+(getCurrentMonth()*100),"��Ÿ"))
				));
		
		
		XYChart.Series series1 = new XYChart.Series();
		series1.setData(FXCollections.observableArrayList(
				new XYChart.Data("1��",db.getMonthTotal(currentUserDB.getUserId(), (getCurrentYear()*10000)+100)),
				new XYChart.Data("2��",db.getMonthTotal(currentUserDB.getUserId(), (getCurrentYear()*10000)+200)),
				new XYChart.Data("3��",db.getMonthTotal(currentUserDB.getUserId(), (getCurrentYear()*10000)+300)),
				new XYChart.Data("4��",db.getMonthTotal(currentUserDB.getUserId(), (getCurrentYear()*10000)+400)),
				new XYChart.Data("5��",db.getMonthTotal(currentUserDB.getUserId(), (getCurrentYear()*10000)+500)),
				new XYChart.Data("6��",db.getMonthTotal(currentUserDB.getUserId(), (getCurrentYear()*10000)+600)),
				new XYChart.Data("7��",db.getMonthTotal(currentUserDB.getUserId(), (getCurrentYear()*10000)+700)),
				new XYChart.Data("8��",db.getMonthTotal(currentUserDB.getUserId(), (getCurrentYear()*10000)+800)),
				new XYChart.Data("9��",db.getMonthTotal(currentUserDB.getUserId(), (getCurrentYear()*10000)+900)),
				new XYChart.Data("10��",db.getMonthTotal(currentUserDB.getUserId(), (getCurrentYear()*10000)+1000)),
				new XYChart.Data("11��",db.getMonthTotal(currentUserDB.getUserId(), (getCurrentYear()*10000)+1100)),
				new XYChart.Data("12��",db.getMonthTotal(currentUserDB.getUserId(), (getCurrentYear()*10000)+1200))
				));
		areaChart.getData().add(series1);
		
		
		labelCompare.setText("�̹� ��, "+currentUserDB.getUserName()+" ���� "+(calcAge(currentUserDB.getUserId())*10)+"�� ��հ� ������ ��, "+getMemberMonthAvg(getCurrentYear(), getCurrentMonth())+"���� �� �����ϰ� �ֽ��ϴ�.");
		
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
		int age = (CurrentY - userBirthY)/10; //���ɴ� (10��:1 20��:2)
		
		return age;
	}
	
	private int getMemberMonthAvg(int year, int mon) {
		
		ArrayList<String> getMatchUser = new ArrayList<String>();
		int sum = 0;
		int avg = 0;
		for(String usersId : db.getMembers()) {
			if(calcAge(usersId) == calcAge(currentUserDB.getUserId())) {
				getMatchUser.add(usersId);
			}
		}

		for(String userId : getMatchUser) {
			sum += db.getMonthTotal(currentUserDB.getUserId(), (year*10000)+(mon*100));
		}
		avg = sum /(getMatchUser.size());
		return avg;		
	}

	
}
