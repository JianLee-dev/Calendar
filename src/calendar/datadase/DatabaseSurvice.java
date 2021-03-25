package calendar.datadase;

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
}
