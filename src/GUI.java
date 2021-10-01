package Version_2.src;

public class GUI {

    public void showGeneration(int pCount, int[][] pGeneration) {

        System.out.println("Generation: " + pCount);
        for (int i = 0; i < pGeneration.length; i++) {
            for (int j = 0; j < pGeneration[i].length; j++) {
                System.out.print(pGeneration[i][j] + " ");
                if (j == pGeneration[i].length - 1) {
                    System.out.print("\n");
                }
            }
        }
    }
}
