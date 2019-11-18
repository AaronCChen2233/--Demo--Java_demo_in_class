import Bootstrap.Parts.AbstractBootstrap;
import Bootstrap.Tools.Alog;

public class App extends AbstractBootstrap {
    static App app;
    public App(String[] CommandLineArguments) {
        super(CommandLineArguments);
    }

    public static void main(String[] args) {
        Alog.logStartup("Started App Main");
        app = new App(args);
    }
}