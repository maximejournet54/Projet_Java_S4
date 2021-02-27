package modele;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;

public class Serveur {
    public static void main(String[] args) {
        try {
            String hote="127.0.0.1";
            final int port = Integer.parseInt("6000");
            // createRegistry permet de lancer le rmiregistry sur le port indique
            LocateRegistry.createRegistry(port);
            Methodes obj=new Methodes();
            Naming.rebind ("rmi://"+ hote +":"+port+ "/accueil", obj);
            System.out.println ("Serveur pret !\n");
        } catch (Exception e) {
                System.out.println ("Probleme avec le serveur:\n" + e);
            }
    }
}