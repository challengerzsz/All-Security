package com.bsb.security.core.properties;

/**
 * 通过继承消除重复属性
 */
public class ImageCodeProperties extends SmsCodeProperties{

    private int width = 67;
    private int height = 23;

    public ImageCodeProperties() {
        setLength(4);
    }


    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
