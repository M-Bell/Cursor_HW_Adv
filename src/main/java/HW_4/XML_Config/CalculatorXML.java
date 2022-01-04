package HW_4.XML_Config;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public record CalculatorXML(int a, int b) {

    public void run() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("bean-factory.xml");

        if (a > b) {
            MinusServiceXML minusService = (MinusServiceXML) beanFactory.getBean("minusService");
            System.out.println(a + " - " + b + " = " + minusService.subtract(a, b));
        } else {
            PlusServiceXML plusService = (PlusServiceXML) beanFactory.getBean("plusService");
            System.out.println(a + " + " + b + " = " + plusService.add(a, b));
        }
    }
}
