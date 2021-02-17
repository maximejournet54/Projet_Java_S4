package modele;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;

public class Serveur {
    public static void main(String[] args) {
        try {
            String hote="127.0.0.1";
            int port = Integer.parseInt("6001");
            // createRegistry permet de lancer le rmiregistry sur le port indiqu�
            LocateRegistry.createRegistry(port);
            Methodes obj=new Methodes();
            Naming.rebind ("rmi://"+ hote +":"+port+ "/jeu", obj);
            System.out.println ("Serveur pret !\n");
        } catch (Exception e) {
                System.out.println ("Pb avec le serveur:\n" + e);
            }
    }
}