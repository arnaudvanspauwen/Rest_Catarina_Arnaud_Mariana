package ifsCars;

import java.rmi.RemoteException;

import common.ICar;
import common.IPersonObserver;
import common.IRentCar;

public class RentCar implements IRentCar{
	
	private IPersonObserver person;
	private ICar car;
	private int amountDays;
	private double rentPrice;
	
	public RentCar(IPersonObserver person, ICar car, int amountDays) throws RemoteException {
		super();
		this.person = person;
		this.car = car;
		this.amountDays = amountDays;
		this.rentPrice = amountDays*car.getPricePerDay();
	}

	public IPersonObserver getPerson() {
		return person;
	}

	public ICar getCar() {
		return car;
	}

	public int getAmountDays() {
		return amountDays;
	}

	public double getRentPrice() {
		return rentPrice;
	}

	public void setPerson(IPersonObserver person) {
		this.person = person;
	}

	public void setCar(ICar car) {
		this.car = car;
	}

	public void setAmountDays(int amountDays) {
		this.amountDays = amountDays;
	}

	public void setRentPrice(double rentPrice) {
		this.rentPrice = rentPrice;
	}
}
