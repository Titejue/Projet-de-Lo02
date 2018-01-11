package fr.utt.lo02;

import GUI.Controleur;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.LinkedList;
import java.util.Scanner;

public class JoueurReel extends Joueur {

    // ajouter méthode supprimer carte de la main


    // ----------------------------- CONSTRUCTEUR -------------------------------------------------------
    public JoueurReel(String nom) {
       this.nom = nom ;
       this.main = new LinkedList<Carte>() ;
       this.uneCarte = false;
    }


    // ---------------------------------------- JOUER ---------------------------------------------------

    public void jouer(LinkedList<Carte> main, LinkedList<Carte> cartesJouable, Joueur j ){
        j.setMain(main) ;
        this.cartesJouable = cartesJouable ;
        System.out.println("Votre main se compose de : ") ;
        afficher(this.main) ;
        System.out.println("\nVous pouvez jouer : " );
        afficher(this.cartesJouable) ;

        /*Scanner sc = new Scanner(System.in) ;
        System.out.println("\n");
        int test = -1 ;*/
        carteChoisie = null;
        while( !cartesJouable.contains(carteChoisie)){


            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(carteChoisie != null && !cartesJouable.contains(carteChoisie))
            {
                System.out.println("Vous ne pouvez pas jouer cette carte");
                carteChoisie = null;
            }
        }
        this.main.remove(carteChoisie);
        // On test si le joueur n'a plus qu'une carte
        /*if(this.main.size() == 1 && !uneCarte)
        {
            uneCarte = true;
            processus = new direCarte( this);
        }
        if(this.main.size() != 1 &&uneCarte)
        {
            uneCarte = false;
            this.processus.plusUneCarte();
        }*/


        // new Carte (cartesJouable.get(numCarte).getValeur(), cartesJouable.get(numCarte).getCouleur()) ;
    }


    // ------------------------------------- CHOISIR LA COULEUR DE LA CARTE --------------------------------

    public void choisirCouleur(){
        //Scanner sc = new Scanner(System.in) ;
        System.out.println("\n");
        Carte carte = new Carte();
        couleurCarte = null;
        System.out.println("Veuillez choisir la Couleur pour les prochains tours :\n 1 : COEUR \n 2 : CARREAU \n 3 : TREFLE \n 4 : PIQUE");

        while(couleurCarte == null)
        {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        carte.setCouleur(couleurCarte);
        /*int c = 5 ;
        while (c>4 || c<1){
            System.out.println("Veuillez choisir la Couleur pour les prochains tours :\n 1 : COEUR \n 2 : CARREAU \n 3 : TREFLE \n 4 : PIQUE");
            //c = sc.nextInt();
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
        }*/

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

    //Setter

    public void setChoix(Carte c)
    {
        this.carteChoisie = c;
    }

    public void setCouleurChoisie(CouleurCarte cc){ this.couleurCarte = cc; }

    public void setJoueurChoix(Joueur j){this.joueurChoisi = j; }



    // ------------------------------------ CHOISIR CARTE --------------------------------------------------
    public void choisirCarte(LinkedList<Joueur> joueurs, Joueur j) {

        int numCarteAJouer = -1;

        //Scanner s = new Scanner(System.in);
        afficher(getMain());

        //choisir la carte
        /*while (numCarteAJouer < 0 || numCarteAJouer > getMain().size()) {
            System.out.println("Veuillez choisir une carte à donner à un joueur");
            numCarteAJouer = s.nextInt();
        }*/
        carteChoisie = null;
        while(carteChoisie == null)
        {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Carte carteADonner;
        carteADonner = carteChoisie;
        Partie.getInstance().getPlateau().enleverCarte(carteADonner);

        // Choisir le joueur à qui la donner
        // joueurs.remove(j) ;


        System.out.println("Voici la liste des joueurs : \n") ;
        for (int i = 1; i < joueurs.size(); i++) {
            System.out.println(i + " : " + joueurs.get(i).getNom() + " : " + joueurs.get(i).getMain().size() + " cartes en main." );
        }

        System.out.println("Veuillez choisir le joueur à qui donner cette carte") ;
        this.joueurChoisi = null;
        Controleur.fenetreChoixJoueur();
        while(joueurChoisi == null)
        {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Joueur choisie : " + joueurChoisi.getNom());
        // Donner la carte au joueur séléctionné
        joueurChoisi.recevoirCarte(carteADonner) ;


        // j.afficher(j.getMain()) ;

        System.out.println("Le joueur a bien reçu la carte") ;

        // On supprime cette carte de la main du joueur
        // on pourrait peut-être utiliser
        LinkedList<Carte> mainFictive = j.getMain() ;
        mainFictive.remove(carteADonner) ;
        j.setMain(mainFictive) ;

        //On test si le joueur n'a plus qu'une carte
        /*if(this.main.size() == 1 && !uneCarte)
        {
            uneCarte = true;
            processus = new direCarte( this);
        }
        if(this.main.size() != 1 &&uneCarte)
        {
            uneCarte = false;
            this.processus.plusUneCarte();
        }*/

    }









}