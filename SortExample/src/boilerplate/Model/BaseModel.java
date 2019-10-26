package boilerplate.Model;

import boilerplate.Controller.BaseController;
import boilerplate.View.BaseView;

import java.util.ArrayList;

public class BaseModel {
    BaseController bController;
    BaseView bView;

    public void setbController(BaseController bController) {
        this.bController = bController;
    }

    public void setbView(BaseView bView) {
        this.bView = bView;
    }
}
