package modele;

import java.rmi.*;
import java.rmi.server.*;

public class Jeu extends UnicastRemoteObject implements JeuInterface {
    public Jeu() throws RemoteException {
        super(); 
    }
 
    //corps des methodes declarees dans JeuInterface a mettre ici
}