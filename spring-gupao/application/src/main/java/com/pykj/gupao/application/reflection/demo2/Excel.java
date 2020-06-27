package com.pykj.gupao.application.reflection.demo2;

public class Excel implements Office {
    @Override
    public void toPDF() {
        System.out.println("Excel重写方法");
    }
}
