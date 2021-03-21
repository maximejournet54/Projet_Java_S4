package controller;

import modele.InterfaceAllumettes;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ImplementationAllumettes extends UnicastRemoteObject implements InterfaceAllumettes {
    public ImplementationAllumettes() throws RemoteException {

    }
}
