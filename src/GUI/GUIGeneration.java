package Version_2.src.GUI;

import Version_2.src.Control;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIGeneration extends JFrame implements ActionListener {
    private JPanel panGen;
    private JPanel[][] panCell;
    private JButton btnNextGen;
    private Control control;

    public GUIGeneration(Control pControl, int[][] pGen) {
        control = pControl;
        int width = pGen.length;
        int height = pGen[0].length;
        setTitle("Aktuelle Generation von Conway's Game of Life");
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());


        panGen = new JPanel();
        panGen.setLayout(new GridLayout(pGen.length, pGen.length));
        cp.add(panGen, BorderLayout.CENTER);


        panCell = new JPanel[pGen.length][pGen[0].length];
        for (int i = 0; i < pGen.length; i++) {
            for (int j = 0; j < pGen[0].length; j++) {
                panCell[i][j] = new JPanel();
                panGen.add(panCell[i][j]);
            }
        }
        showGeneration(pGen);


        btnNextGen = new JButton("Next Generation");
        btnNextGen.addActionListener(this);
        cp.add(btnNextGen, BorderLayout.SOUTH);

        setSize(new Dimension(width * 20, height * 20 + 20));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

    }

    public void showGeneration(int[][] pGen) {
        for (int i = 0; i < pGen.length; i++) {
            for (int j = 0; j < pGen[0].length; j++) {
                if (pGen[i][j] == 1) {
                    panCell[i][j].setBackground(Color.GREEN);
                } else {
                    panCell[i][j].setBackground(Color.BLACK);
                }
            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        showGeneration(control.calcNextGeneration());
    }
}
