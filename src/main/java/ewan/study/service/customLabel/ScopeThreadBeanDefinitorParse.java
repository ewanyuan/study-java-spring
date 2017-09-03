package ewan.study.service.customLabel;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.context.support.SimpleThreadScope;
import org.w3c.dom.Element;

import java.util.HashMap;
import java.util.Map;

public class ScopeThreadBeanDefinitorParse extends AbstractSingleBeanDefinitionParser {

    @Override
    protected Class getBeanClass(Element element) {
        return CustomScopeConfigurer.class;
    }

    @Override
    protected void doParse(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("thread", new SimpleThreadScope());
        builder.addPropertyValue("scopes", map);
    }
}