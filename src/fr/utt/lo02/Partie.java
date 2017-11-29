package fr.utt.lo02;

import java.util.* ;
import java.lang.* ;


public class Partie {

    // Declaration d'un singleton
    private static Partie ourInstance =  null;

    // Attributs de la classe

    private boolean fini = false;

    private static LinkedList<Joueur> joueurs;

    private int nbJoueur;
    private int numVar;
    private int typeDeJeu ;
    private int nbDeck ;
    private Variante variante;
    private JeuDeCarte jeuCarte;

    // ------------------------ CONSTRUCTEUR --------------------------------------

    /**
     * Il faudrait plutot se demander si le nombre de joueur ne devrait pas etre choisi par le joueur lui meme
     */
    private Partie() {

        //On instancie tout les paramètres : Variante, jeuDeCarte et la liste de Joueurs :
        this.joueurs = new LinkedList<>() ;

        System.out.println("Démarrage d'une partie");
        Partie partie = Partie.getInstance();

        System.out.println("Veuillez saisir votre nom");
        Scanner sc = new Scanner(System.in);
        String nomJoueur = sc.nextLine();
        joueurs.add(new JoueurReel(nomJoueur));

        System.out.println("Combien de joueur dans la partie (vous compris)");
        this.nbJoueur = sc.nextInt();
        for (int j = 1; j < nbJoueur; j++) {
            joueurs.add(new Adversaire("adversaire" + j));
        }

        // On demande les données nécessaires : type de jeu, nombre de Decks
        System.out.println("Avec quel Type de Jeu souhaitez-vous joueur ?\t 0 : Jeu classique 54 cartes (52 cartes + 2 Jokers)\t 1 : Jeu de 52 cartes\t 2 : Jeu de 34 cartes (32 cartes + 2 Jokers)\t 3 : Jeu de 32 cartes");
        this.typeDeJeu = sc.nextInt();
        System.out.println("Veuillez choisir le nombre de jeu de Carte de ce type pour la partie : ");
        this.nbDeck = sc.nextInt();

        // On crée le jeu de carte de type JeuDeCarte
        this.jeuCarte = new JeuDeCarte(typeDeJeu, nbDeck);

        System.out.println("Veuillez choisir la variante :\t ");
        System.out.println("0 : Variante Classique \t 1 : Version de MonClar \t 2 : Version Minimale \t 3 : Variante 1 \t 4 : Variante Carte et Maou");
        this.numVar = sc.nextInt();

        /** Numéro de Variante
         *
         */
        switch (numVar) {
            case(0)
        }

        this.variante = new Variante(numVar);

        // On crée la pioche une fois par partie
        Pioche pioche = new Pioche(jeuCarte);
        // On crée le Talon une fois par partie
        Talon talon = new Talon();





    }


// ---------------------------------- GETTER ET SETTER ---------------------------------------------------


    public static LinkedList<Joueur> getJoueurs() {
        return joueurs;
    }

    public static Partie getInstance() {
        if (ourInstance == null){
            ourInstance = new Partie(); // On mettra les paramètres plus tard
            return ourInstance;
        }
        else {
            System.out.println("Erreur : une partie est déja instanciée");
        }
    }




    // -------------------------------- PIOCHER UNE OU PLUSIEURS CARTE(S)

    /**
     * Le joueur va recevoir un "entier" en pénalité
     */


    public void terminer(boolean fini) {
        this.fini = fini;
    }

}
