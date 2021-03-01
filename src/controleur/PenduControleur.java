package controleur;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Optional;

import modele.MethodesInterface;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;

public class PenduControleur {
	//boutons
	@FXML Button a; 
	@FXML Button b;
	@FXML Button c;
	@FXML Button d;
	@FXML Button e;
	@FXML Button f;
	@FXML Button g;
	@FXML Button h;
	@FXML Button i;
	@FXML Button j;
	@FXML Button l;
	@FXML Button k;
	@FXML Button m;
	@FXML Button n;
	@FXML Button o;
	@FXML Button p;
	@FXML Button q;
	@FXML Button r;
	@FXML Button s;
	@FXML Button t;
	@FXML Button u;
	@FXML Button v;
	@FXML Button w;
	@FXML Button x;
	@FXML Button y;
	@FXML Button z;
	@FXML MenuItem fe;
	//labels
	@FXML Label joueur;
	@FXML Label lblTitre;
	@FXML Label lbl1;
	@FXML Label lbl2;
	@FXML Label lbl3;
	@FXML Label lbl4;
	@FXML Label lbl5;
	@FXML Label lbl6;
	@FXML Label lbl7;
	@FXML Label lbl8;
	@FXML Label lbl9;
	@FXML Label lbl10;
	@FXML Label lbl11;
	@FXML Label lbl12;
	@FXML Label lbl13;
	@FXML Label lbl14;
	@FXML Label lbl15;
	@FXML Label lblErreur;
	//Anchorpane
	@FXML javafx.scene.layout.AnchorPane AnchorPane;
	//ListeView
	@FXML ListView<ObservableList<String>> liste;
	//menu
	@FXML MenuBar menu;
	//lignes + cercle pour le dessin du pendu
	@FXML Line l1;
	@FXML Line l2;
	@FXML Line l3;
	@FXML Line l4;
	@FXML Line l5;
	@FXML Line l7;
	@FXML Line l8;
	@FXML Line l9;
	@FXML Line l10;
	@FXML Line l11;
	@FXML Circle c6;
	   
	String mot;
	   
	public int erreur=0;
	   
	public boolean victoire = false;
	   
	public void init() throws RemoteException, MalformedURLException, NotBoundException{
		   
		MethodesInterface obj = (MethodesInterface) Naming.lookup("rmi://127.0.0.1:6000/jeux");
				
		mot = obj.motPendu();
			
		System.out.println("Mot : "+mot);
			
		//afficher+cacher le mot le mot dans le label
		int taille = ((String) mot).length();
		if (taille >= 1)
			lbl1.setText("*");
		if (taille >= 2)
			lbl2.setText("*");
		if (taille >= 3)
			lbl3.setText("*");
		if (taille >= 4)
			lbl4.setText("*");
		if (taille >= 5)
			lbl5.setText("*");
		if (taille >= 6)
			lbl6.setText("*");
		if (taille >= 7)
			lbl7.setText("*");
		if (taille >= 8)
			lbl8.setText("*");
		if (taille >= 9)
			lbl9.setText("*");
		if (taille >= 10)
			lbl10.setText("*");
		if (taille >= 11)
			lbl11.setText("*");
		if (taille >= 12)
			lbl12.setText("*");
		if (taille >= 13)
			lbl13.setText("*");
		if (taille >= 14)
			lbl14.setText("*");
		if (taille >= 15)
			lbl15.setText("*");
	}  
	  
