package AaronChenTools;

import java.util.Scanner;

import static boilerplate.View.BaseView.log;

public class AskQuection {
    static Scanner input = new Scanner(System.in);

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
}
