package fr.utt.lo02;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class JoueurReel extends Joueur {

    // ----------------------------- CONSTRUCTEUR -------------------------------------------------------
    public JoueurReel(String nom) {
       this.nom = nom ;
    }



    // ------------------------------------ CHOISIR CARTE ------------------------------------------------
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

        System.out.println("Il faut choisir une carte à jouer ! \nSuivez les instructions :  ");
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
        Carte carteChoisie = new Carte(carteValeur, carteCouleur) ;

        // On supprime la carteChoisie de la main du joueur
        this.main.remove(carteChoisie);

        // On peut choisir de retourner la carteChoisie ou on prend une methode void ?
        return carteChoisie;

        // Il faudrait appeler une méthode poser sur la defausse ou le talon pour gérer les listes !
    }


}