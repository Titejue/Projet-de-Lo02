package fr.utt.lo02;

public abstract class Joueur {

    //Nom du joueur
    protected String nom ;
    //Cartes en main du joueur
    protected Hand main ;

// -------------------------------------- CONSTRUCTEUR --------------------------------------------------
    public Joueur(String nom,  ){
        this.nom = nom;
        this.main = new Hand(var) ;

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

    public void JouerCarte(Carte carte) {
        Joueur.choisirCarte() ;
        Talon.recevoirCarte(carte) ;
    }

    // -------------------------------------------- RECEVOIR UNE CARTE ------------------------------------------

    public void recevoirCarte(Carte carte) {
        main = main.add(carte) ;
    }

        /**
         * Quand piocher ?
         * Quand on ne peut pas joueur : on passe alors son tour
         * Quand on subit l'action d'une carte spéciale
         * Il faut donc entrer en paramètre d'entrer le nombre de carte à piocher
         */
    }






}

