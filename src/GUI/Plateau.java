package GUI;

import fr.utt.lo02.*;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

public class Plateau extends JPanel implements Observer {

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

        public Plateau(LinkedList<Joueur> j, Pioche p, Talon t)
        {

           // dos = new JLabel(new ImageIcon("src/Images/dos_carte.jpeg"));
            dos = new JLabel(new ImageIcon(new ImageIcon("src/Images/dos_carte.jpeg").getImage().getScaledInstance(75, 100, Image.SCALE_DEFAULT)));

            //Creation des label utile de temps en temps
            trefle = new JLabel(new ImageIcon(new ImageIcon("src/Images/1_trefle.png").getImage().getScaledInstance(150, 200, Image.SCALE_DEFAULT)));
            carreau = new JLabel(new ImageIcon(new ImageIcon("src/Images/1_carreau.png").getImage().getScaledInstance(150, 200, Image.SCALE_DEFAULT)));
            coeur = new JLabel(new ImageIcon(new ImageIcon("src/Images/1_coeur.png").getImage().getScaledInstance(150, 200, Image.SCALE_DEFAULT)));
            pique = new JLabel(new ImageIcon(new ImageIcon("src/Images/1_pique.png").getImage().getScaledInstance(150, 200, Image.SCALE_DEFAULT)));
            titre = new JLabel("Choisissez une couleur");

            trefle.setBounds(50, 100, 150, 200);
            carreau.setBounds(300, 100, 150, 200);
            coeur.setBounds(550, 100, 150, 200);
            pique.setBounds(800, 100, 150, 200);
            titre.setBounds(200, 50, 600,40);



            trefle.setVisible(true);
            carreau.setVisible(true);
            coeur.setVisible(true);
            pique.setVisible(true);
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
                    labelJoueurs.get(i-1).setBounds(i * 1000 / joueurs.size(), 10, 100, 30);
                    this.add(labelJoueurs.get(i-1));
                    this.add(nbCarteAdversaire.get(i-1));
                }

            }

            this.afficherMainJoueur();

            //Afficher la carte du talon
            carteTalon = talon.getDerniereCarte().getImage();
            carteTalon.setBounds(500, 250, 75, 100);
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
            this.remove(carteTalon);
            carteTalon = talon.getDerniereCarte().getImage();
            carteTalon.setBounds(500, 250, 75, 100);
            //System.out.println("GRAPH TEST : talon " + talon.getDerniereCarte().toString());

            this.add(carteTalon);
        }

    public void mAJ(LinkedList<Carte> carteJouables)
    {

        this.afficherMainJoueur(carteJouables);

        //Afficher la carte du talon
        this.remove(carteTalon);
        carteTalon = talon.getDerniereCarte().getImage();
        carteTalon.setBounds(500, 250, 75, 100);
        System.out.println("GRAPH TEST : talon " + talon.getDerniereCarte().toString());

        this.add(carteTalon);
    }



    public void update(Observable o, Object arg0)
    {
        this.afficherMainJoueur();

        //Afficher la carte du talon
        talon.getDerniereCarte().getImage().setBounds(500, 250, 75, 100);
        talon.getDerniereCarte().getImage().setVisible(true);
        this.add(talon.getDerniereCarte().getImage());



        this.repaint();
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
        System.out.println("Tout va bien");
        this.add(trefle);
        this.add(carreau);
        this.add(coeur);
        this.add(pique);
        this.add(titre);

        carteTalon.setVisible(false);
        dos.setVisible(false);

        this.repaint();
    }

    public void choixJoueur()
    {
        this.titre.setText("Choisissez un joueur en cliquant dessus");
    }

    public void retourJeu()
    {
        this.remove(trefle);
        this.remove(carreau);
        this.remove(coeur);
        this.remove(pique);
        this.remove(titre);
        carteTalon.setVisible(true);
        dos.setVisible(true);

        this.repaint();
    }

    public void enleverCarte(Carte c)
    {
        this.remove(c.getImage());
    }
}
