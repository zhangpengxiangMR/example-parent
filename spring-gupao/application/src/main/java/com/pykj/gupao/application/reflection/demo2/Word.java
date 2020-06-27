package com.pykj.gupao.application.reflection.demo2;

/**
 * @description: TODO
 * @author: zhangpengxiang
 * @time: 2020/6/22 22:50
 */
public class Word  implements Office
{
    @Override
    public void toPDF() {
        System.out.println("Word重写方法");
    }
}
