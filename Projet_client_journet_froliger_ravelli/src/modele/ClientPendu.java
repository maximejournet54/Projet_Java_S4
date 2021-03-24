package modele;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.net.URL;
import java.rmi.Naming;

public class ClientPendu {
    public static void lancerPendu() {
        try {
            InterfacePendu obj = (InterfacePendu) Naming.lookup("rmi://localhost:8001/pendu");
            System.out.println("Client connecte.\nOuverture de l'application.\n");
            try {
                Stage stage = new Stage();
                URL fxmlURL= ClientPendu.class.getResource("/vue/Pendu.fxml");
                FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
                Node root = fxmlLoader.load();
                Scene scene = new Scene( (Parent) root, 600, 400);

                stage.setScene(scene);
                stage.getIcons().add(new Image("/vue/icone_pendu.jpg"));
                stage.setTitle("Jeu du Pendu");
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
