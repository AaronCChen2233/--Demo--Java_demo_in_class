import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static boolean isUseUpperLetter = false;
    static boolean isUseLowerLetter = false;
    static boolean isUseNumberLetter = false;
    static int passwordLength = 0;

    public static void main(String[] args) {
        //System.out.println(GeneratePassword());

        /*test data*/
        isUseUpperLetter = true;
        isUseLowerLetter = true;
        isUseNumberLetter = true;
        passwordLength = 6;
        String testPwd = GenerateRandomPassword();
        System.out.println(testPwd);
        input.next();
        MatchPassword(testPwd);

        input.close();
    }

    public static boolean AskYesNoQuestion(String askMessage) {
        String answer;
        boolean yesOrNo = false;
        while (true) {
            System.out.println(askMessage);
            answer = input.nextLine();
            if (answer.toLowerCase().equals("y") || answer.toLowerCase().equals("n")) {
                yesOrNo = answer.toLowerCase().equals("y");
                break;
            } else {
                System.out.println("Please type 'Y' or 'N'");
            }
        }
        return yesOrNo;
    }

    public static int AskIntQuestion(String askMessage) {
        int answer;
        while (true) {
            System.out.println(askMessage);
            if (input.hasNextInt()) {
                answer = input.nextInt();
                break;
            } else {
                System.out.println("Please type a number");
                input.next();
            }
        }
        return answer;
    }

    public static String GetCharBy(char startChar, int nextOfChar) {
        int startint = (int) startChar;
        String generatedString = "";

        for (int i = startint; i < (startint + nextOfChar); i++) {
            generatedString += (char) i;
        }
        return generatedString;
    }

    public static String GeneratePassword() {
        String generatePassword = "";
        while (!isUseUpperLetter && !isUseLowerLetter && !isUseNumberLetter) {
            isUseUpperLetter = AskYesNoQuestion("Do you want to use UpperLetter?(Y/N)");
            isUseLowerLetter = AskYesNoQuestion("Do you want to use LowerLetter?(Y/N)");
            isUseNumberLetter = AskYesNoQuestion("Do you want to use NumberLetter?(Y/N)");
            if (!isUseUpperLetter && !isUseLowerLetter && !isUseNumberLetter) {
                System.out.println("So what do you want?");
            }
        }

        while (passwordLength < 1) {
            passwordLength = AskIntQuestion("How many letters you need?");
            if (passwordLength < 1) {
                System.out.println("Length must greater than 0");
            }
        }

        generatePassword = GenerateRandomPassword();

        return generatePassword;
    }

    private static String GenerateRandomPassword() {
        String generatePassword = "";
        String generateFrom = "";
        Random random = new Random();

        if (isUseUpperLetter) {
            generateFrom += GetCharBy('A', 26);
        }

        if (isUseLowerLetter) {
            generateFrom += GetCharBy('a', 26);
        }

        if (isUseNumberLetter) {
            generateFrom += GetCharBy('0', 10);
        }

        for (int i = 0; i < passwordLength; i++) {
            generatePassword += generateFrom.charAt(random.ints(1, (generateFrom.length())).findFirst().getAsInt());
        }
        return generatePassword;
    }


    public static String MatchPassword(String password) {
        String matchedPassword = "";
        String generateFrom = "";
        generateFrom += GetCharBy('A', 26);
        generateFrom += GetCharBy('a', 26);
        generateFrom += GetCharBy('0', 10);

//        for (int i = 1; i < 3; i++) {
//            MatchPassword("", i, generateFrom, i+1, password);
//        }

        int paswordLength = password.length();
        System.out.println("your password is " + MatchPassword("", paswordLength, generateFrom, paswordLength + 1, password));
        return matchedPassword;
    }

    public static String MatchPassword(String start, int testLength, String generateFrom, int level, String password) {
        String matchedPassword = "" + start;

        if (matchedPassword.equals(password)) {
            return matchedPassword;
        }

        if (matchedPassword.length() >= testLength) {
            System.out.println(matchedPassword);
            return matchedPassword.substring(0, testLength - level);
        }

        level -= 1;
        for (int i = 0; i < generateFrom.length(); i++) {
            matchedPassword = MatchPassword(matchedPassword + generateFrom.charAt(i), testLength, generateFrom, level, password);
            if (matchedPassword.equals(password)) {
                return matchedPassword;
            }
        }

        return matchedPassword.substring(0, testLength - level - 1);
    }


    /*Ivan's Code*/
    public static void permutation(String str) {
        permutation("", str);
    }

    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
        }
    }

}
