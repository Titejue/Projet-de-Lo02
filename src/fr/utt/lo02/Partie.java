package fr.utt.lo02;
import java.util.ArrayList;
import java.util.Scanner;
public class Partie
{
    private static Partie ourInstance = new Partie( 1, 2);
    private boolean fini = false;
    private static ArrayList<Joueur> joueurs;
    private static int nbJoueur;
    private int variante;
    private int nbPaquetCartes;

    public void terminer(boolean fini) {
        this.fini = fini;
    }

    public static Partie getInstance() {
        return ourInstance;
    }

    private Partie(int nbjoueur, int variante) {
        this.nbJoueur = nbjoueur;
        this.variante = variante;
    }
    public static void main (String[] args)
    {
        System.out.println("Entrez votre nom");
        Scanner sc = new Scanner(System.in);
        String nomJoueur = sc.nextLine();
        System.out.println("Combien de joueur dans la partie (vous compris)");
        Partie.nbJoueur = sc.nextInt();
        Joueur j = new JoueurReel(nomJoueur);
        Partie.joueurs.add(j);


    }
}