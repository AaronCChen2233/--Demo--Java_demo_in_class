package boilerplate.View;

import boilerplate.Controller.BaseController;
import boilerplate.Model.BaseModel;

import java.util.Date;

public class BaseView {
    BaseController bController;
    BaseModel bModel;

    final static private Date date = new java.util.Date();
    final static private int _STARTUP = 0;
    final static private int _INFO = 1;
    final static private int _WARN = 2;
    final static private int _ERROR = 3;
    final static private int _EXCEPTION = 4;
    final static private int _SHUTDOWN = 5;

    final static public void log(int level, String message) {
        switch (level) {
            case 0: {
                System.out.println("[" + date + "]" + " - " + (char) 27 + "[44m" + "[Startup]" + (char) 27 + "[0m" + " - " + message);
                break;
            }
            case 1: {
                System.out.println("[" + date + "]" + " - " + (char) 27 + "[34m" + "[Info]" + (char) 27 + "[0m" + " - " + message);
                break;
            }
            case 2: {
                System.out.println("[" + date + "]" + " - " + (char) 27 + "[33m" + "[Warning]" + (char) 27 + "[0m" + " - " + message);
                break;
            }
            case 3: {
                System.out.println("[" + date + "]" + " - " + (char) 27 + "[31m" + "[Error]" + (char) 27 + "[0m" + " - " + message);
                break;
            }
            case 4: {
                System.out.println("[" + date + "]" + " - " + (char) 27 + "[47m" + "[Exception]" + (char) 27 + "[0m" + " - " + message);
                break;
            }
            case 5: {
                System.out.println("[" + date + "]" + " - "+ (char) 27 + "[41m" + "[Shutdown]"+ (char) 27 + "[0m" + " - " + message);
                break;
            }
            default: {
                System.out.println("[" + date + "]" + " - "+ (char) 27 + "[0;97m" + "[Unknown]"+ (char) 27 + "[0m" + " - " + message);
                break;
            }

        }
    }

    public void setbController(BaseController bController) {
        this.bController = bController;
    }

    public void setbModel(BaseModel bModel) {
        this.bModel = bModel;
    }


}
