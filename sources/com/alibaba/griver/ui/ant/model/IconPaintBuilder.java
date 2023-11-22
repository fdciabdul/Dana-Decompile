package com.alibaba.griver.ui.ant.model;

/* loaded from: classes6.dex */
public class IconPaintBuilder {
    public int color;
    public boolean isBold;
    public int resId;
    public String resString;
    public int size;

    public IconPaintBuilder() {
    }

    public IconPaintBuilder(int i, int i2, int i3) {
        this.color = i;
        this.size = i2;
        this.resId = i3;
    }

    public IconPaintBuilder(int i, int i2, String str) {
        this.color = i;
        this.size = i2;
        this.resString = str;
    }
}
