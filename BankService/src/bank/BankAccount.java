package bank;

import common.IBankAccount;

public class BankAccount implements IBankAccount{
	
	private String rib;
	private double balance;
	
	public BankAccount(String rib, double balance) {
		this.rib = rib;
		this.balance = balance;
	}

	@Override
	public String getRib() {
		return rib;
	}

	@Override
	public double getBalance() {
		return balance;
	}

	@Override
	public void setRib(String rib) {
		this.rib = rib;
	}

	@Override
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	

}