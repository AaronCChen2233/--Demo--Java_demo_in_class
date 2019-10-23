package boilerplate.View;

import boilerplate.Controller.BaseController;
import boilerplate.Model.BaseModel;

import java.util.Date;

public class BaseView {
    BaseController bController;
    BaseModel bModel;

    final static private Date date=new java.util.Date();
    final static private int _STARTUP = 0;
    final static private int _INFO = 1;
    final static private int _WARN = 2;
    final static private int _ERROR = 3;
    final static private int _EXCEPTION = 4;
    final static private int _SHUTDOWN = 5;

    final static public void log(int level, String message) {
        switch (level) {
            case 0: {
                System.out.println("[" + date + "]" + " - [Startup] - " + message);
                break;
            }
            case 1: {
                System.out.println("[" + date + "]" + " - [Info] - " + message);
                break;
            }
            case 2: {
                System.out.println("[" + date + "]" + " - [Warning] - " + message);
                break;
            }
            case 3: {
                System.out.println("[" + date + "]" + " - [Error] - " + message);
                break;
            }
            case 4: {
                System.out.println("[" + date + "]" + " - [Exception] - " + message);
                break;
            }
            case 5: {
                System.out.println("[" + date + "]" + " - [Shutdown] - " + message);
                break;
            }
            default: {
                System.out.println("[" + date + "]" + " - [Unknown] - " + message);
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
