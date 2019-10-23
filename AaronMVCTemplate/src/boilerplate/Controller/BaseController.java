package boilerplate.Controller;

import boilerplate.Model.BaseModel;
import boilerplate.View.BaseView;

public class BaseController {
    BaseModel bModel;
    BaseView bView;

    public void setbModel(BaseModel bModel) {
        this.bModel = bModel;
    }

    public void setbView(BaseView bView) {
        this.bView = bView;
    }

}
