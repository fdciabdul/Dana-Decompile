package com.alibaba.griver.image.framework.meta;

/* loaded from: classes6.dex */
public class Size {

    /* renamed from: a  reason: collision with root package name */
    private final int f6585a;
    private final int b;

    public Size(int i, int i2) {
        this.f6585a = i;
        this.b = i2;
    }

    public int getWidth() {
        return this.f6585a;
    }

    public int getHeight() {
        return this.b;
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
            return this.f6585a == size.f6585a && this.b == size.b;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f6585a);
        sb.append("x");
        sb.append(this.b);
        return sb.toString();
    }

    public int hashCode() {
        int i = this.b;
        int i2 = this.f6585a;
        return i ^ ((i2 << 16) | (i2 >>> 16));
    }
}
