package modele;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MethodesInterface extends Remote {
    //entete des fonctions
    public String motPendu() throws RemoteException;

}