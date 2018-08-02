import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Random;

public class InjectRandomIntAnnotationBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] declaredFields = bean.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            IngectRandInt annotation = declaredField.getAnnotation(IngectRandInt.class);
            if (annotation!=null){
                int min = annotation.min();
                int max = annotation.max();
                Random random = new Random();
                int i = min+random.nextInt(max-min);
                declaredField.setAccessible(true);
                ReflectionUtils.setField(declaredField,bean,i);
            }
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
