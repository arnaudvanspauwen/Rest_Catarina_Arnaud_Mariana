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
		ClientStub client = new ClientStub();
		GarageSeller garageSeller = client.getGarageSeller();
		
		garageSeller.consultCarPricesAndAvailability();
		client.getBasket().addToBasket(new Car("CK-923-EJ", "Citroen", "Picasso", true, false, 2, 100.0));
		garageSeller.purchaseCar(client.constructStringFromList(client.getBasket().getCarsInBasket()), "987", "RUB", client.getBasket().basketPrice());
	}

}