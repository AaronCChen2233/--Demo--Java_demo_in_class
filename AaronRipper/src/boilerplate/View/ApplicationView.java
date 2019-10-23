package boilerplate.View;

import boilerplate.Model.ApplicationModel;

public class ApplicationView extends BaseView {
    public void PrintcommandLine() {
        for (String l : ((ApplicationModel) bModel).commandLine) {
            System.out.println(l);
        }
    }

    public void ShowBasicUsageInformation() {
        log(2, "You can try put some args EX: -? -h -c");
        log(2, "You can try -logtest");
    }
}
