package fr.utt.lo02;

import java.util.LinkedList;

public abstract class Joueur {

    //Nom du joueur
    protected String nom;

    //Cartes en main du joueur
    protected LinkedList<Carte> main;


    // --------------------------------------- REMPLIR MAIN ------------------------------------------------

    protected void recevoirCarte(Carte carte) {
        this.main.add(carte);
    }

    // -------------------------------------- GETTER MAIN --------------------------------------------------
    protected LinkedList<Carte> getMain() {
        return main;
    }

    public void setMain(LinkedList<Carte> main) {
        this.main = main;
    }

    // ------------------------------------ RECEVOIR UNE CARTE -----------------------------------------------

    public void ajouterCarte(Carte carte) {
    }


    // ------------------------------------ POSER UNE CARTE --------------------------------------------------
    public void donnercarte(Carte carte) {
    }


    /**
     * Un joueur peut :
     * Piocher
     * Choisir une Carte
     * Poser une carte
     * Passer son tour
     * Regarder le jeu dans main (méthode qui appelle une méthode afficher() de la classe main
     */


    // -------------------------------------------- JOUER UNE CARTE ------------------------------------------


    /**
     * Quand piocher ?
     * Quand on ne peut pas joueur : on passe alors son tour
     * Quand on subit l'action d'une carte spéciale
     * Il faut donc entrer en paramètre d'entrer le nombre de carte à piocher
     */
}


