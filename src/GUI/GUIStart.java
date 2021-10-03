package Version_2.src.GUI;

import Version_2.src.Control;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIStart extends JFrame implements ActionListener {
    private JButton btnRandomStatGen;
    private JButton btnUserInputGen;
    private JLabel lbWorld;
    private JLabel lbBreite;
    private JLabel lbHoehe;
    private JTextField tfBreite;
    private JTextField tfHoehe;
    private JCheckBoxMenuItem cbmiEinzeln;
    private JCheckBoxMenuItem cbmiMehrere;
    private JTextField tfAnzGeneration;

    public GUIStart(Control pControll){
        setTitle("Conway's Game of Life");
        Container cp = getContentPane();
        ((Container) cp).setLayout(null);
        lbWorld = new JLabel("Größe der Generation:");
        lbWorld.setBounds(20, 30, 140, 20);
        cp.add(lbWorld);

        lbBreite = new JLabel("Breite");
        lbBreite.setBounds(170, 30, 50, 20);
        cp.add(lbBreite);

        tfBreite = new JTextField("");
        tfBreite.setBounds(215,30,50,20);
        cp.add(tfBreite);

        lbHoehe = new JLabel("Hoehe");
        lbHoehe.setBounds(280, 30, 50, 20);
        cp.add(lbHoehe);

        tfHoehe = new JTextField("");
        tfHoehe.setBounds(330,30,50,20);
        cp.add(tfHoehe);

        //TODO hier fehlt noch was
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(400, 250));
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
