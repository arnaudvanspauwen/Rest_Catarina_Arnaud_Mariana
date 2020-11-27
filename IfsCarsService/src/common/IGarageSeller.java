package common;

import java.rmi.RemoteException;

public interface IGarageSeller {
	
	public void consultCarPricesAndAvailability() throws RemoteException;
	public void purchaseCar(String basket, String rib, String currency, double price) throws RemoteException;
}
