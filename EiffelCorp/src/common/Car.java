package common;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import common.ICar;

public class Car implements ICar {
	
	private int id;
	private String brand;
	private Boolean available;
	private double pricePerDay;
	private List<String> notes;
		
	public Car(int id, String brand, Boolean available, double pricePerDay) {
		this.id = id;
		this.brand = brand;
		this.available = available;
		this.pricePerDay = pricePerDay;
		this.notes = new ArrayList<String>();
	}
	
	@Override
	public int getId(){
		return id;
	}
	
	@Override
	public void setId(int id){
		this.id = id;
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
		return "Car [id=" + id + ", brand=" + brand + ", available=" + available + "]";
	}
}
