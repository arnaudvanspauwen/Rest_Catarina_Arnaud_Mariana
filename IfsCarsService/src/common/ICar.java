package common;
import java.io.Serializable;
import java.util.List;

public interface ICar extends Serializable {
	public void setLicencePlate(String licencePlate);
	public String getLicencePlate();
	
	public void setBrand(String brand);
	public String getBrand();
	
	public String getModel();
	public void setModel(String model);
	
	public void setAvailable(Boolean available);
	public Boolean getAvailable();
	
	public void setPricePerDay(double pricePerDay);
	public double getPricePerDay();
	
	public List<String> getNotes();	
	public void setNotes(List<String> notes);
	
	public List<CarCondition> getCarConditionEnum();
	public void setCarConditionEnum(List<CarCondition> carConditionEnum);

	
}
