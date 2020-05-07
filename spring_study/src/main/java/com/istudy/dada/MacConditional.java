package com.istudy.dada;


import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MacConditional implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        // 1. 获取bean工厂
        context.getBeanFactory();
        // 2. 获取类加载器
        context.getClassLoader();
        // 3. 获取当前环境信息
        context.getEnvironment();
        // 4. 获取bean定义的注册类
        context.getRegistry();

        Environment environment = context.getEnvironment();
        String property = environment.getProperty("os.name");
        if (property.contains("mac")) {
            return true;
        }
        return false;
    }
}
