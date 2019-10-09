import java.util.Scanner;

public class CheckPalindrome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int ahefOfStringLength = 0;
        String word = "";
        char[] chars;
        boolean isPalindrome = true;
        System.out.print("Please input a word: ");
        word = input.nextLine();
        chars = word.toCharArray();
        ahefOfStringLength = chars.length / 2;
        for (int i = 0; i < ahefOfStringLength; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                isPalindrome = false;
                break;
            }
        }
        System.out.println(isPalindrome ? "It’s a palindrome" : "It’s not a palindrome");
        input.close();
    }
}
