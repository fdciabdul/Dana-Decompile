package com.alibaba.griver.ui.ant.theme;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class AUThemeManager {
    public static final String THEMEKEY_DEFAULT = "defalue";

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, AUAbsTheme> f6699a;
    private static String b;

    static {
        HashMap hashMap = new HashMap();
        f6699a = hashMap;
        b = THEMEKEY_DEFAULT;
        hashMap.put(THEMEKEY_DEFAULT, AUDefaultTheme.getInstence());
    }

    public static AUAbsTheme getTheme(String str) {
        if (TextUtils.isEmpty(str) || f6699a.containsKey(str)) {
            str = b;
        }
        return f6699a.get(str);
    }

    public static AUAbsTheme getCurrentTheme() {
        return getTheme(b);
    }
}
