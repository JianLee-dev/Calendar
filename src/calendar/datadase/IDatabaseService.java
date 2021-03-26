package calendar.datadase;

public interface IDatabaseService {


	void delMember(String userId);
	void modifyMember(UserVO userVO);
	void addMember(UserVO userVO);
}
