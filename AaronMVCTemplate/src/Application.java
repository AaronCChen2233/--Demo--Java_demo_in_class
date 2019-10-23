import boilerplate.Controller.ApplicationController;
import boilerplate.Model.ApplicationModel;
import boilerplate.View.ApplicationView;

public class Application {

    static Application instance;
    ApplicationModel model;
    ApplicationView view;
    ApplicationController controller;
    final static private String _APP_VERSION = "0.0.1";

    Application(String[] args) {
        initialize();
        for (String a : args) {
            controller.addDataToCommandLine(a);
        }
    }

    private void initialize() {
        model = new ApplicationModel();
        view = new ApplicationView();
        controller = new ApplicationController();

        model.setbView(view);
        model.setbController(controller);

        view.setbModel(model);
        view.setbController(controller);

        controller.setbModel(model);
        controller.setbView(view);
    }

    public static void main(String[] args) {
        instance = new Application(args);
        if (args.length == 0) {
            instance.view.ShowBasicUsageInformation();
        } else {
            instance.view.PrintcommandLine();
            instance.model.DoArgument();
        }
    }
}
