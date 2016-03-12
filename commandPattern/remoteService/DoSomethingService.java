package remoteService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import server.commands.Command;

/**
 * Remote Interface
 * @author lmayer
 * @verison 12032016
 *
 */
public interface DoSomethingService extends Remote {

	/**
	 * Aufgabe vom Client
	 * @param c Aufgabe
	 * @throws RemoteException
	 */
	public void doSomething(Command c) throws RemoteException;
	
}
