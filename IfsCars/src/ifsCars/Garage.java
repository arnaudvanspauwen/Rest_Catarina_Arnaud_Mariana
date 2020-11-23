package ifsCars;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.ICar;
import common.IGarageObservable;
import common.IPersonObserver;
import common.IRentCar;

public class Garage extends UnicastRemoteObject implements IGarageObservable {

	private List<ICar> garage;
	private Map<ICar, List<IRentCar>> waitingList;
	private List<IRentCar> historyOfRents;

	public Garage() throws RemoteException {
		super();
		this.garage = new ArrayList<ICar>();
		this.historyOfRents = new ArrayList<IRentCar>();
		this.waitingList = new HashMap<ICar, List<IRentCar>>();
	}

	@Override
	public List<ICar> getGarage() throws RemoteException {
		return this.garage;
	}

	@Override
	public void add(ICar car) throws RemoteException {
		garage.add(car);
		System.out.println("one car added: " + car);
	}

	@Override
	public void del(String licencePlate) throws RemoteException {
		for (ICar car : garage) {
			if (car.getLicencePlate() == licencePlate) {
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
		if (garage.get(garage.indexOf(car)).getAvailable() == false) {
			if (!waitingList.containsKey(garage.get(garage.indexOf(car)))) {
				waitingList.put(garage.get(garage.indexOf(car)), new ArrayList<IRentCar>());
				waitingList.get(garage.get(garage.indexOf(car))).add(rent);
				System.out.println(person + "is waiting for " + garage.get(garage.indexOf(car)));
			} else {
				System.out.println(person + "is waiting for " + garage.get(garage.indexOf(car)) + " else");
				waitingList.get(garage.get(garage.indexOf(car))).add(rent);
			}
			System.out.println("\n");
			return null;
		} else {
			System.out.println("the " + garage.get(garage.indexOf(car)) + " its available");
			System.out.println("entering for " + garage.get(garage.indexOf(car)).equals(car));
			System.out.println("availability " + garage.get(garage.indexOf(car)).getAvailable());
			garage.get(garage.indexOf(car)).setAvailable(false);
			System.out.println("the " + garage.get(garage.indexOf(car)) + "is not available anymore");
			System.out.println("--------------------------------------------");
			System.out.println("\n");
			System.out.println("the " + garage.get(garage.indexOf(car)) + " is being rented by " + person);
			System.out.println("\n");
			historyOfRents.add(rent);
			return rent;
		}
	}

	@Override
	public void returnCar(IRentCar rent, String notes) throws RemoteException{
		this.historyOfRents.remove(rent);
		this.notifyObserver(rent.getCar()); //develop method
		rent.getCar().setAvailable(true);
		rent.getCar().getNotes().add(notes);
	}

	public void notifyObserver(ICar car) throws RemoteException{
		waitingList.remove(0);

	}


}
