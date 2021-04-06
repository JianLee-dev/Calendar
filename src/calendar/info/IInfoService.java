package calendar.info;

import calendar.datadase.UserVO;
import javafx.scene.Parent;

public interface IInfoService {

	
	
	// my Info 클릭시 Field에 정보 세팅
	public void setInfo(Parent root);
	// 수정시 빈칸 확인 유무 -> DB로 Field에 수정된 정보 전달
	public UserVO checkInfo(Parent root);
	// 수정버튼 클릭시 Field 활성/비활성화
	public void enable();
	public void disable();
}
