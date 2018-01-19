package fr.utt.lo02;

import GUI.Controleur;


import java.util.LinkedList;


/**
 * {@inheritDoc}
 * <b>JoueurReel est la classe représentant le Joueur physique</b>
 * <p>JoueurReel hérite de la classe Joueur</p>
 * <p>
 * Un JoueurReel est donc caractérisé par les informations suivantes :
 * <ul>
 * <li>Un nom unique choisi au début de la partie</li>
 * <li>Une main suceptible de changer au cours de la partie</li>
 * <li>Un booléen qui suit le contenu de la main du joueur
 *      True : il reste une carte dans la main de "Adversaire"
 *      False : il ne lui reste pas qu'une carte
 * </li>
 * </ul>
 * </p>
 * @see Joueur
 * @author Titejue, PYBurosse

 */
public class JoueurReel extends Joueur {

    /**
     * Constructeur JoueurReel
     * @param nom
     *            Le nom de "JoueurReel", choisi dès le début
     * <ul>
     * L'objet JoueurReel possède, à sa création, une main composée d'une
     *      liste de Cartes et d'un "marqueur" qui observe si la liste ne
     *      se compose que d'une carte
     * </ul>
     * @see JoueurReel#main
     * @see JoueurReel#uneCarte
     */
    public JoueurReel(String nom) {
        this.nom = nom ;
        this.main = new LinkedList<Carte>() ;
        this.uneCarte = false;
    }


    /**
     * Permet à un "JoueurReel" de jouer à son tour     *
     * @param main
     *          La liste des cartes qui composent la mains de "JoueurReel"
     * @param cartesJouable
     *          La liste des cartes jouables
     * @param j
     *          Le moyen d'identifier le joueur dont on parle
     *          (JoueurReel en l'occurence)
     * @see Joueur#jouer(LinkedList, LinkedList, Joueur)
     */

    public void jouer(LinkedList<Carte> main, LinkedList<Carte> cartesJouable, Joueur j ){
        j.setMain(main) ;
        this.cartesJouable = cartesJouable ;
        System.out.println("Votre main se compose de : ") ;
        afficher(this.main) ;
        System.out.println("\nVous pouvez jouer : " );
        afficher(this.cartesJouable) ;

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
    }


    /**
     * Permet à un "JoueurReel" de choisir la couleur du prochain tour après
     * qu'il aie posé une carte à action spéciale : changement de couleur
     * <ul>
     *     Le JoueurReel va choisir une couleur parmis les quatres possible
     *     On enregistre les couleurs par nombre : 1 à 4
     * </ul>
     * <p> La Carte qui est joué va changer "fictivement" de couleur.
     * Aux yeux des autres joueurs, la carte initiale sera la même, au yeux du
     * jeu, la carte jouée aura la valeur initiale mais la couleur choisie par
     * le "Joueur"
     * </p>
     * @see Joueur#choisirCouleur()
     */
    public void choisirCouleur(){
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
    }

    /**
     * Affiche la main du joueur avec un println
     * <ul>
     *     Il choisit une carte au hasard
     * </ul>
     * @param listeCarte
     * 	la liste des "Carte" qui composent la main du JoueurReel
     * @see Joueur#afficher(LinkedList<Carte>)
     */
    public void afficher(LinkedList<Carte> listeCarte) {
        for (int i=0 ; i<listeCarte.size() ; i++){
            System.out.println(i + " : " + listeCarte.get(i).toString());
        }
    }

    /**
     * Permet à un "JoueurReel" de recevoir une carte et l'ajouter à sa main
     * @param carte
     * 		la Carte que va recevoir le JoueurReel
     * @see Joueur#recevoirCarte(Carte)
     */
    protected void recevoirCarte(Carte carte) {
        this.main.add(carte) ;
    }

    /**
     * Met à jour la main de JoueurReel
     * @param main
     *      Le nouvelle main de l'Adversaire
     */
    public void setMain(LinkedList<Carte> main) {
        this.main = main;
    }

    /**
     * Retourne la couleur d'une Carte
     * @return couleurCarte
     */
    public CouleurCarte getCouleurCarte() {
        return this.couleurCarte ;
    }

    /**
     * Retourne le nom d'un JoueurReel sous forme d'une chaîne de caractères
     * @return nom
     */
    public String getNom() {
        return this.nom ;
    }

    /**
     * Retourne la main du joueur sous la forme d'une LinkedList de "Carte"
     * @return main
     */
    public LinkedList<Carte> getMain() {
        return this.main ;
    }

    /**
     * Met à jour la carte qu'a choisi le JoueurReel
     * @param c
     *      La Carte que choisit le JoueurReel
     */
    public void setChoix(Carte c)
    {
        this.carteChoisie = c;
    }

    /**
     * Met à jour la couleur d'une "Carte"
     * @param cc
     *      La Couleur que l'on choisit
     */
    public void setCouleurChoisie(CouleurCarte cc){ this.couleurCarte = cc; }

    /**
     * Met à jour le "Joueur" choisi par JoueurReel
     * @param j
     *      Le "Joueur" qui est choisi
     */
    public void setJoueurChoix(Joueur j){this.joueurChoisi = j; }


    /**
     * Permet à un "JoueurReel" de choisir une carte à donner à quelqu'un d'autre
     * @param joueurs
     *      La liste des joueurs à qui on peut donner une carte
     * @param j
     *      Le "Joueur" qui va choisir à qui donner la carte
     */
    public void choisirCarte(LinkedList<Joueur> joueurs, Joueur j) {

        int numCarteAJouer = -1;
        afficher(getMain());

        //choisir la carte
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

        System.out.println("Le joueur a bien reçu la carte") ;

        // On supprime cette carte de la main du joueur
        LinkedList<Carte> mainFictive = j.getMain() ;
        mainFictive.remove(carteADonner) ;
        j.setMain(mainFictive) ;

    }
}