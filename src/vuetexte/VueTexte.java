package vuetexte;
import GUI.Controleur;

import java.io.*;
public class VueTexte implements Runnable{

    public static final String PROMPT = ">";
    private boolean quitter;

    public VueTexte()
    {
        Thread t = new Thread(this);
        t.start();
    }

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
