package fr.utt.lo02;


import java.util.LinkedList;
import java.util.Random;

/**
 * {@inheritDoc}
 * <b>Adversaire est la classe représentant un adversaire du joueur</b>
 * <p>Adversaire hérite de la classe Joueur</p>
 * <p>
 * Un adversaire est donc caractérisé par les informations suivantes :
 * <ul>
 * <li>Un nom unique attribué définitivement au début de la partie</li>
 * <li>Une main suceptible de changer au cours de la partie</li>
 * <li>Un booléen qui suit le contenu de la main du joueur
 *      True : il reste une carte dans la main de "Adversaire"
 *      False : il ne lui reste pas qu'une carte
 * </li>
 * </ul>
 * </p>
 * @see Joueur
 * @author Titejue, PYBurosse
 * @version 1.3
 */

public class Adversaire extends Joueur {

    /**
     * Constructeur CouleurCarte
     * @param nom
     *            Le nom de "Adversaire", fxé dès le début
     * <ul>
     * L'objet Adversaire possède, à sa création, une main composée d'une
     *      liste de Cartes et d'un "marqueur" qui observe si la liste ne
     *      se compose que d'une carte
     * </ul>
     * @see Adversaire#main
     * @see Adversaire#uneCarte
     */
    public Adversaire(String nom) {
        this.nom = nom;
        this.main =  new LinkedList<Carte>() ;
        this.uneCarte = false;
    }

    /**
     * Permet à un Adversaire de jouer selon une méthode aléatoire
     * <ul>
     *     L'adversaire va choisir une carte au hasard parmis celles
     *     qu'il peut joueur
     *
     * </ul>
     * @see Joueur#jouer(LinkedList, LinkedList, Joueur)
     * @param main
     *          La liste des cartes qui composent la mains de Adversaire
     * @param cartesJouable
     *          La liste des cartes jouables
     * @param j
     *          Le moyen d'identifier le joueur dont on parle
     *          (Adversaire en l'occurence)
     */
    public void jouer(LinkedList<Carte> main, LinkedList<Carte> cartesJouable, Joueur j){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        j.setMain(main) ;
        this.cartesJouable = cartesJouable ;

        // Séléction aléatoire d'une carte par l'IA
        this.numCarte = new Random().nextInt(this.cartesJouable.size()) ;
        this.carteChoisie = this.cartesJouable.get(numCarte) ;
        this.main.remove(carteChoisie) ;
    }

    /**
     * Permet à un Adversaire de choisir la couleur du prochain tour après
     * qu'il aie posé une carte à action spéciale : changement de couleur
     * <ul>
     *     L'adversaire va choisir une couleur au hasard parmis les quatres possible
     *     On enregistre les couleurs par nombre : 1 à 4
     * </ul>
     * @see Joueur#choisirCouleur()
     */
    public void choisirCouleur() {
        Carte carte = new Carte();

        int c = 5;
        while (c > 4 || c < 1) {
            c = new Random().nextInt(5);
            switch (c) {
                case (1):
                    carte.setCouleur(CouleurCarte.Coeur);
                    this.couleurCarte = CouleurCarte.Coeur;
                    break;
                case (2):
                    carte.setCouleur(CouleurCarte.Carreau);
                    this.couleurCarte = CouleurCarte.Carreau;
                    break;
                case (3):
                    carte.setCouleur(CouleurCarte.Trefle);
                    this.couleurCarte = CouleurCarte.Trefle;
                    break;
                case (4):
                    carte.setCouleur(CouleurCarte.Pique);
                    this.couleurCarte = CouleurCarte.Pique;
                    break;
            }
        }
    }

    /**
     * Permet à un Adversaire de recevoir une carte et l'ajouter à sa main
     * @param carte
     * @see Joueur#recevoirCarte(Carte)
     */
    protected void recevoirCarte(Carte carte) {
        this.main.add(carte) ;
    }

    /**
     * Permet à un Adversaire de choisir une carte à donner à quelqu'un d'autre
     * <ul>
     *     Il choisit une carte au hasard
     * </ul>
     * @param joueurs
     * @param j
     * @see Joueur#choisirCarte(LinkedList, Joueur)
     */
    public void choisirCarte(LinkedList<Joueur> joueurs, Joueur j) {

        int numCarteAJouer = new Random().nextInt(getMain().size()) ;

        Carte carteADonner = new Carte() ;
        carteADonner = j.main.get(numCarteAJouer) ;

        // Choisir le joueur à qui la donner
        System.out.println("Veuillez choisir le joueur à qui donner cette carte");

        LinkedList<Joueur> listeF = new LinkedList<Joueur>() ;

        for (Joueur l : joueurs) {
            if (l != j) {
                listeF.add(l) ;
            }
        }
        int numjoueur = new Random().nextInt(listeF.size() ) ;
        System.out.println("Le joueur " + listeF.get(numjoueur).getNom() + " est séléctionné") ;

        System.out.println("Il reçoit la carte " + carteADonner.toString()) ;
        listeF.get(numjoueur).recevoirCarte(carteADonner) ;

        LinkedList<Carte> mainFictive = j.getMain() ;
        mainFictive.remove(carteADonner) ;
        j.setMain(mainFictive) ;
    }

    /**
     * Affiche la main du joueur avec un println
     * <ul>
     *     Il choisit une carte au hasard
     * </ul>
     * @param listeCarte
     * @see Joueur#afficher(LinkedList)
     */
    public void afficher(LinkedList<Carte> listeCarte) {
        for (int i=0 ; i<listeCarte.size() ; i++){
            System.out.println(i + " : " + listeCarte.get(i).toString());
        }
    }


    /**
     * Met à jour la main de l'Adversaire
     * @param main
     *      Le nouvelle main de l'Adversaire
     * @see Joueur#choisirCouleur()
     */
    public void setMain(LinkedList<Carte> main) {
        this.main = main;
    }

    /**
     * Retourne la couleur de la Carte de l'Adversaire
     * @return La couleur de la carte
     * @see CouleurCarte
     * @see Joueur#getCouleurCarte()
     */
    public CouleurCarte getCouleurCarte() {
        return this.couleurCarte ;
    }

    /**
     * Retourne le nom de l'Adversaire
     * @return La nom de l'Adversaire sous  de la carte
     * @see Joueur#getNom()
     */
    public String getNom() {
        return this.nom ;
    }

    /**
     * Retourne la main de l'Adversaire
     * @return La main de l'Adversaire
     * @see Joueur#getMain()
     */
    public LinkedList<Carte> getMain() {
        return this.main ;
    }



}