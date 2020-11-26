package ifscarsservice;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import bank.BankService;
import bank.BankServiceServiceLocator;
import common.IBasket;
import common.ICar;
import common.IGarageObservable;
import common.IGarageSeller;

public class GarageSeller implements IGarageSeller{
	
	private IGarageObservable garage;
	private BankService bank;

	public GarageSeller() throws MalformedURLException, RemoteException, NotBoundException, ServiceException {
		this.garage = (IGarageObservable) Naming.lookup("garage");
		this.bank = (BankService) new BankServiceServiceLocator().getBankService();			
	}
	
	@Override
	public void consultCarPricesAndAvailability() throws RemoteException {
		for(ICar car : garage.getGarage()) {
			System.out.println(car.toString());
		}
	}
	
	@Override
	public void purchaseCar(IBasket basket, String rib, String currency) throws RemoteException {
		boolean payment = this.bank.payment(rib, basket.basketPrice(), currency);
		if(payment) {
			for(ICar car : basket.getCarsInBasket()) {
				garage.del(car.getLicencePlate());
			}
			System.out.println("Congratulations! Purchase completed!");
		}
		System.out.println("Transaction canceled...");
	}
	
	

}