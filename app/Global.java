import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import play.Application;
import play.GlobalSettings;

/**
 * @author gmatsu
 */
public class Global extends GlobalSettings {

  private static ApplicationContext ctx;

  @Override
  public void onStart(Application application) {
    super.onStart(application);
    ctx = new ClassPathXmlApplicationContext("application-context.xml");
  }

  @Override
  public <A> A getControllerInstance(Class<A> aClass) throws Exception {
    return ctx.getBean(aClass);

  }

}
