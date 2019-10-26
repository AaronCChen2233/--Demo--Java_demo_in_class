package boilerplate.View;

import boilerplate.Model.ApplicationModel;

public class ApplicationView extends BaseView {
    public void PrintcommandLine() {
        for (String l : ((ApplicationModel) bModel).commandLine) {
            System.out.println(l);
        }
    }

    public void ShowBasicUsageInformation() {
//        log(2, "You can try put some args EX: -? -h -c");
//        log(2, "You can try -logtest");
        log(2, "EX: -quicksort 5 1 3 6 9 8 7 5 2 4");
        log(2, "EX: -selectionsort 5 1 3 6 9 8 7 5 2 4");
    }
}
