package com.alibaba.griver.video.view;

import android.graphics.Rect;
import android.graphics.RectF;

/* loaded from: classes6.dex */
public final class MeasureHelper {

    /* renamed from: a  reason: collision with root package name */
    private int f6789a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private String h;
    private int i;
    private RectF j;
    private boolean l;
    private boolean g = false;
    private Rect k = new Rect();
    private boolean m = false;

    public final void setVideoSize(int i, int i2) {
        this.f6789a = i;
        this.b = i2;
    }

    public final boolean isVideoDimensionGot() {
        return this.f6789a > 0 && this.b > 0;
    }

    public final void setRendMode(String str, RectF rectF, int i) {
        this.h = str;
        this.j = rectF;
        this.i = i;
    }

    public final void setFullScreen(boolean z) {
        this.l = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0270  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void doMeasure(int r17, int r18) {
        /*
            Method dump skipped, instructions count: 858
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.video.view.MeasureHelper.doMeasure(int, int):void");
    }

    public final int getMeasuredWidth() {
        return this.c;
    }

    public final int getMeasuredHeight() {
        return this.d;
    }

    public final int getOffsetX() {
        return this.e;
    }

    public final boolean isNeedRelayout() {
        return this.g;
    }

    public final void resetNeedLayout() {
        this.g = false;
    }

    public final int getOffsetY() {
        return this.f;
    }

    public final Rect getDisplayArea() {
        return this.k;
    }
}
