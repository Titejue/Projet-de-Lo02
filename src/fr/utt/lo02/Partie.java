package fr.utt.lo02;

import java.util.* ;
import java.lang.* ;


public class Partie {

    // Declaration d'un singleton

    private static Partie ourInstance = null;

    // Attributs de la classe

    private boolean fini = false;

    private static LinkedList<Joueur> joueurs;
    private LinkedList<Carte> dernieresCartes;
    private LinkedList<Carte> listePioche;
    private LinkedList<Integer> verif;


    private int nbJoueur = 0;
    private int numVar ;
    private int typeDeJeu = 4;
    private int nbDeck;
    private static Variante variante;
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


        this.verif = new LinkedList<Integer>();
        this.verif.add(0);

        while (this.nbJoueur < 2 || this.nbJoueur > 10) {
            System.out.println("Combien de joueur dans la partie (vous compris)");
            this.nbJoueur = sc.nextInt();
            if (nbJoueur < 2) {
                System.out.println("Le nombre de joueurs minimal est 2 !");
            } else if (nbJoueur > 10) {
                System.out.println("On ne peut pas jouer à plus de 10 joueurs ! ");
            } else {
                for (int j = 1; j < nbJoueur; j++) {
                    joueurs.add(new Adversaire("adversaire" + j));
                    this.verif.add(0);
                }
            }
        }


        // On demande les données nécessaires : type de jeu, nombre de Decks
        while (this.typeDeJeu > 3) {
            System.out.println("Avec quel Type de Jeu souhaitez-vous joueur ?\n 0 : Jeu classique 54 cartes (52 cartes + 2 Jokers)\n 1 : Jeu de 52 cartes\n 2 : Jeu de 34 cartes (32 cartes + 2 Jokers)\n 3 : Jeu de 32 cartes");
            this.typeDeJeu = sc.nextInt();
            if (typeDeJeu > 3 || typeDeJeu < 0) {
                System.out.println("Le numéro sélectionné n'est pas répertorié  ! \n");
            }
        }

        nbDeck = 0;

        while (nbDeck < 1 || nbDeck > 30) {
            System.out.println("Veuillez choisir le nombre de jeu de Carte de ce type pour la partie : ");
            this.nbDeck = sc.nextInt();

            if (nbDeck < 1) {
                System.out.println("On ne peut pas jouer au 8 américain sans Deck ! \n");
            } else if (nbDeck > 30) {
                System.out.println("Le nombre limite de deck a été fixé à 30. \n");
            } else {
                System.out.println("Le deck va être créé ! \n");
                this.jeuCarte = new JeuDeCarte(typeDeJeu, nbDeck);
            }
        }



        if (typeDeJeu == 0){
            System.out.println(nbDeck +" jeu de 54 cartes contenant deux Jokers vient d'être créé ") ;
        }
        else if (typeDeJeu == 1){
            System.out.println(nbDeck +" jeu de 52 cartes vient d'être créé ") ;
        }
        else if (typeDeJeu == 2){
            System.out.println(nbDeck +" jeu de 34 cartes contenant deux jokers vient d'être créé ") ;
        }
        else if (typeDeJeu == 3) {
            System.out.println(nbDeck +" jeu de 32 cartes vient d'être créé ") ;
        }


        int var = -1 ;
        this.numVar = 5 ;

        while (this.numVar > 4) {
            while (var != 0) {
                System.out.println("Veuillez choisir la variante : ");
                System.out.println("0 : Variante Classique \n 1 : Version de Monclar \n 2 : Version Minimale \n 3 : Variante 1 \n 4 : Variante Carte et Maou");
                this.numVar = sc.nextInt();

                if (numVar == 0){
                    var = 0;
                } else if(numVar ==1){
                    var = 0;
                } else {
                    System.out.println("Nous n'avons pas encore implémenté cette variante ! ");
                }
            }
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
                this.variante = new VarianteClassique() ;
                break;
            case(1) :
                this.variante = new VarianteMonClar() ;
                break ;
             /**
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
        pioche.distribuer(nombreCarteDistribuer, joueurs);

        /**  PROCESSUS DE VERIFICATION QUE LES MAINS ONT BIEN ETE IMPLEMENTEES

         for (int j=0 ; j<nbJoueur ; j++){
            System.out.println("On retourne la main de " + joueurs.get(j).getNom()) ;
            joueurs.get(j).afficher(joueurs.get(j).getMain()) ;

         }
         */

        // On dépose une carte de la pioche sur le talon
        talon.recevoirCarte(pioche.getPremiereCarte()) ;
        pioche.supprimer(talon.getDerniereCarte()) ;
        System.out.println("La carte sur le talon est : " + talon.getDerniereCarte() + "\n") ;
        this.dernieresCartes = new LinkedList<Carte>() ;
        dernieresCartes.add(talon.getTalon().getLast()) ;
    }


    /**
     * this.listePioche = pioche.getPioche() ;
     * this.nombreDeCarteDeck = listePioche.size() ;
     */


// ---------------------------------- GETTER ET SETTER ---------------------------------------------------
    public static LinkedList<Joueur> getJoueurs() {
        return joueurs;
    }

