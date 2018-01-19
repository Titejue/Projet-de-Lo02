package fr.utt.lo02;

import java.util.LinkedList;

/**
 * <p>
 *     Joueur est la classe qui instancie un joueur
 * </p>
 * Un Joueur est caractérisée par les informations suivantes :
 * <p>
 *     <ul>
 *         <li>Un nom pour identifier le joueur</li>
 *         <li>Une liste de "Carte" qui composent la main du joueur</li>
 *         <li>Une liste de "Carte" qui indiquent les cartes jouables par le "Joueur"</li>
 *         <li>un numéro de carte</li>
 *         <li>une couleur de carte associée à une "Carte"</li>
 *         <li>Une carte que le "Joueur" choisi à certains moment du jeu</li>
 *         <li>Une carte que le "Joueur" va jouer</li>
 *         <li>Une carte que le joueur choisi à certains moment du jeu</li>
 *         <li>Un booléen qui référence si il reste une "Carte" dans la main du "Joueur"</li>
 *         <li>Le processus de type "DireCarte"</li>
 *         <li>Un "Joueur" choisi par le "Joueur" actuel à certains moment du jeu</li>
 *         <li>Les coordonnées d'affichage du "Joueur" dans l'interface graphique</li>
 *     </ul>
 * </p>
 * @see Adversaire
 * @see JoueurReel
 * @author Titejue, PYBurosse
 */
public abstract class Joueur {


    /**
     * Le nom du Joueur sous forme de chaîne de caractère
     */
    protected String nom;

    /**
     * La main du "Joueur" qui se composent de "Carte"
     */
    protected LinkedList<Carte> main ;

    /**
     * La liste de "Carte" que peu jouer le "Joueur"
     */
    protected LinkedList<Carte> cartesJouable ;

    /**
     * Un numéro de carte
     */
    protected int numCarte ;

    /**
     * La couleur d'une carte
     */
    protected CouleurCarte couleurCarte ;

    /**
     * Une "Carte" que choisi le "Joueur" à certains moments du jeu
     */
    protected Carte carteChoisie ;

    /**
     * Une "Carte" que choisi de joueur le "Joueur"
     */
    protected Carte carteAJouer ;

    /**
     * Un booléen qui permet de savoir si il reste une "Carte" dans la main du "Joueur"
     */
    protected boolean uneCarte;

    /**
     * Un processus de type "DireCarte"
     */
    protected DireCarte processus;

    /**
     * Le "Joueur" choisi par le "Joueur" dont c'est le tour
     * <p>
     * 	Pratique pour lorsque le joueur choisi de donner une "Carte" à un autre
     * </p>
     */
    protected Joueur joueurChoisi;

    /**
     * La coordonnée en abscisse de l'affichage du "Joueur" sur l'interface graphique
     */
    protected int x;

    /**
     * La coordonnée en ordonnée de l'affichage du "Joueur" sur l'interface graphique
     */
    protected int y;


    /**
     * Permet à un "Joueur" de recevoir une "Carte"
     * @param carte
     *          La "Carte" reçue par le "Joueur"
     */
    protected void recevoirCarte(Carte carte) { }



    /**
     * Permet à un "Joueur" de jouer
     *
     * @param main
     *          La liste des cartes qui composent la mains de "Joueur"
     * @param cartesJouable
     *          La liste des cartes jouables
     * @param j
     *          Le moyen d'identifier le joueur dont on parle
     */
    public void jouer(LinkedList<Carte> main, LinkedList<Carte> cartesJouable, Joueur j){}



    /**
     * Permet à un "Joueur" de choisir une couleur de la Carte
     * <p>Pratique dans le cas d'une carte spéciale : changer couleur</p>
     */
    public void choisirCouleur(){}

    /**
     * Permet à un "Joueur" de choisir une carte à donner à quelqu'un d'autre
     */
    public void choisirCarte(LinkedList<Joueur> joueurs, Joueur j){}


    /**
     * Retourne la main du "Joueur"
     * @return La main du "Joueur"
     */
    public LinkedList<Carte> getMain() {
        return this.main;
    }

    /**
     * Retourne la couleur d'une Carte
     * @return La couleur de la Carte
     */
    public CouleurCarte getCouleurCarte() {
        return couleurCarte;
    }

    /**
     * Retourne la "Carte" choisie par le "Joueur"
     * @return La Carte choisie
     */
    public Carte getCarteChoisie() {
        return carteChoisie;
    }

    /**
     * Retourne le nom du Joueur sous forme de chaîne de caractères
     * @return La nom du "Joueur"
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Retourne la coordonnée (selon l'axe des abscisses)
     *      du Label "Joueur" dans l'interface graphique
     * @return La position selon X du Label "Joueur"
     */
    public int getX() {
        return x;
    }

    /**
     * Met à Jour la coordonnée (selon l'axe des abscisses)
     *      du Label "Joueur" dans l'interface graphique
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Retourne la coordonnée (selon l'axe des ordonnées)
     *      du Label "Joueur" dans l'interface graphique
     * @return La position selon Y du Label "Joueur"
     */
    public int getY() {
        return y;
    }

    /**
     * Met à jour la coordonnée (selon l'axe des ordonnées)
     *      du Label "Joueur" dans l'interface graphique
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Affiche une liste de "Carte" dans la console
     * @param listeCarte
     */
    public void afficher(LinkedList<Carte> listeCarte) {  }

    /**
     * Met à jour le choix de la carte
     * @param c
     */
    public void setChoix(Carte c) { }

    /**
     * Met à jour la couleur de la carte choisie par le "Joueur"
     * @param cc
     */
    public void setCouleurChoisie(CouleurCarte cc){  }

    /**
     * Met à jour le "Joueur" choisi par le "Joueur" actuel
     * @param j
     */
    public void setJoueurChoix(Joueur j) {   }


    /**
     * Met à jour le "Joueur" choisi par le "Joueur" actuel
     * @param j
     */
    public void setMain(LinkedList<Carte> carte) {   }
}

