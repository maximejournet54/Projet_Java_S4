package controleur;

import javafx.event.ActionEvent;
import modele.InterfacePendu;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

public class ImplementationPendu extends UnicastRemoteObject implements InterfacePendu {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
    
  //pendu
    @Override
	public String motPendu() throws RemoteException {
			String mot="";
			String fichier ="dictionnaire.txt";
			int compteur =0;
			Random rand = new Random();
			int limite = rand.nextInt(15743);//15743=nombre de mots du dictionnaire
			System.out.println(limite+"\n");
			//lecture du fichier texte	
			try{
				InputStream ips=new FileInputStream(fichier); 
				InputStreamReader ipsr=new InputStreamReader(ips);
				BufferedReader br=new BufferedReader(ipsr);
				String ligne;
				while ((ligne=br.readLine())!=null && compteur<limite){
					mot = ligne;
					compteur++;
				}
				br.close(); 
			}		
			catch (Exception e){
				System.out.println(e.toString());
			}
		return mot;
	}
}
