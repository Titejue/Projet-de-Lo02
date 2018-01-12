/*
 * Created by JFormDesigner on Sat Dec 23 21:25:54 CET 2017
 */

package GUI;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Observable;
import java.util.Observer;
/**
 * @author unknown
 */
public class PanneauMenu extends JFrame implements ActionListener, MouseListener, Observer {

    private JPanel panneauMenu;

    private JButton bouton1;
    private JButton bouton2;
    private JButton bouton3;

    private JLabel logoImage;

    private Container contenu;


    public PanneauMenu() {

        setTitle("Jeu du 8 Américain ");

        contenu = getContentPane();

        panneauMenu = new JPanel(new GridLayout(4, 1));
        setUpLabels(); // set up the labels, see the method below

        // On ajoute les bouton et labels à gauche de la fenêtre
        contenu.add(panneauMenu, BorderLayout.WEST);

        //On ajoute l'image à droite
        contenu.add(logoImage);

        addMouseListener(this);

        repaint();

        setVisible(true);

    }

    private void setUpLabels() {

        Color foregroundColor = Color.black;
        Color backgroundColor = Color.gray;

        bouton1 = new JButton("Paramètres");
        bouton1.setOpaque(true); // set the label opaque means
        bouton1.setForeground(foregroundColor); // set the color of the text
        bouton1.setBackground(backgroundColor); // setbackground color
        panneauMenu.add(bouton1);
        bouton1.addActionListener(this);

        bouton2 = new JButton("Lancer une Partie");
        bouton2.setOpaque(true);
        bouton2.setForeground(foregroundColor); // set the color of the text
        bouton2.setBackground(backgroundColor); // setbackground color
        panneauMenu.add(bouton2);
        bouton2.addActionListener(this);

        bouton3 = new JButton("Quitter le Jeu");
        bouton3.setOpaque(true);
        bouton3.setForeground(foregroundColor); // set the color of the text
        bouton3.setBackground(backgroundColor); // setbackground color
        panneauMenu.add(bouton3);
        bouton3.addActionListener(this);

        logoImage = new JLabel(new ImageIcon("src/Images/Logo.jpg"));
        logoImage.setSize(100, 100);
        logoImage.setOpaque(true);
        logoImage.setBackground(Color.white);


    }


    public void actionPerformed(ActionEvent ev) {
        if (ev.getSource() == bouton1)
            System.out.println("action bouton 1");
        if (ev.getSource() == bouton2)
                System.out.println("action bouton 2");
        if (ev.getSource() == bouton3)
            System.out.println("action bouton 3");
    }


    public void mouseClicked(MouseEvent ev) {
        System.out.println("clic");
    }

    public void mousePressed(MouseEvent ev) {
    }

    public void mouseReleased(MouseEvent ev) {
    }

    public void mouseEntered(MouseEvent ev) {
    }

    public void mouseExited(MouseEvent ev) {
    }

    public void update(Observable instanceObservable, Object arg1)
    {

    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Juliette Mendras
    private JButton button1;
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
