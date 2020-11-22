package common;

import java.io.Serializable;

public interface IRentCar extends Serializable{
	
	public ICar getCar();
	public int getAmountDays();
	public double getRentPrice();
	public void setPerson(IPersonObserver person);
	public void setCar(ICar car);
	public void setAmountDays(int amountDays);
	public void setRentPrice(double rentPrice);
	
}
