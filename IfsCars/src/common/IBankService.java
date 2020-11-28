package common;

public interface IBankService {
	
	public boolean payment(String rib, double price, String currency);
	public double changePriceCurrency(double price, String currency);
}
