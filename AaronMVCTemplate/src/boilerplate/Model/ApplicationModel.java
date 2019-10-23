package boilerplate.Model;

import java.util.ArrayList;

public class ApplicationModel extends BaseModel {
    public ArrayList<String> commandLine = new ArrayList<String>();

    public ArrayList getCommandLine() {
        return commandLine;
    }

    public void setCommandLine(ArrayList commandLine) {
        this.commandLine = commandLine;
    }
}
