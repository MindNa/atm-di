package atmjavaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import resources.Javaconfig;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Javaconfig.class);
        ATMSimulator atmSimulator = context.getBean(ATMSimulator.class);
        atmSimulator.run();
    }
}
