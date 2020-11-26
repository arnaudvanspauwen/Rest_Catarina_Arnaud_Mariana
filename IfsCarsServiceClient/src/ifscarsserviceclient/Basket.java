package ifscarsserviceclient;

import java.util.ArrayList;
import java.util.List;

import common.IBasket;
import common.ICar;

public class Basket implements IBasket{
	
	private List<ICar> carsInBasket;
	
	public Basket() {
		this.carsInBasket = new ArrayList<ICar>();
	}

	@Override
	public List<ICar> getCarsInBasket() {
		return carsInBasket;
	}

	@Override
	public void setCarsInBasket(List<ICar> carsInBasket) {
		this.carsInBasket = carsInBasket;
	}
	
	@Override
	public boolean addToBasket(ICar car) {
		return this.carsInBasket.add(car);
	}
	
	@Override
	public boolean deleteFromBasket(ICar car) {
		return this.carsInBasket.remove(car);
	}
	
	@Override
	public double basketPrice() {
		double total = 0.0;
		for(ICar car : carsInBasket) {
			total +=car.getPRICESALE();
		}
		return total;
	}
	
	

}
