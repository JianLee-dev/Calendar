package calendar.main;

import javafx.scene.Parent;

public interface ImainFormSurvice {
	//캘린더 창
	public void showCalendar();
	//그래프 창
	public void showGraph();
	//내정보 창
	public void showInfo();
	
	public void setRoot(Parent root);
	
}
