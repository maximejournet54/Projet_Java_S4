package modele;

import javafx.event.ActionEvent;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfacePendu extends Remote {
    public void menuClic(ActionEvent evt) throws RemoteException;
    public void init() throws RemoteException, MalformedURLException, NotBoundException;
    public void clickBtn(ActionEvent event) throws RemoteException;
    public String motPendu() throws RemoteException;
}