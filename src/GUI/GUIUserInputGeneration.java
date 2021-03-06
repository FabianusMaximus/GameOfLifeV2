package Version_2.src.GUI;

import Version_2.src.Control;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIUserInputGeneration extends JFrame implements ActionListener {
    private Control control;
    private JPanel panGen;
    private JCheckBox[][] cbCell;
    private JButton btnSaveGen;

    private int[][] eingabeGeneration;
    private int groeßeX;
    private int groeßeY;

    public GUIUserInputGeneration(Control pControl, int pWidth, int pHeight) {
        control = pControl;
        groeßeX = pWidth;
        groeßeY = pHeight;
        eingabeGeneration = new int[groeßeX][groeßeY];

        setTitle("Eingabe der Generation");
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        panGen = new JPanel();
        panGen.setLayout(new GridLayout(pWidth, pHeight));
        cp.add(panGen, BorderLayout.CENTER);

        cbCell = new JCheckBox[pWidth][pHeight];
        for (int i = 0; i < cbCell.length; i++) {
            for (int j = 0; j < cbCell[0].length; j++) {
                cbCell[i][j] = new JCheckBox();
                panGen.add(cbCell[i][j]);
            }
        }

        btnSaveGen = new JButton("Save Generation");
        btnSaveGen.addActionListener(this);
        cp.add(btnSaveGen, BorderLayout.SOUTH);

        setSize(new Dimension(pWidth * 20, pHeight * 20));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private void saveGeneration() {
        for (int i = 0; i < groeßeX; i++) {
            for (int j = 0; j < groeßeY; j++) {
                if (cbCell[i][j].isSelected()) {
                    eingabeGeneration[i][j] = 1;
                } else {
                    eingabeGeneration[i][j] = 0;
                }
            }
        }
        control.setGeneration(eingabeGeneration);
        control.start(control.isSelected());
        dispose();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSaveGen) {
            saveGeneration();
        }
    }
}
