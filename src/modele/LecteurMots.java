package modele;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LecteurMots {

    private static final String nomFichier = "dictionnaire.txt";
    private ArrayList<String> mots = new ArrayList<String>();

    public LecteurMots() {
        try (InputStream in = getClass().getResourceAsStream(nomFichier);
            BufferedReader bf = new BufferedReader(new InputStreamReader(in))) {
            String ligne = "";
            while ((ligne = bf.readLine()) != null){
                mots.add(ligne);
            }      
        }catch (Exception e) {
            System.out.println("N'a pas pu trouver/lire le fichier: " + nomFichier);
            System.out.println("Erreur: " + e.getMessage());
        }
    }

    public String retournerMotAleatoire() {
        if (mots.isEmpty()) return "pas de donnees";
        return mots.get((int)(Math.random()*mots.size()));
    }
}