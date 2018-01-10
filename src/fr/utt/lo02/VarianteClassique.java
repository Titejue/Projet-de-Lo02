package fr.utt.lo02;

import java.util.LinkedList;

public class VarianteClassique implements Variante {

    int paiement;
    int numCarteJouable;
    LinkedList<Carte> cartePourJouer ;

    Carte carteJouable;
    int sens ;
    int prochainTour ;

    Carte carteADonner ;
    CouleurCarte couleur ;

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
                this.paiement = 0;
                break;
            case SIX:
                this.paiement = 0;
                break;
            case SEPT:
                this.paiement = 0;
                break;
            case HUIT:
                this.paiement = 0;
                break;
            case NEUF:
                this.paiement = 0;
                break;
            case DIX:
                this.paiement = 0;
                break;
            case V:
                this.paiement = 0;
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
    public void carteJouable(LinkedList<Carte> main, LinkedList<Carte> dernieresCartes, int payer) {


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
        for (Carte c : main) {


            // On commence par le cas spécial : 3 cartes similaires ont déja été posées
            if (dernieresCartes.size()>3 && dernieresCartes.getLast().getValeur() == dernieresCartes.get(taille - 2).getValeur() && dernieresCartes.get(taille - 2).getValeur() == dernieresCartes.get(taille - 3).getValeur() && dernieresCartes.get(taille - 3).getValeur() == dernieresCartes.get(taille - 4).getValeur()) {
                // carte de même valeur
                if (dernieresCartes.getLast().getValeur() == c.getValeur()) {
                    this.carteJouable = c;
                    if (!cartePourJouer.contains(this.carteJouable)) {
                        this.cartePourJouer.add(this.carteJouable);
                    }
                }
            }
            // La dernière carte posée est "neutre"
            else if (payer == 0) {

                // Et c'était un joker, on peut donc jouer n'importe quelle carte par dessus
                if (dernieresCartes.getLast().getValeur() == ValeurCarte.Joker) {
                    this.carteJouable = c;
                    if (!cartePourJouer.contains(this.carteJouable)) {
                        this.cartePourJouer.add(this.carteJouable);
                    }
                } else {

                    // Sinon :

                    // On a une ou plusieurs cartes de même valeurs (carte spéciale possible)
                    if (dernieresCartes.getLast().getValeur() == c.getValeur()) {
                        this.carteJouable = c;
                        if (!cartePourJouer.contains(this.carteJouable)) {
                            this.cartePourJouer.add(this.carteJouable);
                        }
                    }

                    // On a une ou plusieurs cartes de même couleur (carte spéciale possible)
                    else if (dernieresCartes.getLast().getCouleur() == c.getCouleur()) {
                        this.carteJouable = c;
                        if (!cartePourJouer.contains(this.carteJouable)) {
                            this.cartePourJouer.add(this.carteJouable);
                        }
                    }

                    // On a un joker
                    else if (c.getValeur() == ValeurCarte.Joker) {
                        this.carteJouable = c;
                        if (!cartePourJouer.contains(this.carteJouable)) {
                            this.cartePourJouer.add(this.carteJouable);
                        }
                    }
                }
            }
            // La dernière carte posée était spéciale : As ou deux
            else {
                if (payer > 0) {

                    // Un As a été joué précedemment
                    if (dernieresCartes.getLast().getValeur() == ValeurCarte.AS) {
                        if (cartePourJouer.size() > 0) {
                            for (int k = 0; k < cartePourJouer.size(); k++) {
                                cartePourJouer.remove(cartePourJouer.get(k));
                            }
                        }
                        // Soit on possède une carte AS
                        if (ValeurCarte.AS == c.getValeur()) {
                            this.carteJouable = c;
                            if (!cartePourJouer.contains(this.carteJouable)) {
                                this.cartePourJouer.add(this.carteJouable);
                            }
                        }
                        // Soit on possède une carte Joker
                        else if (ValeurCarte.Joker == c.getValeur()) {
                            this.carteJouable = c;
                            if (!cartePourJouer.contains(this.carteJouable)) {
                                this.cartePourJouer.add(this.carteJouable);
                            }
                        }
                    }

                    // Une Carte DEUX a été jouée précedemment
                    else if (dernieresCartes.getLast().getValeur() == ValeurCarte.DEUX) {
                        if (cartePourJouer.size() > 0) {
                            for (int k = 0; k < cartePourJouer.size(); k++) {
                                cartePourJouer.remove(cartePourJouer.get(k));
                            }
                        }
                        // Soit on possède une carte DEUX
                        if (ValeurCarte.DEUX == c.getValeur()) {
                            this.carteJouable = c;
                            if (!cartePourJouer.contains(this.carteJouable)) {
                                this.cartePourJouer.add(this.carteJouable);
                            }
                        }
                        // Soit on possède une carte Joker
                        else if (ValeurCarte.Joker == c.getValeur()) {
                            this.carteJouable = c;
                            if (!cartePourJouer.contains(this.carteJouable)) {
                                this.cartePourJouer.add(this.carteJouable);
                            }
                        }
                    }
                }
            }
        }
    }



