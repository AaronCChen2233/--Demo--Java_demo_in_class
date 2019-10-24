package boilerplate.Model;

import java.util.ArrayList;

public abstract class Argument extends BaseModel {

    ArrayList<String> arguments;
    private boolean hasParamaters;
    private boolean requiresParamaters;
    private String description;
    public ArrayList<String> paramaters = new ArrayList<String>();
    public abstract void DoFunction();

    public void setParamaters(ArrayList<String> paramaters) {
        this.paramaters = paramaters;
    }

    public Argument(ArrayList<String> argument, boolean hasParamaters, boolean requiresParamaters, String description, ArrayList<String> paramaters) {
        this.arguments = argument;
        this.hasParamaters = hasParamaters;
        this.requiresParamaters = requiresParamaters;
        this.description = description;
        this.paramaters = paramaters;
    }

    public Argument(){

    }
}
