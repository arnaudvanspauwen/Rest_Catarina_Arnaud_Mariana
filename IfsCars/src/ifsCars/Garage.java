package ifsCars;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.CarCondition;
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
				System.out.println("******************this when we put people on the waiting list 1st**********************************");
				System.out.println("\n");
				System.out.println(person.getName() + " is waiting for " + garage.get(garage.indexOf(car)).getLicencePlate());
				System.out.println("\n");
				System.out.println("****************************************************");

			} else {
				System.out.println("******************this when we put people on the waiting list after 1st**********************************");
				System.out.println("\n");
				System.out.println(person.getName() + " is waiting for " + garage.get(garage.indexOf(car)).getLicencePlate());
				waitingList.get(garage.get(garage.indexOf(car))).add(rent);
				System.out.println("\n");
				System.out.println("****************************************************");
			}
			System.out.println("\n");
		} else {
			System.out.println("******************this is the rent**********************************");
			System.out.println("\n");
			System.out.println("the " + garage.get(garage.indexOf(car)).getLicencePlate() + " its available");
			garage.get(garage.indexOf(car)).setAvailable(false);
			garage.get(garage.indexOf(car)).setForSale(true);
			System.out.println("the " + garage.get(garage.indexOf(car)).getLicencePlate() + "is not available anymore");
			System.out.println("\n");
			System.out.println("the " + garage.get(garage.indexOf(car)).getLicencePlate() + " is being rented by " + person.getName() + " at the following price: " + rent.getRentPrice());
			System.out.println("\n");
			System.out.println("****************************************************");
			historyOfRents.add(rent);
		}
		return rent;
	}

	@Override
	public void returnCar(IRentCar rent, String notes, CarCondition carEnum) throws RemoteException{
		System.out.println("history of rents before: " + historyOfRents.toString());
		this.historyOfRents.remove(rent);
		System.out.println("history of rents after: " + historyOfRents.toString());
		garage.get(garage.indexOf(rent.getCar())).setAvailable(true);
		garage.get(garage.indexOf(rent.getCar())).getNotes().add(notes);
		garage.get(garage.indexOf(rent.getCar())).getCarConditionEnum().add(carEnum);
		if(waitingList.containsKey(garage.get(garage.indexOf(rent.getCar()))))
			this.notifyObserver(garage.get(garage.indexOf(rent.getCar()))); 

	}

	@Override
	public void notifyObserver(ICar car) throws RemoteException{
		if (!waitingList.get(car).isEmpty()) {
			this.rent(waitingList.get(car).get(0).getPerson(), waitingList.get(car).get(0).getCar(), waitingList.get(car).get(0).getAmountDays());
			System.out.println("waiting list before removing 1 person: " + waitingList.get(car));
			waitingList.get(car).remove(0);
			System.out.println("waiting list after removing 1 person: " + waitingList.get(car));
		}
		//put for sell later!!!!!!!! setForSale()
	}
}
