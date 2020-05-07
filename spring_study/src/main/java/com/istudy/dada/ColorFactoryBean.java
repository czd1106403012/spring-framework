package com.istudy.dada;

import org.springframework.beans.factory.FactoryBean;

public class ColorFactoryBean implements FactoryBean<Color> {

    /**
     * 返回一个对象
     * @return
     * @throws Exception
     */
    @Override
    public Color getObject() throws Exception {
        return new Color();
    }

    /**
     * 类型
     * @return
     */
    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    /**
     * 是否是单例
     * @return
     */
    @Override
    public boolean isSingleton() {
        return true;
    }
}
