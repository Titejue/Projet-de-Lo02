package fr.utt.lo02;

import java.util.* ;
import java.lang.* ;


public class Partie {

    // Declaration d'un singleton
    private static Partie ourInstance =  null;

    // Attributs de la classe

    private boolean fini = false;

    private static LinkedList<Joueur> joueurs;
    private static int nbJoueur;
    private int variante;
    private int typeJeu

    private int nbPaquetCartes;


    // ------------------------ CONSTRUCTEUR --------------------------------------

    /**
     * Il faudrait plutot se demander si le nombre de joueur ne devrait pas etre choisi par le joueur lui meme
     */
    private Partie(int nbjoueur, int variante, int typeDeJeu) {

        this.nbJoueur = nbjoueur;
        this.variante = variante;

        // On crée la pioche une fois par partie
        Pioche pioche = new Pioche();
        // On crée le Talon une fois par partie
        Talon talon = new Talon();
        // On crée le jeu de carte au moment de la création du jeu
        JeuDeCarte jeuCarte = new JeuDeCarte(typeDeJeu) ;


    }


// ---------------------------------- GETTER ET SETTER ---------------------------------------------------


    public static LinkedList<Joueur> getJoueurs() {
        return joueurs;
    }

    public static Partie getInstance() {
        if (ourInstance == null){
            ourInstance = new Partie(2, 0, 1); // On mettra les paramètres plus tard
            return ourInstance;
        }
    }


    // -------------------------------- PIOCHER UNE OU PLUSIEURS CARTE(S)

    /**
     * Le joueur va recevoir un "entier" en pénalité
     */


    public void terminer(boolean fini) {
        this.fini = fini;
    }











    // --------------------------------- METHODE MAIN ---------------------------------------------------------


}
