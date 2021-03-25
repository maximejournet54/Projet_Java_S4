package controleur;

import modele.InterfaceAccueil;

import java.util.Optional;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import static modele.ClientPendu.lancerPendu;
import static modele.ClientMorpion.lancerMorpion;
import static modele.ClientAllumettes.lancerAllumettes;

public class ControleurAccueil implements InterfaceAccueil {
    @FXML private MenuItem menuPendu;
    @FXML private MenuItem menuMorpion;
    @FXML private MenuItem menuAlumette;
    @FXML private MenuItem menuQuitter;
    @FXML private MenuItem menuInfo;

    // actions au clic sur le jeu du pendu dans l'accueil

    @FXML
    public void cliquerPendu() {
        lancerPendu();
    }

    @FXML
    public void cliquerMorpion(){
    	lancerMorpion();
    }
    
    @FXML
    public void cliquerAllu(){
    	lancerAllumettes();
    }
    
    @FXML
    public void cliquerQuitter() {
        Alert alerte = new Alert(AlertType.CONFIRMATION);
        alerte.setTitle("Attention!");
        alerte.setHeaderText("Attention, vous allez fermer l'application");
        alerte.setContentText("Voulez-vous vraiment fermer l'application?");
        ButtonType btnOui = new ButtonType("Oui");
        ButtonType btnNon = new ButtonType("Non", ButtonData.CANCEL_CLOSE);
        alerte.getButtonTypes().setAll(btnOui,btnNon);
        Optional<ButtonType> resultat = alerte.showAndWait();
        if (resultat.get() == btnOui){
            Platform.exit();
        }
    }

    @FXML
    public void cliquerAide() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vue/Aide.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Menu d'aide");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
