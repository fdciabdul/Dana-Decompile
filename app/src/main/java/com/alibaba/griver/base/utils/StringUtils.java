package com.alibaba.griver.base.utils;

/* loaded from: classes2.dex */
public class StringUtils {
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
}
