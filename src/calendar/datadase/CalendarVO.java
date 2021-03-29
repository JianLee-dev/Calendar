package calendar.datadase;

public class CalendarVO {
/*
		    
		CREATE TABLE calendar(
		    c_id VARCHAR2(20) NOT NULL,
		    c_date NUMBER NOT NULL,
		    c_category VARCHAR2(20) NOT NULL,
		    c_name VARCHAR2(30) NOT NULL,
		    c_price NUMBER NOT NULL
		    );
		    
		    */
	
	
	private String cId;
	private Integer cDate;
	private String cCategory;
	private String cName;
	private int cPrice;
	public String getcId() {
		return cId;
	}
	public void setcId(String cId) {
		this.cId = cId;
	}
	public Integer getcDate() {
		return cDate;
	}
	public void setcDate(Integer cDate) {
		this.cDate = cDate;
	}
	public String getcCategory() {
		return cCategory;
	}
	public void setcCategory(String cCategory) {
		this.cCategory = cCategory;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public int getcPrice() {
		return cPrice;
	}
	public void setcPrice(int cPrice) {
		this.cPrice = cPrice;
	}
	
	
	
}
