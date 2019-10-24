package boilerplate.Model;

import boilerplate.View.ApplicationView;

import java.util.*;

import static boilerplate.View.BaseView.log;
/*
 * 1) Create a program that generates the alphabet from a to z
 * 2) Extend that program to create a 'word' that contains random characters
 * 3) Extend that program to create a 'word' that is between min length and max length in size
 * 4) Extend that program to include Numbers from 0 - 1 as well
 * 5) Extend that program to only include letters/numbers from which we specify
 * 6) Create a program that tells if a word is a palindrome or not
 * 7) Create a program that 'reverses' the word
 * */

public class RipperArgument extends Argument {

    static Scanner input = new Scanner(System.in);

    /*If user did given those property use default setting */
    static boolean isUseUpperLetter = true;
    static boolean isUseLowerLetter = true;
    static boolean isUseNumberLetter = true;
    static boolean isUsePalindrome = false;
    static boolean isGenerateReverses = false;
    static boolean isAllowSpecifyWordGreaterThanMaxLength = false;
    static int passwordMinLength = 8;
    static int passwordMaxLength = 8;
    static int generateCount = 10;
    static String specifyWord = "abc";

    public RipperArgument(ArrayList<String> argument, boolean hasParamaters, boolean requiresParamaters, String description, ArrayList<String> paramaters) {
        super(argument, hasParamaters, requiresParamaters, description, paramaters);
    }

    RipperArgument() {
        super();
    }

    @Override
    public void DoFunction() {
        try {
            isUseUpperLetter = paramaters.get(0).toLowerCase().equals("y");
            isUseLowerLetter = paramaters.get(1).toLowerCase().equals("y");
            isUseNumberLetter = paramaters.get(2).toLowerCase().equals("y");
            isUsePalindrome = paramaters.get(3).toLowerCase().equals("y");
            isGenerateReverses = paramaters.get(4).toLowerCase().equals("y");
            passwordMinLength = Integer.valueOf(paramaters.get(5));
            passwordMaxLength = Integer.valueOf(paramaters.get(6));
            generateCount = Integer.valueOf(paramaters.get(7));
            specifyWord = paramaters.size() <= 8 ? "" : paramaters.get(8);
        } catch (Exception ex) {
            log(2, "Ooops that something wrong");
            log(1, "You can type -Run [use upper letter? (y/n)] [use lower letter? (y/n)] [use number? (y/n)] [use palindrome? (y/n)] [generate reverses ? (y/n)] [min Length(int)] [max Length(int)] [generate count(int)] [specify word(String)]");
            log(1, "EX: -generate y y y n n 8 8 10 abc");
            log(1,"But don't worry we will ask you some question then generate passwords ");
            GeneratePasswordByAsk();
        }
        for (int i = 0; i < generateCount; i++) {
            log(1, "Generate password " + (i + 1) + ": " + GenerateARandomPassword());
        }
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

    public static boolean AskYesNoQuestion(String askMessage, String trueString, String falseString) {
        String answer;
        boolean yesOrNo = false;
        while (true) {
            System.out.println(askMessage);
            answer = input.nextLine();
            if (answer.toLowerCase().equals(trueString.toLowerCase()) || answer.toLowerCase().equals(falseString.toLowerCase())) {
                yesOrNo = answer.toLowerCase().equals(trueString.toLowerCase());
                break;
            } else {
                log(2, String.format("Please type '%1$s' or '%2$s'", trueString, falseString));
            }
        }
        return yesOrNo;
    }

    public static int AskNumberQuestion(String askMessage) {
        int answer;
        while (true) {
            System.out.println(askMessage);
            if (input.hasNextInt()) {
                answer = input.nextInt();
                break;
            } else {
                log(2, "Please type a number");
                input.next();
            }
        }
        return answer;
    }

    public static String AskStringQuestion(String askMessage) {
        String answer;
        System.out.println(askMessage);
        answer = input.nextLine();

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

    public static String ShuffleString(String oString) {
        String out = "";
        List<String> shuffleList = Arrays.asList(oString.split(""));
        Collections.shuffle(shuffleList);
        for (String s : shuffleList) {
            out += s;
        }
        return out;
    }

    public static void GeneratePasswordByAsk() {
        String generatePassword = "";

        do {
            isUseUpperLetter = AskYesNoQuestion("Do you want to use UpperLetter?(Y/N)", "Y", "N");
            isUseLowerLetter = AskYesNoQuestion("Do you want to use LowerLetter?(Y/N)", "Y", "N");
            isUseNumberLetter = AskYesNoQuestion("Do you want to use NumberLetter?(Y/N)", "Y", "N");
            specifyWord = AskStringQuestion("Please type specify Word if you want");

            if (!isUseUpperLetter && !isUseLowerLetter && !isUseNumberLetter && specifyWord.equals("")) {
                System.out.println("So what do you want?");
            }
        } while (!isUseUpperLetter && !isUseLowerLetter && !isUseNumberLetter && specifyWord.equals(""));

        isUsePalindrome = AskYesNoQuestion("Is Palindrome?(Y/N)", "Y", "N");

        /*If not palindrome ask should it generate Reverses version, Because if is palindrome reversed is same*/
        if (!isUsePalindrome) {
            isGenerateReverses = AskYesNoQuestion("Do you want reverses version?(Y/N)", "Y", "N");
        }

        do {
            passwordMinLength = AskNumberQuestion("At less how many letters you need?");
            if (passwordMinLength < 1) {
                log(2, "Length must greater than 0");
            }
        } while (passwordMinLength < 1);

        boolean isSpecifyWordGreaterThanMaxLength = false;
        do {
            passwordMaxLength = AskNumberQuestion("how many letters you need? (The max)");

            /*if user put some specify word he need and max length shorter than specify words show warn*/
            if (!specifyWord.equals("") && passwordMaxLength < specifyWord.length()) {
                isSpecifyWordGreaterThanMaxLength = true;
                input.nextLine();
                log(2, "Because you have some specify words but your password max length shorter than specify words");
                isAllowSpecifyWordGreaterThanMaxLength = AskYesNoQuestion("May some of specify words won't appear Is that OK?(Y/N)", "Y", "N");
            } else {
                isSpecifyWordGreaterThanMaxLength = false;
            }

            if (passwordMaxLength < passwordMinLength) {
                log(2, "The max length must greater than or equal to min length");
            }
        } while (passwordMaxLength < passwordMinLength || (isSpecifyWordGreaterThanMaxLength && !isAllowSpecifyWordGreaterThanMaxLength));

        do {
            generateCount = AskNumberQuestion("How many passwords you need?");
            if (generateCount < 1) {
                log(2, "count must greater than 0");
            }
        } while (generateCount < 1);

        GenerateAllPassword();

        log(5, "Thank for use AaronPassword Generater hope you enjoy!");

        input.close();
    }

    public static void GenerateAllPassword() {
        String generatePassword;
        ArrayList<String> generatedStrings = new ArrayList<String>();
        for (int i = 0; i < generateCount; i++) {
            generatePassword = GenerateARandomPassword();
            log(1, "Generate password " + (i + 1) + ": " + generatePassword);
            generatedStrings.add(generatePassword);
        }

        if (isGenerateReverses) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < generatedStrings.size(); i++) {
                stringBuilder = new StringBuilder(generatedStrings.get(i));
                log(1, "Generate password " + (i + 1) + " (reverse version): " + stringBuilder.reverse());
            }
        }
    }

