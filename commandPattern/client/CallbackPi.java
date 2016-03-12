package client;

import java.math.BigDecimal;
import java.rmi.RemoteException;

import callback.Callback;

/**
 * Gibt das Ergebnis der Berechnung zurück
 * Implementier Callback
 * @author Lukas
 * @verison 12032016
 */
public class CallbackPi implements Callback{

	@Override
	/**
	 * Gibt das Ergebnis der Berechnung aus
	 */
	public BigDecimal receivePi(BigDecimal pi) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println(pi);
		return pi;
	}

	
}
