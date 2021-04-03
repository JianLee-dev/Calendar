package calendar.calendar.info;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class ViewTableModel {

	private StringProperty category;
	private StringProperty name;
	private IntegerProperty price;
	
	public ViewTableModel() {
	}
	
	public ViewTableModel(StringProperty category, StringProperty name, IntegerProperty price) {
		this.category = category;
		this.name = name;
		this.price = price;
	}
	
	
	public StringProperty getCategory() {
		return category;
	}
	public void setCategory(StringProperty category) {
		this.category = category;
	}
	public StringProperty getName() {
		return name;
	}
	public void setName(StringProperty name) {
		this.name = name;
	}
	public IntegerProperty getPrice() {
		return price;
	}
	public void setPrice(IntegerProperty price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "ViewTableModel [category=" + category + ", name=" + name + ", price=" + price + "]";
	}


	
}
