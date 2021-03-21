package modele;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.rmi.Naming;

public class ClientMorpion {
    public static void lancerMorpion() {
        try {
            InterfacePendu obj = (InterfacePendu) Naming.lookup("rmi://localhost:8001/morpion");
            System.out.println("Client connecte.\nOuverture de l'application.\n");
            try {
                Stage stage = new Stage();
                URL fxmlURL= ClientPendu.class.getResource("/vue/Morpion.fxml");
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
