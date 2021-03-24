package modele;

import java.net.URL;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

public interface InterfaceAllumettes extends Remote{
    public void Jouer() throws RemoteException;
    public void Quitter() throws RemoteException;
    public void RetourAccueil() throws RemoteException;
    public void Rejouer() throws RemoteException;
    public void Tirer1() throws RemoteException;
    public void Tirer2() throws RemoteException;
    public void initialize(URL url, ResourceBundle resourceBundle) throws RemoteException;
    public int Choix(int nbre) throws RemoteException;
    public void TourOrdi() throws RemoteException;
    public void fin() throws RemoteException;
    public void MajAllumettes(int nbreAlluJeu) throws RemoteException;

}
