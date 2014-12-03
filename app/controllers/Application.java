package controllers;

import org.springframework.stereotype.Component;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

@Component
public class Application extends Controller {

    public Result index() {
        return ok(index.render("Your new application is ready."));
    }

}
