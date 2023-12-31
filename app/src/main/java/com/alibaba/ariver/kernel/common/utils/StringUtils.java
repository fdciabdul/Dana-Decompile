package com.alibaba.ariver.kernel.common.utils;

import java.util.Collection;
import java.util.Map;

/* loaded from: classes3.dex */
public class StringUtils {
    public static <K, V> String map2String(Map<K, V> map) {
        return (map == null || map.isEmpty()) ? "" : collection2String(map.entrySet());
    }

    public static <T> String collection2String(Collection<T> collection) {
        StringBuilder sb = new StringBuilder();
        if (collection != null && !collection.isEmpty()) {
            sb.append("{");
            for (T t : collection) {
                if (t != null) {
                    sb.append(t.toString());
                    sb.append(",");
                }
            }
            int lastIndexOf = sb.lastIndexOf(",");
            if (-1 != lastIndexOf) {
                sb.deleteCharAt(lastIndexOf);
            }
            sb.append("}");
        }
        return sb.toString();
    }

    public static <T> String array2String(T[] tArr) {
        StringBuilder sb = new StringBuilder();
        if (tArr != null && tArr.length > 0) {
            sb.append("[");
            for (T t : tArr) {
                if (t != null) {
                    sb.append(t.toString());
                    sb.append(",");
                }
            }
            int lastIndexOf = sb.lastIndexOf(",");
            if (-1 != lastIndexOf) {
                sb.deleteCharAt(lastIndexOf);
            }
            sb.append("]");
        }
        return sb.toString();
    }

    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static boolean isEquals(String str, String str2) {
        if (str == null) {
            return str2 == null;
        }
        return str.equals(str2);
    }

    public static boolean isEqualsIgnoreCase(String str, String str2) {
        if (str == null) {
            return str2 == null;
        }
        return str.equalsIgnoreCase(str2);
    }
}
