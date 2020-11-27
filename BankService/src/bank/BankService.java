package bank;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.rpc.ServiceException;

import com.currencysystem.webservices.currencyserver.CurncsrvReturnRate;
import com.currencysystem.webservices.currencyserver.CurrencyServerLocator;
import com.currencysystem.webservices.currencyserver.CurrencyServerSoap;

import common.IBankAccount;
import common.IBankService;

public class BankService implements IBankService{

	private List<IBankAccount> bank;

	public BankService() {
		this.bank = this.initializeAccounts();
	}

	public List<IBankAccount> initializeAccounts() {
		List<IBankAccount> accounts = new ArrayList<IBankAccount>();
		IBankAccount marianaAccount = new BankAccount("987", 1000);
		IBankAccount catarinaAccount = new BankAccount("654", 3000);
		IBankAccount arnaudAccount = new BankAccount("543", 2000);
		IBankAccount mahdiAccount = new BankAccount("321", 5000);
		accounts.add(marianaAccount);
		accounts.add(catarinaAccount);
		accounts.add(arnaudAccount);
		accounts.add(mahdiAccount);
		return accounts;
	}
	
	@Override
	public boolean payment(String rib, double price, String currency) {
		if(!currency.equals("EUR")) {
			try {
				CurrencyServerSoap currencyServerSoap = new CurrencyServerLocator().getCurrencyServerSoap();
				price = (double) currencyServerSoap.convert("", currency, "EUR", price, false, "", CurncsrvReturnRate.curncsrvReturnRateNumber, "", "");
			} catch (ServiceException e) {
				e.printStackTrace();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		for(IBankAccount bankAccount : bank) {
			if(bankAccount.getRib().equals(rib) && bankAccount.getBalance() > price) {
				bankAccount.setBalance(bankAccount.getBalance() - price);
				return true;
			}
		}

		return false;
	}


}