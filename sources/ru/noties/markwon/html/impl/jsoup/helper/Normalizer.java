package ru.noties.markwon.html.impl.jsoup.helper;

import java.util.Locale;

/* loaded from: classes6.dex */
public final class Normalizer {
    public static String getAuthRequestContext(String str) {
        return str != null ? str.toLowerCase(Locale.ENGLISH) : "";
    }
}
