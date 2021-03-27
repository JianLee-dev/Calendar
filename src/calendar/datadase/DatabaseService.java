package calendar.datadase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import calendar.login.LoginController;

public class DatabaseService implements IDatabaseService{
	
	//localhost 125.132.133.80
	private String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private String uid = "java";
	private String upw = "1234";
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public DatabaseService() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	


	//�쉶�썝異붽�

	@Override
	public void addMember(UserVO userVO) {
		String sql = "INSERT INTO userInfo values(?,?,?,?,?)";
		try {
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,userVO.getUserId());
			pstmt.setString(2,userVO.getUserPw());
			pstmt.setString(3,userVO.getUserName());
			pstmt.setInt(4,userVO.getUserBirth());
			pstmt.setInt(5,userVO.getUserPhone());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}





	@Override
	public void delMember(String userId) {
		String sql = "DELETE FROM userInfo WHERE id=?";
		try {
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,userId);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public UserVO getMember(String userId) {
		String sql = "SELECT * FROM userInfo WHERE user_id=?";
		try {
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,userId);
			rs = pstmt.executeQuery();
			UserVO userVO = new UserVO();
			while(rs.next()) {
				userVO.setUserId(rs.getString("user_id"));
				userVO.setUserPw(rs.getString("user_pw"));
				userVO.setUserName(rs.getString("user_name"));
				userVO.setUserBirth(rs.getInt("user_birth"));
				userVO.setUserPhone(rs.getInt("user_phone"));
			}
			return userVO;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}



	@Override
	public void modifyMember(UserVO userVO) {
		String sql = "UPDATE userInfo SET user_pw=?, user_name=?, user_birth=?, user_phone=? WHERE user_id=?";
		try {
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,userVO.getUserPw());
			pstmt.setString(2,userVO.getUserName());
			pstmt.setInt(3,userVO.getUserBirth());
			pstmt.setInt(4,userVO.getUserPhone());
			pstmt.setString(5,userVO.getUserId());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean loginCheck(UserVO userVO) {
		String sql = "SELECT user_pw FROM userInfo WHERE user_id=?";
		String pw = null;
		try {
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,userVO.getUserId());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				pw = rs.getString("user_pw");
			}
			
			if (userVO.getUserPw().equals(pw)) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}


	


	@Override
	public void saveCalendar(CalendarVO cvo) {
		String sql = "INSERT INTO calender VALUES(?,?,?,?,?)";
		try {
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,cvo.getcId());
			pstmt.setInt(2,cvo.getcDate());
			pstmt.setString(3,cvo.getcCategory());
			pstmt.setString(4,cvo.getcName());
			pstmt.setInt(5,cvo.getcPrice());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}




	@Override
	public void modifyCalendar(CalendarVO cvo) {
		String sql = "UPDATE FROM calender SET c_id=?, c_date=?, c_category=?, c_name=?, c_price=?";
		try {
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,cvo.getcId());
			pstmt.setInt(2,cvo.getcDate());
			pstmt.setInt(3,cvo.getcDate());
			pstmt.setString(4,cvo.getcName());
			pstmt.setInt(5,cvo.getcPrice());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}





	@Override
	public void deleteCalendar(CalendarVO cvo) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void getCalendar() {
		// TODO Auto-generated method stub
		
	}




	@Override
	//GraphController에서 사용
	public int getCatAvg(String id, int yearMonth, String category) {
		int catAvg = 0;
		//select AVG(c_price) from calendar where c_id=id,(c_date/100)=yearMonth,c_category= category;
		
		return catAvg;
	}



	@Override
	//GraphController에서 사용
	public int getMonthTotal(String id, int yearMonth) {
		int monthTotal = 0;
		//select SUM(c_price) from calendar where c_id=id,(c_date/100)=yearMonth;
		
		return monthTotal;
	}




	@Override
	//GraphController에서 사용
	public ArrayList<String> getMembers() {
		ArrayList<String> members = new ArrayList<String>();
		//select DISTINCT c_user from calendar;
		
		
		return members;
	}

	
	
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
