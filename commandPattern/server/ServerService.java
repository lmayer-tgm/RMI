package server;

import java.rmi.RemoteException;

import remoteService.DoSomethingService;
import server.commands.Command;

/**
 * Server-seitige Implementierung des Remote-Interfaces
 * @author Lukas
 *
 */
public class ServerService implements DoSomethingService {

	@Override
	/**
	 * Aufgabe von Client
	 */
	public void doSomething(Command c) throws RemoteException {
		c.execute();
	}
}
