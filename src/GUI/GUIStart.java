package Version_2.src.GUI;

import Version_2.src.Control;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIStart extends JFrame implements ActionListener {
    private Control control;
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
    private JLabel lbGeneration;

    public GUIStart(Control pControll) {
        control = pControll;
        setTitle("Conway's Game of Life");
        Container cp = getContentPane();
        ((Container) cp).setLayout(null);
        lbWorld = new JLabel("Größe der Generation:");
        lbWorld.setBounds(20, 30, 140, 20);
        cp.add(lbWorld);

        lbBreite = new JLabel("Breite");
        lbBreite.setBounds(170, 30, 50, 20);
        cp.add(lbBreite);

        tfBreite = new JTextField("20");
        tfBreite.setBounds(215, 30, 50, 20);
        cp.add(tfBreite);

        lbHoehe = new JLabel("Hoehe");
        lbHoehe.setBounds(280, 30, 50, 20);
        cp.add(lbHoehe);

        tfHoehe = new JTextField("20");
        tfHoehe.setBounds(330, 30, 50, 20);
        cp.add(tfHoehe);

        cbmiEinzeln = new JCheckBoxMenuItem("Einzelberechnung der Generationen");
        cbmiEinzeln.setBounds(20, 70, 300, 20);
        cbmiEinzeln.setSelected(true);
        cbmiEinzeln.addActionListener(this);
        cp.add(cbmiEinzeln);

        cbmiMehrere = new JCheckBoxMenuItem("Berechnung mehrerer Generationen");
        cbmiMehrere.setBounds(20, 100, 300, 20);
        cbmiMehrere.addActionListener(this);
        cp.add(cbmiMehrere);

        tfAnzGeneration = new JTextField("");
        tfAnzGeneration.setBounds(20, 130, 40, 20);
        tfAnzGeneration.setEnabled(false);
        cp.add(tfAnzGeneration);

        lbGeneration = new JLabel(".ten Generation");
        lbGeneration.setBounds(65, 130, 100, 20);
        cp.add(lbGeneration);

        btnRandomStatGen = new JButton("Zufällige Startgeneration");
        btnRandomStatGen.setBounds(20, 160, 300, 20);
        btnRandomStatGen.addActionListener(this);
        cp.add(btnRandomStatGen);

        btnUserInputGen = new JButton("Zur Eingabe der Startgeneration");
        btnUserInputGen.setBounds(20, 185, 300, 20);
        btnUserInputGen.addActionListener(this);
        cp.add(btnUserInputGen);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(400, 250));
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRandomStatGen) {
            int breite;
            int hoehe;
            if (!tfBreite.getText().equals("") && !tfHoehe.getText().equals("")) {
                breite = Integer.parseInt(tfBreite.getText());
                hoehe = Integer.parseInt(tfHoehe.getText());
            } else {
                breite = 0;
                hoehe = 0;
            }
            if (breite != 0 && hoehe != 0) {
                control.initGeneration(breite, hoehe);
                int nrCycles;
                if (!tfAnzGeneration.getText().equals("") && Integer.parseInt(tfAnzGeneration.getText()) != 0) {
                    nrCycles = Integer.parseInt(tfAnzGeneration.getText());
                } else {
                    nrCycles = 0;
                }

                control.setNrOfCycles(nrCycles);
                control.createRandomGen();
                control.start(cbmiMehrere.isSelected());
                dispose();
            } else {
                System.out.println("Bitte geben sie zuerst eine Zahl ein, die größer als 0 ist");
            }


        } else if (e.getSource() == btnUserInputGen) {
            int breite;
            int hoehe;
            if (!tfBreite.getText().equals("") && !tfHoehe.getText().equals("")) {
                breite = Integer.parseInt(tfBreite.getText());
                hoehe = Integer.parseInt(tfHoehe.getText());
            } else {
                breite = 0;
                hoehe = 0;
            }
            if (breite != 0 && hoehe != 0) {
                if (cbmiEinzeln.isSelected()) {
                    control.startUserInputGenerationGUI(breite, hoehe);
                } else {
                    control.setNrOfCycles(Integer.parseInt(tfAnzGeneration.getText()));
                    control.startUserInputGenerationGUI(breite, hoehe);
                    control.setSelected();
                }

            } else {
                System.out.println("Bitte geben sie zuerst eine Zahl ein, die größer als 0 ist");
            }
        } else if (e.getSource() == cbmiEinzeln) {
            cbmiMehrere.setSelected(false);
            tfAnzGeneration.setEnabled(false);
            tfAnzGeneration.setText("");
        } else if (e.getSource() == cbmiMehrere) {
            cbmiEinzeln.setSelected(false);
            tfAnzGeneration.setEnabled(true);
        }
    }
}
