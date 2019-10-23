package boilerplate.Controller;

import boilerplate.Model.ApplicationModel;
import boilerplate.View.ApplicationView;

public class ApplicationController extends BaseController {

    public ApplicationController(ApplicationView appView, ApplicationModel appModel) {

        this.bView = appView;
        this.bModel = appModel;
    }

    public ApplicationController(){

    }

    public void addDataToCommandLine(String date) {
        ((ApplicationModel)bModel).commandLine.add(date);
    }
}
