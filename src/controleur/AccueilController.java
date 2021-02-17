package controleur;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.application.Platform;
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
import javafx.stage.Stage;

public class AccueilController implements Initializable {

	@FXML private MenuItem mnu_pendu;
	@FXML private MenuItem mnu_morpion;
	@FXML private MenuItem mnu_alumette;
	@FXML private MenuItem mnu_quitter;
	@FXML private MenuItem mnu_aide;
	@FXML private MenuItem mnu_sql;
	@FXML private MenuItem mnu_liste_memoire;
	@FXML private MenuItem mnu_info;
	
	@FXML
	public void click_mnu_pendu() {
		try {
	        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/Categorie.fxml"));
	        Parent root1 = (Parent) fxmlLoader.load();
	        Stage stage = new Stage();
	        stage.setScene(new Scene(root1)); 
	        stage.setTitle("Menu Categorie");
	        stage.show();
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	
	// actions au clic sur les mnu_item pour choisir le jeu a completer apres
	
	/*
	@FXML
	public void click_mnu_morpion() {
		try {
	        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/Client.fxml"));
	        Parent root1 = (Parent) fxmlLoader.load();
	        Stage stage = new Stage();
	        stage.setScene(new Scene(root1));  
	        stage.setTitle("Menu Client");
	        stage.show();
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	*/
	
	/*
	@FXML
	public void click_mnu_alumette() {
		try {
	        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/Commande.fxml"));
	        Parent root1 = (Parent) fxmlLoader.load();
	        Stage stage = new Stage();
	        stage.setScene(new Scene(root1));  
	        stage.setTitle("Menu Commande");
	        stage.show();
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	*/

	/*
	
	@FXML
	public void click_mnu_produit() {
		 try {
		        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/Produit.fxml"));
		        Parent root1 = (Parent) fxmlLoader.load();
		        Stage stage = new Stage();
		        stage.setScene(new Scene(root1));  
		        stage.setTitle("Menu Produit");
		        stage.show();
		    } catch(Exception e) {
		        e.printStackTrace();
		    }
	}
	*/
	
	@FXML
	public void click_mnu_quitter() {
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

	
	
	//fenetre Aide.xml a faire apres aussi
	/*
	@FXML
	public void click_mnu_aide() {
		try {
	        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/Aide.fxml"));
	        Parent root1 = (Parent) fxmlLoader.load();
	        Stage stage = new Stage();
	        stage.setScene(new Scene(root1));  
	        stage.setTitle("Menu d'aide");
	        stage.show();
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	*/
}
