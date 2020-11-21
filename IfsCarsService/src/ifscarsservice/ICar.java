package ifscarsservice;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICar extends Remote {
	public void setId(int id) throws RemoteException;
	public int getId() throws RemoteException;
	
	public void setBrand(String brand) throws RemoteException;
	public String getBrand() throws RemoteException;
	
	public void setAvailable(Boolean available) throws RemoteException;
	public Boolean getAvailable() throws RemoteException;
	
}
