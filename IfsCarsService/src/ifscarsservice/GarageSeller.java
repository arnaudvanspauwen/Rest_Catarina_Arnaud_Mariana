package ifscarsservice;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import common.IGarageObservable;
import common.IGarageSeller;

public class GarageSeller implements IGarageSeller{
	
	private IGarageObservable garage;
//	private Bank bank;

	public GarageSeller() throws MalformedURLException, RemoteException, NotBoundException {
		this.garage = (IGarageObservable) Naming.lookup("garage");
//		this.bank = (Bank) BankServiceLocator().getBank();			
	}
	
	
	
	
	
	

}
