package fr.utt.lo02;

import java.util.* ;

public abstract class Joueur {

    //Nom du joueur
    protected String nom ;
    //Cartes en main du joueur
    protected LinkedList<Carte> main ;
    // On va compter le nombre de jours instanciés
    public static int NombreJoueur = 0 ;

    /**
     * On s'occupera de la stratégie des joueurs plus tard
     **/


    /**
     * Un joueur peut :
     * Piocher
     * Poser une carte
     * Passer son tour
     * Regarder le jeu dans main (méthode qui appelle une méthode afficher() de la classe main
     */

    public void piocher(Carte carte) {
        main.add(carte);
    }

    // -------------------------------------------- POSER CARTE -----------------------------------------------

    
    public Carte posercarte() {
        // Il faut créer un objet "carteChoisie" qui est l'une des cartes composant la main du joueur
        // Il va falloir demander par un terminal quelle carte jouer
        /**
         * 1) Affichage de la main
         * 2) Choix de l'une des cartes de la main du joueur
         * 3) On enlève la carteChoisie de la main du joueur et on l'ajoute au tapis
         */
        // Possibilité d'afficher les cartes de la main
        /** Methode à coder : en attende de la classe Main ?*/
        // On demande quelle carte jouer
        // On part du principe que carte prend en paramètre deux String : couleur et valeur ?
        Scanner cartePourJouer = new Scanner(System.in);
        System.out.println("Il faut choisir une carte à jouer ! \t Suivez les instructions :  ");
        System.out.println("Veuillez Saisir la valeur de la carte à jouer ");
        String carteValeur = cartepourJouer.nextLine();
        // On vide la ligne avant d'en lire une autre
        cartePourJouer.nextLine();
        System.out.println("Veuillez Saisir la couleur de la carte à jouer ");
        String carteCouleur = cartepourJouer.nextLine();
        System.out.println("Vous jouez la carte" + str);
        Carte carteChoisie = new Carte(x);
        main = main.remove(carteChoisie);
        //System.out.println(carteChoisie);
        return carteChoisie;
    }
    /
    On pose
    la 1
    ère carte
    du deck
    sur la
    défausse
    Carte carte = this.liste.getFirst();
    // On supprime la carte du paquet de cartes du joueur
        this.liste.remove(carte);
    // On renvoie la valeur de la carte jouée
        return carte;

    // Création de la classe JoueurReel
    public class JoueurReel extends Joueur {
        /**
         * Constructeur
         **/
        public Joueur(String nom) {
            this.nom = nom;
            Joueur.NombreJoueur++;
        }
    }

    public class Adversaire extends Joueur {
        /**
         * Constructeur
         **/
        public Adversaire(String nom) {
            this.nom = nom;
            Joueur.NombreJoueur++;
        }
    }
}

