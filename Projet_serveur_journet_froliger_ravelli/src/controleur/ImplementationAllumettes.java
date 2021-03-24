package controleur;

import modele.InterfaceAllumettes;

import java.net.URL;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;
import java.util.ResourceBundle;

public class ImplementationAllumettes extends UnicastRemoteObject implements InterfaceAllumettes {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ImplementationAllumettes() throws RemoteException {
        super();
    }

    @Override
    public void Jouer() throws RemoteException {

    }

    @Override
    public void Quitter() throws RemoteException {

    }

    @Override
    public void RetourAccueil() throws RemoteException {

    }

    @Override
    public void Rejouer() throws RemoteException {

    }

    @Override
    public void Tirer1() throws RemoteException {

    }

    @Override
    public void Tirer2() throws RemoteException {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) throws RemoteException {

    }

    @Override
    public int Choix(int nbre) throws RemoteException {
        Random random = new Random();
        nbre = 1+random.nextInt(2-1);
        return nbre;
    }

    @Override
    public void TourOrdi() throws RemoteException {

    }

    @Override
    public void fin() throws RemoteException {

    }

    @Override
    public void MajAllumettes(int nbreAlluJeu) throws RemoteException {

    }
}
