package fr.utt.lo02;

import vuetexte.VueTexte;

/**
 * <b>La classe Main contient la méthode "main" </b>
 *
 * @author Titejue, PYBurosse
 *
 */
public class Main {
    /**
     * Méthode main executée au lancement du programme
     * Lance l'interface console et lance la partie
     */
    public static void main(String[] args) {

        VueTexte vt = new VueTexte();
        Partie partie = Partie.getInstance();

        Partie.getInstance().lancerPartie();


    }





}