    // ----------------------------- PREMIER TOUR ----------------------------------------------------
    public void carteJouableDebut(Joueur j, LinkedList<Carte> main, LinkedList<Carte> dernieresCartes) {

        this.cartePourJouer = new LinkedList<Carte>() ;

        for (Carte c : main) {

            if (dernieresCartes.getLast().getValeur() == c.getValeur()) {
                this.carteJouable = c ;
                if (this.cartePourJouer.contains(carteJouable) == false) {
                    this.cartePourJouer.add(carteJouable) ;
                }
            }

            else if (dernieresCartes.getLast().getCouleur() == c.getCouleur()){
                this.carteJouable = c ;
                if (!this.cartePourJouer.contains(carteJouable)) {
                    this.cartePourJouer.add(carteJouable);
                }
            }
        }
    }



    // ------------------------------ VIDER CARTE POUR JOUER -----------------------------------------------

    public void viderCartePourJouer(){
        this.cartePourJouer.removeAll(cartePourJouer) ;
    }



    // ---------------------------- ACTION DES CARTES -----------------------------------------------

    public void actionCarte(Carte carte, int sens, int tour, int nbJoueur, Joueur j, LinkedList<Joueur> joueurs) {

        // On gère les action, prochain tour et le sens du jeu dans ces conditions if

        if (carte.getValeur() == ValeurCarte.V) {
            System.out.println("Le sens du jeu change ! \n");
            this.sens = (-1) * sens;
            this.prochainTour = (((tour + this.sens)%  nbJoueur + nbJoueur ) % nbJoueur);
        }
        else if (carte.getValeur() == ValeurCarte.DIX) {
            System.out.println("Vous allez rejouer !\n");
            this.sens  = sens ;
            this.prochainTour = tour;
        }
        else if (carte.getValeur() == ValeurCarte.SEPT) {
            System.out.println("Le tour du joueur suivant est sauté !\n");
            this.sens = sens;
            this.prochainTour = (((tour + 2 * this.sens) % nbJoueur + nbJoueur) % nbJoueur) ;
        }
        else if (carte.getValeur() == ValeurCarte.CINQ) {
            // Le joueur peut donner une carte à n'importe quel joueur
            Partie.getInstance().getPlateau().afficherMainJoueur();
            j.choisirCarte(joueurs, j) ;
            this.sens = sens ;
            this.prochainTour = (((tour + this.sens)%  nbJoueur + nbJoueur ) % nbJoueur);
        }
        else if (carte.getValeur() == ValeurCarte.HUIT) {
            Partie.getInstance().getPlateau().choixCouleur();
            // Le joueur peut choisir la couleur
            j.choisirCouleur() ;
            this.couleur = j.getCouleurCarte() ;
            System.out.println("Vous avez choisi la couleur " + couleur );
            this.sens = sens ;
            this.prochainTour = (((tour + this.sens)%  nbJoueur + nbJoueur ) % nbJoueur);
        }
        else {
            this.sens = sens ;
            this.prochainTour = (((tour + this.sens) % nbJoueur + nbJoueur) % nbJoueur)  ;
        }
    }



      /** VALEUR DE PAIEMENT
     * OK -5 : donner une carte à un joueur de votre choix
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
    public void setCartePourJouer(LinkedList<Carte> cartePourJouer){
        this.cartePourJouer = cartePourJouer ;
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
    public void setCarteADonner(Carte carte){
        this.carteADonner = carte ;
    }
    public CouleurCarte getCouleur(){
        return couleur ;
    }


}
