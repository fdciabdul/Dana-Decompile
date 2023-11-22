package com.alibaba.ariver.app.api.service.font;

/* loaded from: classes6.dex */
public class FontSizeSetting {

    /* renamed from: a  reason: collision with root package name */
    private int f5970a;
    private float b;

    public FontSizeSetting(int i, float f) {
        this.f5970a = i;
        this.b = f;
    }

    public float getScale() {
        return this.b;
    }

    public int getLevel() {
        return this.f5970a;
    }

    public String toString() {
        return String.format("fontSize\t fontScale=%d,level=%d", Float.valueOf(this.b), Integer.valueOf(this.f5970a));
    }
}
