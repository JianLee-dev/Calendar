package calendar.datadase;

import java.util.ArrayList;
import java.util.List;

public interface IDatabaseService {


	void delMember(String userId);
	void modifyMember(UserVO userVO);
	int addMember(UserVO userVO);
	UserVO getMember(String userId);
	boolean loginCheck(UserVO userVO);
	
	void addCalendar(CalendarVO cvo);
	void modifyCalendar(CalendarVO cvo);
	void deleteCalendar(Integer cNo);
	List<CalendarVO> getCalendar(String id, Integer date);
	
	int getCatAvg(String id, int yearMonth, String category);
	int getMonthTotal(String id, int yearMonth);
	public int getDayTotal(String id, int date);
	ArrayList<String> getMembers();
}