package common;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Car extends UnicastRemoteObject implements ICar {
	
	//catarina
	private int id;
	private String brand;
	private Boolean available;
	
	public Car() throws RemoteException{}
	
	public Car(int id, String brand, Boolean available) throws RemoteException{
		this.id = id;
		this.brand = brand;
		this.available = available;
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

	@Override
	public String toString() {
		return "Car [id=" + id + ", brand=" + brand + ", available=" + available + "]";
	}

	
	

}
