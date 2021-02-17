package modele;

import java.rmi.*;
import java.rmi.server.*;

public class Methodes extends UnicastRemoteObject implements MethodesInterface {
    public Methodes() throws RemoteException {
        super(); 
    }
 
    //mettre corps des fonctions ici + throws RemoteException
}