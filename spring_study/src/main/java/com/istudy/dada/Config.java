package com.istudy.dada;


import org.springframework.context.annotation.*;

@Configuration
//放在类上，只有当条件满足时，整个类的bean才会生效
//@Conditional({
//        MacConditional.class
//})
/*@ComponentScan(value = "com.istudy.dada")
@ComponentScan(value = "com.istudy.dada", excludeFilters = {
        // exclude 排除哪些组件
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
})*/
 /*只包含哪些组件
@ComponentScan(value = "com.istudy.dada", includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
}, useDefaultFilters = false)*/
//ComponentScans用户多个注解生效
// @ComponentScans({
//        @ComponentScan(value = "com.istudy.dada"),
//        @ComponentScan(value = "com.istudy.dada", includeFilters = {
//                @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
//        }, useDefaultFilters = false)
//
//})
/*@Import(Color.class) ??? ImportSelector ??? */
@Import(RowBeanRegister.class)
public class Config {

    /**
     * scope:见代码注释 懒加载：用于单例，在容器创建时不创建对象，第一次使用时，创建对象并初始化
     */
    @Bean
    @Scope
    @Lazy
    public Person person() {
        return new Person("czd", 26);
    }

    /**
     *
     * 如果os是mac，给bill注册
     * 如果是非mac，给linux注册
     * 放在方法上，影响的只有这一个方法
     */
    @Bean("bill")
    @Conditional({
            MacConditional.class
    })
    public Person person01() {
        return new Person("czd2", 26);
    }

    @Bean("linus")
    @Conditional({
            NonMacConditional.class
    })
    public Person person02() {
        return new Person("czd3", 26);
    }

    /**
     *
     * 给容器中注册组件
     * 1. 包扫描+组件识别注解(@controller+@service+@repository/@Component)
     * 2. @bean(导入的第三方里面的组件)
     * 3. @Import(快速的给容器中导入一个组件)
     *      3.1 @import
     *      3.2 ImportSelecor
     *      3.3 ImportBeanDefinitionRegister
     * 4. 实现FactoryBean
     *
     *
     * @author zhida.chen@ttpai.cn
     *
     */

    @Bean
    public ColorFactoryBean colorFactoryBean() {

        return new ColorFactoryBean();
    }

}
