package client;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import callback.Callback;
import remoteService.DoSomethingService;
import server.commands.CalculationCommand;
import server.commands.Command;
import server.commands.LoginCommand;
import server.commands.RegisterCommand;
import server.commands.Pi;

/**
 * Client-Klasse, verbindet sich mit dem stub des Server und sendet die Aufgabe
 * 
 * @author lmayer
 * @version 12032016
 *
 */
public class Client {

	public static void main(String[] args) {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		try {
			Registry registry = LocateRegistry.getRegistry(1234);

			DoSomethingService uRemoteObject = (DoSomethingService) registry.lookup("Service");
			System.out.println("Service found");

			Command rc = new RegisterCommand();
			Command lc = new LoginCommand();
			Command cc = new CalculationCommand();

			uRemoteObject.doSomething(rc);
			uRemoteObject.doSomething(lc);
			uRemoteObject.doSomething(cc);

			//Neues Remote Objekt erstellen und in die RMIRuntime exportieren
			Callback cb = new CallbackPi();
			Callback stub = (Callback) UnicastRemoteObject.exportObject(cb, 0); //UnicastRemoteObject wieder zu Callback parsen

			int digits = Integer.parseInt(args[0]);
//			Command<BigDecimal> calc = (Command<BigDecimal>) new Pi(digits, stub);
			Command<BigDecimal> calc = new Pi(digits, stub);
			//Aufgabe übermitteln
			uRemoteObject.doSomething(calc);
//			System.out.println(calc);
		} catch (RemoteException re) {
			System.err.println("Service not found?" + " Check your RMI-Registry!");
			System.exit(1);
		} catch (Exception e) {
			System.err.println("Service exception:");
			e.printStackTrace();
			System.exit(1);
		}
	}
}
