import java.util.Random;

public class PasswordGenerator {

    public static String[] GenerateRandomPasswords(int passwordMinLength, int passwordMaxLength, boolean isUseLowerLetter, boolean isUseUpperLetter, boolean isUseNumberLetter, int count) {
        String[] passwords = new String[count];
        for (int i = 0; i < count; i++) {
            passwords[i] = GenerateARandomPassword(passwordMinLength, passwordMaxLength, isUseLowerLetter, isUseUpperLetter, isUseNumberLetter);
        }
        return passwords;
    }

    private static String GenerateARandomPassword(int passwordMinLength, int passwordMaxLength, boolean isUseLowerLetter, boolean isUseUpperLetter, boolean isUseNumberLetter) {
        String generatePassword = "";
        String generateFrom = "";
        boolean isOdd = false;
        Random random = new Random();
        int passwordLength = random.nextInt((passwordMaxLength - passwordMinLength) + 1) + passwordMinLength;


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

    private static String Palindrome(String generatePassword, String generateFrom, int passwordLength) {
        Random random = new Random();
        boolean isOdd;
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
        return generatePassword;
    }

    public static String GetCharBy(char startChar, int nextOfChar) {
        int startint = (int) startChar;
        String generatedString = "";

        for (int i = startint; i < (startint + nextOfChar); i++) {
            generatedString += (char) i;
        }
        return generatedString;
    }


}
