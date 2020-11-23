package common;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import common.ICar;

public class Car implements ICar {
	
	private String licencePlate;
	private String brand;
	private String model;
	private Boolean available;
	private double pricePerDay;
	private List<String> notes;
		
	public Car(String licencePlate, String brand, String model, Boolean available, double pricePerDay) {
		this.licencePlate = licencePlate;
		this.brand = brand;
		this.model = model;
		this.available = available;
		this.pricePerDay = pricePerDay;
		this.notes = new ArrayList<String>();
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
	public String toString() {
		return "Car [licencePlate=" + licencePlate + ", brand=" + brand + ", model=" + model + ", available=" + available + "]";
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
