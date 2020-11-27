package ifscarsserviceclient;

import java.rmi.RemoteException;
import java.util.List;

import javax.xml.rpc.ServiceException;

import common.ICar;
import ifscarsservice.GarageSeller;
import ifscarsservice.GarageSellerServiceLocator;

public class ClientStub {
	
//	private GarageSeller garageSeller;
	
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
		GarageSeller garageSeller = (GarageSeller) new GarageSellerServiceLocator().getGarageSeller();
		System.out.println("heyy");
		garageSeller.consultCarPricesAndAvailability();
		System.out.println("ciaoo");
		
	}

}