	public void btnclic (ActionEvent event) throws RemoteException {
		Button boutonClique = (Button) event.getTarget();
		Button boutonNon = (Button) event.getTarget();
		String boutonLabel = boutonClique.getText();
			
		int pos = 0;
		if(mot.toUpperCase().indexOf(boutonClique.getText(),pos) == 0){
			lbl1.setText(boutonClique.getText());
			pos=1;
		}
		if(mot.toUpperCase().indexOf(boutonClique.getText(),pos) == 1){
			lbl2.setText(boutonClique.getText());
			pos=2;
		}
		if(mot.toUpperCase().indexOf(boutonClique.getText(),pos) == 2){
			lbl3.setText(boutonClique.getText());
			pos=3;
		}
		if(mot.toUpperCase().indexOf(boutonClique.getText(),pos) == 3){
			lbl4.setText(boutonClique.getText());
			pos=4;
		}
		if(mot.toUpperCase().indexOf(boutonClique.getText(),pos) == 4){
			lbl5.setText(boutonClique.getText());
			pos=5;
		}
		if(mot.toUpperCase().indexOf(boutonClique.getText(),pos) == 5){
			lbl6.setText(boutonClique.getText());
			pos=6;
		}
		if(mot.toUpperCase().indexOf(boutonClique.getText(),pos) == 6){
			lbl7.setText(boutonClique.getText());
			pos=7;
		}
		if(mot.toUpperCase().indexOf(boutonClique.getText(),pos) == 7){
			lbl8.setText(boutonClique.getText());
			pos=8;
		}
		if(mot.toUpperCase().indexOf(boutonClique.getText(),pos) == 8){
			lbl9.setText(boutonClique.getText());
			pos=9;
		}
		if(mot.toUpperCase().indexOf(boutonClique.getText(),pos) == 9){
			lbl10.setText(boutonClique.getText());
			pos=10;
		}
		if(mot.toUpperCase().indexOf(boutonClique.getText(),pos) == 10){
			lbl11.setText(boutonClique.getText());
			pos=11;
		}
		if(mot.toUpperCase().indexOf(boutonClique.getText(),pos) == 11){
			lbl12.setText(boutonClique.getText());
			pos=12;
		}
		if(mot.toUpperCase().indexOf(boutonClique.getText(),pos) == 12){
			lbl13.setText(boutonClique.getText());
			pos=13;
		}
		if(mot.toUpperCase().indexOf(boutonClique.getText(),pos) == 13){
			lbl14.setText(boutonClique.getText());
			pos=14;
		}
		if(mot.toUpperCase().indexOf(boutonClique.getText(),pos) == 14){
			lbl15.setText(boutonClique.getText());
			pos=15;
		}
		System.out.println(erreur);
		//S'il s'agit d'une mauvaise
		if (mot.toUpperCase().indexOf(boutonClique.getText()) == -1 && erreur == 0){
			l1.setVisible(true);
			erreur=1;
		}
		else if (mot.toUpperCase().indexOf(boutonClique.getText()) == -1 && erreur == 1){
			l2.setVisible(true);
			erreur=2;
		}
		else if (mot.toUpperCase().indexOf(boutonClique.getText()) == -1 && erreur == 2){
			l3.setVisible(true);
			erreur=3;
		}
		else if (mot.toUpperCase().indexOf(boutonClique.getText()) == -1 && erreur == 3){
			l4.setVisible(true);
			erreur=4;
		}
		else if (mot.toUpperCase().indexOf(boutonClique.getText()) == -1 && erreur == 4){
			l5.setVisible(true);
			erreur=5;
		}
		else if (mot.toUpperCase().indexOf(boutonClique.getText()) == -1 && erreur == 5){
			c6.setVisible(true);
			erreur=6;
		}
		else if (mot.toUpperCase().indexOf(boutonClique.getText()) == -1 && erreur == 6){
			l7.setVisible(true);
			erreur=7;
		}
		else if (mot.toUpperCase().indexOf(boutonClique.getText()) == -1 && erreur == 7){
			l8.setVisible(true);
			erreur=8;
		}
		else if (mot.toUpperCase().indexOf(boutonClique.getText()) == -1 && erreur == 8){
			l9.setVisible(true);
			erreur=9;
		}
		else if (mot.toUpperCase().indexOf(boutonClique.getText()) == -1 && erreur == 9){
			l10.setVisible(true);
			erreur=10;
		}
		else if (mot.toUpperCase().indexOf(boutonClique.getText()) == -1 && erreur == 10){
			l11.setVisible(true);
			erreur=11;
		}
		if(erreur==11 ){
			lblErreur.setText("Vous avez perdu");
		}
			
		//cacher le bouton quand on clique dessus
		boutonClique.setDisable(true);
			
		//si le joueur gagne
		if( lbl1.getText()!= "*" && lbl2.getText()!="*" && lbl3.getText()!="*" && lbl4.getText()!="*"
			&& lbl5.getText()!="*" && lbl6.getText()!="*" && lbl7.getText()!="*" && lbl8.getText()!="*"
			&& lbl9.getText()!="*" && lbl10.getText()!="*" && lbl11.getText()!="*" && lbl12.getText()!="*"
			&& lbl13.getText()!="*" && lbl14.getText()!="*" && lbl15.getText()!="*"){
				lblErreur.setText("vous avez gagne!");
				victoire=true;
			}		 
			
		// ajouter le bouton selectionne dans une liste view
		ListView<String> list = new ListView<String>();
		ObservableList<String> items =FXCollections.observableArrayList (boutonClique.getText());
		liste.getItems().add(items);
		//desactiver les boutons
		if(erreur==11 || victoire){
			if(a.isDisable() == false){
				a.setDisable(true);
			}
			if(b.isDisable() == false){
				b.setDisable(true);
			}
			if(c.isDisable() == false){
				c.setDisable(true);
			}
			if(d.isDisable()==false){
				d.setDisable(true);
			}
			if(e.isDisable()==false){
				e.setDisable(true);
			}
			if(f.isDisable()==false){
				f.setDisable(true);
			}
			if(g.isDisable()==false){
				g.setDisable(true);
			}
			if(h.isDisable()==false){
				h.setDisable(true);
			}
			if(i.isDisable()==false){
				i.setDisable(true);
			}
			if(j.isDisable()==false){
				j.setDisable(true);
			}
			if(k.isDisable()==false){
					k.setDisable(true);
			}
			if(l.isDisable()==false){
				l.setDisable(true);
			}
			if(m.isDisable()==false){
				m.setDisable(true);
			}
			if(n.isDisable()==false){
				n.setDisable(true);
			}
			if(o.isDisable()==false){
				o.setDisable(true);
			}
			if(p.isDisable()==false){
				p.setDisable(true);
			}
			if(q.isDisable()==false){
				q.setDisable(true);
			}
			if(r.isDisable()==false){
				r.setDisable(true);
			}
			if(s.isDisable()==false){
				s.setDisable(true);
			}
			if(t.isDisable()==false){
				t.setDisable(true);
			}
			if(u.isDisable()==false){
				u.setDisable(true);
			}
			if(v.isDisable()==false){
				v.setDisable(true);
			}
			if(w.isDisable()==false){
				w.setDisable(true);
			}
			if(x.isDisable()==false){
				x.setDisable(true);
			}
			if(y.isDisable()==false){
				y.setDisable(true);
			}
			if(z.isDisable()==false){
				z.setDisable(true);
			}
		}
	}
	   
	//Initialisation menu
	public void menuClic(ActionEvent evt) throws RemoteException {
		MenuItem menuClique = (MenuItem) evt.getTarget();
		String menuLabel = menuClique.getText();
			
		if ("Rejouer".equals(menuLabel)){
			//recup de la fenetre a l'aide d'un element
			Stage stageCourant = (Stage) lblTitre.getScene().getWindow();
			stageCourant.close();
			//lancement de la seconde fenetre
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
			
		if ("Quitter".equals(menuLabel)){
			/*
			//recup de la fenetre a l'aide d'un element
			Stage stageCourant = (Stage) lblTitre.getScene().getWindow();
			stageCourant.close();
			//lancement de la seconde fenetre
			try{
				Stage stage = new Stage();
				AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/vue/Accueil.fxml"));
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
			*/
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

	}
}
