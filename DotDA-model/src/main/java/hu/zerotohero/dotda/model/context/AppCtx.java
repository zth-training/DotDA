package hu.zerotohero.dotda.model.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * @author Balázs Hodossy <bhodossy@gmail.com>
 */
@Service
public class AppCtx implements ApplicationContextAware {

    private static ApplicationContext context = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static <T> T bean(Class<T> clazz) {
        return context.getBean(clazz);
    }

    public static <T> T bean(String name, Class<T> clazz) {
        return context.getBean(name, clazz);
    }

    public static Object bean(String name) {
        return context.getBean(name);
    }
}
