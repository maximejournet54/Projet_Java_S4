package modele;
	
import java.rmi.*;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;


public class Client extends Application {
		
    //methode qui ouvre l'accueil
	@Override
	public void start(Stage primaryStage) {
		try {
			URL fxmlURL=getClass().getResource("/vue/Accueil.fxml");
			FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
			Parent root = fxmlLoader.load();
			
			Scene scene = new Scene(root, 900, 700);
			//scene.getStylesheets().add(getClass().getResource("/vue/Accueil.css").toExternalForm());
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Accueil");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
        try {
            String hote="127.0.0.1";
            int port = Integer.parseInt("6001");
            // lookup est une methode de Naming qui permet de rechercher un objet dans le service de nommage
			MethodesInterface obj = (MethodesInterface) Naming.lookup ("rmi://"+ hote +":"+port + "/jeu");
            System.out.println("Client connecte.\nOuverture de l'application.\n");
            launch(args);
        } catch (Exception e) {
            System.out.println ("Pb avec le client:\n" + e);
        }
	}
}