package controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import modele.InterfaceAccueil;
import java.net.URL;
import java.rmi.Naming;
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;

public class ControllerAllumettes implements Initializable {
    @FXML private Button btn_jouer, btn_quit, btn_retour, btn_rejouer, btn_une_allu, btn_deux_allu;
    @FXML private Label lbl_non, lbl_joueur, lbl_titre, lbl_ordi, lbl_nbr_joueur, lbl_nbr_ordi, lbl_coup_choisi, lbl_premier_joueur, lbl_premier_ordi, lbl_commence, lbl_fin;
    @FXML private Line a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21;
    int nbreAlluJeu=21;
    int nbrJ=0;
    int nbrO=0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btn_rejouer.setVisible(false);
        btn_une_allu.setVisible(false);
        btn_deux_allu.setVisible(false);
        lbl_joueur.setVisible(false);
        lbl_ordi.setVisible(false);
        lbl_nbr_joueur.setVisible(false);
        lbl_nbr_ordi.setVisible(false);
        lbl_premier_joueur.setVisible(false);
        lbl_premier_ordi.setVisible(false);
        lbl_commence.setVisible(false);
        lbl_fin.setVisible(false);
        lbl_non.setVisible(false);
    }

    public void Jouer() {
        nbrO=0;
        nbrJ=0;
        nbreAlluJeu=21;
        int joueurCom=0;
        joueurCom=Choix(joueurCom);
        btn_rejouer.setVisible(true);
        lbl_joueur.setVisible(true);
        lbl_ordi.setVisible(true);
        lbl_nbr_joueur.setVisible(true);
        lbl_nbr_joueur.setText(String.valueOf(nbrJ));
        lbl_nbr_ordi.setVisible(true);
        lbl_nbr_ordi.setText(String.valueOf(nbrO));
        btn_jouer.setVisible(false);
        lbl_non.setVisible(false);

        if (joueurCom==1) {
            lbl_commence.setVisible(true);
            lbl_premier_ordi.setVisible(true);
            lbl_premier_joueur.setVisible(false);
            TourOrdi();
        } else if (joueurCom==2) {
            lbl_commence.setVisible(true);
            lbl_premier_joueur.setVisible(true);
            lbl_premier_ordi.setVisible(false);
        }
        btn_une_allu.setVisible(true);
        btn_deux_allu.setVisible(true);
    }

    public void TourOrdi() {
        int tour=0;
        tour=Choix(tour);
        System.out.println(tour);
        if (tour==1) {
            nbrO++;
            nbreAlluJeu--;
            lbl_nbr_ordi.setText(String.valueOf(nbrO));
            MajAllumettes(nbreAlluJeu);
        }
        else if((tour==2) || (nbreAlluJeu<2)) {
            tour = 1;
            TourOrdi();
        }
        else if(tour==2) {
            nbrO=nbrO+2;
            nbreAlluJeu=nbreAlluJeu-2;
            lbl_nbr_ordi.setText(String.valueOf(nbrO));
            MajAllumettes(nbreAlluJeu);
        }

    }

    public int Choix(int nbre) {
        Random random = new Random();
        nbre = 1+random.nextInt(3-1);
        return nbre;
    }


    public void Quitter() {
        Alert alerte = new Alert(Alert.AlertType.CONFIRMATION);
        alerte.setTitle("Attention!");
        alerte.setHeaderText("Attention, vous allez fermer l'application");
        alerte.setContentText("Voulez-vous vraiment fermer l'application?");
        ButtonType btnOui = new ButtonType("Oui");
        ButtonType btnNon = new ButtonType("Non", ButtonBar.ButtonData.CANCEL_CLOSE);
        alerte.getButtonTypes().setAll(btnOui,btnNon);
        Optional<ButtonType> resultat = alerte.showAndWait();
        if (resultat.get() == btnOui){
            Platform.exit();
        }

    }
    public void RetourAccueil() {
        try {
            InterfaceAccueil obj = (InterfaceAccueil) Naming.lookup("rmi://localhost:8001/accueil");
            System.out.println("Client connecte.\nOuverture de l'application.\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        try {
            URL fxmlURL=getClass().getResource("/vue/VueAccueil.fxml");
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
            Node root = fxmlLoader.load();
            Scene scene = new Scene( (Parent) root);

            stage.setScene(scene);
            stage.setTitle("Accueil de l'application");
            stage.setResizable(false);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void Rejouer() {
        btn_rejouer.setVisible(false);
        btn_une_allu.setVisible(false);
        btn_deux_allu.setVisible(false);
        lbl_joueur.setVisible(false);
        lbl_ordi.setVisible(false);
        lbl_nbr_joueur.setVisible(false);
        lbl_nbr_ordi.setVisible(false);
        lbl_premier_joueur.setVisible(false);
        lbl_premier_ordi.setVisible(false);
        lbl_commence.setVisible(false);
        btn_jouer.setVisible(true);
        lbl_fin.setVisible(false);
        lbl_non.setVisible(false);
        a21.setVisible(true);
        a20.setVisible(true);
        a19.setVisible(true);
        a18.setVisible(true);
        a17.setVisible(true);
        a16.setVisible(true);
        a15.setVisible(true);
        a14.setVisible(true);
        a13.setVisible(true);
        a12.setVisible(true);
        a11.setVisible(true);
        a10.setVisible(true);
        a9.setVisible(true);
        a8.setVisible(true);
        a7.setVisible(true);
        a6.setVisible(true);
        a5.setVisible(true);
        a4.setVisible(true);
        a3.setVisible(true);
        a2.setVisible(true);
        a1.setVisible(true);
    }
    public void Tirer1() {
        nbreAlluJeu--;
        nbrJ++;
        lbl_nbr_joueur.setText(String.valueOf(nbrJ));
        MajAllumettes(nbreAlluJeu);
        if (nbreAlluJeu!=0) {
            TourOrdi();
        }
    }

    public void Tirer2() {
        if (nbreAlluJeu<2) {
            lbl_non.setVisible(true);
        }
       else {
            nbreAlluJeu = nbreAlluJeu - 2;
            nbrJ = nbrJ + 2;
            lbl_nbr_joueur.setText(String.valueOf(nbrJ));
            MajAllumettes(nbreAlluJeu);
            if (nbreAlluJeu!=0) {
                TourOrdi();
            }
        }
    }

    public void MajAllumettes(int nbreAlluJeu) {
        switch(nbreAlluJeu) {
            case 20:
                a21.setVisible(false);
                break;
            case 19:
                a21.setVisible(false);
                a20.setVisible(false);
                break;
            case 18:
                a21.setVisible(false);
                a20.setVisible(false);
                a19.setVisible(false);
                break;
            case 17:
                a21.setVisible(false);
                a20.setVisible(false);
                a19.setVisible(false);
                a18.setVisible(false);
                break;
            case 16:
                a21.setVisible(false);
                a20.setVisible(false);
                a19.setVisible(false);
                a18.setVisible(false);
                a17.setVisible(false);
                break;
            case 15:
                a21.setVisible(false);
                a20.setVisible(false);
                a19.setVisible(false);
                a18.setVisible(false);
                a17.setVisible(false);
                a16.setVisible(false);
                break;
            case 14:
                a21.setVisible(false);
                a20.setVisible(false);
                a19.setVisible(false);
                a18.setVisible(false);
                a17.setVisible(false);
                a16.setVisible(false);
                a15.setVisible(false);
                break;
            case 13:
                a21.setVisible(false);
                a20.setVisible(false);
                a19.setVisible(false);
                a18.setVisible(false);
                a17.setVisible(false);
                a16.setVisible(false);
                a15.setVisible(false);
                a14.setVisible(false);
                break;
            case 12:
                a21.setVisible(false);
                a20.setVisible(false);
                a19.setVisible(false);
                a18.setVisible(false);
                a17.setVisible(false);
                a16.setVisible(false);
                a15.setVisible(false);
                a14.setVisible(false);
                a13.setVisible(false);
                break;
            case 11:
                a21.setVisible(false);
                a20.setVisible(false);
                a19.setVisible(false);
                a18.setVisible(false);
                a17.setVisible(false);
                a16.setVisible(false);
                a15.setVisible(false);
                a14.setVisible(false);
                a13.setVisible(false);
                a12.setVisible(false);
                break;
            case 10:
                a21.setVisible(false);
                a20.setVisible(false);
                a19.setVisible(false);
                a18.setVisible(false);
                a17.setVisible(false);
                a16.setVisible(false);
                a15.setVisible(false);
                a14.setVisible(false);
                a13.setVisible(false);
                a12.setVisible(false);
                a11.setVisible(false);
                break;
            case 9:
                a21.setVisible(false);
                a20.setVisible(false);
                a19.setVisible(false);
                a18.setVisible(false);
                a17.setVisible(false);
                a16.setVisible(false);
                a15.setVisible(false);
                a14.setVisible(false);
                a13.setVisible(false);
                a12.setVisible(false);
                a11.setVisible(false);
                a10.setVisible(false);
                break;
            case 8:
                a21.setVisible(false);
                a20.setVisible(false);
                a19.setVisible(false);
                a18.setVisible(false);
                a17.setVisible(false);
                a16.setVisible(false);
                a15.setVisible(false);
                a14.setVisible(false);
                a13.setVisible(false);
                a12.setVisible(false);
                a11.setVisible(false);
                a10.setVisible(false);
                a9.setVisible(false);
                break;
            case 7:
                a21.setVisible(false);
                a20.setVisible(false);
                a19.setVisible(false);
                a18.setVisible(false);
                a17.setVisible(false);
                a16.setVisible(false);
                a15.setVisible(false);
                a14.setVisible(false);
                a13.setVisible(false);
                a12.setVisible(false);
                a11.setVisible(false);
                a10.setVisible(false);
                a9.setVisible(false);
                a8.setVisible(false);
                break;
            case 6:
                a21.setVisible(false);
                a20.setVisible(false);
                a19.setVisible(false);
                a18.setVisible(false);
                a17.setVisible(false);
                a16.setVisible(false);
                a15.setVisible(false);
                a14.setVisible(false);
                a13.setVisible(false);
                a12.setVisible(false);
                a11.setVisible(false);
                a10.setVisible(false);
                a9.setVisible(false);
                a8.setVisible(false);
                a7.setVisible(false);
                break;
            case 5:
                a21.setVisible(false);
                a20.setVisible(false);
                a19.setVisible(false);
                a18.setVisible(false);
                a17.setVisible(false);
                a16.setVisible(false);
                a15.setVisible(false);
                a14.setVisible(false);
                a13.setVisible(false);
                a12.setVisible(false);
                a11.setVisible(false);
                a10.setVisible(false);
                a9.setVisible(false);
                a8.setVisible(false);
                a7.setVisible(false);
                a6.setVisible(false);
                break;
            case 4:
                a21.setVisible(false);
                a20.setVisible(false);
                a19.setVisible(false);
                a18.setVisible(false);
                a17.setVisible(false);
                a16.setVisible(false);
                a15.setVisible(false);
                a14.setVisible(false);
                a13.setVisible(false);
                a12.setVisible(false);
                a11.setVisible(false);
                a10.setVisible(false);
                a9.setVisible(false);
                a8.setVisible(false);
                a7.setVisible(false);
                a6.setVisible(false);
                a5.setVisible(false);
                break;
            case 3:
                a21.setVisible(false);
                a20.setVisible(false);
                a19.setVisible(false);
                a18.setVisible(false);
                a17.setVisible(false);
                a16.setVisible(false);
                a15.setVisible(false);
                a14.setVisible(false);
                a13.setVisible(false);
                a12.setVisible(false);
                a11.setVisible(false);
                a10.setVisible(false);
                a9.setVisible(false);
                a8.setVisible(false);
                a7.setVisible(false);
                a6.setVisible(false);
                a5.setVisible(false);
                a4.setVisible(false);
                break;
            case 2:
                a21.setVisible(false);
                a20.setVisible(false);
                a19.setVisible(false);
                a18.setVisible(false);
                a17.setVisible(false);
                a16.setVisible(false);
                a15.setVisible(false);
                a14.setVisible(false);
                a13.setVisible(false);
                a12.setVisible(false);
                a11.setVisible(false);
                a10.setVisible(false);
                a9.setVisible(false);
                a8.setVisible(false);
                a7.setVisible(false);
                a6.setVisible(false);
                a5.setVisible(false);
                a4.setVisible(false);
                a3.setVisible(false);
                break;
            case 1:
                a21.setVisible(false);
                a20.setVisible(false);
                a19.setVisible(false);
                a18.setVisible(false);
                a17.setVisible(false);
                a16.setVisible(false);
                a15.setVisible(false);
                a14.setVisible(false);
                a13.setVisible(false);
                a12.setVisible(false);
                a11.setVisible(false);
                a10.setVisible(false);
                a9.setVisible(false);
                a8.setVisible(false);
                a7.setVisible(false);
                a6.setVisible(false);
                a5.setVisible(false);
                a4.setVisible(false);
                a3.setVisible(false);
                a2.setVisible(false);
                break;
            case 0:
                a21.setVisible(false);
                a20.setVisible(false);
                a19.setVisible(false);
                a18.setVisible(false);
                a17.setVisible(false);
                a16.setVisible(false);
                a15.setVisible(false);
                a14.setVisible(false);
                a13.setVisible(false);
                a12.setVisible(false);
                a11.setVisible(false);
                a10.setVisible(false);
                a9.setVisible(false);
                a8.setVisible(false);
                a7.setVisible(false);
                a6.setVisible(false);
                a5.setVisible(false);
                a4.setVisible(false);
                a3.setVisible(false);
                a2.setVisible(false);
                a1.setVisible(false);
                fin();
                break;
        }
    }
    public void fin() {
        if (nbrO%2!=0) {
            lbl_fin.setVisible(true);
            lbl_premier_ordi.setVisible(true);
            lbl_premier_joueur.setVisible(false);
            btn_rejouer.setVisible(true);
            lbl_commence.setVisible(false);
        }
        if (nbrJ%2!=0) {
            lbl_fin.setVisible(true);
            lbl_premier_ordi.setVisible(false);
            lbl_premier_joueur.setVisible(true);
            btn_rejouer.setVisible(true);
            lbl_commence.setVisible(false);
        }
    }
}
