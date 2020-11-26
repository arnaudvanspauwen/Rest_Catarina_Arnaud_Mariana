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
		this.bank = new ArrayList<IBankAccount>();
	}

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

		return true;
	}


}