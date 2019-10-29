import com.sun.org.apache.xpath.internal.Arg;

import java.util.ArrayList;
import java.util.Collections;

public class CommandLine {
    String[] Arguments;
    ArrayList<String> Argumentslist = new ArrayList<String>();

    public CommandLine(String[] arguments) {
        Arguments = arguments;
        Collections.addAll(Argumentslist, Arguments);
        Debug.logInfo("I see arguments: Count(" + arguments.length + ")");
        if (arguments.length == 0) {
            Debug.logWarning("I see arguments: Count(" + arguments.length + ") you can try -runtest [testTimes (int)]");
            Debug.logWarning("EX: -runtest 5");
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
