package com.bsb.security.core.properties;

public class ValidateCodeProperties {

    private ImageCodeProperties imageCodeProperties = new ImageCodeProperties();

    private SmsCodeProperties smsCodeProperties = new SmsCodeProperties();

    public SmsCodeProperties getSmsCodeProperties() {
        return smsCodeProperties;
    }

    public void setSmsCodeProperties(SmsCodeProperties smsCodeProperties) {
        this.smsCodeProperties = smsCodeProperties;
    }

    public ImageCodeProperties getImageCodeProperties() {
        return imageCodeProperties;
    }

    public void setImageCodeProperties(ImageCodeProperties imageCodeProperties) {
        this.imageCodeProperties = imageCodeProperties;
    }
}
