package com.pykj.design.principle.liskovsubstiution.example;

/**
 * @description: 长方形
 * @author: zhangpengxiang
 * @time: 2020/4/20 18:08
 */
public class Rectangle {

    private long height;

    private long width;

    public long getHeight() {
        return height;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    public long getWidth() {
        return width;
    }

    public void setWidth(long width) {
        this.width = width;
    }
}
