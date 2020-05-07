package com.istudy.dada;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 配置bean生命周期
 * bean的创建-初始化-销毁
 * 单示例：在容器启动时创建
 * 多实例：在每次获取时创建
 * 初始化：对象创建完成，并赋值好，调用初始化方法
 * 销毁：单实例：容器关闭的时候
 *      多实例：容器不会管理这个bean，容器不会调用销毁方法
 *
 * 1. 指定初始化和销毁方法，通过@bean的initMethod,destroyMethod的属性配置
 * 2. InitializingBean.afterPropertiesSet(初始化) DisposableBean.destroy(销毁)
 * 3. 使用JSR250：@PostConstruct 在bean创建完成并赋值初始化，来调用初始化方法
 * @PreDestroy 在容器销毁bean之前通知清理工作
 * 4. BeanPostProcessor:bean的后置处理器
 *    在bean初始化前后进行一些处理工作
 * 遍历得到容器中的BeanPostProcessor，挨个执行postProcessAfterInitialization，
 * 一旦返回null，跳出for循环，不会执行后面的BeanPostProcessor
 * wrappedBean = applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);
 * invokeInitMethods(beanName, wrappedBean, mbd);
 * wrappedBean = applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
 *
 * Spring底层对BeanPostProcessor
 */
@ComponentScan("com.istudy.dada")
@EnableAspectJAutoProxy
/**
 * AOP原理：
 * @EnableAspectJAutoProxy
 * 1. @EnableAspectJAutoProxy是什么？
 * @Import(AspectJAutoProxyRegistrar.class)：给容器中导入AspectJAutoProxyRegistrar
 *  AspectJAutoProxyRegistrar自定义给容器中注册bean
 *     internalAutoProxyCreator -> AnnotationAwareAspectJAutoProxyCreator
 * 2. AnnotationAwareAspectJAutoProxyCreator
 *      -> AspectJAwareAdvisorAutoProxyCreator
 *          -> AbstractAdvisorAutoProxyCreator
 *              -> AbstractAutoProxyCreator
 *                  implements SmartInstantiationAwareBeanPostProcessor, BeanFactoryAware
 *                  关注后置处理器(在bean初始化完成前后做的事情)，自动装配BeanFactory
 *    AbstractAutoProxyCreator.setBeanFactory()
 *    AbstractAutoProxyCreator有后置处理器
 *
 *    AbstractAdvisorAutoProxyCreator.setBeanFactory() -> initBeanFactory()
 *
 *    AnnotationAwareAspectJAutoProxyCreator.initBeanFactory
 *
 * 流程：
 *  1. 传入配置类，创建ioc容器
 *  2. 注册配置类，调用refresh()
 *  3. registerBeanPostProcessors，注册bean的后置处理器来方便拦截bean的创建
 *      3.1 先获取ioc容器中已经定义了的需要创建对象的所有BeanPostProcessor
 *      3.2 给容器中加别的BeanPostProcessor
 *      3.3 优先注册实现了PriorityOrdered的给容器中加别的BeanPostProcessor
 *      3.4 在注册实现了Ordered的给容器中加别的BeanPostProcessor
 *      3.5 最后注册普通的BeanPostProcessor
 *      3.6 注册BeanPostProcessor，实际上就是创建BeanPostProcessor对象，保存在容器中
 *          创建internalAutoProxyCreator的BeanPostProcessor
 *          1. 创建Bean的实例
 *          2. populateBean：给bean的各种属性赋值
 *          3. initializeBean：初始化bean
 *              1. invokeAwareMethods()
 *              2. applyBeanPostProcessorBeforeInitialization
 *              3. invokeInitMethods：执行初始化方法
 *              4. applyBeanPostProcessorAfterInitialization
 *          4. BeanPostProcessor(AnnotationAwareAspectJAutoProxyCreator) 创建成功， --> aspectjAdvisorsBuilder
 *      3.7 把BeanPostProcessor注册到BeanFactory中
 */
public class MainConfigOfLifeCycle {

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Car car() {
        return new Car();
    }
}
