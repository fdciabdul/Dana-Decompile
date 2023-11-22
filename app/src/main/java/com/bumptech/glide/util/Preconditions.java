package com.bumptech.glide.util;

import android.text.TextUtils;
import java.util.Collection;

/* loaded from: classes3.dex */
public final class Preconditions {
    private Preconditions() {
    }

    public static void BuiltInFictitiousFunctionClassFactory(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static <T> T BuiltInFictitiousFunctionClassFactory(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static String getAuthRequestContext(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Must not be null or empty");
        }
        return str;
    }

    public static <T extends Collection<Y>, Y> T getAuthRequestContext(T t) {
        if (t.isEmpty()) {
            throw new IllegalArgumentException("Must not be empty.");
        }
        return t;
    }

    public static <T> T PlaceComponentResult(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException("Argument must not be null");
    }
}
