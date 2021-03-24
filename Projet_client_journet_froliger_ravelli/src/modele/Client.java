package modele;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.rmi.*;

import java.net.URL;

public class Client extends Application{
    public static void main(String[] args) {
        try {
            InterfaceAccueil obj = (InterfaceAccueil) Naming.lookup("rmi://localhost:8001/accueil");
            System.out.println("Client connecte.\nOuverture de l'application.\n");
            launch(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start(Stage stage){
        try {
            URL fxmlURL=getClass().getResource("/vue/Accueil.fxml");
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
            Node root = fxmlLoader.load();
            Scene scene = new Scene( (Parent) root, 900, 700);
            stage.getIcons().add(new Image("/vue/icone_accueil.jpg"));
            stage.setScene(scene);
            stage.setTitle("Accueil de l'application");
            stage.setResizable(false);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
