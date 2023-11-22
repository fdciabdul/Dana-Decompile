package com.huawei.hms.push;

/* loaded from: classes8.dex */
public abstract class w {
    public static final char[] getAuthRequestContext = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String getAuthRequestContext(byte[] bArr) {
        return bArr == null ? "" : new String(bArr, x.PlaceComponentResult);
    }
}
