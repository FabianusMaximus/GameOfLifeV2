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

    public GUIStart(Control pControll){
        setTitle("Conway's Game of Life");
        Container cp = getContentPane();
        ((Container) cp).setLayout(null);
        lbWorld = new JLabel("Größe der Generation: ");
        lbWorld.setBounds(20, 30, 140, 20);
        cp.add(lbWorld);
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
