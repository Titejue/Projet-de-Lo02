package GUI;


import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.*;
import fr.utt.lo02.* ;


public class ChoisirPanel extends JPanel {


    private int WIDTH = 120;
    private double RATIO = 1.452;
    private ImageIcon logo;

    private JPanel boutons;

    private JButton bouton1;
    private JButton bouton2;
    private JButton bouton3;

    private Container contenu;

    private String nom ;


    public ChoisirPanel() {


        String[] variante = {"Variante Classique", "Variante de MonClar"};

        // Création du JPanel choix

        JPanel choix = new JPanel(new GridLayout(3, 1));

        // Choix nom du joueur
        JButton boutonNom = new JButton("Entrez votre nom") ;
        JTextField texte = new JTextField("Test") ;

        choix.add(boutonNom);
        choix.add(texte);

        repaint();
        setVisible(true);

        /**combo = new JComboBox(tab);

        //Ajout du listener

        combo.addItemListener(new ItemState());

        combo.addActionListener(new ItemAction());

        combo.setPreferredSize(new Dimension(100, 20));

        combo.setForeground(Color.blue);

        //La fin reste inchangée
         */
    }



    //La classe interne ItemState reste inchangée


    class ItemAction implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            //System.out.println("ActionListener : action sur " + combo.getSelectedItem());
        }
    }
}


