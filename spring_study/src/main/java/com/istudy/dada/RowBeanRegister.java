package com.istudy.dada;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class RowBeanRegister implements ImportBeanDefinitionRegistrar {


    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        boolean person = registry.containsBeanDefinition("person");
        if (person) {
            RootBeanDefinition beanDefinition = new RootBeanDefinition(Row.class);
            registry.registerBeanDefinition("row", beanDefinition);
        }
    }
}
