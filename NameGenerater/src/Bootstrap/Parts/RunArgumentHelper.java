package Bootstrap.Parts;

import Bootstrap.Tools.Alog;

public class RunArgumentHelper implements IArgumentHelper {
    @Override
    public void showArgumentHelper() {
        Alog.logWarning("Argument not found");
        Alog.logWarning("Run NameGenerater please type -run [generateCount]");
        Alog.logWarning("EX: -run 100");
    }
}
