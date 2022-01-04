package HW_4;

import HW_4.Annotation_Config.CalculatorAnnotation;
import HW_4.Java_Config.CalculatorJava;
import HW_4.XML_Config.CalculatorXML;

public class Test {
    public static void main(String[] args) {
        int a = 3;
        int b = 7;

        CalculatorAnnotation calculatorAnnotation = new CalculatorAnnotation(a, b);
        CalculatorJava calculatorJava = new CalculatorJava(a, b);
        CalculatorXML calculatorXML = new CalculatorXML(a, b);

        System.out.println("Component Annotation");
        calculatorAnnotation.run();
        System.out.println("Config class");
        calculatorJava.run();
        System.out.println("XML file");
        calculatorXML.run();
    }
}
