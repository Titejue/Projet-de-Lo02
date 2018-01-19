package vuetexte;
import GUI.Controleur;

import java.io.*;
/**
 *
 * <b>VueTexte est la classe qui gère les entrées console</b>
 * <p>Elle implémente l'interface Runnable car elle fonctionne dans un Thread paralléle au reste du programme</p>
 * <p>
 * Cette classe retransmet au Contrôleur les entrées de la console, en les mettant dans la même forme que les entrées via l'interface graphique
 * @see Controleur
 *
 * </p>
 *
 * @author Titejue, PYBurosse
 * @version 1.0
 */
public class VueTexte implements Runnable{

    public static final String PROMPT = ">";
    private boolean quitter;

    /**
     * Constructeur de VueTexte
     * Création et démarrage du Thread qui lit les entrées console
     */
    public VueTexte()
    {
        Thread t = new Thread(this);
        t.start();
    }

    /**
     * Permet de lire dans la console les caractères entrés par l'utilisateur
     * @return
     *      La chaîne de caractère à traiter
     */
    private int lireChaine()
    {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));

        String lecture =null;
        int resultat= -1000;
        try {
            System.out.print(VueTexte.PROMPT);
            lecture =br.readLine();

        } catch (IOException e)
        {
            System.err.println(e.getMessage());
        }
        if(lecture.equals("quitter"))
        {
            this.quitter = true;
        }
        resultat = Integer.parseInt(lecture);

        return resultat;
    }

    /**
     * Methode Run de l'interface Runnable
     * Contient les instructions executées dans le Thread parallèle
     * Tant que la partie n'est pas terminée, lit les entrées console, et les transmet au controleur
     * @see Controleur#choixTexte(int)
     */

    public void run()
    {
        int saisie = 0;
        quitter = false;
        do
        {
            saisie = this.lireChaine();

            Controleur.getInstance().choixTexte(saisie);




        } while (quitter == false);
        System.exit(0);
    }
}
