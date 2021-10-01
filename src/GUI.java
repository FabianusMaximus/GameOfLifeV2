package Version_2.src;

public class GUI {

    public void showGeneration(int[][] pGeneration) {
        System.out.println("-----------------------------------------");
        for (int i = 0; i < pGeneration.length; i++) {
            for (int j = 0; j < pGeneration[i].length; j++) {
                System.out.print(pGeneration[i][j] + "\t");
                if (j == pGeneration[i].length - 1) {
                    System.out.print("\n");
                }
            }
        }
    }
}
