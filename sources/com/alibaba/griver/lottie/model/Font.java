package com.alibaba.griver.lottie.model;

/* loaded from: classes6.dex */
public class Font {
    public static final String FONT_DEFAULT = "INNER_DEFAULT_FONT";
    private final float ascent;
    private final String family;
    private final String name;
    private final String style;

    public Font(String str, String str2, String str3, float f) {
        this.family = str;
        this.name = str2;
        this.style = str3;
        this.ascent = f;
    }

    public String getFamily() {
        return this.family;
    }

    public String getName() {
        return this.name;
    }

    public String getStyle() {
        return this.style;
    }

    public float getAscent() {
        return this.ascent;
    }

    public static Font getDefault() {
        return new Font(FONT_DEFAULT, FONT_DEFAULT, "normal", 0.0f);
    }
}
