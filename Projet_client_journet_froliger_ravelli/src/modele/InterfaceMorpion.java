package modele;

import javafx.event.ActionEvent;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;


public interface InterfaceMorpion extends Remote {
	public void initGrille() throws RemoteException;
	public void PlacerX(int c) throws RemoteException;
	public void PlacerO(int c) throws RemoteException;
	public int testRanc(int a, int b, int c) throws RemoteException;
	public int testGagnant() throws RemoteException;
	public void AfficheGrille()throws RemoteException;
}
