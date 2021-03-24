package modele;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.net.URL;
import java.rmi.Naming;

public class ClientAllumettes {
    public static void lancerAllumettes() {
        try {
            InterfaceAllumettes obj = (InterfaceAllumettes) Naming.lookup("rmi://localhost:8001/allu");
            System.out.println("Client connecte.\nOuverture de l'application.\n");
            try {
                Stage stage = new Stage();
                URL fxmlURL= ClientPendu.class.getResource("/vue/Allumettes.fxml");
                FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
                Node root = fxmlLoader.load();
                Scene scene = new Scene( (Parent) root);

                stage.setScene(scene);
                stage.setTitle("Jeu des Allumettes");
                stage.getIcons().add(new Image("/vue/icone_allumettes.jpg"));
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
