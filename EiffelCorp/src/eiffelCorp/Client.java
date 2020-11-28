package eiffelCorp;
import java.io.File;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import common.Car;
import common.CarCondition;
import common.ICar;
import common.IGarageObservable;
import common.IPersonObserver;
import common.IRentCar;
import common.Person;

public class Client {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		Path currentPath = Paths.get("");
		String path = currentPath.toAbsolutePath().toString();
		path = path.substring(0, path.lastIndexOf(File.separator));
		String policy_path = "file:" + File.separator + File.separator + path + File.separator + "EiffelCorp" + File.separator + "src" + File.separator + "eiffelCorp" + File.separator + "client.policy";
		String codebase_path = "file:" + File.separator + File.separator + path + File.separator + "IfsCars" + File.separator + "bin" + File.separator;
		System.setProperty("java.security.policy", policy_path);
		System.setProperty("java.rmi.server.codebase", codebase_path);
		System.setSecurityManager(new RMISecurityManager());
		
		IGarageObservable garage = (IGarageObservable) Naming.lookup("garage");
		
		IPersonObserver mariana = new Person("Mariana", 123, false);
		IPersonObserver catarina = new Person("Catarina", 124, true);
		IPersonObserver arnaud = new Person("Arnaud", 125, true);
		
		ICar citroen = new Car("CK-923-EJ", "Citroen", "Picasso", true, false, 2, 2000.0);
		ICar bmw = new Car("IK-911-AB", "BMW", "i8", true, false, 2, 1000.0);
		ICar mercedes = new Car("IK-911-AB", "Mercedes", "E220", true, false, 2, 1500.0);
		
		
		garage.add(citroen);
		garage.add(bmw);
		garage.add(mercedes);
		
		IRentCar rentMariana = garage.rent(mariana, citroen, 6);
		IRentCar rentCatarina = garage.rent(catarina, bmw, 3);
		IRentCar rentArnaud = garage.rent(arnaud, citroen, 6);
		
		garage.returnCar(rentCatarina, "Muy Bueno", CarCondition.GOOD);
		garage.returnCar(rentMariana, "It was OK", CarCondition.OK);
		garage.returnCar(rentArnaud, "no good", CarCondition.BAD);
	}

}
