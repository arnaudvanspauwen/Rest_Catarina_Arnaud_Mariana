package eiffelCorp;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import common.Car;
import common.ICar;
import common.IGarageObservable;
import common.IPersonObserver;
import common.Person;

public class Client {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		IGarageObservable garage = (IGarageObservable) Naming.lookup("garage");
		IPersonObserver person = new Person("Mariana", 123, true);
		ICar car = new Car(1, "Citroen", true, 2);
		garage.add(1, "Citroen", true, 2);
		garage.add(2, "Citroen", false, 3);
		System.out.println(garage.toString());
		List<ICar> list = garage.lookAvailable();
		System.out.println(list.toString());
		garage.rent(person, car, 6);
		
	}

}
