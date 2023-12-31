package com.alibaba.griver.lottie.value;

/* loaded from: classes6.dex */
public class ScaleXY {
    private float scaleX;
    private float scaleY;

    public ScaleXY(float f, float f2) {
        this.scaleX = f;
        this.scaleY = f2;
    }

    public ScaleXY() {
        this(1.0f, 1.0f);
    }

    public float getScaleX() {
        return this.scaleX;
    }

    public float getScaleY() {
        return this.scaleY;
    }

    public void set(float f, float f2) {
        this.scaleX = f;
        this.scaleY = f2;
    }

    public boolean equals(float f, float f2) {
        return this.scaleX == f && this.scaleY == f2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getScaleX());
        sb.append("x");
        sb.append(getScaleY());
        return sb.toString();
    }
}
