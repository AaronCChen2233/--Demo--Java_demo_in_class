package boilerplate.Model;

import boilerplate.View.ApplicationView;

import java.util.ArrayList;
import java.util.Arrays;

public class ApplicationModel extends BaseModel {
    public ArrayList<String> commandLine = new ArrayList<String>();
    private LogTestArgument logTestArgument;

    public ArrayList getCommandLine() {
        return commandLine;
    }

    public void setCommandLine(ArrayList commandLine) {
        this.commandLine = commandLine;
    }

    public void DoArgument() {
        logTestArgument = new LogTestArgument(new ArrayList<String>(Arrays.asList("-logtest")),false,false,"This is log Test Argument",new ArrayList<>());
        for (String c : commandLine) {
            /*if commandLine have switch which mean it is a Argument*/
            if(Switchs.allownSwitch.contains(c.charAt(0))){
               if( logTestArgument.arguments.contains(c)){
                   logTestArgument.DoFunction();
               }

            }
        }
    }
}
