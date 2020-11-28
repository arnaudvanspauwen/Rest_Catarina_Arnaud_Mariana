package ifscarsservice;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.rpc.ServiceException;


import bank.BankService;
import bank.BankServiceServiceLocator;
import common.Car;
import common.IBasket;
import common.ICar;
import common.IGarageObservable;
import common.IGarageSeller;
import common.IBankService;

public class GarageSeller implements IGarageSeller{

	private IGarageObservable garage;
	private BankService bank;

	public GarageSeller() throws MalformedURLException, RemoteException, NotBoundException, ServiceException {
		this.garage = (IGarageObservable) Naming.lookup("garage");
		this.bank = (BankService) new BankServiceServiceLocator().getBankService();			
	}

	@Override
	public void consultCarPricesAndAvailability() throws RemoteException {
		System.out.println("Prices and Availability:");
		for(ICar car : garage.getGarage()) {
			System.out.println(car.toString());
		}
	}

	@Override
	public void purchaseCar(String basket, String rib, String currency, double price) throws RemoteException {
		List<ICar> cars = new ArrayList<ICar>();
		String[] stringAllCars = basket.split(";");
		for (int i = 0; i < stringAllCars.length; i++) {
			String[] stringCar = stringAllCars[i].split(",");
			ICar car = new Car(stringCar[0], stringCar[1], stringCar[2], Boolean.valueOf(stringCar[3]), Boolean.valueOf(stringCar[4]), Double.parseDouble(stringCar[5]), Double.parseDouble(stringCar[6]));
			cars.add(car);
		}
		double amount = this.bank.changePriceCurrency(price, currency);
		System.out.println("The price will be " + amount + " " + currency );
		boolean payment = this.bank.payment(rib, amount, currency);
		if(payment) {
			for(ICar car : cars) {
				garage.del(car.getLicencePlate());
			}
			System.out.println("Congratulations! Purchase completed!");
		}else 
			System.out.println("Transaction canceled...");
	}

}