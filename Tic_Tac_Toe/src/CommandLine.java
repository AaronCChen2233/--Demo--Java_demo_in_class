import com.sun.org.apache.xpath.internal.Arg;

import java.util.ArrayList;
import java.util.Collections;

public class CommandLine {
    String[] Arguments;
    ArrayList<String> Argumentslist = new ArrayList<String>();

    public CommandLine(String[] arguments) {
        Arguments = arguments;
        Collections.addAll(Argumentslist, Arguments);
//        Debug.logInfo("I see arguments: Count(" + arguments.length + ")");
        if (arguments.length == 0) {
            Debug.logWarning("If you wnat run test type -runtest [TestTimes(int)]EX: -runtest 5");
            Debug.logWarning("If you want run as window type -runwindow EX: -runwindow ");
            Debug.logWarning("I see arguments: Count(" + arguments.length + ") we will start this game by use terminal");
        }
    }

    public boolean doesArgumentExists(String argument) {
        for (String agr : Arguments) {
            if (agr.equals(argument)) {
                return true;
            }
        }
        return false;
    }

    public int getArgumentIndex(String argument) {
        for (int i = 0; i < Arguments.length; i++) {
            if (Arguments[i].equals(argument)) {
                return i;
            }
        }
        return -1;
    }
}
