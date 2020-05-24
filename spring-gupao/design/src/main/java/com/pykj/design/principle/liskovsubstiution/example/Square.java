package com.pykj.design.principle.liskovsubstiution.example;

/**
 * @description: 正方形
 * @author: zhangpengxiang
 * @time: 2020/4/20 18:14
 */
public class Square extends Rectangle {

    private long Length;

    public long getLength() {
        return Length;
    }

    public void setLength(long length) {
        Length = length;
    }

    @Override
    public long getHeight() {
        return getLength();
    }

    @Override
    public void setHeight(long height) {
        setLength(height);
    }

    @Override
    public long getWidth() {
        return getLength();
    }

    @Override
    public void setWidth(long width) {
        setLength(width);
    }
}
