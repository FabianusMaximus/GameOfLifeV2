package Version_2;

public class Control {
    GUI TheGUI = new GUI();
    int generation[][] = new int[6][6];

    public Control() {
        for (int j = 0; j < generation.length; j++) {
            for (int i = 0; i < generation[j].length; i++) {
                generation[j][i] = 0;
            }
        }

        generation[1][2] = 1;
        generation[3][1] = 1;
        generation[2][2] = 1;
        generation[3][3] = 1;
        generation[4][3] = 1;
        generation[2][4] = 1;
    }

    public void start() {
        TheGUI.showGeneration(generation);
        TheGUI.showGeneration(calcNextGeneration());
        TheGUI.showGeneration(calcNextGeneration());
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
                if (x > 0 && y > 0 && x < 5 && y < 5 && generation[x][y] == 1) {
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
        int holdGeneration[][] = new int[6][6];
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
        generation = holdGeneration;
        return holdGeneration;
    }
}
