package fr.utt.lo02;

import java.util.LinkedList;

public abstract class Joueur {

    //Nom du joueur
    protected String nom;

    protected LinkedList<Carte> main ;
    protected LinkedList<Carte> cartesJouable ;
    protected int numCarte ;
    protected CouleurCarte couleurCarte ;
    protected Carte carteChoisie ;



    // --------------------------------------- REMPLIR MAIN ------------------------------------------------

    protected void recevoirCarte(Carte carte) { }



    // ---------------------------------------- JOUER ------------------------------------------------------

    public void jouer(LinkedList<Carte> main, LinkedList<Carte> cartesJouable){}



    // -------------------------------------- GETTER MAIN --------------------------------------------------

    public void setMain(LinkedList<Carte> main) { }


    // ------------------------------------ RECEVOIR UNE CARTE -----------------------------------------------

    public void ajouterCarte(Carte carte) {   }


    // ------------------------------------ POSER UNE CARTE --------------------------------------------------
    public void donnercarte(Carte carte) {
    }


    // ------------------------------------ CHOISIR COULEUR CARTE --------------------------------------------------

    public void choisircouleur(){}

    // ------------------------------------- JOUER -----------------------------------------------------------

    public void jouer(){}










    // -------------------------- GETTER ---------------------------


    protected LinkedList<Carte> getMain() {
        return main;
    }

    public int getNumCarte() {
        return numCarte;
    }

    public CouleurCarte getCouleurCarte() {
        return couleurCarte;
    }

    public Carte getCarteChoisie() {
        return carteChoisie;
    }

    /**
     * Un joueur peut
     * Piocher
     * Choisir une Carte
     * Poser une carte
     * Passer son tour
     * Regarder le jeu dans main (méthode qui appelle une méthode afficher() de la classe main
     */


    /**
     * Quand piocher ?
     * Quand on ne peut pas joueur : on passe alors son tour
     * Quand on subit l'action d'une carte spéciale
     * Il faut donc entrer en paramètre d'entrer le nombre de carte à piocher
     */
}


