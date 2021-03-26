package calendar.datadase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseService implements IDatabaseService{
	
	//localhost
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
	
	
	


	//회원추가

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
	public void modifyMember(UserVO userVO) {
		String sql = "UPDATE FROM userInfo SET user_pw=?, user_name=?, user_birth=?, user_phone=? WHERE id=?";
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





	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
