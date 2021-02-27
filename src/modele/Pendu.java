package modele;

import java.util.HashMap;

import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Pendu extends Application {

    private static final int APP_W = 900;
    private static final int APP_H = 500;
    private static final Font DEFAULT_FONT = new Font("Calibri", 36);

    private static final int POINTS_PER_LETTER = 100;
    private static final float BONUS_MODIFIER = 0.2f;

    /**
     * The word to guess
     */
    private SimpleStringProperty mot = new SimpleStringProperty();

    /**
     * How many letters left to guess
     */
    private SimpleIntegerProperty lettresADeviner = new SimpleIntegerProperty();

    /**
     * Current score
     */
    private SimpleIntegerProperty score = new SimpleIntegerProperty();

    /**
     * How many points next correct letter is worth
     */
    private float modifieurScore = 1.0f;

    /**
     * Is game jouable
     */
    private SimpleBooleanProperty jouable = new SimpleBooleanProperty();

    /**
     * List for letters of the word {@link #word}
     * It is backed up by the HBox children list,
     * so changes to this list directly affect the GUI
     */
    private ObservableList<Node> lettres;

    /**
     * K - characters [A..Z] and '-'
     * V - javafx.scene.Text representation of K
     */
    private HashMap<Character, Text> alphabet = new HashMap<Character, Text>();

    private ImagePendu pendu = new ImagePendu();

    private LecteurMots lecteurMots = new LecteurMots();

    public Parent creerContenu() {
        HBox ligneLettres = new HBox();
        ligneLettres.setAlignment(Pos.CENTER);
        lettres = ligneLettres.getChildren();

        jouable.bind(pendu.vies.greaterThan(0).and(lettresADeviner.greaterThan(0)));
        jouable.addListener((obs, old, newValue) -> {
            if (!newValue.booleanValue())
                arreterJeu();
        });

        Button boutonEncore = new Button("NEW GAME");
        boutonEncore.disableProperty().bind(jouable);
        boutonEncore.setOnAction(event -> commencerJeu());

        // layout
        HBox ligne1 = new HBox();
        HBox ligne3 = new HBox();
        ligne1.setAlignment(Pos.CENTER);
        ligne3.setAlignment(Pos.CENTER);
        for (int i = 0 ; i < 20; i++) {
            ligne1.getChildren().add(new Letter(' '));
            ligne3.getChildren().add(new Letter(' '));
        }

        HBox ligneAlphabet = new HBox(5);
        ligneAlphabet.setAlignment(Pos.CENTER);
        for (char c = 'A'; c <= 'Z'; c++) {
            Text t = new Text(String.valueOf(c));
            t.setFont(DEFAULT_FONT);
            alphabet.put(c, t);
            ligneAlphabet.getChildren().add(t);
        }

        Text tiret = new Text("-");
        tiret.setFont(DEFAULT_FONT);
        alphabet.put('-', tiret);
        ligneAlphabet.getChildren().add(tiret);

        Text textScore = new Text();
        textScore.textProperty().bind(score.asString().concat(" Points"));

        HBox lignePendu = new HBox(10, boutonEncore, textScore, pendu);
        lignePendu.setAlignment(Pos.CENTER);

        VBox vBox = new VBox(10);
        // vertical layout
        vBox.getChildren().addAll(
                ligne1,
                ligneLettres,
                ligne3,
                ligneAlphabet,
                lignePendu);
        return vBox;
    }

    private void arreterJeu() {
        for (Node n : lettres) {
            Letter lettre = (Letter) n;
            lettre.show();
        }
    }

    private void commencerJeu() {
        for (Text t : alphabet.values()) {
            t.setStrikethrough(false);
            t.setFill(Color.BLACK);
        }

        pendu.reset();
        mot.set(lecteurMots.retournerMotAleatoire().toUpperCase());
        lettresADeviner.set(mot.length().get());

        lettres.clear();
        for (char c : mot.get().toCharArray()) {
            lettres.add(new Letter(c));
        }
    }

    private static class ImagePendu extends Parent {
        private static final int DEBUT_DOS_HORIZONTAL = 100;
        private static final int DEBUT_DOS_VERTICAL = 20;
        private static final int SPINE_END_X = DEBUT_DOS_HORIZONTAL;
        private static final int SPINE_END_Y = DEBUT_DOS_VERTICAL + 50;

        /**
         * How many vies left
         */
        private SimpleIntegerProperty vies = new SimpleIntegerProperty();

        public ImagePendu() {
            Circle tete = new Circle(20);
            tete.setTranslateX(DEBUT_DOS_HORIZONTAL);

            Line dos = new Line();
            dos.setStartX(DEBUT_DOS_HORIZONTAL);
            dos.setStartY(DEBUT_DOS_VERTICAL);
            dos.setEndX(SPINE_END_X);
            dos.setEndY(SPINE_END_Y);

            Line brasGauche = new Line();
            brasGauche.setStartX(DEBUT_DOS_HORIZONTAL);
            brasGauche.setStartY(DEBUT_DOS_VERTICAL);
            brasGauche.setEndX(DEBUT_DOS_HORIZONTAL + 40);
            brasGauche.setEndY(DEBUT_DOS_VERTICAL + 10);

            Line brasDroit = new Line();
            brasDroit.setStartX(DEBUT_DOS_HORIZONTAL);
            brasDroit.setStartY(DEBUT_DOS_VERTICAL);
            brasDroit.setEndX(DEBUT_DOS_HORIZONTAL - 40);
            brasDroit.setEndY(DEBUT_DOS_VERTICAL + 10);

            Line jambeGauche = new Line();
            jambeGauche.setStartX(SPINE_END_X);
            jambeGauche.setStartY(SPINE_END_Y);
            jambeGauche.setEndX(SPINE_END_X + 25);
            jambeGauche.setEndY(SPINE_END_Y + 50);

            Line jambeDroite = new Line();
            jambeDroite.setStartX(SPINE_END_X);
            jambeDroite.setStartY(SPINE_END_Y);
            jambeDroite.setEndX(SPINE_END_X - 25);
            jambeDroite.setEndY(SPINE_END_Y + 50);

            getChildren().addAll(tete, dos, brasGauche, brasDroit, jambeGauche, jambeDroite);
            vies.set(getChildren().size());
        }

        public void reset() {
            getChildren().forEach(noeud -> noeud.setVisible(false));
            vies.set(getChildren().size());
        }

        public void takeAwayLife() {
            for (Node n : getChildren()) {
                if (!n.isVisible()) {
                    n.setVisible(true);
                    vies.set(vies.get() - 1);
                    break;
                }
            }
        }
    }

    private static class Letter extends StackPane {
        private Rectangle arrierePlan = new Rectangle(40, 60);
        private Text texte;

        public Letter(char lettre) {
            arrierePlan.setFill(lettre == ' ' ? Color.DARKSEAGREEN : Color.WHITE);
            arrierePlan.setStroke(Color.BLUE);

            texte = new Text(String.valueOf(lettre).toUpperCase());
            texte.setFont(DEFAULT_FONT);
            texte.setVisible(false);

            setAlignment(Pos.CENTER);
            getChildren().addAll(arrierePlan, texte);
        }

        public void show() {
            RotateTransition rt = new RotateTransition(Duration.seconds(1), arrierePlan);
            rt.setAxis(Rotate.Y_AXIS);
            rt.setToAngle(180);
            rt.setOnFinished(event -> texte.setVisible(true));
            rt.play();
        }

        public boolean isEqualTo(char other) {
            return texte.getText().equals(String.valueOf(other).toUpperCase());
        }
    }

    @Override
    public void start(Stage scenePrincipale) throws Exception {
        Scene scene = new Scene(creerContenu());
        scene.setOnKeyPressed((KeyEvent event) -> {
            if (event.getText().isEmpty())
                return;

            char appuye = event.getText().toUpperCase().charAt(0);
            if ((appuye < 'A' || appuye > 'Z') && appuye != '-')
                return;

            if (jouable.get()) {
                Text t = alphabet.get(appuye);
                if (t.isStrikethrough())
                    return;

                // mark the letter 'used'
                t.setFill(Color.BLUE);
                t.setStrikethrough(true);

                boolean trouve = false;

                for (Node n : lettres) {
                    Letter letter = (Letter) n;
                    if (letter.isEqualTo(appuye)) {
                        trouve = true;
                        score.set(score.get() + (int)(modifieurScore * POINTS_PER_LETTER));
                        lettresADeviner.set(lettresADeviner.get() - 1);
                        letter.show();
                    }
                }

                if (!trouve) {
                    pendu.takeAwayLife();
                    modifieurScore = 1.0f;
                }
                else {
                    modifieurScore += BONUS_MODIFIER;
                }
            }
        });

        scenePrincipale.setResizable(false);
        scenePrincipale.setWidth(APP_W);
        scenePrincipale.setHeight(APP_H);
        scenePrincipale.setTitle("Jeu du pendu");
        scenePrincipale.setScene(scene);
        scenePrincipale.show();
        commencerJeu();
    }

    public static void main(String[] args) {
        launch(args);
    }
}