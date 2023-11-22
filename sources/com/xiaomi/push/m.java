package com.xiaomi.push;

/* loaded from: classes8.dex */
public class m {
    static final char[] MyBillsEntityDataFactory = "0123456789ABCDEF".toCharArray();

    public static String getAuthRequestContext(byte[] bArr, int i) {
        StringBuilder sb = new StringBuilder(i * 2);
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = bArr[i2 + 0] & 255;
            char[] cArr = MyBillsEntityDataFactory;
            sb.append(cArr[i3 >> 4]);
            sb.append(cArr[i3 & 15]);
        }
        return sb.toString();
    }
}
