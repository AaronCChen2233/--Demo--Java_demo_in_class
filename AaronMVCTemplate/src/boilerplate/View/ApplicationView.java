package boilerplate.View;

import boilerplate.Model.ApplicationModel;

public class ApplicationView extends BaseView {
    public void PrintcommandLine() {
        for (String l : ((ApplicationModel) bModel).commandLine) {
            System.out.println(l);
        }
    }
}
