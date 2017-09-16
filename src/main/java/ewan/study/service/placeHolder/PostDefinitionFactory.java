package ewan.study.service.placeHolder;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;

import java.io.InputStream;
import java.util.Properties;

/**
 * Created by ewan on 10/09/2017.
 */


public class PostDefinitionFactory implements BeanDefinitionRegistryPostProcessor {
    private static final String passwordEncriptionKey = "password";

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        Properties prop = new Properties();
        try {
            InputStream in = this.getClass().getClassLoader().getResourceAsStream("placeHolder/conn.properties");
            prop.load(in);
        } catch (Exception ex) {
            ex.printStackTrace();
        }


        beanDefinitionRegistry.getBeanDefinition("conn").getPropertyValues().add("password", prop.getProperty("conn.pwd"));
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

        String encryptedPassword = configurableListableBeanFactory.getBeanDefinition("conn")
                .getPropertyValues().get("password").toString();

        String password = AESHelper.AESDncode(passwordEncriptionKey, encryptedPassword);
        configurableListableBeanFactory.getBeanDefinition("conn")
                .getPropertyValues().add("password", password).toString();
    }
}
