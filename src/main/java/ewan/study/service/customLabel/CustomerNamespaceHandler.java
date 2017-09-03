package ewan.study.service.customLabel;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;
import org.w3c.dom.Element;

public class CustomerNamespaceHandler extends NamespaceHandlerSupport {

    public void init() {
        registerBeanDefinitionParser("customer", new CustomerBeanDefinitionParser());
    }

    class CustomerBeanDefinitionParser extends AbstractSingleBeanDefinitionParser{
        protected Class getBeanClass(Element element) {
            return Customer.class;
        }

        protected void doParse(Element element, BeanDefinitionBuilder bean) {
            String name = element.getAttribute("name");
            bean.addPropertyValue("name", name);
        }
    }
}