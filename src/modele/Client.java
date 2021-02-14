package modele;

import java.rmi.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            String hote="127.0.0.1";
            int port = Integer.parseInt("6005");
            // lookup est une methode de Naming qui permet de rechercher un objet dans le service de nommage
            JeuInterface obj = (JeuInterface) Naming.lookup ("rmi://"+ hote +":"+port + "/jeu");
            System.out.println("Client connecté.\n");
            /*
            Scanner sc=new Scanner(System.in);
            System.out.println("Choisir le jeu à lancer: 1= pendu \t 2= alumettes\n 3= tic tac toe\n");
            int choix = sc.nextInt();
            if(choix==1){
                System.out.println("Vous avez choisi le jeu du pendu.\n");
            }
            else if (choix==2){
                System.out.println("Vous avez choisi le jeu des alumettes\n");
            }
            else if (choix==3){
                System.out.println("Vous avez choisi le jeu Tic-tac-toe.\n");
            }
            else{
                System.out.println("Choix incorrect, sortie de l'application\n");
                System.exit(1);
            }
            sc.close();
            */
            //partie entre commentaires a mettre dans interface graphique de la page d accueil de l application
        } catch (Exception e) {
            System.out.println ("Erreur du client: " + e);
        }
    }
}
