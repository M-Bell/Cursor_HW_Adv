package HW_4.Java_Config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public record CalculatorJava(int a, int b) {

    public void run() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("HW_4.Java_Config");

        if (a > b) {
            MinusServiceJava minusService = (MinusServiceJava) applicationContext.getBean("minusServiceJava");
            System.out.println(a + " - " + b + " = " + minusService.subtract(a, b));
        } else {
            PlusServiceJava plusService = (PlusServiceJava) applicationContext.getBean("plusServiceJava");
            System.out.println(a + " + " + b + " = " + plusService.add(a, b));
        }
    }
}
