package io.opentelemetry.api.internal;

import java.util.Objects;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class StringUtils {
    private static boolean isPrintableChar(char c) {
        return c >= ' ' && c <= '~';
    }

    public static boolean isNullOrEmpty(@Nullable String str) {
        return str == null || str.isEmpty();
    }

    public static String padLeft(String str, int i) {
        return padStart(str, i, '0');
    }

    private static String padStart(String str, int i, char c) {
        Objects.requireNonNull(str);
        if (str.length() >= i) {
            return str;
        }
        StringBuilder sb = new StringBuilder(i);
        for (int length = str.length(); length < i; length++) {
            sb.append(c);
        }
        sb.append(str);
        return sb.toString();
    }

    public static boolean isPrintableString(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!isPrintableChar(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private StringUtils() {
    }
}
