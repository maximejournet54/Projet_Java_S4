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
    public void cliquerAide() throws RemoteException {

    }

    @Override
    public void cliquerQuitter() throws RemoteException {

    }

    @Override
    public void cliquerPendu() throws RemoteException {

    }
    
    @Override
    public void cliquerAllu() throws RemoteException {

    }
    
    @Override
    public void cliquerMorpion() throws RemoteException {

    }
}