package controllers;

import managers.CustomerResourceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * @author: gmatsu
 */
@Component
public class CustomerController extends Controller {

  @Autowired
  private CustomerResourceManager customerResourceManager;

  public Result index(){

    return ok();
  }


  public Result merge(){

    return ok();
  }





}
