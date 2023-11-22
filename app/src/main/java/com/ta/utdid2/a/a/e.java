package com.ta.utdid2.a.a;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f7688a = Pattern.compile("([\t\r\n])+");

    public static boolean isEmpty(String str) {
        return str == null || str.length() <= 0;
    }

    public static int hashCode(String str) {
        if (str.length() > 0) {
            int i = 0;
            for (char c : str.toCharArray()) {
                i = (i * 31) + c;
            }
            return i;
        }
        return 0;
    }

    public static boolean isBlank(String str) {
        int length;
        if (str == null || (length = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static Map<String, String> a(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        TreeMap treeMap = new TreeMap(new Comparator<String>() { // from class: com.ta.utdid2.a.a.e.1
            @Override // java.util.Comparator
            public final int compare(String str, String str2) {
                return str.compareTo(str2);
            }
        });
        treeMap.putAll(map);
        return treeMap;
    }

    public static String l(String str) {
        return (str == null || "".equals(str)) ? str : f7688a.matcher(str).replaceAll("");
    }
}
