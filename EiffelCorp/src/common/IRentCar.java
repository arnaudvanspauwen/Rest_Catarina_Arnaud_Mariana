package common;

import java.io.Serializable;

public interface IRentCar extends Serializable{
	
	public ICar getCar();
	public String getStartRent();
	public String getEndRent();
	public int getAmountDays();
	public double getPriceRent();
//	public IPersonObserver getNotify();

}
