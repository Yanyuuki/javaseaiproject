package com.yanyuuki.extends3modifier;

import com.yanyuuki.extends2modifier.Fu;

public class Zi extends Fu {
    public void show() {
        // privateMethod();
        // defaultMethod();
        protectedMethod();//不同包子类只能访问protected和public
        publicMethod();
    }

}
