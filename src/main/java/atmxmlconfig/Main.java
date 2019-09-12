package atmxmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("xmlconfig.xml");
        ATMSimulator atmSimulator = context.getBean("atmSimulator", ATMSimulator.class);
        atmSimulator.run();
    }
}
