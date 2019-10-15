import javax.swing.*;
import java.util.*;

public class GameOfLife {

    public static void main(String[] args) {
        /***
         * test
         * int orangin[][] = {
         *                 {0, 0, 1, 0, 1, 0},
         *                 {0, 0, 0, 1, 1, 0},
         *                 {0, 0, 0, 1, 0, 0},
         *                 {0, 0, 0, 0, 0, 0},
         *                 {0, 0, 0, 0, 0, 0},
         *                 {0, 0, 0, 0, 0, 0},
         *         };
         */

        //Windows test
        JFrame frame = new JFrame("GameOfLifeWindows");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        

        Random r = new Random();
        /*input grid width*/
        Scanner input = new Scanner(System.in);
        System.out.println("Here will create a grid and random origin cell: ");
        System.out.print("Please input grid width : ");
        int gridx = input.nextInt();
        System.out.print("Please input grid height : ");
        int gridy = input.nextInt();

        /*for test size*/
//        int gridx = 20;
//        int gridy = 20;

        int origin[][] = new int[gridx][gridy];
        for (int i = 0; i < gridx; i++) {
            for (int j = 0; j < gridy; j++) {
                origin[i][j] = r.nextInt((1 - 0) + 1) + 0;
            }
        }

        /*for test*/
//        int origin[][] = {
//                {0, 0, 0, 0, 0, 0},
//                {0, 1, 1, 0, 0, 0},
//                {0, 1, 0, 0, 0, 0},
//                {0, 0, 0, 0, 1, 0},
//                {0, 0, 0, 1, 1, 0},
//                {0, 0, 0, 0, 0, 0},
//        };

//        input.close();

        while (true) {
            origin = NextGeneration(origin);
            System.out.println();
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

    public static int[][] NextGeneration(int[][] cells) {
        int[][] next = new int[cells.length][cells[0].length];
        int neighbourAliveCount = 0;

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {

                /*scan it neighbours*/
                neighbourAliveCount = 0;
                for (int y = -1; y < 2; y++) {
                    for (int x = -1; x < 2; x++) {
                        if (x == 0 && y == 0) {
                            /*skip it self*/
                            continue;
                        }

                        int cellx = j + x;
                        int celly = i + y;

                        /*for infinite,te loop*/
                        cellx = cellx < 0 ? cells[i].length - 1 : cellx;
                        cellx = cellx >= cells[i].length ? 0 : cellx;
                        celly = celly < 0 ? cells.length - 1 : celly;
                        celly = celly >= cells.length ? 0 : celly;

                        if (cells[celly][cellx] == 1) {
                            neighbourAliveCount++;
                        }
                    }
                }

                /*Any live cell with fewer than two live neighbours dies, as if by underpopulation.*/
                if (neighbourAliveCount < 2) {
                    next[i][j] = 0;
                    continue;
                }

                /*Any live cell with two or three live neighbours lives on to the next generation.*/
                if (neighbourAliveCount == 2) {
                    next[i][j] = cells[i][j];
                    continue;
                }

                /*Any live cell with more than three live neighbours dies, as if by overpopulation.*/
                if (neighbourAliveCount > 3) {
                    next[i][j] = 0;
                    continue;
                }

                /*Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.*/
                if (neighbourAliveCount == 3) {
                    next[i][j] = 1;
                    continue;
                }
            }
        }

        /*output*/
        for (int i = 0; i < next.length; i++) {
            for (int j = 0; j < next[i].length; j++) {
                System.out.print(next[i][j]);
            }
            System.out.println();
        }

        return next;
    }
}
