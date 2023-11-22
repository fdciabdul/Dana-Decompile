package com.alibaba.griver.lottie.model;

/* loaded from: classes6.dex */
public class ParagraphStyle {
    private final String lineBreakMode;
    private final float miniScale;
    private final String text;

    public ParagraphStyle(String str, float f, String str2) {
        this.text = str;
        this.miniScale = f;
        this.lineBreakMode = str2;
    }

    public String getText() {
        return this.text;
    }

    public float getMiniScale() {
        return this.miniScale;
    }

    public String getLineBreakMode() {
        return this.lineBreakMode;
    }
}
