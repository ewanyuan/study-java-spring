package ewan.study.service.customLabel;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class ScopeThreadNameSpaceHandler extends NamespaceHandlerSupport {
    public void init() {
        registerBeanDefinitionParser("thread",
                new ScopeThreadBeanDefinitorParse());
    }
}
