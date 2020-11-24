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

	@Override
	public IPersonObserver getPerson() {
		return person;
	}

	@Override
	public ICar getCar() {
		return car;
	}

	@Override
	public int getAmountDays() {
		return amountDays;
	}

	@Override
	public double getRentPrice() {
		return rentPrice;
	}

	@Override
	public void setPerson(IPersonObserver person) {
		this.person = person;
	}

	@Override
	public void setCar(ICar car) {
		this.car = car;
	}

	@Override
	public void setAmountDays(int amountDays) {
		this.amountDays = amountDays;
	}

	@Override
	public void setRentPrice(double rentPrice) {
		this.rentPrice = rentPrice;
	}

	@Override
	public String toString() {
		return "Rent is" + person + car + amountDays + rentPrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((car == null) ? 0 : car.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RentCar other = (RentCar) obj;
		if (car == null) {
			if (other.car != null)
				return false;
		} else if (!car.equals(other.car))
			return false;
		return true;
	}
}
