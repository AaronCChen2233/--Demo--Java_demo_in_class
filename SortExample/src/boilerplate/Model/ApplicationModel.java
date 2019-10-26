package boilerplate.Model;

import boilerplate.View.ApplicationView;

import java.util.ArrayList;
import java.util.Arrays;

public class ApplicationModel extends BaseModel {
    public ArrayList<String> commandLine = new ArrayList<String>();
    private LogTestArgument logTestArgument;
    private SortArgument sortArgument;

    public ArrayList getCommandLine() {
        return commandLine;
    }

    public void setCommandLine(ArrayList commandLine) {
        this.commandLine = commandLine;
    }

    public void DoArgument() {
        commandLine.add("-");
        logTestArgument = new LogTestArgument(new ArrayList<String>(Arrays.asList("logtest", "lt")), false, false, "This is log Test Argument", new ArrayList<>());
        sortArgument = new SortArgument(new ArrayList<String>(Arrays.asList("quicksort","selectionsort")),false,false,"This is sort Argument", new ArrayList<>());
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
                if (sortArgument.arguments.contains(ThisArgument.substring(1, ThisArgument.length()))) {
                    sortArgument.setParamaters(tempParamaters);
                    switch (ThisArgument.substring(1, ThisArgument.length())) {
                        case "quicksort":{
                            sortArgument.QuickSort();
                            break;
                        }
                        case "selectionsort":{
                            sortArgument.SelectionSort();
                            break;
                        }
                    }

                }

                tempParamaters = new ArrayList<String>();
                ThisArgument = c;
            }
        }
    }
}
