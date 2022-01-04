package HW_4.Annotation_Config;

import org.springframework.stereotype.Component;

@Component
public class PlusServiceAnnotation {
    int add(int a, int b) {
        return a + b;
    }
}
