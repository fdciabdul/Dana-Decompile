package ru.noties.markwon.html.impl.jsoup.nodes;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Map;
import org.commonmark.internal.util.Html5Entities;

/* loaded from: classes6.dex */
public abstract class CommonMarkEntities {
    private static final Map<String, String> getAuthRequestContext;

    public static boolean BuiltInFictitiousFunctionClassFactory(String str) {
        return getAuthRequestContext.containsKey(str);
    }

    public static int MyBillsEntityDataFactory(String str, int[] iArr) {
        String str2 = getAuthRequestContext.get(str);
        if (str2 != null) {
            int length = str2.length();
            if (length == 1) {
                iArr[0] = str2.charAt(0);
            } else {
                iArr[0] = str2.charAt(0);
                iArr[1] = str2.charAt(1);
            }
            return length;
        }
        return 0;
    }

    static {
        Map<String, String> emptyMap;
        try {
            Field declaredField = Html5Entities.class.getDeclaredField("getAuthRequestContext");
            declaredField.setAccessible(true);
            emptyMap = (Map) declaredField.get(null);
        } catch (Throwable unused) {
            emptyMap = Collections.emptyMap();
        }
        getAuthRequestContext = emptyMap;
    }

    private CommonMarkEntities() {
    }
}
