package com.alibaba.griver.beehive.lottie.util;

/* loaded from: classes6.dex */
public class StringUtils {
    private StringUtils() {
    }

    public static String replaceEach(String str, String[] strArr, String[] strArr2) {
        return replaceEach(str, strArr, strArr2, false, 0);
    }

    private static String replaceEach(String str, String[] strArr, String[] strArr2, boolean z, int i) {
        String str2;
        String str3;
        int length;
        String str4;
        while (str != null && str.length() != 0 && strArr != null && strArr.length != 0 && strArr2 != null && strArr2.length != 0) {
            if (i < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("TimeToLive of ");
                sb.append(i);
                sb.append(" is less than 0: ");
                sb.append(str);
                throw new IllegalStateException(sb.toString());
            }
            int length2 = strArr.length;
            int length3 = strArr2.length;
            if (length2 != length3) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Search and Replace array lengths don't match: ");
                sb2.append(length2);
                sb2.append(" vs ");
                sb2.append(length3);
                throw new IllegalArgumentException(sb2.toString());
            }
            boolean[] zArr = new boolean[length2];
            int i2 = -1;
            int i3 = -1;
            for (int i4 = 0; i4 < length2; i4++) {
                if (!zArr[i4] && (str4 = strArr[i4]) != null && str4.length() != 0 && strArr2[i4] != null) {
                    int indexOf = str.indexOf(strArr[i4]);
                    if (indexOf == -1) {
                        zArr[i4] = true;
                    } else if (i2 == -1 || indexOf < i2) {
                        i3 = i4;
                        i2 = indexOf;
                    }
                }
            }
            if (i2 == -1) {
                return str;
            }
            int i5 = 0;
            for (int i6 = 0; i6 < strArr.length; i6++) {
                if (strArr[i6] != null && (str3 = strArr2[i6]) != null && (length = str3.length() - strArr[i6].length()) > 0) {
                    i5 += length * 3;
                }
            }
            StringBuilder sb3 = new StringBuilder(str.length() + Math.min(i5, str.length() / 5));
            int i7 = 0;
            while (i2 != -1) {
                while (i7 < i2) {
                    sb3.append(str.charAt(i7));
                    i7++;
                }
                sb3.append(strArr2[i3]);
                i7 = strArr[i3].length() + i2;
                i2 = -1;
                i3 = -1;
                for (int i8 = 0; i8 < length2; i8++) {
                    if (!zArr[i8] && (str2 = strArr[i8]) != null && str2.length() != 0 && strArr2[i8] != null) {
                        int indexOf2 = str.indexOf(strArr[i8], i7);
                        if (indexOf2 == -1) {
                            zArr[i8] = true;
                        } else if (i2 == -1 || indexOf2 < i2) {
                            i3 = i8;
                            i2 = indexOf2;
                        }
                    }
                }
            }
            int length4 = str.length();
            while (i7 < length4) {
                sb3.append(str.charAt(i7));
                i7++;
            }
            str = sb3.toString();
            if (!z) {
                return str;
            }
            i--;
        }
        return str;
    }

    public static String join(Object[] objArr, String str) {
        int length;
        if (objArr == null) {
            return null;
        }
        int length2 = objArr.length;
        if (length2 == 0) {
            length = 0;
        } else {
            Object obj = objArr[0];
            length = ((obj == null ? 16 : obj.toString().length()) + 1) * length2;
        }
        StringBuffer stringBuffer = new StringBuffer(length);
        for (int i = 0; i < length2; i++) {
            if (i > 0) {
                stringBuffer.append(str);
            }
            Object obj2 = objArr[i];
            if (obj2 != null) {
                stringBuffer.append(obj2);
            }
        }
        return stringBuffer.toString();
    }

    public static boolean equal(String str, String str2) {
        if (str == null) {
            return str2 == null;
        }
        return str.equals(str2);
    }
}
