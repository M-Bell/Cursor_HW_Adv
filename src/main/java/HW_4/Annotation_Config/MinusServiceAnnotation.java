package HW_4.Annotation_Config;

import org.springframework.stereotype.Component;

@Component
public class MinusServiceAnnotation {
    int subtract(int a, int b) {
        return a - b;
    }
}
