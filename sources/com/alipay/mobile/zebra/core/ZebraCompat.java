package com.alipay.mobile.zebra.core;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public class ZebraCompat {
    public static String wrapCamelName(String str) {
        if (str == null) {
            return str;
        }
        String lowerCase = str.toLowerCase();
        StringBuilder sb = new StringBuilder();
        int length = lowerCase.length();
        for (int i = 0; i < length; i++) {
            char charAt = lowerCase.charAt(i);
            if (i != 0 && charAt != str.charAt(i)) {
                sb.append('-');
            }
            sb.append(charAt);
        }
        return sb.length() != length ? sb.toString() : lowerCase;
    }

    public static Map<String, String> unpackStyle(String str) {
        HashMap hashMap = new HashMap();
        if (str == null) {
            return hashMap;
        }
        for (String str2 : str.split(";")) {
            String[] split = str2.split(":");
            if (split.length == 2) {
                hashMap.put(split[0].trim(), split[1].trim());
            }
        }
        return hashMap;
    }
}
