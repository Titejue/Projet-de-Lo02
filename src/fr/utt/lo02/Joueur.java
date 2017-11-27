package fr.utt.lo02;

import java.util.* ;
import java.lang.* ;

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
     * Choisir une Carte
     * Poser une carte
     * Passer son tour
     * Regarder le jeu dans main (méthode qui appelle une méthode afficher() de la classe main
     */

    public Carte piocher() {
        Carte cartePioche = Pioche.getFirst(pioche) ;
        main.add(carte);
        return carte ;
    }

    // -------------------------------------------- CHOISIR CARTE -----------------------------------------------


    public Carte choisirCarte() {

        // Il faut créer un objet "carteChoisie" qui est l'une des cartes composant la main du joueur
        // Il va falloir demander par un terminal quelle carte jouer

        /**
         * 1) Affichage de la main
         * 2) Choix de l'une des cartes de la main du joueur
         * 3) On enlève la carteChoisie de la main du joueur et on l'ajoute au tapis
         */

        // Possibilité d'afficher les cartes de la main

        /** Methode à coder : en attente de la classe Main ?*/

        // On demande quelle carte jouer
        // On part du principe que carte prend en paramètre deux String : couleur et valeur ?

        Scanner cartePourJouer = new Scanner(System.in);

        System.out.println("Il faut choisir une carte à jouer ! \t Suivez les instructions :  ");
        System.out.println("Veuillez Saisir la valeur de la carte à jouer ");
        String carteValeur = cartePourJouer.nextLine() ;

        // On vide la ligne avant d'en lire une autre
        cartePourJouer.nextLine();

        System.out.println("Veuillez Saisir la couleur de la carte à jouer ");
        String carteCouleur = cartePourJouer.nextLine();

        //On affiche la carte choisie
        System.out.println("Vous jouez la carte : " + carteValeur + " de " + carteCouleur);

        /**
         * Pour trouver la carte : recherche dans la main du joueur de la carte en question
         * Création de l'objet carteChoisie de type carte et défausse de la main du joueur
         * IL FAUT VERIFIER COMMENT PY DECLARE LE CONSTRUCTEUR CARTE !!!
         */
        Carte carteChoisie = new Carte(carteValeur, carteCouleur);

        // On supprime la carteChoisie de la main du joueur
        main = main.remove(carteChoisie);

        // On peut choisir de retourner la carteChoisie ou on prend une methode void ?
        return carteChoisie;

        // Il faudrait appeler une méthode poser sur la defausse ou le talon pour gérer les listes !
    }


    // -------------------------------------------- JOUER UNE CARTE ------------------------------------------

    public void JouerCarte(Carte carte) {
        Joueur.choisirCarte() ;
        Talon.recevoirCarte(carte) ;
    }

    // -------------------------------------------- PIOCHER UNE CARTE ------------------------------------------

    public void PiocherCarte(int nombre) {
        for (int i=0, i=nombre, i++) {
            Carte carte = Pioche.getFirst();
            System.out.println("Vous avez pioché la carte " + Carte.carte.getValeur() + " de " + Carte.carte.getCouleur());
            main = main.add(carte) ;
            Pioche.pioche = Pioche.pioche.remove(carte) ;
        }
        /**
         * Quand piocher ?
         * Quand on ne peut pas joueur : on passe alors son tour
         * Quand on subit l'action d'une carte spéciale
         * Il faut donc entrer en paramètre d'entrer le nombre de carte à piocher
         */
    }




    //-------------------------------------------- "SOUS-CLASSES" ---------------------------------------------

    // Création de la classe JoueurReel
    public class JoueurReel extends Joueur {

        public Joueur(String nom) {
            this.nom = nom ;
            Joueur.NombreJoueur++ ;
        }
    }

    // Création de la classe Adversaire
    public class Adversaire extends Joueur {
        // On essaiera de jouer à plusieurs en local ou écran scindé ?

        public Adversaire(String nom) {
            this.nom = nom ;
            Joueur.NombreJoueur++ ;
        }
    }



}

