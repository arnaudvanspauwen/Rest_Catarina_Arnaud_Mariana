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
import common.ICar;
import common.IGarageObservable;
import common.IPersonObserver;
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
		IPersonObserver person = new Person("Mariana", 123, true);
		IPersonObserver jos = new Person("Jos", 124, true);
		IPersonObserver fons = new Person("Fons", 125, true);
		ICar citroen1 = new Car("CK-923-EJ", "Citroen", "Picasso", true, 2);
		ICar citroen2 = new Car("IK-911-AB", "Citroen", "Picasso", true, 2);
		garage.add(citroen1);
		garage.add(citroen2);
		System.out.println(garage.toString());
		List<ICar> list = garage.lookAvailable();
		System.out.println(list.toString());
		garage.rent(person, citroen1, 6);
		System.out.println(garage.getGarage().get(garage.getGarage().indexOf(citroen1)).getAvailable());
		garage.rent(jos, citroen1, 3);
		garage.rent(fons, citroen1, 6);

		
	}

}
