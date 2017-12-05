package fr.utt.lo02;

import java.util.LinkedList;
import java.util.Scanner;

public class JoueurReel extends Joueur {

    // ajouter méthode supprimer carte de la main


    // ----------------------------- CONSTRUCTEUR -------------------------------------------------------
    public JoueurReel(String nom) {
       this.nom = nom ;
       this.main = new LinkedList<Carte>() ;
    }


    // ---------------------------------------- JOUER ---------------------------------------------------

    public void jouer(LinkedList<Carte> main, LinkedList<Carte> cartesJouable, Joueur j ){
        j.setMain(main) ;
        this.cartesJouable = cartesJouable ;
        System.out.println("Votre main se compose de : ") ;
        afficher(this.main) ;
        System.out.println("\nVous pouvez jouer : " );
        afficher(this.cartesJouable) ;

        Scanner sc = new Scanner(System.in) ;
        System.out.println("\n");
        System.out.println("Quelle carte souhaitez-vous jouer ?");
        this.numCarte = -1 ;

        while( numCarte < 0 || numCarte > cartesJouable.size()){
            this.numCarte = sc.nextInt() ;
        }


        this.carteChoisie = cartesJouable.get(numCarte) ;
        this.main.remove(carteChoisie) ;

        // new Carte (cartesJouable.get(numCarte).getValeur(), cartesJouable.get(numCarte).getCouleur()) ;
    }


    // ------------------------------------- CHOISIR LA COULEUR DE LA CARTE --------------------------------

    public void choisirCouleur(){
        Scanner sc = new Scanner(System.in) ;
        System.out.println("\n");
        Carte carte = new Carte();

        int c = 5 ;
        while (c>4 || c<1){
            System.out.println("Veuillez choisir la Couleur pour les prochains tours :\n 1 : COEUR \n 2 : CARREAU \n 3 : TREFLE \n 4 : PIQUE");
            c = sc.nextInt();
            switch (c) {
                case (1):
                    carte.setCouleur(CouleurCarte.Coeur);
                    this.couleurCarte = CouleurCarte.Coeur ;
                    break;
                case (2):
                    carte.setCouleur(CouleurCarte.Carreau);
                    this.couleurCarte = CouleurCarte.Carreau ;
                    break;
                case (3):
                    carte.setCouleur(CouleurCarte.Trefle);
                    this.couleurCarte = CouleurCarte.Trefle ;
                    break;
                case (4):
                    carte.setCouleur(CouleurCarte.Pique);
                    this.couleurCarte = CouleurCarte.Pique ;
                    break;
                default:
                    System.out.println("Vous n'avez pas saisie la bonne référence");
            }
        }

    }



    // ---------------------------------------- AFFICHER LA MAIN -------------------------------------------

    public void afficher(LinkedList<Carte> listeCarte) {
        for (int i=0 ; i<listeCarte.size() ; i++){
            System.out.println(i + " : " + listeCarte.get(i).toString());
        }
    }



    // --------------------------------------- REMPLIR MAIN ------------------------------------------------
    protected void recevoirCarte(Carte carte) {
        this.main.add(carte) ;
    }



    // -------------------------------------- GETTER  ------------------------------------------------------


    public void setMain(LinkedList<Carte> main) {
        this.main = main;
    }

    public CouleurCarte getCouleurCarte() {
        return this.couleurCarte ;
    }

    public String getNom() {
        return this.nom ;
    }

    public LinkedList<Carte> getMain() {
        return this.main ;
    }






    // ------------------------------------ CHOISIR CARTE --------------------------------------------------
    public void choisirCarte(LinkedList<Joueur> joueurs, Joueur j) {
        int numCarteAJouer = -1;
        Scanner s = new Scanner(System.in);
        afficher(getMain());

        //choisir la carte
        while (numCarteAJouer < 0 || numCarteAJouer > getMain().size()) {
            System.out.println("Veuillez choisir une carte à donner à un joueur");
            numCarteAJouer = s.nextInt();
        }
        Carte carteADonner = new Carte() ;
        carteADonner = main.get(numCarteAJouer);

        // Choisir le joueur à qui la donner
        joueurs.remove(j) ;
        System.out.println("Voici la liste des joueurs : \n") ;
        for (int i = 0; i < joueurs.size(); i++) {
            System.out.println(i + " : " + joueurs.get(i).getNom()) ;
        }

        System.out.println("Veuillez choisir le joueur à qui donner cette carte") ;


        int numjoueur = s.nextInt() ;

        // Donner la carte au joueur séléctionné
        joueurs.get(numjoueur).recevoirCarte(carteADonner) ;
        // On supprime cette carte de la main du joueur
        // on pourrait peut-être utiliser
        LinkedList<Carte> mainFictive = j.getMain() ;
        mainFictive.remove(carteADonner) ;
        j.setMain(mainFictive) ;
    }









}