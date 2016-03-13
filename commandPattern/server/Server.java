package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import remoteService.DoSomethingService;
/**
 * rechnet die Aufgabe eines Clients und schickt das Ergebnis über einen Callback zurück
 * @author lmayer
 * @verison 12032016
 *  */
public class Server {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		try{
			//erstellen des remote objekts und exportieren in die RMIRuntime 
			ServerService uRemoteObject = new ServerService();
			DoSomethingService stub = (DoSomethingService) UnicastRemoteObject.exportObject(uRemoteObject, 0);
			//Neue Registry und binden des Objekts
			Registry registry = LocateRegistry.createRegistry(1234);
			registry.rebind("Service", stub);
			System.out.println("Service bound! Press Enter to terminate ...");

			while ( System.in.read() != '\n' );
			UnicastRemoteObject.unexportObject(uRemoteObject, true);

			System.out.println("Service unbound, System goes down ...");

		} catch (RemoteException re) {
			System.err.println("Service already bound?" + " Check your RMI-Registry settings!");
			re.printStackTrace();
			System.exit(1);
		} catch (Exception e) {
			System.err.println("Service exception:");
			e.printStackTrace();
			System.exit(1);
		}

	}

}
