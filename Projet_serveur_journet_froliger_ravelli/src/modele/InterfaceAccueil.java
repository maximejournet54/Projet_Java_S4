package modele;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceAccueil extends Remote {
    public void cliquerAide() throws RemoteException;
    public void cliquerQuitter() throws RemoteException;
    public void cliquerPendu() throws RemoteException;
    public void cliquerMorpion() throws RemoteException;
    public void cliquerAllu() throws RemoteException;
}
