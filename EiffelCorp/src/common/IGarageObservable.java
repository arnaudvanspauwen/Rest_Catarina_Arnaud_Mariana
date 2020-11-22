package common;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface IGarageObservable extends Remote{
	
	public List<ICar> getGarage() throws RemoteException;
	public void add(int id, String brand, Boolean available, double pricePerDay) throws RemoteException;
	public void del(int id) throws RemoteException;
	public List<ICar> lookBrand(String brand) throws RemoteException;
	public List<ICar> lookAvailable() throws RemoteException;
	public IRentCar rent(IPersonObserver person, ICar car, int amountDays) throws RemoteException;
}
