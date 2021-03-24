package controleur;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import modele.InterfaceMorpion;

import java.net.URL;
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
    private Label turnLabel;
    @FXML
    private Label signLabel;
    @FXML
    private Label opierdoluLabel;
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
    public void handleImageClicked(MouseEvent event){
    	try {
            Remote obj = (InterfaceMorpion) Naming.lookup("rmi://localhost:8001/morpion"); 
            ImageView img = (ImageView) event.getSource();
           // System.out.println(event.getSource().toString());
            int numCase = (Integer.parseInt(event.getSource().toString().substring(15, 16)))-1;
           // System.out.println(numCase);
        	Image temp = img.getImage();
            
            if (obj instanceof InterfaceMorpion) {
            	if(temp == null) {
            		if(test % 2 ==0) {
            			imageX = new Image(ControleurMorpion.class.getResource("../vue/X.png").toString());
                		img.setImage(imageX);
                		((InterfaceMorpion)obj).PlacerX(numCase);
 
                		test++;
            		}else {
            			imageO = new Image(ControleurMorpion.class.getResource("../vue/O.png").toString());
                		img.setImage(imageO);
                		((InterfaceMorpion)obj).PlacerO(numCase);
                		

                		
                		test++;
            		}
            	}
            	
            	
            }
            gagnant=((InterfaceMorpion)obj).testGagnant();
            
            if(gagnant==1) {
            	System.out.println("Le joueur X a gagné");
            }else if(gagnant==0) {
            	System.out.println("Le joueur O a gagné");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    	
    }
}