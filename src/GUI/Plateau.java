package GUI;

import fr.utt.lo02.*;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
/**
 * {@inheritDoc}
 * <b>Plateau est le panneau visible dans la fenêtre de jeu durant la partie</b>
 * <p>Plateau hérite de la classe JPanel</p>
 * <p>
 * Le plateau contient la liste des éléments visible fixe durant la partie :
 * <ul>
 * <li>Le dos de carte représentant la pioche</li>
 * <li>Les labels représentant les adversaires et leur nombre de carte</li>
 * <li>La carte visible sur le dessus du talon</li>
 * <li>Les cartes permettant de choisir la couleur</li>
 * </ul>
 * </p>
 * @author Titejue, PYBurosse
 * @version 1.3
 */

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

    /**
     * Constructeur du plateau
     * @param j
     *          La liste des joueurs de la partie
     * @param p
     *          Une réference à la pioche
     * @param t
     *          Une réference au talon
     *
     * Création et mise en place des éléments statiques de l'image
     */
        public Plateau(LinkedList<Joueur> j, Pioche p, Talon t)
        {

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

    /**
     * Mise à jour des informations visible à l'écran
     * <ul>
     *     <li>La main du joueur
     *     @see Plateau#afficherMainJoueur()
     *     </li>
     *     <li>Le nombre de carte dans les mains de chaque adversaires</li>
     *     <li>La carte sur le dessus du talon</li>
     * </ul>
     */


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

            this.remove(carteTalon);
            carteTalon = talon.getDerniereCarte().getImage();
            carteTalon.setBounds(500, 250, 75, 100);

            this.add(carteTalon);
        }

    /**
     * Mise à jour des informations visible à l'écran, selon les cartes jouables par le joueur
     * <ul>
     *     <li>La main du joueur, selon les cartes qu'il peut jouer
     *     @see Plateau#afficherMainJoueur(LinkedList)
     *     </li>
     *     <li>Le nombre de carte dans les mains de chaque adversaires</li>
     *     <li>La carte sur le dessus du talon</li>
     * </ul>
     */

    public void mAJ(LinkedList<Carte> carteJouables)
    {

        this.afficherMainJoueur(carteJouables);

        //Afficher la carte du talon
        this.remove(carteTalon);
        carteTalon = talon.getDerniereCarte().getImage();
        carteTalon.setBounds(500, 250, 75, 100);

        this.add(carteTalon);
    }


    /**
     * Reaffichage de la main du joueur à l'écran
     * Pour chaque carte de la main du joueur, on affiche son label associé, réparti selon le nombre de carte
     */
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

    /**
     * Reaffichage de la main du joueur à l'écran, selon la disponibilité des cartes
     * Les cartes sont affiché en sur-élevant les cartes actuellement jouables selon la situation
     * @param carteJouables
     *          La liste des cartes jouables, donc à sur-élevé à l'écran
     */
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

        /**
            Rend visible à l'écran les labels des cartes permettant de choisir une nouvelle couleur
         */
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

    /**
     * Permet de revenir au jeu après les actions spéciales telles que
     * <ul>
     *     <li>Choix d'une nouvelle couleur</li>
     *     <li>Choix d'une carte à donner à un joueur</li>
     * </ul>
     */
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


    /**
     * Permet de changer le titre du jeu affichant les actions en train d'être effectuées, ou le joueur en train de jouer
     * @param s
     *          Le nouveau titre à afficher
     */
    public void setTitre(String s)
    {
        this.titre.setText(s);
    }

    /**
     * Permet d'enlever une carte du plateau lorsqu'elle ne doit plus être visible
     * @param c
     *          La carte à enlever
     */
    public void enleverCarte(Carte c)
    {
        this.remove(c.getImage());
    }
}