    private static String GenerateARandomPassword() {
        String generatePassword = "";
        String generateFrom = "";
        boolean isOdd = false;
        Random random = new Random();
        int passwordLength = random.nextInt((passwordMaxLength - passwordMinLength) + 1) + passwordMinLength;

        /*if allow specify word greater than max length just use specify word*/
        if (isAllowSpecifyWordGreaterThanMaxLength) {
            generateFrom = specifyWord;
        } else {
            if (isUseUpperLetter) {
                generateFrom += GetCharBy('A', 26);
            }

            if (isUseLowerLetter) {
                generateFrom += GetCharBy('a', 26);
            }

            if (isUseNumberLetter) {
                generateFrom += GetCharBy('0', 10);
            }
        }

        for (int i = 0; i < passwordLength - specifyWord.length(); i++) {
            generatePassword += generateFrom.charAt(random.ints(1, (generateFrom.length())).findFirst().getAsInt());
        }
        generatePassword += specifyWord;
        generatePassword = ShuffleString(generatePassword);

        if (isUsePalindrome) {
            isOdd = passwordLength % 2 != 0;
            /*get helf*/
            generatePassword = generatePassword.substring(0, passwordLength / 2);
            StringBuilder stringBuilder = new StringBuilder(generatePassword);
            String reversesPart = stringBuilder.reverse().toString();
            if (isOdd) {
                char generateChar = generateFrom.charAt(random.ints(1, (generateFrom.length())).findFirst().getAsInt());
                generatePassword += generateChar + reversesPart;
            } else {
                generatePassword += reversesPart;
            }
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
}
