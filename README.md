# Projet_Java_S4

## Utiliser cette application avec Eclipse:
<hr/>

### 1.
Télécharger ou cloner le repository `Projet_Java_S4` depuis github.
### 2.
Ouvrir Eclipse, puis sous l'onglet file de la barre de menu, choisir Open projects from system files.
### 3.
A côté de import source, cliquer sur le bouton Directory puis cliquer sur le dossier `Projet_client_journet_froliger_ravelli`. 
### 4.
Cliquer sur terminer.
### 5.
Répéter les étapes 4 et 5 mais cette fois avec le dossier `Projet_serveur_journet_froliger_ravelli`. 
### 6.
Pour importer JavaFX, clic droit sur le projet serveur(`Projet_serveur_journet_froliger_ravelli`), Java Build Path, cliquer sur Add Library, user Library, cliquer sur user Librarys, New.
Après l'avoir nommée, cliquer sur celle-ci puis add external JARS.
Se rendre dans le répertoire où le repository est enregistré, dans le dossier lib, puis importer tous les JARS.
### 7.
Pour le projet client(`Projet_client_journet_froliger_ravelli`), clic droit sur `Projet_client_journet_froliger_ravelli` dans l'arborescence des fichiers, build path, add library, user library puis choisir le nom donné à la librairie contenant JavaFX importée dans l'étape précédente.
### 8.
Répéter l'étape 7 avec le projet serveur.
### 9.
Ouvrir les fichiers Client et Serveur se trouvant respectivement dans les projets `Projet_client_journet_froliger_ravelli` et `Projet_serveur_journet_froliger_ravelli`. 
### 10.
Lors de la compilation, le message "JavaFX components are missing" s'affiche.
Clic droit sur chaque projet, run configurations, puis ajouter la ligne suivante dans vm argument: 
--module-path "chemin\javaFX" --add-modules javafx.fxml,javafx.controls
Bien sûr, remplacer chemin\javaFX par l'emplacement du dossier lib où est enregistré ce repository .
### 11.
Lancer le serveur, puis clic sur pin console.
Cliquer sur Open console, puis pin new Console view.
### 12.
Enfin, lancer le Client et commencer à jouer.

<hr/>
Pour davantage d'explications, suivre ce <a href="https://www.youtube.com/watch?v=oVn6_2KuYbM">tutoriel</a>. 
