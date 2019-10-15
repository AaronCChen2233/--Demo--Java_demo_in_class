import java.util.Scanner;

public class CheckPalindrome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int halfOfStringLength = 0;
        String word = "";

        String tryAgainYesNo;
        boolean isPalindrome;
        while (true) {
            isPalindrome = true;

            System.out.print("Please input a word: ");
            word = input.nextLine();

            halfOfStringLength = word.length() / 2;
            for (int i = 0; i < halfOfStringLength; i++) {
                /*here will check opposite char*/
                if (word.toLowerCase().charAt(i) != word.toLowerCase().charAt(word.length() - 1 - i)) {
                    isPalindrome = false;
                    break;
                }
            }
            System.out.println(isPalindrome ? "✔ It’s a palindrome" : "✗ It’s not a palindrome");

            System.out.print("Do you want try again?(Y/N)");
            tryAgainYesNo = input.nextLine();

            if (tryAgainYesNo.toLowerCase().equals("n")) {
                break;
            }
        }
        input.close();

        /*** here have some example
         * Anna
         * Civic
         * Kayak
         * Level
         * Madam
         * Mom
         * Noon
         * Racecar
         * kayak
         */

//        /*This is other way*/
//        char[] chars;
//        chars = word.toCharArray();
//        halfOfStringLength = chars.length / 2;
//
//        for (int i = 0; i < halfOfStringLength; i++) {
//            /*if different it isn't a palindrome*/
//            if (chars[i] != chars[chars.length - 1 - i]) {
//                isPalindrome = false;
//                break;
//            }
//        }

    }
}
