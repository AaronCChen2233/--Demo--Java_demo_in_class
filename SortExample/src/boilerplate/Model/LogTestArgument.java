package boilerplate.Model;

import java.util.ArrayList;

public class LogTestArgument extends Argument {

    public LogTestArgument(ArrayList<String> argument, boolean hasParamaters, boolean requiresParamaters, String description, ArrayList<String> paramaters) {
        super(argument, hasParamaters, requiresParamaters, description, paramaters);
    }

    @Override
    public void DoFunction() {
        for (int i = 0; i < 6; i++) {
            bView.log(i, "This is test for different type "+ this.paramaters.toString());
        }
    }
}
