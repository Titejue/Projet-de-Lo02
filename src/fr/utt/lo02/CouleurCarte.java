package fr.utt.lo02;

public enum CouleurCarte {
    Trefle("trefle"),
    Coeur("coeur"),
    Carreau("carreau"),
    Pique("pique");

    private String name = "";

    CouleurCarte(String nom) {
        this.name = nom;
    }

    public String getName()
    {
        return this.name;
    }
}
