package fr.utt.lo02;

import java.util.* ;
import java.lang.* ;


public class Partie {

    // Declaration d'un singleton

    private static Partie ourInstance = null ;

    // Attributs de la classe

    private boolean fini = false;

    private static LinkedList<Joueur> joueurs;
    private LinkedList<Carte> dernièresCartes;
    private LinkedList<Carte> listePioche ;


    private int nbJoueur = 0;
    private int numVar = 5 ;
    private int typeDeJeu = 4;
    private int nbDeck ;
    private Variante variante ;
    private JeuDeCarte jeuCarte ;
    private Carte derniereCarte ;
    private Pioche pioche ;
    private Talon talon ;
    private int nombreDeCarteDeck ;
    private int nombreCarteDistribuer ;


    // ------------------------ CONSTRUCTEUR --------------------------------------

    /**
     * Il faudrait plutot se demander si le nombre de joueur ne devrait pas etre choisi par le joueur lui meme
     */
    public Partie() {

        //On instancie tout les paramètres : Variante, jeuDeCarte et la liste de Joueurs :
        this.joueurs = new LinkedList<>() ;

        System.out.println("Démarrage d'une partie") ;

        System.out.println("Veuillez saisir votre nom") ;
        Scanner sc = new Scanner(System.in) ;
        String nomJoueur = sc.nextLine() ;
        joueurs.add(new JoueurReel(nomJoueur)) ;
        this.nbJoueur++ ;

        while (this.nbJoueur < 2) {
            System.out.println("Combien de joueur dans la partie (vous compris)");
            this.nbJoueur = sc.nextInt();
            if (nbJoueur < 2){
                System.out.println("Le nombre de joueurs minimal est 2 !") ;
            }
            else {
                for (int j = 1; j < nbJoueur; j++) {
                    joueurs.add(new Adversaire("adversaire" + j));
                }
            }
        }


        // On demande les données nécessaires : type de jeu, nombre de Decks
        while (this.typeDeJeu > 3) {
            System.out.println("Avec quel Type de Jeu souhaitez-vous joueur ?\n 0 : Jeu classique 54 cartes (52 cartes + 2 Jokers)\n 1 : Jeu de 52 cartes\n 2 : Jeu de 34 cartes (32 cartes + 2 Jokers)\n 3 : Jeu de 32 cartes");
            this.typeDeJeu = sc.nextInt();
            if (typeDeJeu > 3){
                System.out.println("Le numéro sélectionné n'est pas répertorié  ! \n") ;
            }
            else {
                for (int j = 1; j < nbJoueur; j++) {
                    joueurs.add(new Adversaire("adversaire" + j)) ;
                }
            }
        }

        System.out.println("Veuillez choisir le nombre de jeu de Carte de ce type pour la partie : ");
        this.nbDeck = sc.nextInt();

        // On crée le jeu de carte de type JeuDeCarte
        this.jeuCarte = new JeuDeCarte(typeDeJeu, nbDeck);


        while (this.numVar > 4) {
            System.out.println("Veuillez choisir la variante : ");
            System.out.println("0 : Variante Classique \n 1 : Version de MonClar \n 2 : Version Minimale \n 3 : Variante 1 \n 4 : Variante Carte et Maou");
            this.numVar = sc.nextInt();
        }

        /** Numéro de Variante
         * 0 : Variante Classique
         * 1 : Version de MonClar
         * 2 : Version Minimale
         * 3 : Variante 1
         * 4 : Variante Carte et Maou
         */


        switch (numVar) {
            case(0) :
                this.variante = new VarianteClassique() ;
                break ;
            /**case(1) :
                this.variante = new VarianteMonClar();
                break ;
            case(2) :
                this.variante = new VarianteMinimale();
                break ;
            case(3) :
                this.variante  = new Variante1() ;
                break ;**/
            default:
        }

        // On crée la pioche une fois par partie
        this.pioche = new Pioche(jeuCarte) ;
        // On crée le Talon une fois par partie
        this.talon = new Talon() ;


        // On choisit le nombre de carte à distribuer
        if (numVar == 0 || numVar == 1 || numVar == 2 || numVar == 3 || numVar == 4 ){
            if (nbJoueur == 2) {
                if (nbDeck == 1) {
                    this.nombreCarteDistribuer = 10;
                } else {
                    this.nombreCarteDistribuer = 15;
                }
            }
            else if (nbJoueur == 3){
                if (nbDeck == 1) {
                    this.nombreCarteDistribuer = 8;
                } else {
                    this.nombreCarteDistribuer = 12;
                }
            }
            else {
                if (nbDeck == 1) {
                    this.nombreCarteDistribuer = 6;
                } else {
                    this.nombreCarteDistribuer = 9;
                }
            }
        }

        // On distribue les cartes
        for (int i=0 ; i<joueurs.size() ; i++) {
            pioche.donnerCarte(joueurs.get(i), 1);
        }

        // On dépose une carte de la pioche sur le talon
        talon.recevoirCarte(pioche.getPremiereCarte()) ;
    }



    /**
     * this.listePioche = pioche.getPioche() ;
     * this.nombreDeCarteDeck = listePioche.size() ;
     */



// ---------------------------------- GETTER ET SETTER ---------------------------------------------------


    public LinkedList<Joueur> getJoueurs() {
        return joueurs;
    }

    public static Partie getInstance() {
        if (ourInstance == null){
            ourInstance = new Partie();
        }
        return ourInstance ;
    }





    // -------------------------------- GERER UN TOUR ---------------------------------


    // On enregistrera les valeurs des cartes jouées dans une linkedList qui ne gardera qu'en mémoire que les x dernières cartes jouées.
    // x étant le nombre de joueurs dans la parties

    








    /**
     * Le joueur va recevoir un "entier" en pénalité
     */


    public void terminer(boolean fini) {
        this.fini = fini;
    }

}
