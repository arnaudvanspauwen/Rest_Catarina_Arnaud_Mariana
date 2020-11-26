package common;

import java.rmi.RemoteException;

public interface IGarageSeller {
	
	public void consultCarPricesAndAvailability() throws RemoteException;
	public void purchaseCar(IBasket basket, String rib, String currency) throws RemoteException;

}
