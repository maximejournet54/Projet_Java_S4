package modele;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceAccueil extends Remote {
    public void clickMenuAide() throws RemoteException;
    public void clickMenuQuitter() throws RemoteException;
    public void clickMenuPendu() throws RemoteException;
    public void clickMenuMorpion() throws RemoteException;
}
