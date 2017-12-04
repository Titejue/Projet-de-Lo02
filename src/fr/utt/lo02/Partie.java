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


        verif = new LinkedList<Integer>();
        verif.add(0);

        while (this.nbJoueur < 2) {
            System.out.println("Combien de joueur dans la partie (vous compris)");
            this.nbJoueur = sc.nextInt();
            if (nbJoueur < 2) {
                System.out.println("Le nombre de joueurs minimal est 2 !");
            } else {
                for (int j = 1; j < nbJoueur; j++) {
                    joueurs.add(new Adversaire("adversaire" + j));
                    verif.add(0);
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
                    System.out.println("On distribue 10 cartes par joueurs");
                    this.nombreCarteDistribuer = 10;
                } else {
                    System.out.println("On distribue 15 cartes par joueurs");
                    this.nombreCarteDistribuer = 15;
                }
            } else if (nbJoueur == 3) {
                if (nbDeck == 1) {
                    System.out.println("On distribue 18 cartes par joueurs");
                    this.nombreCarteDistribuer = 8;
                } else {
                    System.out.println("On distribue 12 cartes par joueurs");
                    this.nombreCarteDistribuer = 12;
                }
            } else {
                if (nbDeck == 1) {
                    System.out.println("On distribue 6 cartes par joueurs");
                    this.nombreCarteDistribuer = 6;
                } else {
                    System.out.println("On distribue 9 cartes par joueurs");
                    this.nombreCarteDistribuer = 9;
                }
            }
        }

        // On distribue les cartes
        for (int j = 0; j < nombreCarteDistribuer; j++) {
            for (int i = 0; i < joueurs.size(); i++) {
                pioche.donnerCarte(joueurs.get(i), 1);
            }
        }

        // On dépose une carte de la pioche sur le talon
        talon.recevoirCarte(pioche.getPremiereCarte());
        System.out.println("La carte sur le talon est : " + talon.getDerniereCarte() + "\n");
        this.dernièresCartes = new LinkedList<Carte>();
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
        return prochainTour;
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

    public int getTourPrecedent() {
        return tourPrecedent;
    }

    public void setPaiementTotal(int a) {
        this.paiementTotal = a;
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


    private int sens;
    private int prochainTour;
    private int tour;
    private int tourPrecedent;
    private int paiementTotal;
    private Joueur joueurTour ;

    public void lancerPartie() {
        int compteur = 0;
        setTour(new Random().nextInt(joueurs.size()));
        setSens(1);
        this.prochainTour = tour;
        setPaiementTotal(0);

        while (!verif.contains(1)) {

            // Vérifier l'action de la dernière carte jouée
            // Déterminer l'action du joueur en fonction de l'effet
            // Fin du tour : incrémenter le compteur et déterminer la valeur de la variable sens.

            this.tour = prochainTour;
            System.out.println("\nC'est au tour du joueur " + joueurs.get(tour).getNom() + "\n");
            this.joueurTour = joueurs.get(tour);
            System.out.println("La carte sur le talon est : " + talon.getDerniereCarte().toString());

            // PREMIER TOUR : on ne prend pas en compte l'effet de la carte sur le talon, seulement sa valeur et couleur
            if (compteur == 0) {
                this.paiement = 0;
                variante.carteJouableDebut(joueurTour, joueurTour.getMain(), dernièresCartes);

                // CAS 1 : on ne peut rien joueur
                if (variante.getCartePourJouer().size() == 0) {
                    System.out.println("Vous ne pouvez rien jouer, vous piochez une carte !\n");
                    pioche.donnerCarte(joueurs.get(tour), 1);
                    //On ne change pas le sens
                    // On incrémente le tour et le compteur
                    this.prochainTour = (((tour + sens) % nbJoueur + nbJoueur) % nbJoueur);
                    compteur++;

                }
                // CAS 2 : On peut jouer une carte
                else {
                    joueurTour.jouer(joueurTour.getMain(), variante.getCartePourJouer(), joueurTour);
                    //On a la carte choisie par le joueur

                    this.carteChoisie = joueurTour.getCarteChoisie();
                    System.out.println("La carte " + carteChoisie.toString() + " est jouée \n");
                    //On la pose sur le talon
                    talon.recevoirCarte(carteChoisie);

                    // on enregistre la carte choisie dans les dernières cartes
                    this.derniereCarte = carteChoisie;
                    dernièresCartes.add(carteChoisie);

                    // On vérifie les effets de la carte choisie
                    variante.effetCarte(carteChoisie);
                    setPaiement(variante.getPaiement());

                    // On va chercher l'action de la carte pour le prochain tour sauf si elle doit s'exécuter sur ce tour
                    // exemple :
                    // donner une carte à un autre joueur de son choix
                    // changer de couleur
                    variante.actionCarte(paiement, sens, tour, nbJoueur, joueurTour, joueurs);

                    // Si on change la couleur, on modifie la couleur d'une carte fictive posée sur le dessus du talon
                    if (paiement == -1) {
                        derniereCarte.setCouleur(variante.getCouleur());
                        dernièresCartes.remove(carteChoisie);
                        dernièresCartes.add(derniereCarte);
                    }
                    this.sens = variante.getSens();
                    this.prochainTour = variante.getProchainTour();
                    compteur++;
                }

            } else {
                variante.carteJouable(joueurTour, joueurTour.getMain(), dernièresCartes, paiement);

                // on fixe le paiementTotal
                this.paiementTotal = paiementTotal + this.paiement;


                // CAS 1 : on ne peut rien jouer
                if (variante.getCartePourJouer().size() == 0) {
                    // La dernière carte était une carte AS ou DEUX :
                    if (derniereCarte.getValeur() == ValeurCarte.AS || derniereCarte.getValeur() == ValeurCarte.DEUX) {
                        System.out.println("Vous ne pouvez rien jouer, et vous piochez " + paiementTotal + " Cartes.");
                        pioche.donnerCarte(joueurTour, paiementTotal);

                        // On remet le paiement à zéro
                        this.paiementTotal = 0;
                        this.paiement = 0 ;

                        // On ne change pas le sens
                        // On incrémente le tour et le compteur
                        this.prochainTour = (((tour + sens) % nbJoueur + nbJoueur) % nbJoueur);

                    }
                    // Le dernière carte était neutre
                    else {
                        System.out.println("Vous ne pouvez rien jouer, vous piochez une carte !\n");
                        pioche.donnerCarte(joueurTour, 1);

                        //On ne change pas le sens
                        // On incrémente le tour et le compteur
                        this.prochainTour = (((tour + sens) % nbJoueur + nbJoueur) % nbJoueur);
                        this.paiementTotal = 0;
                        this.paiement = 0 ;
                    }
                    compteur++;
                }

                // CAS 2 : On peut jouer
                else {
                    // On fait choisir une carte au joueur
                    joueurTour.jouer(joueurTour.getMain(), variante.getCartePourJouer(), joueurTour);

                    //On a la carte choisie par le joueur
                    this.carteChoisie = joueurTour.getCarteChoisie();
                    System.out.println("La carte " + carteChoisie.toString() + " est jouée \n");
                    //On la pose sur le talon
                    talon.recevoirCarte(carteChoisie);

                    // On enregistre la carte choisie dans les dernières cartes
                    this.derniereCarte = carteChoisie;
                    dernièresCartes.add(carteChoisie);

                    // On vérifie les effets de la carte choisie
                    variante.effetCarte(carteChoisie);
                    setPaiement(variante.getPaiement());

                    // On va chercher l'action de la carte pour le prochain tour sauf si elle doit s'exécuter sur ce tour
                    // Exemple :
                    // Donner une carte à un autre joueur de son choix
                    // Changer de couleur
                    variante.actionCarte(paiement, sens, tour, nbJoueur, joueurs.get(tour), joueurs);

                    // Si on change la couleur, on modifie la couleur d'une carte fictive posée sur le dessus de la pioche
                    if (paiement == -1) {
                        derniereCarte.setCouleur(variante.getCouleur());
                        dernièresCartes.remove(carteChoisie);
                        dernièresCartes.add(derniereCarte);
                    }
                    this.sens = variante.getSens();
                    this.prochainTour = variante.getProchainTour();
                    compteur++ ;
                }
            }
        }
    }
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
                     */



