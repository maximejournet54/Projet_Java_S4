package controleur;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import modele.MethodesInterface;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
	@FXML Label labeltitre;
	@FXML Label lab1;
	@FXML Label lab2;
	@FXML Label lab3;
	@FXML Label lab4;
	@FXML Label lab5;
	@FXML Label lab6;
	@FXML Label lab7;
	@FXML Label lab8;
	@FXML Label lab9;
	@FXML Label lab10;
	@FXML Label lab11;
	@FXML Label lab12;
	@FXML Label lab13;
	@FXML Label lab14;
	@FXML Label lab15;
	@FXML Label laberror;
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
	   
	String cmot;
	   
	public int erreur=0;
	   
	public boolean victoire = false;
	   
	public void init() throws RemoteException, MalformedURLException, NotBoundException{
		   
	MethodesInterface obj = (MethodesInterface) Naming.lookup("rmi://127.0.0.1:6000/jeux");
	        
	cmot = obj.motPendu();
	 	   
	System.out.println("Mot : "+cmot);
		   
	//afficher+cacher le mot le mot dans le label
	int taille = ((String) cmot).length();
	if (taille >= 1)
		lab1.setText("*");
	if (taille >= 2)
		lab2.setText("*");
	if (taille >= 3)
		lab3.setText("*");
	if (taille >= 4)
		lab4.setText("*");
	if (taille >= 5)
		lab5.setText("*");
	if (taille >= 6)
		lab6.setText("*");
	if (taille >= 7)
		lab7.setText("*");
	if (taille >= 8)
		lab8.setText("*");
	if (taille >= 9)
		lab9.setText("*");
	if (taille >= 10)
		lab10.setText("*");
	if (taille >= 11)
		lab11.setText("*");
	if (taille >= 12)
		lab12.setText("*");
	if (taille >= 13)
		lab13.setText("*");
	if (taille >= 14)
		lab14.setText("*");
	if (taille >= 15)
		lab15.setText("*");
}  
	  
	public void btnclic (ActionEvent event) throws RemoteException {
		Button boutonClique = (Button) event.getTarget();
		Button boutonNon = (Button) event.getTarget();
		String boutonLabel = boutonClique.getText();
			
			
		int pos = 0;
		if(cmot.toUpperCase().indexOf(boutonClique.getText(),pos) == 0){
			lab1.setText(boutonClique.getText());
			pos=1;
		}
		if(cmot.toUpperCase().indexOf(boutonClique.getText(),pos) == 1){
			lab2.setText(boutonClique.getText());
			pos=2;
		}
		if(cmot.toUpperCase().indexOf(boutonClique.getText(),pos) == 2){
			lab3.setText(boutonClique.getText());
			pos=3;
		}
		if(cmot.toUpperCase().indexOf(boutonClique.getText(),pos) == 3){
			lab4.setText(boutonClique.getText());
			pos=4;
		}
		if(cmot.toUpperCase().indexOf(boutonClique.getText(),pos) == 4){
			lab5.setText(boutonClique.getText());
			pos=5;
		}
		if(cmot.toUpperCase().indexOf(boutonClique.getText(),pos) == 5){
			lab6.setText(boutonClique.getText());
			pos=6;
		}
		if(cmot.toUpperCase().indexOf(boutonClique.getText(),pos) == 6){
			lab7.setText(boutonClique.getText());
			pos=7;
		}
		if(cmot.toUpperCase().indexOf(boutonClique.getText(),pos) == 7){
			lab8.setText(boutonClique.getText());
			pos=8;
		}
		if(cmot.toUpperCase().indexOf(boutonClique.getText(),pos) == 8){
			lab9.setText(boutonClique.getText());
			pos=9;
		}
		if(cmot.toUpperCase().indexOf(boutonClique.getText(),pos) == 9){
			lab10.setText(boutonClique.getText());
			pos=10;
		}
		if(cmot.toUpperCase().indexOf(boutonClique.getText(),pos) == 10){
			lab11.setText(boutonClique.getText());
			pos=11;
		}
		if(cmot.toUpperCase().indexOf(boutonClique.getText(),pos) == 11){
			lab12.setText(boutonClique.getText());
			pos=12;
		}
		if(cmot.toUpperCase().indexOf(boutonClique.getText(),pos) == 12){
			lab13.setText(boutonClique.getText());
			pos=13;
		}
		if(cmot.toUpperCase().indexOf(boutonClique.getText(),pos) == 13){
			lab14.setText(boutonClique.getText());
			pos=14;
		}
		if(cmot.toUpperCase().indexOf(boutonClique.getText(),pos) == 14){
			lab15.setText(boutonClique.getText());
			pos=15;
		}
		System.out.println(erreur);
		//S'il s'agit d'une mauvaise
		if (cmot.toUpperCase().indexOf(boutonClique.getText()) == -1 && erreur == 0){
			l1.setVisible(true);
			erreur=1;
		}
		else if (cmot.toUpperCase().indexOf(boutonClique.getText()) == -1 && erreur == 1){
			l2.setVisible(true);
			erreur=2;
		}
		else if (cmot.toUpperCase().indexOf(boutonClique.getText()) == -1 && erreur == 2){
			l3.setVisible(true);
			erreur=3;
		}
		else if (cmot.toUpperCase().indexOf(boutonClique.getText()) == -1 && erreur == 3){
			l4.setVisible(true);
			erreur=4;
		}
		else if (cmot.toUpperCase().indexOf(boutonClique.getText()) == -1 && erreur == 4){
			l5.setVisible(true);
			erreur=5;
		}
		else if (cmot.toUpperCase().indexOf(boutonClique.getText()) == -1 && erreur == 5){
			c6.setVisible(true);
			erreur=6;
		}
		else if (cmot.toUpperCase().indexOf(boutonClique.getText()) == -1 && erreur == 6){
			l7.setVisible(true);
			erreur=7;
		}
		else if (cmot.toUpperCase().indexOf(boutonClique.getText()) == -1 && erreur == 7){
			l8.setVisible(true);
			erreur=8;
		}
		else if (cmot.toUpperCase().indexOf(boutonClique.getText()) == -1 && erreur == 8){
			l9.setVisible(true);
			erreur=9;
		}
		else if (cmot.toUpperCase().indexOf(boutonClique.getText()) == -1 && erreur == 9){
			l10.setVisible(true);
			erreur=10;
		}
		else if (cmot.toUpperCase().indexOf(boutonClique.getText()) == -1 && erreur == 10){
			l11.setVisible(true);
			erreur=11;
		}
		if(erreur==11 ){
			laberror.setText("Vous avez perdu");
		}
			
		//cacher le bouton quand on clique dessus
		boutonClique.setDisable(true);
			
		//si le joueur gagne
		if( lab1.getText()!= "*" && lab2.getText()!="*" && lab3.getText()!="*" && lab4.getText()!="*"
			&& lab5.getText()!="*" && lab6.getText()!="*" && lab7.getText()!="*" && lab8.getText()!="*"
			&& lab9.getText()!="*" && lab10.getText()!="*" && lab11.getText()!="*" && lab12.getText()!="*"
			&& lab13.getText()!="*" && lab14.getText()!="*" && lab15.getText()!="*"){
				laberror.setText("vous avez gagne!");
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
			Stage stageCourant = (Stage) labeltitre.getScene().getWindow();
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
			
		if ("Retour".equals(menuLabel)){
			//recup de la fenetre a l'aide d'un element
			Stage stageCourant = (Stage) labeltitre.getScene().getWindow();
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
		}

	}
}
