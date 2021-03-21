package controleur;

import modele.InterfaceAccueil;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ImplementationAccueil extends UnicastRemoteObject implements InterfaceAccueil {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ImplementationAccueil() throws RemoteException {
        super();
    }

    @Override
    public void clickMenuAide() throws RemoteException {

    }

    @Override
    public void clickMenuQuitter() throws RemoteException {

    }

    @Override
    public void clickMenuPendu() throws RemoteException {

    }
}