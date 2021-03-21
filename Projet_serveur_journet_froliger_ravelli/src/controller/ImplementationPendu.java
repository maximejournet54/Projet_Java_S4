package controller;

import javafx.event.ActionEvent;
import modele.InterfacePendu;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ImplementationPendu extends UnicastRemoteObject implements InterfacePendu {
    public ImplementationPendu() throws RemoteException {
        super();
    }

    @Override
    public void menuClic(ActionEvent evt) throws RemoteException {

    }

    @Override
    public void init() throws RemoteException, MalformedURLException, NotBoundException {

    }

    @Override
    public void clickBtn(ActionEvent event) throws RemoteException {

    }
}
