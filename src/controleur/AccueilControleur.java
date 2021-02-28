package controleur;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AccueilControleur implements Initializable {

	@FXML private MenuItem menuPendu;
	@FXML private MenuItem menuMorpion;
	@FXML private MenuItem menuAlumette;
	@FXML private MenuItem menuQuitter;
	@FXML private MenuItem menuInfo;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	}

	// actions au clic sur les menuItem pour choisir le jeu a completer apres
	
	@FXML
	public void click_mnu_pendu(ActionEvent event) {
	    try{
	    	Stage stage = new Stage();
	            
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("/vue/Pendu.fxml"));
			Scene scene = new Scene(root); //redimmension auto 
	        //stage.initModality(Modality.APPLICATION_MODAL); //pour cacher la zone fenetre de windows
	        //stage.initStyle(StageStyle.UNDECORATED);
	        stage.setTitle("Pendu");       
	        stage.setScene(scene);		
			stage.setResizable(false);
	        stage.show();   	
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	/*
	@FXML
	public void click_mnu_morpion() {
		try {
	        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vue/Morpion.fxml"));
	        Parent root1 = (Parent) fxmlLoader.load();
	        Stage stage = new Stage();
	        stage.setScene(new Scene(root1));  
	        stage.setTitle("Jeu du Morpion");
	        stage.show();
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	
	@FXML
	public void click_mnu_alumette() {
		try {
	        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vue/Alumettes.fxml"));
	        Parent root1 = (Parent) fxmlLoader.load();
	        Stage stage = new Stage();
	        stage.setScene(new Scene(root1));  
	        stage.setTitle("Jeu des alumettes");
	        stage.show();
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	*/
	
	@FXML
	public void clickMenuQuitter() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Attention!");
		alert.setHeaderText("Attention, vous allez fermer l'application");
		alert.setContentText("Voulez-vous vraiment fermer l'application?");
		ButtonType btnOui = new ButtonType("Oui");
		ButtonType btnNon = new ButtonType("Non", ButtonData.CANCEL_CLOSE);
		alert.getButtonTypes().setAll(btnOui,btnNon);
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == btnOui){
			Platform.exit();
		}
	}
	
	@FXML
	public void clickMenuAide() {
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