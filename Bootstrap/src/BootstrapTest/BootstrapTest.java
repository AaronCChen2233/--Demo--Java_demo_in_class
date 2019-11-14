package BootstrapTest;

import Bootstrap.App.Bootstrap;
import Bootstrap.Tools.Alog;

public class BootstrapTest extends Bootstrap {
    public BootstrapTest(String[] CommandLineArguments) {
        super(CommandLineArguments);
    }

    public static void main(String[] args) {
        Alog.logStartup("Started BootstrapTest Main");
    }
}