    public static Partie getInstance() {
        if (ourInstance == null) {
            ourInstance = new Partie();
        }
        return ourInstance;
    }

    public LinkedList<Carte> getDernieresCartes() {
        return dernieresCartes;
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

    public static Variante getVariante() {
        return variante;
    }

    public Pioche getPioche(){return pioche;}

    // ------------------------------------- VERIFIER VICTOIRE ---------------------------------------------

    // Vérifier les victoires


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
        setSens(1);
        this.prochainTour = new Random().nextInt(joueurs.size());
        setPaiementTotal(0);


        while (!verif.contains(1)) {

            // Vérifier l'action de la dernière carte jouée
            // Déterminer l'action du joueur en fonction de l'effet
            // Fin du tour : incrémenter le compteur et déterminer la valeur de la variable sens.

            this.tour = prochainTour ;
            this.joueurTour = joueurs.get(tour) ;

            System.out.println("\n----------------------------------------------- ") ;
            System.out.println("\nC'est au tour du joueur " + joueurTour.getNom() ) ;
            System.out.println("Le joueur " + joueurTour.getNom() + " possède " + joueurTour.getMain().size() + " en main. " ) ;
            System.out.println("La carte sur le talon est : " + talon.getDerniereCarte().toString()) ;
            if (dernieresCartes.getLast().getValeur() == ValeurCarte.HUIT){
                System.out.println("La couleur choisie au dernier tour est le " + dernieresCartes.getLast().getCouleur()) ;
            }


            // PREMIER TOUR : on ne prend pas en compte l'effet de la carte sur le talon, seulement sa valeur et couleur


            if (compteur == 0) {
                this.paiement = 0 ;
                variante.carteJouableDebut(joueurTour, joueurTour.getMain(), dernieresCartes) ;


                // CAS 1 : on ne peut rien joueur
                if (variante.getCartePourJouer().size() == 0) {
                    System.out.println("Vous ne pouvez rien jouer, vous piochez une carte !") ;

                    LinkedList<Carte> listeTest = new LinkedList<Carte>();
                    listeTest = pioche.donnerCarte(joueurTour, 1) ;
                    System.out.println("Vous avez pioché la carte " + listeTest.getLast().toString() + "\n") ;

                    //On ne change pas le sens
                    // On incrémente le tour et le compteur
                    this.prochainTour = Math.floorMod(tour + sens , nbJoueur) ;
                    compteur++;
                }


                // CAS 2 : On peut jouer une carte
                else {
                    joueurTour.jouer(joueurTour.getMain(), variante.getCartePourJouer(), joueurTour);

                    //On a la carte choisie par le joueur
                    this.carteChoisie = joueurTour.getCarteChoisie();
                    System.out.println("La carte " + carteChoisie.toString() + " est jouée \n");

                    //On la pose sur le talon
                    talon.recevoirCarte(carteChoisie) ;

                    // on enregistre la carte choisie dans les dernières cartes
                    Carte derniereCarte = new Carte (carteChoisie.getValeur(), carteChoisie.getCouleur()) ;
                    dernieresCartes.add(derniereCarte) ;

                    // On vérifie les effets de la carte choisie
                    variante.effetCarte(carteChoisie) ;
                    setPaiement(variante.getPaiement()) ;

                    // On va chercher l'action de la carte pour le prochain tour sauf si elle doit s'exécuter sur ce tour
                    // Exemple :
                    // donner une carte à un autre joueur de son choix
                    // changer de couleur
                    variante.actionCarte(dernieresCartes.getLast(), sens, tour, nbJoueur, joueurTour, joueurs) ;


                    // Si on change la couleur, on modifie la couleur d'une carte fictive posée sur le dessus du talon
                    //if (paiement == -1) {
                    if (talon.getDerniereCarte().getValeur() == ValeurCarte.HUIT) {
                        dernieresCartes.getLast().setCouleur(variante.getCouleur()) ;
                    }

                    this.sens = variante.getSens() ;
                    this.prochainTour = variante.getProchainTour() ;
                    compteur++ ;
                }

                // TEST SURVIE
                variante.viderCartePourJouer() ;




            // TOUR > 1

            } else {
                variante.carteJouable(joueurTour.getMain(), dernieresCartes, paiement);

                // on fixe le paiementTotal
                this.paiementTotal = paiementTotal + paiement;


                // CAS 1 : on ne peut rien jouer
                if (variante.getCartePourJouer().size() == 0) {

                    // La dernière carte était une carte AS ou DEUX :
                    if (dernieresCartes.getLast().getValeur() == ValeurCarte.AS || dernieresCartes.getLast().getValeur() == ValeurCarte.DEUX) {
                        System.out.println("Vous ne pouvez rien jouer, et vous piochez " + paiementTotal + " Cartes.");

                        LinkedList<Carte> listeTest = new LinkedList<Carte>();
                        listeTest = pioche.donnerCarte(joueurTour, paiementTotal) ;
                        System.out.println("Vous avez pioché les cartes : ");
                        for (int i = 0 ; i < listeTest.size() ; i++) {
                            System.out.println(listeTest.get(i).toString());
                        }

                        // On remet le paiement à zéro
                        this.paiementTotal = 0;
                        this.paiement = 0 ;

                        // On ne change pas le sens
                        // On incrémente le tour et le compteur
                        this.prochainTour = Math.floorMod(tour + sens , nbJoueur) ;
                    }

                    // Le dernière carte était neutre
                    else {
                        System.out.println("Vous ne pouvez rien jouer, vous piochez une carte !\n") ;

                        LinkedList<Carte> listeTest = new LinkedList<Carte>();
                        listeTest = pioche.donnerCarte(joueurs.get(tour), 1) ;
                        System.out.println("Vous avez pioché la carte " + listeTest.getLast().toString() + "\n") ;

                        //On ne change pas le sens
                        // On incrémente le tour et le compteur

                        this.prochainTour = Math.floorMod(tour + sens , nbJoueur) ;
                        this.paiementTotal = 0 ;
                        this.paiement = 0 ;
                    }
                    compteur++ ;
                }

                // CAS 2 : On peut jouer
                else {
                    // On fait choisir une carte au joueur
                    joueurTour.jouer(joueurTour.getMain(), variante.getCartePourJouer(), joueurTour) ;

                    //On a la carte choisie par le joueur
                    this.carteChoisie = joueurTour.getCarteChoisie() ;
                    System.out.println("La carte " + carteChoisie.toString() + " est jouée \n") ;
                    //On la pose sur le talon
                    //Carte newcarteCouleur = new Carte(carteChoisie.getValeur(), carteChoisie.getCouleur()) ;
                    talon.recevoirCarte(carteChoisie) ;

                    // On enregistre la carte choisie dans les dernières cartes
                    Carte derniereCarte = new Carte (carteChoisie.getValeur(), carteChoisie.getCouleur()) ;
                    dernieresCartes.add(derniereCarte) ;

                    // On vérifie les effets de la carte choisie
                    variante.effetCarte(carteChoisie) ;
                    setPaiement(variante.getPaiement()) ;

                    // On va chercher l'action de la carte pour le prochain tour sauf si elle doit s'exécuter sur ce tour
                    // Exemple :
                    // Donner une carte à un autre joueur de son choix
                    // Changer de couleur



                    // On vérifie une première fois la liste vérif si besoin
                    /**
                    for (int k = 0; k < joueurs.size() ; k++) {
                        System.out.println("On affiche k " + k) ;
                        System.out.println("On affiche joueurs size : " + joueurs.size()) ;

                        System.out.println("On affiche le joueur " + joueurs.get(k).getNom() ) ;
                        if (joueurs.get(k).getMain().size() == 0) {
                            System.out.println("Le joueur " + joueurs.get(k).getNom() + " a gagné ! ") ;
                            verif.set(k, 1);
                        } else {
                            verif.set(k, 0);
                        }
                    }
                     */


                    variante.actionCarte(dernieresCartes.getLast(), sens, tour, nbJoueur, joueurs.get(tour), joueurs);

                    // Si on change la couleur, on modifie la couleur d'une carte fictive posée sur le dessus de la pioche
                    if (talon.getDerniereCarte().getValeur() == ValeurCarte.HUIT) {
                        dernieresCartes.getLast().setCouleur(variante.getCouleur());
                    }

                    this.sens = variante.getSens();
                    this.prochainTour = variante.getProchainTour();
                    compteur++ ;


                }
                // TEST SURVIE
                variante.viderCartePourJouer() ;
            }

            if (pioche.getPioche().size() < 10) {
                System.out.println("Il y a moins de 10 cartes dans la pioche ! ");
                Carte carteTalon = talon.getDerniereCarte();
                // On ajoute les cartes du talon dans la pioche et on vide le talon
                for (int i = 0 ; i<talon.getTalon().size() ; i++) {
                    pioche.getPioche().add(talon.getTalon().get(i)) ;
                    talon.getTalon().remove(talon.getTalon().get(i)) ;
                }
                // A présent, la pioche contient toute les cartes du talons ainsi que celles qui restaient dans la pioche
                // On supprime la dernière carte du talon de la pioche
                pioche.getPioche().remove(carteTalon);
                // On ajoute la fameuse carteTalon
                talon.getTalon().add(carteTalon);
                // On mélange la pioche
                Collections.shuffle(pioche.getPioche());
                System.out.println("On mélange la pioche");

            }

            /**
            // On vérifie une seconde fois la liste vérif si besoin
            for (int k = 0; k < joueurs.size() ; k++) {
                System.out.println("On affiche k " + k) ;
                System.out.println("On affiche joueurs size : " + joueurs.size()) ;

                System.out.println("On affiche le joueur " + joueurs.get(k).getNom() ) ;
                if (joueurs.get(k).getMain().size() == 0) {
                    System.out.println("Le joueur " + joueurs.get(k).getNom() + " a gagné ! ") ;
                    verif.set(k, 1);
                } else {
                    verif.set(k, 0);
                }
            }
             */
        }
        System.out.println("La partie est terminée.") ;
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



