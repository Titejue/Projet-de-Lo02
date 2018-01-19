package fr.utt.lo02;

import javax.swing.*;


/**
 * <b>Carte est la classe qui décrit l'objet carte </b>
 * Une carte est caractérisée par les informations suivantes :
 * <p>
 * <ul>
 * <li>Une Valeur de Carte de type ValeurCarte</li>
 * <li>Une Couleur de carte de type CouleurCarte</li>
 * <li>Une image associée à la carte qui permet de l'afficher dans
 *      l'interface graphique
 * </li>
 * </ul>
 * </p>
 * @see ValeurCarte
 * @see CouleurCarte
 * @author Titejue, PYBurosse
 * @version 1.3
 */
public class Carte {



    /**
     * La valeur de "Carte"
     */
    private ValeurCarte valeur ;

    /**
     * La couleur de "Carte"
     */
    private CouleurCarte couleur ;

    /**
     * L'image associée à "Carte"
     */
    private JLabel image;


    /**
     * Constructeur de "Carte"
     * Construit une image de carte et un objet avec une valeur et une couleur
     * @param num
     *      La valeur de la carte
     * @param type
     *       La couleur de la carte
     *
     * @see ValeurCarte
     * @see CouleurCarte
     */
    public Carte(ValeurCarte num, CouleurCarte type) {
        this.valeur = num ;
        this.couleur = type ;
        //System.out.println("src/Images/" + this.getValeur().getNumero() + "_" + this.couleur.getName() + ".png");
        //this.image = new JLabel(new ImageIcon(new ImageIcon("src/Images/" + this.getValeur().getNumero() + "_" + this.couleur.getName() + ".png").getImage().getScaledInstance(75, 100, Image.SCALE_DEFAULT)));
        this.image = new ImageCarte("src/Images/" + this.getValeur().getNumero() + "_" + this.couleur.getName() + ".png", this);
        this.image.setOpaque(true);

    }


    /**
     * Constructeur de "Carte"
     * Construit une image de carte et un objet avec une valeur uniquement.
     * Pratique pour créer le joker
     * @param num
     *      La valeur de la carte
     * @see ValeurCarte
     */
    public Carte(ValeurCarte num) {
        this.valeur = num ;
        this.image = new ImageCarte("src/Images/joker_1.png", this);


    }

    /**
     * Constructeur de "Carte"
     * Construit un objet "Carte" avec une couleur uniquement.
     * @param coul
     *      La couleur de la carte
     * @see CouleurCarte
     */
    public Carte(CouleurCarte coul){
        this.couleur = coul ;
    }

    /**
     * Constructeur de "Carte"
     * Construit un objet "Carte"
     */
    public Carte() {}


    /**
     * Retourne la valeur de "carte"
     * @return La valeur correspondante de type ValeurCarte
     */
    public ValeurCarte getValeur() {
        return this.valeur;
    }

    /**
     * Retourne l'image de "carte"
     * @return L'image correspondante de type JLabel
     */
    public JLabel getImage() {
        return image;
    }

    /**
     * Met à jour la valeur de "carte"
     * @param numero
     */
    void setValeur(ValeurCarte numero) {
        this.valeur = numero;
    }

    /**
     * Retourne la couleur de "carte"
     * @return La couleur correspondante de type CouleurCarte
     */
    public CouleurCarte getCouleur() {
        return this.couleur;
    }

    /**
     * Met à jour la couleur de "carte"
     * @param type
     */
    void setCouleur(CouleurCarte type) {
        this.couleur = type;
    }

    /**
     * Affiche la valeur et la couleur d'une carte
     * @return Valeur de la carte
     * @return Couleur de la carte
     */
    public String toString() {
        String s ;
        if (this.getValeur() == ValeurCarte.Joker){
            s = "" + this.valeur+ "" ;
        }
        else {
            s = "" + this.getValeur() + " de " + this.getCouleur() + "" ;
        }
        return s ;
    }
}
