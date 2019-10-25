package boilerplate.Model;

import java.util.ArrayList;
import java.util.Arrays;

public class ApplicationModel extends BaseModel {
    public ArrayList<String> commandLine = new ArrayList<String>();
    private LogTestArgument logTestArgument;
    private RipperArgument ripperArgument;

    public ArrayList getCommandLine() {
        return commandLine;
    }

    public void setCommandLine(ArrayList commandLine) {
        this.commandLine = commandLine;
    }

    public void DoArgument() {
        commandLine.add("-");
        logTestArgument = new LogTestArgument(new ArrayList<String>(Arrays.asList("logtest", "lt")), false, false, "This is log Test Argument", new ArrayList<>());
        ripperArgument = new RipperArgument(new ArrayList<String>(Arrays.asList("generate", "Generate", "Byask", "byask", "AaronRipper", "aaronpipper")), false, false, "This is log Test Argument", new ArrayList<>());

        ArrayList<String> tempParamaters = new ArrayList<String>();
        String ThisArgument = "-";

        for (String c : commandLine) {
            /*if commandLine have switch which mean it is a Argument if not is Paramater*/
            if (!Switchs.allownSwitch.contains(c.charAt(0))) {
                tempParamaters.add(c);

            } else {
                if (logTestArgument.arguments.contains(ThisArgument.substring(1, ThisArgument.length()))) {
                    logTestArgument.setParamaters(tempParamaters);
                    logTestArgument.DoFunction();
                }
                if (ripperArgument.arguments.contains(ThisArgument.substring(1, ThisArgument.length()))) {
                    switch (ThisArgument.substring(1, ThisArgument.length())) {
                        case "generate":
                        case "Generate": {
                            ripperArgument.setParamaters(tempParamaters);
                            ripperArgument.DoFunction();
                            break;
                        }
                        case "Byask":
                        case "byask": {
                            ripperArgument.GeneratePasswordByAsk();
                            break;
                        }
                        case "aaronpipper":
                        case "AaronRipper": {
                            ripperArgument.setParamaters(tempParamaters);
                            ripperArgument.AaronRipper();
                            break;
                        }
                    }
                }

                tempParamaters = new ArrayList<String>();
                ThisArgument = c;
            }
        }
    }

    public void Rundefault() {
        ripperArgument = new RipperArgument();
        ripperArgument.GenerateAllPassword();
//        ripperArgument.GeneratePasswordByAsk();
    }
}
