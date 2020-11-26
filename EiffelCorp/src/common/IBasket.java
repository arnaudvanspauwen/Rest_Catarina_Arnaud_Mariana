package common;

import java.util.List;

public interface IBasket {
	
	public List<ICar> getCarsInBasket();
	public void setCarsInBasket(List<ICar> carsInBasket);
	public boolean addToBasket(ICar car);
	public boolean deleteFromBasket(ICar car);
	public double basketPrice();

}
