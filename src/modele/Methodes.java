package modele;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.rmi.*;
import java.rmi.server.*;
import java.util.Random;

public class Methodes extends UnicastRemoteObject implements MethodesInterface {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Methodes() throws RemoteException {
        super(); 
    }
 
    //pendu
    @Override
	public String motPendu() throws RemoteException {
			String mot="";
			String fichier ="dictionnaire.txt";
			int compteur =0;
			Random randomGenerator = new Random();
			int limite = randomGenerator.nextInt(15743);//15743=nb de mots du dictionnaire
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