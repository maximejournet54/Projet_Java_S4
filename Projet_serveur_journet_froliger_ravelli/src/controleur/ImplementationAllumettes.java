package controleur;

import modele.InterfaceAllumettes;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ImplementationAllumettes extends UnicastRemoteObject implements InterfaceAllumettes {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ImplementationAllumettes() throws RemoteException {

    }
}
