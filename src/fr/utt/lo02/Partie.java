package fr.utt.lo02;

import java.util.* ;
import java.lang.* ;


public class Partie
{
    // Declaration d'un singleton
    private static Partie ourInstance = new Partie( 1, 2);

    // Attributs de la classe
    private boolean fini = false ;
    private static LinkedList<Joueur> joueurs ;
    private static int nbJoueur ;
    private int variante ;
    private int nbPaquetCartes ;


    // ------------------------ CONSTRUCTEUR

    /**
     * Il faudrait plutot se demander si le nombre de joueur ne devrait pas etre choisi par le joueur lui meme
     */
    private Partie(int nbjoueur, int variante) {

        this.nbJoueur = nbjoueur;
        this.variante = variante;
        // On crée la pioche une fois par partie
        Pioche pioche = new Pioche();
        // On crée le Talon une fois par partie
        Talon talon = new Talon();
        // On crée le jeu de carte au moment de la création du jeu
        JeuDeCarte jeuCarte = new JeuDeCarte( int typedeJeu);
    }




    public void terminer(boolean fini) {
        this.fini = fini;
    }

    public static Partie getInstance() {
        return ourInstance;
    }


    public static void main (String[] args)
    {
        System.out.println("Veuillez saisir votre nom");
        Scanner sc = new Scanner(System.in) ;
        String nomJoueur = sc.nextLine() ;
        System.out.println("Combien de joueur dans la partie (vous compris)");
        Partie.nbJoueur = sc.nextInt() ;
        joueurs.add(new JoueurReel());


    }
}