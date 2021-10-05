package Version_2.src;

import Version_2.src.Datenbank.DataBase;
import Version_2.src.GUI.GUI;
import Version_2.src.GUI.GUIGeneration;
import Version_2.src.GUI.GUIStart;
import Version_2.src.GUI.GUIUserInputGeneration;

public class Control {
    GUIGeneration guiGeneration;
    GUIUserInputGeneration inputGeneration;
    DataBase Datenbank = new DataBase();
    int generation[][];
    int count = 0;
    int nrOfCycles;

    public Control() {
        GUIStart guiStart = new GUIStart(this);
    }

    public void setGeneration(int[][] pGeneration) {
        generation = pGeneration;
    }

    public int[][] getGeneration() {
        return generation;
    }

    public void initGeneration(int pWidth, int pHeight) {
        generation = new int[pWidth][pHeight];
    }

    public void createRandomGen() {
        for (int x = 0; x < generation.length; x++) {
            for (int y = 0; y < generation[x].length; y++) {
                int random = (int) (Math.random() * 2);
                if (random == 1) {
                    generation[x][y] = 1;
                } else {
                    generation[x][y] = 0;
                }
            }
        }
    }

    private void showGeneration() {
        if (guiGeneration == null) {
            guiGeneration = new GUIGeneration(this, generation);
            guiGeneration.showGeneration(generation);
        }else{
            guiGeneration.showGeneration(generation);
        }


    }


    private int countNeighboursAlive(int pX, int pY) {
        int anzAlive = 0;
        int x = pX - 1;
        int y = pY - 1;
        if (generation[pX][pY] == 1) {
            anzAlive--;
        }
        while (y < pY + 2) {
            for (int i = 0; i < 3; i++) {
                if (x > 0 && y > 0 && x < generation.length - 1 && y < generation[1].length - 1 && generation[x][y] == 1) {
                    anzAlive++;
                }
                x++;
            }
            x = pX - 1;
            y++;
        }
        return anzAlive;
    }

    public int[][] calcNextGeneration() {
        int holdGeneration[][] = new int[generation.length][generation[0].length];
        for (int i = 0; i < holdGeneration.length; i++) {
            for (int j = 0; j < holdGeneration[i].length; j++) {
                holdGeneration[i][j] = 0;
            }
        }
        for (int i = 0; i < generation.length; i++) {
            for (int j = 0; j < generation[i].length; j++) {
                if (generation[i][j] == 1 && countNeighboursAlive(i, j) < 2) { //weniger als zwei lebende Nachbarn
                    holdGeneration[i][j] = 0;
                } else if (generation[i][j] == 1 && countNeighboursAlive(i, j) > 3) { //mehr als 3 lebende Nachbarn
                    holdGeneration[i][j] = 0;
                } else if (generation[i][j] == 1 && countNeighboursAlive(i, j) == 3 ||
                        generation[i][j] == 1 && countNeighboursAlive(i, j) == 2) { //2 oder 3 lebende Nachbarn
                    holdGeneration[i][j] = 1;
                } else if (generation[i][j] == 0 && countNeighboursAlive(i, j) == 3) { //tot mit 3 Nachbarn
                    holdGeneration[i][j] = 1;
                }
            }
        }
        Datenbank.saveGeneration(generation, count);
        generation = holdGeneration;
        return holdGeneration;
    }

    private void calcGenerationsAhead(int pNrOfCycles) {
        for (int i = 0; i < pNrOfCycles; i++) {
            calcNextGeneration();
        }
    }

    public void setNrOfCycles(int pNrOfCycles) {
        nrOfCycles = pNrOfCycles;
    }

    public void startUserInputGenerationGUI(int pWidth, int pHeight) {
        if (inputGeneration == null) {
            inputGeneration = new GUIUserInputGeneration(this, pWidth,pHeight);
        }
    }

    public void start() {
        showGeneration();
    }
}
