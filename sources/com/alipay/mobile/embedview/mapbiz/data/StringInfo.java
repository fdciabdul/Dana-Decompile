package com.alipay.mobile.embedview.mapbiz.data;

import android.graphics.Color;

/* loaded from: classes6.dex */
public class StringInfo {
    public int color;
    public int end;
    public int start;

    public static StringInfo initStringInfo(int i, int i2, String str) {
        int i3;
        StringInfo stringInfo = new StringInfo();
        stringInfo.start = i;
        stringInfo.end = i2;
        try {
            i3 = Color.parseColor(str);
        } catch (Throwable unused) {
            i3 = -16777216;
        }
        stringInfo.color = i3;
        return stringInfo;
    }
}
