package calendar.datadase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	
	

	//회원가입
	@Override
	public int addMember(UserVO userVO) {
		String sql = "INSERT INTO userInfo values(?,?,?,?,?)";
		try {
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,userVO.getUserId());
			pstmt.setString(2,userVO.getUserPw());
			pstmt.setString(3,userVO.getUserName());
			pstmt.setInt(4,userVO.getUserBirth());
			pstmt.setInt(5,userVO.getUserPhone());
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}




	//유저 삭제
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
	
	//유저 정보 가져오기
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


	//유저 수정
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

	//로그인 유무 
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
	public void addCalendar(CalendarVO cvo) {

		String sql = "INSERT INTO calendar VALUES(calendar_seq.nextval,?,?,?,?,?)";
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
		String sql = "UPDATE calendar SET c_category=?, c_name=?, c_price=? WHERE c_no=?";
		try {
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
		
	
			pstmt.setString(1,cvo.getcCategory());
			pstmt.setString(2,cvo.getcName());
			pstmt.setInt(3,cvo.getcPrice());
			pstmt.setInt(4,cvo.getcNo());
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





	//삭제 방법 정한 후 수정필요
	public void deleteCalendar(Integer cNo) { 
		String sql = "DELETE FROM calendar WHERE c_no=?";
		try {
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,cNo);
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




	//캘린더 정보 가져오기
	@Override
	public List<CalendarVO> getCalendar(String id, Integer date) {
		List<CalendarVO> list = new ArrayList<>();
		System.out.println("id : " + id);
		System.out.println("date: " + date);
		
		String sql = "SELECT * FROM calendar WHERE c_id=? and c_date=?";
		try {
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setInt(2,date);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CalendarVO vo = new CalendarVO();
				vo.setcNo(rs.getInt("c_no"));
				vo.setcId(id);
				vo.setcDate(date);
				vo.setcCategory(rs.getString("c_category"));
				vo.setcName(rs.getString("c_name"));
				vo.setcPrice(rs.getInt("c_price"));
				list.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}



	 
	@Override
	//GraphController에서 사용  //해당 월, 해당 카테고리 평균
	public int getCatAvg(String id, int yearMonth, String category) { //yearMonth형식 : 20210100 
		String sql = "SELECT AVG(c_price) AS average FROM CALENDAR WHERE C_ID=? and TRUNC(c_date,-2)=? and c_category=?";
		try {
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setInt(2,yearMonth);
			pstmt.setString(3,category);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
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
		return 0;
	}



	@Override
	//GraphController에서 사용  //해달 월 총 지출 금액
	public int getMonthTotal(String id, int yearMonth) { //yearMonth형식 : 20210100 
		String sql = "SELECT SUM(C_PRICE) FROM CALENDAR where C_ID=? and TRUNC(C_DATE,-2)="+yearMonth;
		try {
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);

			}
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
		return 0;
	}

	public int getDayTotal(String id, int date) { //day형식 : 20210101 
		String sql = "SELECT SUM(C_PRICE) FROM CALENDAR where C_ID=? and TRUNC(C_DATE)="+date;
		try {
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);

			}
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
		return 0;
	}



	@Override
	//GraphController에서 사용  //지출내역이 존재하는 유저목록 반환
	public ArrayList<String> getMembers() {
		ArrayList<String> members = new ArrayList<String>();
		String sql = "SELECT DISTINCT C_ID FROM CALENDAR";
		try {
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				members.add(rs.getString("C_ID"));
			}
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
		return members;
	}

	
	public String findId(String Name, int Num) {
		String sql = "SELECT USER_ID FROM USERINFO WHERE USER_NAME=? and USER_PHONE=?";
		try {
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,Name);
			pstmt.setInt(2,Num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getString(1);

			}
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
	
	
	public String findPwd(String Id, String Name, int Num) {  
		String sql = "SELECT USER_PW FROM USERINFO WHERE USER_ID=? and USER_NAME=? and USER_PHONE=?";
		try {
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,Id);
			pstmt.setString(2,Name);
			pstmt.setInt(3,Num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getString(1);

			}
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
	
	
	
	
	
	
	
	
	
	
}
