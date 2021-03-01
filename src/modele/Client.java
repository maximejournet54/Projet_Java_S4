package modele;
	
import java.rmi.*;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.Node;

public class Client extends Application {
		
    //methode qui ouvre l'accueil
	@Override
	public void start(Stage primaryStage) {
		try {
			URL fxmlURL=getClass().getResource("/vue/Accueil.fxml");
			FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
			Node root = fxmlLoader.load();
			
			Scene scene = new Scene( (Parent) root, 900, 700);
			//scene.getStylesheets().add(getClass().getResource("/vue/Accueil.css").toExternalForm());
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Accueil de l'application");
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
        try {
            String hote="127.0.0.1";
            final int port = Integer.parseInt("6000");
            // lookup est une methode de Naming qui permet de rechercher un objet dans le service de nommage
			MethodesInterface obj = (MethodesInterface) Naming.lookup ("rmi://"+ hote +":"+port + "/jeux");
            System.out.println("Client connecte.\nOuverture de l'application.\n");
            launch(args);
        } catch (Exception e) {
            System.out.println ("Probleme avec le client:\n" + e);
        }
	}
	
}