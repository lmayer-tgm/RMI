package callback;

import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Remote Interface des Clients 
 * 
 * @author lmayer
 * @version 12032016
 */
public interface Callback extends Remote {

	 /**
	  * Erhält vom Server das Ergebnis
	  * @param pi Ergebnis der Rechnung
	  * @throws RemoteException
	  */
	void receivePi(BigDecimal pi) throws RemoteException;
}
