package com.xiaomi.push;

import com.huawei.hms.framework.common.ContainerUtils;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.Random;

/* loaded from: classes8.dex */
public class cu {
    private static final char[] getAuthRequestContext = "&quot;".toCharArray();
    private static final char[] KClassImpl$Data$declaredNonStaticMembers$2 = "&apos;".toCharArray();
    private static final char[] MyBillsEntityDataFactory = "&amp;".toCharArray();
    private static final char[] BuiltInFictitiousFunctionClassFactory = "&lt;".toCharArray();
    private static final char[] lookAheadTest = "&gt;".toCharArray();
    private static Random PlaceComponentResult = new Random();
    private static char[] moveToNextValue = "0123456789abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    public static String BuiltInFictitiousFunctionClassFactory(String str) {
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        double d = length;
        Double.isNaN(d);
        StringBuilder sb = new StringBuilder((int) (d * 1.3d));
        int i = 0;
        int i2 = 0;
        while (i < length) {
            char c = charArray[i];
            if (c <= '>') {
                if (c == '<') {
                    if (i > i2) {
                        sb.append(charArray, i2, i - i2);
                    }
                    i2 = i + 1;
                    sb.append(BuiltInFictitiousFunctionClassFactory);
                } else if (c == '>') {
                    if (i > i2) {
                        sb.append(charArray, i2, i - i2);
                    }
                    i2 = i + 1;
                    sb.append(lookAheadTest);
                } else if (c == '&') {
                    if (i > i2) {
                        sb.append(charArray, i2, i - i2);
                    }
                    int i3 = i + 5;
                    if (length <= i3 || charArray[i + 1] != '#' || !Character.isDigit(charArray[i + 2]) || !Character.isDigit(charArray[i + 3]) || !Character.isDigit(charArray[i + 4]) || charArray[i3] != ';') {
                        i2 = i + 1;
                        sb.append(MyBillsEntityDataFactory);
                    }
                } else if (c == '\"') {
                    if (i > i2) {
                        sb.append(charArray, i2, i - i2);
                    }
                    i2 = i + 1;
                    sb.append(getAuthRequestContext);
                } else if (c == '\'') {
                    if (i > i2) {
                        sb.append(charArray, i2, i - i2);
                    }
                    i2 = i + 1;
                    sb.append(KClassImpl$Data$declaredNonStaticMembers$2);
                }
            }
            i++;
        }
        if (i2 == 0) {
            return str;
        }
        if (i > i2) {
            sb.append(charArray, i2, i - i2);
        }
        return sb.toString();
    }

    private static String MyBillsEntityDataFactory(String str, String str2, String str3) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(str2, 0);
        if (indexOf < 0) {
            return str;
        }
        char[] charArray = str.toCharArray();
        char[] charArray2 = str3.toCharArray();
        int length = str2.length();
        StringBuilder sb = new StringBuilder(charArray.length);
        sb.append(charArray, 0, indexOf);
        sb.append(charArray2);
        int i = indexOf + length;
        while (true) {
            int indexOf2 = str.indexOf(str2, i);
            if (indexOf2 <= 0) {
                sb.append(charArray, i, charArray.length - i);
                return sb.toString();
            }
            sb.append(charArray, i, indexOf2 - i);
            sb.append(charArray2);
            i = indexOf2 + length;
        }
    }

    public static String MyBillsEntityDataFactory(byte[] bArr) {
        return String.valueOf(aa.MyBillsEntityDataFactory(bArr));
    }

    public static String PlaceComponentResult() {
        char[] cArr = new char[5];
        for (int i = 0; i < 5; i++) {
            cArr[i] = moveToNextValue[PlaceComponentResult.nextInt(71)];
        }
        return new String(cArr);
    }

    public static final String PlaceComponentResult(String str) {
        return MyBillsEntityDataFactory(MyBillsEntityDataFactory(MyBillsEntityDataFactory(MyBillsEntityDataFactory(MyBillsEntityDataFactory(str, "&lt;", SimpleComparison.LESS_THAN_OPERATION), "&gt;", SimpleComparison.GREATER_THAN_OPERATION), "&quot;", "\""), "&apos;", "'"), "&amp;", ContainerUtils.FIELD_DELIMITER);
    }
}
