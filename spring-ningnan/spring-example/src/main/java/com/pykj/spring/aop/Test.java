package com.pykj.spring.aop;

public class Test {
    public static void main(String[] args) {

        Cal cal = new CalImpl();
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler();
        Cal cal1 = (Cal) myInvocationHandler.bind(cal);
        cal1.add(1, 1);
        cal1.sub(2, 1);
        cal1.mul(2, 3);
        cal1.div(6, 2);

    }

}
