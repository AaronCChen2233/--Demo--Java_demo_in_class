package boilerplate.View;

import boilerplate.Model.ApplicationModel;

public class ApplicationView extends BaseView {
    public void PrintcommandLine() {
        for (String l : ((ApplicationModel) bModel).commandLine) {
            System.out.println(l);
        }
    }

    public void ShowBasicUsageInformation() {
        log(1, "You can type -Generate [use upper letter? (y/n)] [use lower letter? (y/n)] [use number? (y/n)] [use palindrome? (y/n)] [generate reverses ? (y/n)] [min Length(int)] [max Length(int)] [generate count(int)] [specify word(String)]");
        log(1, "EX: -Generate y y y n n 8 8 3 abc");
        log(1, "You can use '-byask' we will ask you some question then generate password");
        log(1, "You can type -AaronRipper [Password Length(int)] [specify word(String)]");
        log(1, "EX: -AaronRipper 3 @#$");
        log(1, "Here is we generate use default Setting");
    }
}
