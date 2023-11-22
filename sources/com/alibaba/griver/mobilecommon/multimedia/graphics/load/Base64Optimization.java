package com.alibaba.griver.mobilecommon.multimedia.graphics.load;

/* loaded from: classes6.dex */
public class Base64Optimization {
    public final int offset;
    public final int parts;
    public final int stride;

    public Base64Optimization(int i, int i2, int i3) {
        this.offset = i;
        this.stride = i2;
        this.parts = i3;
    }

    public static Base64Optimization createDefault() {
        return new Base64Optimization(150, 50, 3);
    }
}
