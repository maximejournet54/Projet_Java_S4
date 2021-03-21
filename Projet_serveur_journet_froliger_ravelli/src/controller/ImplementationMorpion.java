package controller;

import modele.InterfaceMorpion;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ImplementationMorpion extends UnicastRemoteObject implements InterfaceMorpion {
    public ImplementationMorpion() throws RemoteException {

    }
}
