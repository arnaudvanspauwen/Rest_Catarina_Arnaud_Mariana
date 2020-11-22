package ifsCars;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import common.IGarageObservable;

public class Server {

	public static void main(String[] args) throws RemoteException, MalformedURLException {
			LocateRegistry.createRegistry(1099);
			IGarageObservable garage = new Garage();
			System.setProperty("java.security.policy", "file:./server.policy");
			Naming.rebind("garage", garage);
	}
}
