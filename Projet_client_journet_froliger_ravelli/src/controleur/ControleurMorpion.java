package controleur;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import modele.InterfaceMorpion;

import java.rmi.Naming;
import java.rmi.Remote;

public class ControleurMorpion{
	
	private Image imageX;
	private Image imageO;
	int test = 0;
	int gagnant = -1;
	
    @FXML
    private GridPane gridPane;
    @FXML
    private Label signLabel;
    @FXML
    private ImageView im1;
    @FXML
    private ImageView im2;
    @FXML
    private ImageView im3;
    @FXML
    private ImageView im4;
    @FXML
    private ImageView im5;
    @FXML
    private ImageView im6;
    @FXML
    private ImageView im7;
    @FXML
    private ImageView im8;
    @FXML
    private ImageView im9;
    @FXML
    private Button btn_rejouer;

    
    
    @FXML
    public void handleImageClicked(MouseEvent event){
    	try {
            Remote obj = (InterfaceMorpion) Naming.lookup("rmi://localhost:8001/morpion"); 
            ImageView img = (ImageView) event.getSource();
            int numCase = (Integer.parseInt(event.getSource().toString().substring(15, 16)))-1;
        	Image temp = img.getImage();
            
            if (obj instanceof InterfaceMorpion) {
            	if(temp == null) {
            		if(test % 2 ==0) {
            			imageX = new Image(ControleurMorpion.class.getResource("/vue/icone_etoile.png").toString());
                		img.setImage(imageX);
                		((InterfaceMorpion)obj).PlacerX(numCase);
                			
                		test++;
            		}else {
            			imageO = new Image(ControleurMorpion.class.getResource("/vue/icone_cercle.png").toString());
                		img.setImage(imageO);
                		((InterfaceMorpion)obj).PlacerO(numCase);
                		

                		
                		test++;
            		}
            	}
            	
            	
            }
            gagnant=((InterfaceMorpion)obj).testGagnant();
            if(gagnant != -1) {
            	btn_rejouer.setVisible(true);
            	signLabel.setVisible(true);
	            if(gagnant==1) {
	            	System.out.println("Le joueur X a gagné");
	            	signLabel.setText("Le joueur X a gagné");
	            	im1.setDisable(true);
	            	im2.setDisable(true);
	            	im3.setDisable(true);
	            	im4.setDisable(true);
	            	im5.setDisable(true);
	            	im6.setDisable(true);
	            	im7.setDisable(true);
	            	im8.setDisable(true);
	            	im9.setDisable(true);
	            }else if(gagnant==0) {
	            	System.out.println("Le joueur O a gagné");
	            	signLabel.setText("Le joueur O a gagné");
	            	im1.setDisable(true);
	            	im2.setDisable(true);
	            	im3.setDisable(true);
	            	im4.setDisable(true);
	            	im5.setDisable(true);
	            	im6.setDisable(true);
	            	im7.setDisable(true);
	            	im8.setDisable(true);
	            	im9.setDisable(true);
	            }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    	
    }
    @FXML
    public void Rejouer(MouseEvent event){
    	
    	try {
    	Remote obj = (InterfaceMorpion) Naming.lookup("rmi://localhost:8001/morpion"); 
    	 if (obj instanceof InterfaceMorpion) {
    		 ((InterfaceMorpion)obj).initGrille();
    		 im1.setImage(null);
    		 im2.setImage(null);
    		 im3.setImage(null);
    		 im4.setImage(null);
    		 im5.setImage(null);
    		 im6.setImage(null);
    		 im7.setImage(null);
    		 im8.setImage(null);
    		 im9.setImage(null);
    		 im1.setDisable(false);
         	im2.setDisable(false);
         	im3.setDisable(false);
         	im4.setDisable(false);
         	im5.setDisable(false);
         	im6.setDisable(false);
         	im7.setDisable(false);
         	im8.setDisable(false);
         	im9.setDisable(false);
    		 gagnant = -1;
    		 btn_rejouer.setVisible(false);
    		 signLabel.setVisible(false);
    		 signLabel.setText(" ");
    	 }
    	}catch (Exception e) {
            e.printStackTrace();
        }
    }
}