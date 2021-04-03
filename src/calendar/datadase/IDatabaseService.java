package calendar.datadase;

import java.util.ArrayList;
import java.util.List;

public interface IDatabaseService {


	void delMember(String userId);
	void modifyMember(UserVO userVO);
	int addMember(UserVO userVO);
	UserVO getMember(String userId);
	boolean loginCheck(UserVO userVO);
	
	void saveCalendar(CalendarVO cvo);
	void modifyCalendar(CalendarVO cvo);
	void deleteCalendar(CalendarVO cvo);
	List<CalendarVO> getCalendar(String id, Integer date);
	
	int getCatAvg(String id, int yearMonth, String category);
	int getMonthTotal(String id, int yearMonth);
	ArrayList<String> getMembers();
}