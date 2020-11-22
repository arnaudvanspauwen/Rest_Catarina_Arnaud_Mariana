package ifsCars;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import common.ICar;
import common.IGarageObservable;

public class Garage extends UnicastRemoteObject implements IGarageObservable {

	private ArrayList<ICar> garage;

	public Garage() throws RemoteException {
		super();
		this.garage = new ArrayList<ICar>();
	}

	@Override
	public void add(int id, String brand, Boolean available, double pricePerDay) throws RemoteException {
		ICar car = new Car(id, brand, available, pricePerDay);
		garage.add(car);
		System.out.println("one car added: " + car);

	}

	@Override
	public void del(int id) throws RemoteException {
		for (ICar car : garage) {
			if (car.getId() == id) {
				garage.remove(car);
			}
		}
	}

	@Override
	public List<ICar> lookBrand(String brand) throws RemoteException {
		List carsList = new ArrayList<ICar>();
		for (ICar car : garage) {
			if (car.getBrand().equals(brand)) {
				carsList.add(car);
			}
		}
		return carsList;
	}

	@Override
	public List<ICar> lookAvailable() throws RemoteException {
		List carsList = new ArrayList<ICar>();
		for (ICar car : garage) {
			if (car.getAvailable().equals(true)) {
				carsList.add(car);
			}
		}
		System.out.println("cars available" + carsList);
		return carsList;
	}
	
	

}
