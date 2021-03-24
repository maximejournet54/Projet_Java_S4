package modele;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.net.URL;
import java.rmi.Naming;
import java.rmi.Remote;

public class ClientMorpion  extends Application{
	
	public static void main(String[] args) {
        try {
            Remote obj = (InterfaceMorpion) Naming.lookup("rmi://localhost:8001/morpion");
            System.out.println("Client connecte.\nOuverture de l'application.\n");
            if (obj instanceof InterfaceMorpion) {
            	((InterfaceMorpion)obj).initGrille();
            	((InterfaceMorpion)obj).AfficheGrille();
            }
            launch(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	public void start(Stage stage){
        try {
            URL fxmlURL=getClass().getResource("/vue/Morpion.fxml");
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
            Node root = fxmlLoader.load();
            Scene scene = new Scene( (Parent) root, 900, 700);

            stage.setScene(scene);
            stage.setTitle("Jeu du Morpion");
            stage.setResizable(false);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

	    public static void lancerMorpion() {
	        try {
	            InterfaceMorpion obj = (InterfaceMorpion) Naming.lookup("rmi://localhost:8001/morpion");
	            System.out.println("Client connecte.\nOuverture de l'application.\n");
	            try {
	                Stage stage = new Stage();
	                URL fxmlURL= ClientMorpion.class.getResource("/vue/Morpion.fxml");
	                FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
	                Node root = fxmlLoader.load();
	                Scene scene = new Scene( (Parent) root, 900, 700);

	                stage.setScene(scene);
	                stage.setTitle("Jeu du Morpion");
	                stage.setResizable(false);
	                stage.show();
	            } catch(Exception e) {
	                e.printStackTrace();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	}


