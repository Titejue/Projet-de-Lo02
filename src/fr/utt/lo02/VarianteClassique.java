package fr.utt.lo02;

import java.util.LinkedList;

public class VarianteClassique implements Variante {

    int paiement;
    int numCarteJouable;
    LinkedList<Carte> cartePourJouer ;

    Carte carteJouable;
    int sens ;
    int prochainTour ;


    // --------------------------- CONSTRUCTEUR ----------------------------------------------------
    public void VarianteClassique() {
        System.out.println("Vous avez choisi la variante Classique");
    }


    // ------------------------------------ EFFET DES CARTES ----------------------------------------
    public int effetCarte(Carte carte) {

        /** VALEUR DE PAIEMENT
         * -5 : donner une carte à joueur
         * -4 : saute le tour d'un joueur
         * -3 : le joueur rejoue
         * -2 : changer le sens
         * -1 : changer de couleur
         * 0 : ne fait rien
         * 1 : +1 à un joueur
         * 2 : +2 à un joueur
         * 4 : +4 à un joueur
         */

        switch (carte.getValeur()) {
            case AS:
                this.paiement = 4;
                break;
            case DEUX:
                this.paiement = 2;
                break;
            case TROIS:
                this.paiement = 0;
                break;
            case QUATRE:
                this.paiement = 0;
                break;
            case CINQ:
                this.paiement = -5;
                break;
            case SIX:
                this.paiement = 0;
                break;
            case SEPT:
                this.paiement = -4;
                break;
            case HUIT:
                this.paiement = -1;
                break;
            case NEUF:
                this.paiement = 0;
                break;
            case DIX:
                this.paiement = -3;
                break;
            case V:
                this.paiement = -2;
                break;
            case D:
                this.paiement = 0;
                break;
            case R:
                this.paiement = 0;
                break;
            case Joker:
                this.paiement = 0;
                break;
            default:
        }
        return paiement;
    }


    // ---------------------------- CARTES JOUABLES ----------------------------------------------------------
    public void carteJouable(Joueur j, LinkedList<Carte> main, LinkedList<Carte> dernieresCartes, int payer) {


        int taille = dernieresCartes.size();
        // size() : nb d'élément dans la liste
        // get(int i) : renvoie l'élément au rang i sachant que l'on commence au rang 0

        /** CARTE JOUABLE
         * 0 : Carte de même valeur ou spéciale
         * -1 : Carte de même couleur ou spéciale
         * -2 : Carte de même couleur ou valeur ou spéciale
         * 1 : AS
         * 2 : Deux
         * 3 : Trois ...
         */

        // On balaie les cartes de la main :
        for (int i = 0; i < main.size(); i++) {

            // On commence par le cas spécial : 3 cartes similaires ont déja été posées
            if (dernieresCartes.getLast() == dernieresCartes.get(taille - 2) && dernieresCartes.get(taille - 2) == dernieresCartes.get(taille - 3) && dernieresCartes.get(taille - 3) == dernieresCartes.get(taille - 4)) {
                // carte de même valeur
                if (dernieresCartes.getLast().getValeur() == main.get(i).getValeur()) {
                    this.carteJouable = main.get(i);
                    if (!cartePourJouer.contains(carteJouable)) {
                        this.cartePourJouer.add(carteJouable);
                    }
                }
            } else {
                // La dernière carte posée est "neutre" : ne permet pas de changer de couleur
                if (payer == 0 || payer == -5 || payer == -4 || payer == -3 || payer == -2) {
                    // On a une ou plusieurs cartes de même valeurs (carte spéciale possible)
                    if (dernieresCartes.getLast().getValeur() == main.get(i).getValeur()) {
                        this.carteJouable = main.get(i);
                        if (!cartePourJouer.contains(carteJouable)) {
                            this.cartePourJouer.add(carteJouable);
                        }
                    }
                    // On a une ou plusieurs cartes de même couleur (carte spéciale possible)
                    else if (dernieresCartes.getLast().getCouleur() == main.get(i).getCouleur()) {
                        this.carteJouable = main.get(i);
                        if (!cartePourJouer.contains(carteJouable)) {
                            this.cartePourJouer.add(carteJouable);
                        }
                    }
                    // On a un joker
                    else if (main.get(i).getValeur() == ValeurCarte.Joker) {
                        this.carteJouable = main.get(i);
                        if (!cartePourJouer.contains(carteJouable)) {
                            this.cartePourJouer.add(carteJouable);
                        }
                    }
                } else if (payer == -1) {
                    // On demande la couleur qu'a choisi le joueur précedent


                }
            }
        }
    }



    // ----------------------------- PREMIER TOUR ----------------------------------------------------
    public void carteJouableDebut(Joueur j, LinkedList<Carte> main, LinkedList<Carte> dernieresCartes) {
        for (int i = 0; i < main.size(); i++) {
            this.carteJouable = main.get(i);
            if (!cartePourJouer.contains(carteJouable)) {
                this.cartePourJouer.add(carteJouable);
            }
        }
    }



    // ---------------------------- ACTION DES CARTES -----------------------------------------------

    public void actionCarte(int paie, int sens, int tour, int nbJoueur) {

        // On gère les action, prochain tour et le sens du jeu dans ces conditions if

        if (paie == -2) {
            System.out.println("Le sens du jeu change ! \n");
            this.sens = (-1) * sens;
            this.prochainTour = (((tour + sens)%  nbJoueur + nbJoueur ) % nbJoueur);
        }
        else if (paie == -3) {
            System.out.println("Vous allez rejouer !\n");
            this.sens  = sens ;
            this.prochainTour = tour;
        }
        else if (paie == -4) {
            System.out.println("Le tour du joueur suivant est sauté !\n");
            this.sens = sens;
            this.prochainTour = (((tour + 2 * sens) % nbJoueur + nbJoueur) % nbJoueur) ;
        }
        else {
            this.sens = sens ;
            this.prochainTour = (((tour + 2 * sens) % nbJoueur + nbJoueur) % nbJoueur)  ;
        }
    }


    public void miseEnAction(int paie){

    }




    /** VALEUR DE PAIEMENT
     * -5 : donner une carte à joueur
     * OK -4 : saute le tour d'un joueur
     * OK -3 : le joueur rejoue
     * OK -2 : changer le sens
     * -1 : changer de couleur
     * 0 : ne fait rien
     * 1 : +1 à un joueur
     * 2 : +2 à un joueur
     * 4 : +4 à un joueur
     */


    // ----------------------------------- GETTER ET SETTER -------------------------------------------
    public LinkedList<Carte> getCartePourJouer() {
        return cartePourJouer;
    }
    public int getPaiement(){
        return paiement;
    }
    public int getSens() {
        return sens;
    }
    public int getProchainTour() {
        return prochainTour;
    }
}
