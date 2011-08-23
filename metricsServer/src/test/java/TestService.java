import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestService {

	@Test
	public void testService() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
		//Service s = (Service) ctx.getBean(Service.class);
		//s.getDatos();
	}
}
