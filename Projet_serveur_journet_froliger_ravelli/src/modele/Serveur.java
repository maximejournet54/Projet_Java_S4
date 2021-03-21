package modele;

import controller.ImplementationAccueil;
import controller.ImplementationAllumettes;
import controller.ImplementationMorpion;
import controller.ImplementationPendu;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Serveur {
    public static void main(String[] args) {
        try {
            int port = 8001;
            LocateRegistry.createRegistry(port);

            ImplementationAccueil accueil = new ImplementationAccueil();
            Naming.rebind("rmi://localhost:8001/accueil", accueil);

            ImplementationPendu pendu = new ImplementationPendu();
            Naming.rebind("rmi://localhost:8001/pendu", pendu);

            ImplementationAllumettes allumette = new ImplementationAllumettes();
            Naming.rebind("rmi://localhost:8001/allu", allumette);

            ImplementationMorpion morpion = new ImplementationMorpion();
            Naming.rebind("rmi://localhost:8001/morpion", morpion);

            System.out.println(">>> Serveur pret");
        } catch (Exception e) {
            System.out.println("Dysfonctionnement dans le serveur : ");
            System.out.println(e);
        }
    }
}
