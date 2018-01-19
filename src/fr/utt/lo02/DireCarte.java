package fr.utt.lo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
/**
 * {@inheritDoc}
 * <b>Dire carte est la classe qui permet aux joueurs d'annoncer "Carte" ou "Contre-Carte" lorsque quelqu'un n'a plus qu'une carte</b>
 * <p>DireCarte implémente l'interface Runnable car il fonctionne dans un Thread parallèle au jeu</p>
 *
 *
 * @author Titejue, PYBurosse
 * @version 1.3
 */
public class DireCarte implements Runnable{

    private boolean disCarte;
    private Joueur jConcerne;

    /**
     * Contructeur de DireCarte
     *
     * Créer et démarre le Thread attendant que le joueur concerné dise "Carte" ou qu'un de ses adversaires dise "Contre-Carte"
     * @param jC
     *          Le joueur n'ayant plus qu'une seul carte en main
     *
     * @see Joueur
     */
    public DireCarte( Joueur jC)
    {
        this.jConcerne = jC;
        Thread t = new Thread(this);
        t.start();
    }

    /**
     * La méthode run issue de l'interface Runnable
     * Fonctionne jusqu'à ce que le joueur réel dis Carte ou Contre-Carte, ou qu'un adversaire le dise, selon une probabilité
     */
    public void run()
    {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        String r = null;
        this.disCarte = false;
        int randc = (int)(Math.random() * 10) +1;
        int randcc = (int)(Math.random() * 10) +1;
        try{
            r = br.readLine();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(3000);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        if(!(jConcerne instanceof JoueurReel))
        {

            if(randc > 3)
            {
                disCarte = true;
                System.out.println("Le joueur " + jConcerne.getNom() + " a dit CARTE");



            }
            else if( r.equals( "contre-carte" )|| r.equals("Contre-Carte") || r.equals("CONTRE-CARTE")  ||  r.equals("contrecarte") || r.equals("ContreCarte") || r.equals("CONTRECARTE") || r.equals("contre carte") || r.equals("Contre Carte") || r.equals("CONTRE CARTE")||randcc > 4)
            {
                System.out.println("Quelqu'un a dit CONTRE CARTE au joueur " + jConcerne.getNom());
                //Faire piocher deux cartes à jConcerné
                Partie.getInstance().getPioche().donnerCarte(this.jConcerne, 2);

                disCarte = true;
            }
        }
        else
        {
            if(r.equals("carte") || r.equals("Carte") || r.equals("CARTE") )
            {
                System.out.println(jConcerne.getNom() + " a dit CARTE");
                disCarte = true;
            }
            else if(randcc >= 4)
            {
                System.out.println("Quelqu'un a dit CONTRE CARTE au joueur " + jConcerne.getNom());

                //FAIRE piocher 2 cartes à jConcerné
                Partie.getInstance().getPioche().donnerCarte(this.jConcerne, 2);

                disCarte = true;
            }
        }
        while(!this.disCarte)
        {
            // On refat le test toutes les secondes
            try {
                Thread.sleep(1000);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
            randc = (int)(Math.random() * 10) +1;
            randcc = (int)(Math.random() * 10) +1;
            try{
                r = br.readLine();
            }
            catch(IOException e) {
                e.printStackTrace();
            }
            if(!(jConcerne instanceof JoueurReel))
            {

                if( randc >= 9)
                {
                    disCarte = true;
                    System.out.println("Le joueur " + jConcerne.getNom() + " a dit CARTE");
                }
                else if( r.equals( "contre-carte" )|| r.equals("Contre-Carte") || r.equals("CONTRE-CARTE")  ||  r.equals("contrecarte") || r.equals("ContreCarte") || r.equals("CONTRECARTE") || r.equals("contre carte") || r.equals("Contre Carte") || r.equals("CONTRE CARTE")||randcc >= 9)
                {
                    System.out.println("Quelqu'un a dit CONTRE CARTE au joueur " + jConcerne.getNom());
                    //Faire piocher deux cartes à jConcerné
                    Partie.getInstance().getPioche().donnerCarte(this.jConcerne, 2);
                    disCarte = true;
                }

            }
            else
            {
                if(r.equals("carte") || r.equals("Carte") || r.equals("CARTE") )
                {
                    System.out.println(jConcerne.getNom() + " a dit CARTE");
                    disCarte = true;
                }
                else if(randcc >= 9)
                {
                    System.out.println("Quelqu'un a dit CONTRE CARTE au joueur " + jConcerne.getNom());

                    //FAIRE piocher 2 cartes à jConcerné
                    Partie.getInstance().getPioche().donnerCarte(this.jConcerne, 2);

                    disCarte = true;
                }
            }
        }

    }

    /**
     * Permet d'arrêter le Thread si le joueur concerné n'a plus une seule carte en main
     */
    public void plusUneCarte()
    {
        this.disCarte = true;
    }
}
