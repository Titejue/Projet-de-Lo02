package fr.utt.lo02;

/**
 * <b>CouleurCarte est un type énuméré "type-safe".</b>
 * <p>
 * Il existe quatre couleurs de cartes :
 * <ul>
 * <li>Trèfle</li>
 * <li>Coeur</li>
 * <li>Carreau</li>
 * <li>Pique</li>
 * </ul>
 * </p>
 *
 * @author Titejue, PYBurosse
 * @version 1.0
 */


public enum CouleurCarte {

    /**
     * L'énumération des couleurs
     */
    Trefle("trefle"),
    Coeur("coeur"),
    Carreau("carreau"),
    Pique("pique");


    /**
     * Le nom de "couleurCarte"
     */
    private String name = "";


    /**
     * Constructeur CouleurCarte
     * @param nom
     *            Le nom de "CouleurCarte" de carte
     */
    CouleurCarte(String nom) {
        this.name = nom;
    }


    /**
     * Retourne la couleur de la carte
     *
     * @return La couleur correspondante, sous la forme d'une
     *      chaîne de caractères
     */
    public String getName()
    {
        return this.name;
    }
}