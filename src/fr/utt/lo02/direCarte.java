package fr.utt.lo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
public class direCarte implements Runnable{

    private boolean disCarte;
    private Joueur jConcerne;

    public direCarte( Joueur jC)
    {
        this.jConcerne = jC;
        Thread t = new Thread();
        t.start();
    }
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
                //à rajouter
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
                //a rajouter

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
                    //à rajouter
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
                    //a rajouter

                    disCarte = true;
                }
            }
        }

    }

    public void plusUneCarte()
    {
        this.disCarte = true;
    }
}
