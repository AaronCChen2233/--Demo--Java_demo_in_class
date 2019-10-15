public class TwoDArrayOutput {
    public static void main(String[] args) {
        int[][] twoDarray = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}};
        for (int i = 0; i < twoDarray.length; i++) {
            for (int j = 0; j < twoDarray[i].length; j++) {
                System.out.print(twoDarray[i][j]);
                // if isn't the last one add ","
                if (j + 1 < twoDarray[i].length) {
                    System.out.print(",");
                }
            }
            System.out.println();
        }
    }
}
