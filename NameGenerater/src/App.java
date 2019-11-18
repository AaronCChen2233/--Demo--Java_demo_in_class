import Bootstrap.App.EApp;
import Bootstrap.Parts.AbstractBootstrap;
import Bootstrap.Parts.EArgument;
import Bootstrap.Parts.RunArgumentHelper;
import Bootstrap.Tools.Alog;
import MVVM.Parts.Model.NameGeneraterModel;

public class App extends AbstractBootstrap {
    static App app;
    public App(String[] CommandLineArguments) {
        super(CommandLineArguments);
    }

    public static void main(String[] args) {
        Alog.logStartup("Started App Main");
        app = new App(args);
    }

    @Override
    public void OnInitialized() {

    }

    @Override
    public void OnShutdown() {

    }

    @Override
    public void OnApplicationUpdate() {
        if (argumentAndParamaters.size() > 0) {
            argumentAndParamaters.forEach((k, v) -> {
                EArgument eArgument = null;
                try {
                    k = k.replace("-", "");
                    k = k.toLowerCase();
                    eArgument = EArgument.valueOf(k);
                } catch (Exception ex) {

                }

                if (eArgument != null) {
                    switch (eArgument) {
                        case run:
                            NameGeneraterModel sieveofEratosthenes = new NameGeneraterModel();
                            sieveofEratosthenes.Run(Integer.parseInt(v));
                            break;
                        case runwindow:
                            /*window version coming soon*/
                            break;
                    }
                }
            });
        } else {
            /*No Argument*/
            RunArgumentHelper runArgumentHelper = new RunArgumentHelper();
            runArgumentHelper.showArgumentHelper();
        }

        setAppState(EApp.ShuttingDown);
    }
}