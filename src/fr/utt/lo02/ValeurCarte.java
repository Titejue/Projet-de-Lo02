package fr.utt.lo02;

public enum ValeurCarte {
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

    private String name = "";
    private int valeur = 0;


    ValeurCarte(String nom, int valeur) {
        this.name = nom;
        this.valeur = valeur;
    }

    public int getNumero()
    {
        return this.valeur;
    }

    public String getName()
    {
        return this.name;
    }

}

