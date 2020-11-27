package ifscarsserviceclient;

import java.rmi.RemoteException;
import java.util.List;

import javax.security.auth.login.AccountException;
import javax.xml.rpc.ServiceException;

import common.Car;
import common.IBankAccount;
import common.ICar;
import ifscarsservice.GarageSeller;
import ifscarsservice.GarageSellerServiceLocator;

public class ClientStub {
	
	private GarageSeller garageSeller;
	private Basket basket;
	
	public ClientStub() throws ServiceException {
		this.garageSeller = (GarageSeller) new GarageSellerServiceLocator().getGarageSeller();
		this.basket = new Basket();
	}
	
	
	public GarageSeller getGarageSeller() {
		return garageSeller;
	}

	public Basket getBasket() {
		return basket;
	}

	public String constructStringFromList(List<ICar> garage) {
		StringBuilder builder = new StringBuilder();
		for(ICar car : garage) {
			builder.append(car.getLicencePlate());
			builder.append(",");
			builder.append(car.getBrand());
			builder.append(",");
			builder.append(car.getModel());
			builder.append(",");
			builder.append(car.getAvailable());
			builder.append(",");
			builder.append(car.getForSale());
			builder.append(",");
			builder.append(car.getPricePerDay());
			builder.append(",");
			builder.append(car.getPRICESALE());
			builder.append(";");
		}
		return builder.toString();
	}
	
	public static void main(String[] args) throws ServiceException, RemoteException {
//		Basket basket = new Basket();
//		constructStringFromList.
		
//		GarageSeller garageSeller = (GarageSeller) new GarageSellerServiceLocator().getGarageSeller();
		ClientStub client = new ClientStub();
		GarageSeller garageSeller = client.getGarageSeller();
		
		System.out.println("trying to check price and availability");
		garageSeller.consultCarPricesAndAvailability();
		System.out.println("put in the basket");
		client.getBasket().addToBasket(new Car("CK-923-EJ", "Citroen", "Picasso", true, false, 2, 100.0));
		System.out.println("purchase");
		garageSeller.purchaseCar(client.constructStringFromList(client.getBasket().getCarsInBasket()), "987", "EUR", client.getBasket().basketPrice());
		
		
		System.out.println("ciaoo");
		
		
		
	}

}