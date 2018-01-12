package GUI;

import fr.utt.lo02.*;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

public class Plateau extends JPanel {

    private LinkedList<Joueur> joueurs;
    private Pioche pioche;
    private Talon talon;
    private Joueur jReal;
    private JLabel dos;
    private JLabel carteTalon;
    private JLabel trefle;
    private JLabel carreau;
    private JLabel coeur;
    private JLabel pique;
    private JLabel titre;
    private LinkedList<JLabel> nbCarteAdversaire;
    private Carte talonActuel;
    private static final int X_TALON = 500;
    private static final int Y_TALON = 250;


        public Plateau(LinkedList<Joueur> j, Pioche p, Talon t)
        {

           // dos = new JLabel(new ImageIcon("src/Images/dos_carte.jpeg"));
            dos = new JLabel(new ImageIcon(new ImageIcon("src/Images/dos_carte.jpeg").getImage().getScaledInstance(75, 100, Image.SCALE_DEFAULT)));

            //Creation des label utile de temps en temps
            trefle = new CouleurClic("src/Images/1_trefle.png", CouleurCarte.Trefle);
            carreau = new CouleurClic("src/Images/1_carreau.png", CouleurCarte.Carreau);
            coeur = new CouleurClic("src/Images/1_coeur.png", CouleurCarte.Coeur);
            pique = new CouleurClic("src/Images/1_pique.png", CouleurCarte.Pique);
            titre = new JLabel("");

            trefle.setBounds(50, 100, 150, 200);
            carreau.setBounds(300, 100, 150, 200);
            coeur.setBounds(550, 100, 150, 200);
            pique.setBounds(800, 100, 150, 200);
            titre.setBounds(300, 150, 600,40);
            titre.setFont(new Font(" TimesRoman ",Font.BOLD,30));



            trefle.setVisible(true);
            carreau.setVisible(true);
            coeur.setVisible(true);
            pique.setVisible(true);
            titre.setVisible(true);
            this.add(titre);
            //Afficher la pioche
            this.setBackground(new Color(18, 100, 6));
            dos.setBounds(400, 250, 75, 100);
            dos.setOpaque(true);
            this.add(dos);
            this.validate();
            this.setLayout(null);
            this.setVisible(true);

            this.joueurs = j;
            this.pioche = p;
            this.talon = t;


            jReal = joueurs.get(0);
            //Afficher les adversaires
            int i;

            LinkedList<JLabel> labelJoueurs= new LinkedList<JLabel>();
            nbCarteAdversaire = new LinkedList<JLabel>();

            for(Joueur ja:joueurs)
            {
                if(ja != jReal)
                {
                    i = joueurs.indexOf(ja);
                    nbCarteAdversaire.add(new JLabel("" + ja.getMain().size() + " cartes"));
                    nbCarteAdversaire.get(i-1).setBounds(i * 1000 / joueurs.size(), 30, 100, 30);
                    labelJoueurs.add(new JLabel(ja.getNom()));
                    ja.setX(i * 1000 / joueurs.size());
                    ja.setY(10);
                    labelJoueurs.get(i-1).setBounds(ja.getX(), ja.getY(), 100, 30);
                    this.add(labelJoueurs.get(i-1));
                    this.add(nbCarteAdversaire.get(i-1));
                }

            }

            this.afficherMainJoueur();

            //Afficher la carte du talon
            talonActuel = talon.getDerniereCarte();
            carteTalon = talonActuel.getImage();
            carteTalon.setBounds(X_TALON, Y_TALON, 75, 100);
            carteTalon.setVisible(true);
            this.add(carteTalon);


        }



        public void mAJ()
        {

            this.afficherMainJoueur();

            //Mettre à jour le nombre de carte de chaque adversaire
            for(Joueur ja:joueurs)
            {

                if(ja != jReal)
                {
                    int i = joueurs.indexOf(ja);
                    nbCarteAdversaire.get(i-1).setText("" + ja.getMain().size() + " cartes");
                }
            }
            //Afficher la carte du talon
            /*if(carteTalon != talonActuel.getImage())
            {
                if(Partie.getInstance().getJoueurTour() == jReal)
                {
                    this.animationVersTalon(carteTalon);

                }
                else
                {
                    this.animationVersTalon(Partie.getInstance().getJoueurTour(), carteTalon);
                }
            }*/
            this.remove(carteTalon);
            carteTalon = talon.getDerniereCarte().getImage();
            carteTalon.setBounds(500, 250, 75, 100);

            this.add(carteTalon);
        }

    public void mAJ(LinkedList<Carte> carteJouables)
    {

        this.afficherMainJoueur(carteJouables);

        //Afficher la carte du talon
        this.remove(carteTalon);
        carteTalon = talon.getDerniereCarte().getImage();
        carteTalon.setBounds(500, 250, 75, 100);

        this.add(carteTalon);
    }





    public void afficherMainJoueur() {
        int i;

        //Afficher la main du joueur
        for (Carte c : jReal.getMain()) {
            i = jReal.getMain().indexOf(c);
            int nbCarte = jReal.getMain().size();

            c.getImage().setBounds(10 + i * 1000 / nbCarte, 450, 75, 100);
            c.getImage().setOpaque(true);
            this.add(c.getImage());
        }
    }
        public void afficherMainJoueur(LinkedList<Carte> carteJouables)
        {
            int i;

            //Afficher la main du joueur
            for(Carte c:jReal.getMain())
            {
                i = jReal.getMain().indexOf(c);
                int nbCarte = jReal.getMain().size();
                if(!carteJouables.contains(c))
                {
                    c.getImage().setBounds(10+i*1000/nbCarte, 450, 75, 100);
                }

                else
                {
                    c.getImage().setBounds(10+i*1000/nbCarte, 420, 75, 100);
                }
                c.getImage().setOpaque(true);
                this.add(c.getImage());
            }

            //On affiche le nombre de cartes de chaques joueurs


        }

    public void choixCouleur()
    {
        this.add(trefle);
        this.add(carreau);
        this.add(coeur);
        this.add(pique);
        this.add(titre);

        carteTalon.setVisible(false);
        dos.setVisible(false);

        this.repaint();
    }


    public void retourJeu()
    {
        this.remove(trefle);
        this.remove(carreau);
        this.remove(coeur);
        this.remove(pique);

        carteTalon.setVisible(true);
        dos.setVisible(true);

        this.repaint();
    }

    public void animationVersTalon(Joueur j, JLabel c)
    {
        c.setBounds(j.getX(), j.getY(), 75, 100);
        this.add(c);
        for(int x = 0; x <= 60; x++)
        {
            c.setBounds(j.getX() + x * (X_TALON - j.getX()), j.getY() + x * (Y_TALON - j.getY()), 75, 100);
            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.repaint();
    }

    public void animationVersTalon(JLabel c)
    {
        int origineX = c.getX();
        int origineY = c.getY();

        for(int x = 0; x <= 60; x++)
        {
            c.setBounds(origineX - x * (origineX - X_TALON), origineY - x * (origineY - X_TALON), 75, 100);
            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void setTitre(String s)
    {
        this.titre.setText(s);
    }

    public void enleverCarte(Carte c)
    {
        this.remove(c.getImage());
    }
}
