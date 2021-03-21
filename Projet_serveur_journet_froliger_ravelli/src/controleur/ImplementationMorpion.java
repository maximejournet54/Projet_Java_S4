package controleur;

import modele.InterfaceMorpion;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ImplementationMorpion extends UnicastRemoteObject implements InterfaceMorpion {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ImplementationMorpion() throws RemoteException {

    }
}
