package com.huawei.agconnect.config.impl;

/* loaded from: classes7.dex */
public class Hex {
    private static final char[] MyBillsEntityDataFactory = "0123456789ABCDEF".toCharArray();

    public static byte[] BuiltInFictitiousFunctionClassFactory(String str) {
        return BuiltInFictitiousFunctionClassFactory(str.toCharArray());
    }

    private static byte[] BuiltInFictitiousFunctionClassFactory(char[] cArr) {
        if ((cArr.length & 1) == 0) {
            byte[] bArr = new byte[cArr.length >> 1];
            int i = 0;
            int i2 = 0;
            while (i < cArr.length) {
                int digit = Character.digit(cArr[i], 16);
                if (digit == -1) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Illegal hexadecimal character at index ");
                    sb.append(i);
                    throw new IllegalArgumentException(sb.toString());
                }
                int i3 = i + 1;
                int digit2 = Character.digit(cArr[i3], 16);
                if (digit2 == -1) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Illegal hexadecimal character at index ");
                    sb2.append(i3);
                    throw new IllegalArgumentException(sb2.toString());
                }
                i = i3 + 1;
                bArr[i2] = (byte) (((digit << 4) | digit2) & 255);
                i2++;
            }
            return bArr;
        }
        throw new IllegalArgumentException("Odd number of characters.");
    }

    public static String getAuthRequestContext(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            char[] cArr = MyBillsEntityDataFactory;
            sb.append(cArr[(b >> 4) & 15]);
            sb.append(cArr[b & 15]);
        }
        return sb.toString();
    }
}
