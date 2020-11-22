package ifsCars;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import common.ICar;

public class Car extends UnicastRemoteObject implements ICar {
	
	private int id;
	private String brand;
	private Boolean available;
	private double pricePerDay;
		
	public Car(int id, String brand, Boolean available, double pricePerDay) throws RemoteException{
		this.id = id;
		this.brand = brand;
		this.available = available;
		this.pricePerDay = pricePerDay;
	}
	
	public int getId() throws RemoteException{
		return id;
	}
	
	public void setId(int id) throws RemoteException{
		this.id = id;
	}
	
	public String getBrand() throws RemoteException{
		return brand;
	}
	
	public void setBrand(String brand) throws RemoteException{
		this.brand = brand;
	}
	
	public Boolean getAvailable() throws RemoteException{
		return available;
	}
	
	public void setAvailable(Boolean available) throws RemoteException{
		this.available = available;
	}
	
	public double getPricePerDay() throws RemoteException {
		return pricePerDay;
	}
	
	public void setPricePerDay(double pricePerDay) throws RemoteException {
		this.pricePerDay = pricePerDay;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", brand=" + brand + ", available=" + available + "]";
	}
}
