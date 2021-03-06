package common;
import java.util.ArrayList;
import java.util.List;

import common.CarCondition;
import common.ICar;

public class Car implements ICar {
	
	private String licencePlate;
	private String brand;
	private String model;
	private Boolean available;
	private Boolean forSale;
	private double pricePerDay;
	private double PRICESALE;
	private List<String> notes;
	private List<CarCondition> carConditionEnum;
		
	public Car(String licencePlate, String brand, String model, Boolean available, Boolean forSale, double pricePerDay, double priceSale) {
		this.licencePlate = licencePlate;
		this.brand = brand;
		this.model = model;
		this.available = available;
		this.forSale = forSale;
		this.pricePerDay = pricePerDay;
		this.PRICESALE = priceSale;
		this.notes = new ArrayList<String>();
		this.carConditionEnum = new ArrayList<CarCondition>();
		this.forSale = false;
	}
	
	@Override
	public String getLicencePlate(){
		return licencePlate;
	}
	
	@Override
	public void setLicencePlate(String licencePlate){
		this.licencePlate = licencePlate;
	}
	
	@Override
	public String getBrand(){
		return brand;
	}
	
	@Override
	public void setBrand(String brand){
		this.brand = brand;
	}
	
	@Override
	public String getModel(){
		return model;
	}
	
	@Override
	public void setModel(String model){
		this.model = model;
	}
	
	@Override
	public Boolean getAvailable(){
		return available;
	}
	
	@Override
	public void setAvailable(Boolean available){
		this.available = available;
	}
	
	
	@Override
	public Boolean getForSale() {
		return forSale;
	}

	@Override
	public void setForSale(Boolean forSale) {
		this.forSale = forSale;
	}
	
	@Override
	public double getPRICESALE() {
		return PRICESALE;
	}

	@Override
	public double getPricePerDay(){
		return pricePerDay;
	}
	
	@Override
	public void setPricePerDay(double pricePerDay){
		this.pricePerDay = pricePerDay;
	}

	@Override
	public List<String> getNotes() {
		return notes;
	}
	
	@Override
	public void setNotes(List<String> notes) {
		this.notes = notes;
	}

	@Override
	public List<CarCondition> getCarConditionEnum() {
		return this.carConditionEnum;
	}

	@Override
	public void setCarConditionEnum(List<CarCondition> carConditionEnum) {
		this.carConditionEnum = carConditionEnum;
	}

	@Override
	public String toString() {
		return "Car [licencePlate=" + licencePlate + ", brand=" + brand + ", model=" + model + ", available for Rent =" + available + ", available for Sale = " + forSale +", price per day (in euros) = " + pricePerDay + ", price for Sale (in euros) =" + PRICESALE + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((licencePlate == null) ? 0 : licencePlate.hashCode());
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
		Car other = (Car) obj;
		if (licencePlate == null) {
			if (other.licencePlate != null)
				return false;
		} else if (!licencePlate.equals(other.licencePlate))
			return false;
		return true;
	}
	
}
