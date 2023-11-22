package com.alibaba.griver.mobilecommon.multimedia.graphics.data;

/* loaded from: classes6.dex */
public class Size {
    private final int mHeight;
    private final int mWidth;

    public Size(int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof Size) {
            Size size = (Size) obj;
            return this.mWidth == size.mWidth && this.mHeight == size.mHeight;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.mWidth);
        sb.append("x");
        sb.append(this.mHeight);
        return sb.toString();
    }

    public int hashCode() {
        int i = this.mHeight;
        int i2 = this.mWidth;
        return i ^ ((i2 << 16) | (i2 >>> 16));
    }
}
