package GUI;

import java.awt.*;
import java.util.LinkedList;

import javax.swing.*;
import fr.utt.lo02.*;

import fr.utt.lo02.JoueurReel;
/**
 *
 * <b>Contrôleur est la classe qui permet de faire le lien entre l'interface graphique et le modèle</b>
 * <p>Celui ci est unique, c'est donc un singleton</p>
 * <p>
 * Le contrôleur effectue les actions suivantes
 *
 * <ul>
 * <li>Indiquer au modèle que le joueur à cliqué sur une carte à joueur</li>
 * <li>Indiquer au modèle quelle couleur le joueur à choisi</li>
 * <li>Indiquer au modèle quel adversaire à été choisi </li>
 * </ul>
 * </p>
 *
 * @author Titejue, PYBurosse
 * @version 1.3
 */
public class Controleur {
    private static LinkedList<Joueur> joueurs;
    private Pioche pioche;
    private Talon talon;
    private JFrame fenetre;
    private Joueur JReal;
    private static Controleur ourInstance = null;

    /**
     * Constructeur du controleur
     * @param j,p,t,f
                Initialisation des références à la liste des joueurs, aux objets pioche et talon, ainsi qu'à la fenêtre graphique.
     *
     */
    private Controleur(LinkedList<Joueur> j, Pioche p, Talon t, JFrame f)
    {
        joueurs = j;
        this.pioche = p;
        this.talon = t;
        this.fenetre = f;
        JReal = this.joueurs.get(0);





    }
    //getter et createur du singleton
    public static Controleur getInstance()
    {
        return ourInstance;
    }
    public static Controleur getInstance(LinkedList<Joueur> j, Pioche p, Talon t, JFrame f)
    {
        if(ourInstance ==null)
        {
            ourInstance = new Controleur(j, p, t, f);
        }
        return ourInstance;
    }

    /**
     * Permet d'indiquer au modèle que le joueur a cliqué sur une carte
     * @param c
     *          La carte choisi par le joueur
     */
    public static void carteClic(Carte c)
    {
        Partie.getInstance().getJoueurReel().setChoix(c);
    }

    /**
     * Permet d'indiquer au modèle que le joueur a choisi une nouvelle couleur
     * @param cc
     *          La couleur choisi par le joueur
     */
    public static void couleurClic(CouleurCarte cc)
    {
        Partie.getInstance().getJoueurReel().setCouleurChoisie(cc);
    }
    /**
     * Permet d'indiquer au modèle que le joueur a choisi un adversaire
     * @param j
     *          L'adversaire choisi par le joueur
     */
    public static void joueurClic(Joueur j)
    {
        Partie.getInstance().getJoueurReel().setJoueurChoix(j);
    }

    //---------------------------------Choisir un adversaire------------------

    /**
     * Permet d'ouvrir une fenêtre contenant la liste des joueurs de la partie, afin que l'utilisateur puisse choisi un des autres joueurs
     */
    public static void fenetreChoixJoueur()
    {
        JFrame fenChoix = new JFrame();
        fenChoix.setVisible(true);
        fenChoix.setBounds(150, 150, 200, 500);
        fenChoix.setLayout(new GridLayout((joueurs.size() - 1), 1));
        fenChoix.setResizable(false);
        fenChoix.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        fenChoix.setTitle("Choisissez un joueur pour lui donner la carte");


        for(Joueur j:joueurs)
        {
            if(! (j instanceof JoueurReel))
            fenChoix.getContentPane().add(new BoutonAdversaire(j.getNom(), j, fenChoix));
        }
        fenChoix.repaint();


    }

    /**
     * Permet d'indiquer au modèle qu'un choix a été fait par le biais de l'interface console
     * @param i
     *          Le numéro du choix entré dans la console
     */
    public void choixTexte(int i)
    {

        Partie.getInstance().getJoueurReel().setChoix(Partie.getInstance().getJoueurReel().getMain().get(i));
        Partie.getInstance().getJoueurReel().setJoueurChoix(joueurs.get(i));
        switch(i)
        {
            case (1):
                Partie.getInstance().getJoueurReel().setCouleurChoisie(CouleurCarte.Coeur);
                break;
            case (2):
                Partie.getInstance().getJoueurReel().setCouleurChoisie(CouleurCarte.Carreau);
                break;
            case (3):
                Partie.getInstance().getJoueurReel().setCouleurChoisie(CouleurCarte.Trefle);
                break;
            case (4):
                Partie.getInstance().getJoueurReel().setCouleurChoisie(CouleurCarte.Pique);
                break;
            default:
                System.out.println("Vous n'avez pas saisie la bonne référence");

        }
    }



}
