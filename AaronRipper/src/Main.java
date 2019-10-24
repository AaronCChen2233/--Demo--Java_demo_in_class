import boilerplate.Controller.ApplicationController;
import boilerplate.Model.ApplicationModel;
import boilerplate.View.ApplicationView;

import java.util.Random;
import java.util.Scanner;

public class Main {

    static Main instance;
    ApplicationModel model;
    ApplicationView view;
    ApplicationController controller;
    final static private String _APP_VERSION = "0.0.1";

    Main(String[] args) {
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
        instance = new Main(args);
        if (args.length == 0) {
            instance.view.ShowBasicUsageInformation();
            instance.model.Rundefault();
        } else {
            instance.model.DoArgument();
        }

    }
}
