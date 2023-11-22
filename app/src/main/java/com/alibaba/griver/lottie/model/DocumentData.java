package com.alibaba.griver.lottie.model;

import android.graphics.PointF;

/* loaded from: classes6.dex */
public class DocumentData {
    public final float baselineShift;
    public final int color;
    public final String fontName;
    public final PointF framePosition;
    public final PointF frameSize;
    public final Justification justification;
    public final float lineHeight;
    public final float size;
    public final int strokeColor;
    public final boolean strokeOverFill;
    public final float strokeWidth;
    public final String text;
    public final int tracking;

    /* loaded from: classes6.dex */
    public enum Justification {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public DocumentData(String str, String str2, float f, Justification justification, int i, float f2, float f3, int i2, int i3, float f4, boolean z, PointF pointF, PointF pointF2) {
        this.text = str;
        this.fontName = str2;
        this.size = f;
        this.justification = justification;
        this.tracking = i;
        this.lineHeight = f2;
        this.baselineShift = f3;
        this.color = i2;
        this.strokeColor = i3;
        this.strokeWidth = f4;
        this.strokeOverFill = z;
        this.frameSize = pointF;
        this.framePosition = pointF2;
    }

    public int hashCode() {
        int hashCode = (int) ((((this.text.hashCode() * 31) + this.fontName.hashCode()) * 31) + this.size);
        int ordinal = this.justification.ordinal();
        int i = this.tracking;
        long floatToRawIntBits = Float.floatToRawIntBits(this.lineHeight);
        return (((((((hashCode * 31) + ordinal) * 31) + i) * 31) + ((int) (floatToRawIntBits ^ (floatToRawIntBits >>> 32)))) * 31) + this.color;
    }
}
