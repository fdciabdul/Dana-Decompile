package com.alipay.mobile.security.faceauth;

/* loaded from: classes7.dex */
public class FaceDetectType {
    private int defaultValue;
    public static final FaceDetectType AIMLESS = new FaceDetectType(0);
    public static final FaceDetectType BLINK = new FaceDetectType(1);
    public static final FaceDetectType MOUTH = new FaceDetectType(2);
    public static final FaceDetectType NONE = new FaceDetectType(3);
    public static final FaceDetectType POS_YAW = new FaceDetectType(4);
    public static final FaceDetectType POS_PITCH = new FaceDetectType(5);
    public static final FaceDetectType IDST = new FaceDetectType(6);

    public FaceDetectType(int i) {
        this.defaultValue = i;
    }

    public int getValue() {
        return this.defaultValue;
    }
}
