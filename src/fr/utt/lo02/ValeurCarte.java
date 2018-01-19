package fr.utt.lo02;

/**
 * <b>ValeurCarte est un type énuméré "type-safe".</b>
 * <p>
 * Il existe quatorze valeurs de cartes possibles pour un jeu
 *      de carte classique (52 cartes et 2 jokers) :
 * <ul>
 * <li>AS</li>
 * <li>DEUX</li>
 * <li>TROIS</li>
 * <li>QUATRE</li>
 * <li>CINQ</li>
 * <li>SIX</li>
 * <li>SEPT</li>
 * <li>HUIT</li>
 * <li>NEUF</li>
 * <li>DIX</li>
 * <li>V (Valet)</li>
 * <li>D (Dame)</li>
 * <li>R (Roi)</li>
 * <li>Joker</li>
 * </ul>
 * </p>
 *
 * @author Titejue
 * @version 1.0
 */

public enum ValeurCarte {

    /**
     * L'énumération des valeurs
     */
    AS("as", 1),
    DEUX("deux", 2),
    TROIS("trois", 3),
    QUATRE("quatre", 4),
    CINQ("cinq", 5),
    SIX("six", 6),
    SEPT("sept", 7),
    HUIT("huit", 8),
    NEUF("neuf", 9),
    DIX("dix", 10),
    V("valet", 11),
    D("dame", 12),
    R("roi", 13),
    Joker("Joker", 14);

    /**
     * Le nom de "valeur"
     */
    private String name = "";

    /**
     * Le nombre associé à "valeur"
     */
    private int valeur = 0;

    /**
     * Constructeur ValeurCarte
     *
     * @param nom
     *          Le nom de "ValeurCarte".
     * @param valeur
     *           La valeur de "ValeurCarte".
     */
    ValeurCarte(String nom, int valeur) {
        this.name = nom;
        this.valeur = valeur;
    }

    /**
     * Retourne la valeur de "ValeurCarte"
     * @return La valeur de la carte, sous la forme d'un entier
     */
    public int getNumero()
    {
        return this.valeur;
    }

    /**
     * Retourne le nom de "ValeurCarte"
     * @return Le nom de la carte, sous la forme d'une
     *      chaîne de caractères
     */
    public String getName()
    {
        return this.name;
    }

}
