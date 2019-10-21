import java.util.*;

public class GameOfLife {
    private static int generationTimes = 0;

    public static void main(String[] args) throws InterruptedException {
        /*input grid width*/
        Scanner input = new Scanner(System.in);
        System.out.println("Here will create a grid and random origin cell");
        System.out.print("Please input grid width : ");
        int gridx = input.nextInt();
        System.out.print("Please input grid height : ");
        int gridy = input.nextInt();
        System.out.print("Please input percent which is for create random alive cell : ");
        int percent = input.nextInt();
        System.out.print("Please input max generation times (if you want infinite please type -1): ");
        int maxGenerationTimes = input.nextInt();

        int[][] origin = CreateRandomCellGrid(gridy, gridx, percent);

        /*for test date*/
//        int origin[][] = {
//                {0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 1, 0, 0},
//                {0, 1, 0, 0, 1, 0},
//                {0, 1, 0, 0, 1, 0},
//                {0, 0, 1, 0, 0, 0},
//        };

//        input.close();
        while (true) {
            System.out.println(generationTimes);
            OutputCellPlayGrid(origin);
            origin = NextGeneration(origin);

            if (generationTimes == maxGenerationTimes) {
                System.out.println("Ooops is time to stop!");
                break;
            }

            if (!CheckAllCellAlive(origin)) {
                System.out.println("Ooops All cells are dead");
                break;
            }

            Thread.sleep(350);
            generationTimes++;
        }
    }

    /***
     * Any live cell with fewer than two live neighbours dies, as if by underpopulation.
     * Any live cell with two or three live neighbours lives on to the next generation.
     * Any live cell with more than three live neighbours dies, as if by overpopulation.
     * Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
     * @param cells
     * @return
     */

    public static int[][] NextGeneration(int[][] cells) throws InterruptedException {
        int[][] next = new int[cells.length][cells[0].length];
        int neighbourAliveCount = 0;

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {

                /*scan it neighbours*/
                neighbourAliveCount = GetNeighbourAliveCount(cells, i, j);

                /* Rule1
                Any live cell with fewer than two live neighbours dies, as if by underpopulation.*/
                if (neighbourAliveCount < 2) {
                    next[i][j] = 0;
                    continue;
                }

                /*Rule2
                Any live cell with two or three live neighbours lives on to the next generation.*/
                if (neighbourAliveCount == 2 || neighbourAliveCount == 3) {
                    next[i][j] = cells[i][j];

                    /*Rule4
                    Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.*/
                    if (neighbourAliveCount == 3) {
                        next[i][j] = 1;
                    }
                    continue;
                }

                /*Rule3
                Any live cell with more than three live neighbours dies, as if by overpopulation.*/
                if (neighbourAliveCount > 3) {
                    next[i][j] = 0;
                    continue;
                }
            }
        }
        return next;
    }

    private static int GetNeighbourAliveCount(int[][] cells, int i, int j) {
        int neighbourAliveCount = 0;
        /*scan neighbour in 3*3 */
        for (int y = -1; y < 2; y++) {
            for (int x = -1; x < 2; x++) {

                /*skip it self*/
                if (x == 0 && y == 0) {
                    continue;
                }

                int cellx = j + x;
                int celly = i + y;

                /*for infinite loop*/
                cellx = cellx < 0 ? cells[i].length - 1 : cellx;
                cellx = cellx >= cells[i].length ? 0 : cellx;
                celly = celly < 0 ? cells.length - 1 : celly;
                celly = celly >= cells.length ? 0 : celly;

                /*1 is alive*/
                if (cells[celly][cellx] == 1) {
                    neighbourAliveCount++;
                }
            }
        }
        return neighbourAliveCount;
    }

    private static void OutputCellPlayGrid(int[][] next) {
        /*for convert to String, for clear to see*/
        String[][] nextStr = new String[next.length][next[0].length];
        for (int i = 0; i < next.length; i++) {
            for (int j = 0; j < next[i].length; j++) {
                nextStr[i][j] = next[i][j] == 0 ? " " : "■";
            }
            System.out.print(Arrays.toString(nextStr[i]));
            System.out.println();
        }
//        String outputString = "";
//        for (int i = 0; i < next.length; i++) {
//            for (int j = 0; j < next[i].length; j++) {
//                outputString += next[i][j] == 0 ? " ☐" : " \uD83C\uDD70";
//            }
//            outputString += "\n";
//        }
//        System.out.println(outputString);
    }

    private static int[][] CreateRandomCellGrid(int gridx, int gridy, int precent) {

        int origin[][] = new int[gridx][gridy];
        for (int i = 0; i < gridx; i++) {
            for (int j = 0; j < gridy; j++) {
                origin[i][j] = RandomBooleanByPercent(precent) ? 1 : 0;
            }
        }
        return origin;
    }

    private static boolean RandomBooleanByPercent(int percent) {
        Random r = new Random();
        return ((r.nextInt(100) + 1) <= percent);
    }

    private static boolean CheckAllCellAlive(int[][] cells) {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (cells[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void CleanScreen() {
        for (int i = 0; i <= 100; i++) {
            System.out.println();
        }
    }
}
