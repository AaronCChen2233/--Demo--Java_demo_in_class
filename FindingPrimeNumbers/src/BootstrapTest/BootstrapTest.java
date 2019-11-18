package BootstrapTest;

import Bootstrap.Tools.Alog;
import Bootstrap.App.Bootstrap;
public class BootstrapTest extends Bootstrap {
    public BootstrapTest(String[] CommandLineArguments) {
        super(CommandLineArguments);
    }

    public static void main(String[] args) {
        Alog.logStartup("Started BootstrapTest Main");
        BootstrapTest bootstrapTest = new BootstrapTest(args);
    }

    @Override
    public void OnInitialized() {

    }

    @Override
    public void OnShutdown() {

    }

    @Override
    public void OnApplicationUpdate() {

    }
}
