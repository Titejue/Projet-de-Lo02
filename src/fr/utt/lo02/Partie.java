package fr.utt.lo02;

import java.util.* ;
import java.lang.* ;


public class Partie {

    // Declaration d'un singleton

    private static Partie ourInstance = null;

    // Attributs de la classe

    private boolean fini = false;

    private static LinkedList<Joueur> joueurs;
    private LinkedList<Carte> dernièresCartes;
    private LinkedList<Carte> listePioche;
    private LinkedList<Integer> verif;


    private int nbJoueur = 0;
    private int numVar = 5;
    private int typeDeJeu = 4;
    private int nbDeck;
    private Variante variante;
    private JeuDeCarte jeuCarte;
    private Carte derniereCarte;
    private Carte carteChoisie;
    private Pioche pioche;
    private Talon talon;
    private int nombreDeCarteDeck;
    private int nombreCarteDistribuer;
    private int victoire;
    private int paiement;


    // ------------------------ CONSTRUCTEUR --------------------------------------

    /**
     * Il faudrait plutot se demander si le nombre de joueur ne devrait pas etre choisi par le joueur lui meme
     */
    public Partie() {

        //On instancie tout les paramètres : Variante, jeuDeCarte et la liste de Joueurs :
        this.joueurs = new LinkedList<>();

        System.out.println("Démarrage d'une partie");

        System.out.println("Veuillez saisir votre nom");
        Scanner sc = new Scanner(System.in);
        String nomJoueur = sc.nextLine();
        joueurs.add(new JoueurReel(nomJoueur));
        this.nbJoueur++;
        verif = new LinkedList<Integer>() ;
        verif.add(0) ;

        while (this.nbJoueur < 2) {
            System.out.println("Combien de joueur dans la partie (vous compris)");
            this.nbJoueur = sc.nextInt();
            if (nbJoueur < 2) {
                System.out.println("Le nombre de joueurs minimal est 2 !");
            } else {
                for (int j = 1; j < nbJoueur; j++) {
                    joueurs.add(new Adversaire("adversaire" + j));
                    verif.add(0) ;
                    nbJoueur ++ ;
                }
            }
        }


        // On demande les données nécessaires : type de jeu, nombre de Decks
        while (this.typeDeJeu > 3) {
            System.out.println("Avec quel Type de Jeu souhaitez-vous joueur ?\n 0 : Jeu classique 54 cartes (52 cartes + 2 Jokers)\n 1 : Jeu de 52 cartes\n 2 : Jeu de 34 cartes (32 cartes + 2 Jokers)\n 3 : Jeu de 32 cartes");
            this.typeDeJeu = sc.nextInt();
            if (typeDeJeu > 3) {
                System.out.println("Le numéro sélectionné n'est pas répertorié  ! \n");
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
            case (0):
                this.variante = new VarianteClassique();
                break;
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
        this.pioche = new Pioche(jeuCarte);
        // On crée le Talon une fois par partie
        this.talon = new Talon();


        // On choisit le nombre de carte à distribuer
        if (numVar == 0 || numVar == 1 || numVar == 2 || numVar == 3 || numVar == 4) {
            if (nbJoueur == 2) {
                if (nbDeck == 1) {
                    this.nombreCarteDistribuer = 10;
                } else {
                    this.nombreCarteDistribuer = 15;
                }
            } else if (nbJoueur == 3) {
                if (nbDeck == 1) {
                    this.nombreCarteDistribuer = 8;
                } else {
                    this.nombreCarteDistribuer = 12;
                }
            } else {
                if (nbDeck == 1) {
                    this.nombreCarteDistribuer = 6;
                } else {
                    this.nombreCarteDistribuer = 9;
                }
            }
        }

        // On distribue les cartes
        for (int i = 0; i < joueurs.size(); i++) {
            pioche.donnerCarte(joueurs.get(i), 1);
        }

        // On dépose une carte de la pioche sur le talon
        talon.recevoirCarte(pioche.getPremiereCarte());
        this.dernièresCartes = new LinkedList<Carte>() ;
        dernièresCartes.add(pioche.getPioche().getLast());
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
        if (ourInstance == null) {
            ourInstance = new Partie();
        }
        return ourInstance;
    }

    public LinkedList<Carte> getDernièresCartes() {
        return dernièresCartes;
    }

    public int getSens() {
        return sens;
    }
    public void setSens(int sens) {
        this.sens = sens;
    }

    public void setPaiement(int paiement) {
        this.paiement = paiement;
    }

    public void setProchainTour(int prochainTour) {
        this.prochainTour = prochainTour;
    }

    public int getProchainTour() {
        return prochainTour ;
    }

    public int getTour() {
        return tour;
    }

    public void setTour(int tour) {
        this.tour = tour;
    }

    public int getNbJoueur() {
        return nbJoueur;
    }
    public void setTourPrecedent(int tourPrecedent) {
        this.tourPrecedent = tourPrecedent;
    }
    public int getTourPrecedent(){
        return tourPrecedent;
    }


    // ------------------------------------- VERIFIER VICTOIRE ---------------------------------------------

    // Vérifier les victoires

    public LinkedList<Integer> verifVictoire() {
        for (int k = 0; k < nbJoueur; k++) {
            Joueur joueurTour = joueurs.get(k);
            if (joueurTour.getMain().size() == 0) {
                verif.set(k, 1);
            } else {
                verif.set(k, 0);
            }
        }
        return verif;
    }

    // -------------------------------- GERER UN TOUR ---------------------------------



    // On enregistrera les valeurs des cartes jouées dans une linkedList qui ne gardera qu'en mémoire que les x dernières cartes jouées.
    // x étant le nombre de joueurs dans la parties


    private int sens ;
    private int prochainTour ;
    private int tour ;
    private int tourPrecedent;

    public void lancerPartie() {
        int compteur = 0 ;
        setTour(new Random().nextInt(joueurs.size()));
        setSens(1);
        this.prochainTour = tour ;

        while (!verif.contains(1)) {

            // Vérifier l'action de la dernière carte jouée
            // Déterminer l'action du joueur en fonction de l'effet
            // fin du tour : incrémenter le compteur et déterminer la valeur de la variable sens.

            this.tour = prochainTour ;

            // PREMIER TOUR : on ne prend pas en compte l'effet de la carte sur le talon, seulement sa valeur et couleur
            if (compteur == 0) {
                this.paiement = 0 ;
                variante.carteJouableDebut(joueurs.get(tour), joueurs.get(tour).getMain(), dernièresCartes) ;

                // CAS 1 : on ne peut rien joueur
                if (variante.getCartePourJouer().size() == 0) {
                    System.out.println("Vous ne pouvez rien jouer, vous piochez une carte !\n") ;
                    pioche.donnerCarte(joueurs.get(tour), 1) ;
                    //On ne change pas le sens
                }
                // CAS 2 : On peut jouer une carte
                else {
                    joueurs.get(tour).jouer(joueurs.get(tour).getMain(), variante.getCartePourJouer()) ;
                    //On a la carte choisie par le joueur
                    this.carteChoisie = joueurs.get(tour).getCarteChoisie() ;
                    //On la pose sur le talon
                    talon.recevoirCarte(carteChoisie) ;

                    // On retire la carte de la main du joueur
                    LinkedList<Carte> mainFictive = joueurs.get(tour).getMain() ;
                    mainFictive.remove(carteChoisie) ;
                    joueurs.get(tour).setMain(mainFictive) ;

                    // on enregistre la carte choisie dans les dernières cartes
                    this.derniereCarte = carteChoisie ;
                    dernièresCartes.add(carteChoisie) ;

                    // On vérifie les effets de la carte choisie
                    variante.effetCarte(carteChoisie) ;
                    this.paiement = variante.getPaiement() ;

                    // On va chercher l'action de la carte pour le prochain tour sauf si elle doit s'exécuter sur ce tour
                    // exemple :
                    // donner une carte à un autre joueur de son choix
                    // changer de couleur
                    variante.actionCarte(paiement, sens, tour, nbJoueur, joueurs.get(tour), joueurs) ;

                    // Si on change la couleur, on modifie la couleur d'une carte fictive posée sur le dessus de la pioche
                    if (paiement==-1) {
                        derniereCarte.setCouleur(variante.getCouleur()) ;
                    }
                    this.sens = variante.getSens() ;
                    this.prochainTour = variante.getProchainTour() ;
                }

            } else {
                // On met en action la carte précédente
               // variante.carteJouable(joueurs.get(tour), joueurs.get(tour).getMain(), dernièresCartes) ;






                // On met en action la dernière carte jouée





                variante.carteJouableDebut(joueurs.get(tour), joueurs.get(tour).getMain(), dernièresCartes);


            }
            compteur++;
            setTourPrecedent(getTour());
            setTour(getProchainTour());
        }



                    /** VALEUR DE PAIEMENT
                     *
                     * Changement de sens
                     *
                     * OK -5 : donner une carte à joueur
                     * OK -4 : saute le tour d'un joueur
                     * OK -3 : le joueur rejoue
                     * OK -2 : changer le sens
                     * OK -1 : changer de couleur
                     * 0 : ne fait rien
                     * 1 : +1 à un joueur
                     * 2 : +2 à un joueur
                     * 4 : +4 à un joueur
                     * /




/**
                    if (paiement == -3){
                        tour =
                    }

                    sens = (tour + sens) % joueurs.size() ;


**/

/**




                    // On vérifie les effets de la carte
                    variante.carteJouable(joueurs.get(tour), joueurs.get(tour).getMain(), dernièresCartes, paiement);

                }


                System.out.println("Vous ne pouvez rien jouer, vous piochez une carte !\n");
                pioche.donnerCarte(joueurs.get(tour), 1);
                //On ne change pas le sens
                tour = tour + 1;
            }



            joueurs.get(tour).jouer(joueurs.get(tour).getMain(), variante.getCartePourJouer());
        }


        joueurs.get(tour).jouer();





    }


    /**
     * Va de 0 à la size-1
     * int tour = new Random().nextInt(joueurs.size());
     *
     *
     *
     */













    /**
     * Le joueur va recevoir un "entier" en pénalité
     */


    /**public void terminer(boolean fini) {
        this.fini = fini;
    }*/
    }
}
