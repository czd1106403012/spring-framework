package com.istudy.dada;

import org.springframework.stereotype.Component;

@Component
public class Color2 {

    public Color2() {
        System.out.println("construct color2");
    }

    public void test(){
        System.out.println("color2 test");
    }
}
