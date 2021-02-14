package modele;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;

public class Serveur {
    public static void main(String[] args) {
        try {
            String hote="127.0.0.1";
            int port = Integer.parseInt("6005");
            //createRegistry permet de lancer le rmiregistry sur le port indique
            LocateRegistry.createRegistry(port);
            Jeu obj=new Jeu();
            //rebind est une methode de la classe Naming qui permet d exporter un objet dans le service de nommage
            Naming.rebind ("rmi://"+ hote +":"+port+ "/jeu", obj);
            System.out.println ("Serveur pret !");
        } catch (Exception e) {
                System.out.println ("Echec du serveur: " + e);
            }
    }
}
