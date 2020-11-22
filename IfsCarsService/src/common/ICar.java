package common;
import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ICar extends Serializable {
	public void setId(int id);
	public int getId();
	
	public void setBrand(String brand);
	public String getBrand();
	
	public void setAvailable(Boolean available);
	public Boolean getAvailable();
	
	public void setPricePerDay(double pricePerDay);
	public double getPricePerDay();
	
	public List<String> getNotes();	
	public void setNotes(List<String> notes);

}
