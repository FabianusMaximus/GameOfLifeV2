package Version_2;

public class GUI {
    int generation = 0;

    public void showGeneration(int[][] pGeneration) {

        System.out.println("Generation: " + generation);
        for (int i = 0; i < pGeneration.length; i++) {
            for (int j = 0; j < pGeneration[i].length; j++) {
                System.out.print(pGeneration[i][j] + " ");
                if (j == pGeneration[i].length - 1) {
                    System.out.print("\n");
                }
            }
        }
        generation++;
    }
}
