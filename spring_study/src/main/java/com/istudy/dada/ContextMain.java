package com.istudy.dada;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ContextMain {

    /*public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
//        Person person = applicationContext.getBean(Person.class);
//        System.out.println(person.getAge());

    }*/

    /*public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);

        // 获取环境变量
        Environment environment = applicationContext.getEnvironment();
        String osName = environment.getProperty("os.name");
        System.out.println(osName);


        for (String name : beanNamesForType) {

            System.out.println(name);
        }

        Map<String, Person> beansOfType = applicationContext.getBeansOfType(Person.class);
        System.out.println(beansOfType);
    }*/

    /*public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        System.out.println("====================");

        Object colorFactoryBean = applicationContext.getBean("colorFactoryBean");
        System.out.println(colorFactoryBean.getClass());
        // 获取原来的factoryBean
        Object bean = applicationContext.getBean("&colorFactoryBean");
        System.out.println(bean.getClass());

    }*/

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("容器创建完成");

        Color2 color2 = (Color2) applicationContext.getBean("color2");
//        System.out.println(color.getValue());
        color2.test();

    }
}
