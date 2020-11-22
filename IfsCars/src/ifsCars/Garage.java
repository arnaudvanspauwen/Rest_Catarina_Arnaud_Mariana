package ifsCars;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.List;

import common.ICar;
import common.IGarageObservable;
import common.IPersonObserver;
import common.IRentCar;

public class Garage extends UnicastRemoteObject implements IGarageObservable {

	private List<ICar> garage;
	private List<IPersonObserver> waitingList;
	private List<IRentCar> historyOfRents;

	public Garage() throws RemoteException {
		super();
		this.garage = new ArrayList<ICar>();
	}

	@Override
	public List<ICar> getGarage() throws RemoteException {
		return this.garage;
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

	@Override
	public IRentCar rent(IPersonObserver person, ICar car, int amountDays) throws RemoteException {
		IRentCar rent = new RentCar(person, car, amountDays);
		System.out.println("rent is " + rent.toString());
		if (car.getAvailable() == false) {
			waitingList.add(person);
		} else {
			System.out.println("its available");
			car.setAvailable(false);
			System.out.println("the" + car + " is being rented by " + person);
			historyOfRents.add(rent);
			return rent;
		}
		return null;
	}


}
