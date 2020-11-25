package bank;

import java.util.ArrayList;
import java.util.List;

import common.IBankAccount;
import common.IBankService;

public class BankService implements IBankService{
	
	private List<IBankAccount> bank;

	public BankService() {
		this.bank = new ArrayList<IBankAccount>();
	}
	
	public boolean payment(String rib, double price, String currency) {
		return true;
	}
	

}