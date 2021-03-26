package calendar.datadase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;



public class DatabaseSurvice implements IDatabaseSurvice {

	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "java"; 
	String pwd = "1234";  
	
	public DatabaseSurvice() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int saveUser(UserVO uvo) {
		
			String sql = "INSERT INTO userInfo(user_id,user_pw,user_name,user_birth,user_phone) VALUES(?,?,?,?,?)";
			int result = 0;
			try {
				/*
				CREATE TABLE userInfo(
				    user_id VARCHAR2(20) PRIMARY KEY,
				    user_pw VARCHAR2(20) NOT NULL,
				    user_name VARCHAR2(20) NOT NULL,
				    user_birth NUMBER NOT NULL,
				    user_phone NUMBER NOT NULL
				    );
				*/
				Connection con = DriverManager.getConnection(url,id,pwd);
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, uvo.getUserId());
				ps.setString(2, uvo.getUserPw());
				ps.setString(3, uvo.getUserName());
				ps.setInt(4, uvo.getUserBirth());
				ps.setInt(5, uvo.getUserPhone());
				
				result = ps.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		
	}

	
	@Override
	public int saveCalendar(CalendarVO cvo) {
		String sql = "INSERT INTO calender(c_id,c_date,c_category,c_name,c_price) VALUES(?,?,?,?,?)";
		int result = 0;
		try {
			/*
			CREATE TABLE calender(
			    c_id VARCHAR2(20) NOT NULL,
			    c_date NUMBER NOT NULL,
			    c_category VARCHAR2(20) NOT NULL,
			    c_name VARCHAR2(30) NOT NULL,
			    c_price NUMBER NOT NULL
			    );
			*/
			Connection con = DriverManager.getConnection(url,id,pwd);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cvo.getcId());
			ps.setInt(2, cvo.getcDate());
			ps.setString(3, cvo.getcCategory());
			ps.setString(4, cvo.getcName());
			ps.setString(5, cvo.getcPrice());
			
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	
		
	}
}
