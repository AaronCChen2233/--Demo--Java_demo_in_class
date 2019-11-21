import Bootstrap.App.EApp;
import Bootstrap.Parts.AbstractBootstrap;
import Bootstrap.Tools.Alog;
import MVVM.Parts.Model.DetectClipboard;
import MVVM.Parts.Model.GetTranslateInfo;

import java.util.Scanner;

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
        DetectClipboard.DetectClipboardThread timeSetter = new DetectClipboard.DetectClipboardThread() {
            @Override
            public void detectClipboardStringChange(String newString) {
                System.out.println(newString);
                GetTranslateInfo.getByVoiceTube(newString);
            }
        };
        Thread t = new Thread(timeSetter);
        t.start();
    }

    @Override
    public void OnShutdown() {

    }

    @Override
    public void OnApplicationUpdate() {
        Scanner input = new Scanner(System.in);
        String exit = input.nextLine();
        if (exit.toLowerCase().equals("exit")) {
            setAppState(EApp.ShuttingDown);
        }
    }
}