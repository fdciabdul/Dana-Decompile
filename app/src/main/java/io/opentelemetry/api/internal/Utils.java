package io.opentelemetry.api.internal;

/* loaded from: classes.dex */
public final class Utils {
    private Utils() {
    }

    public static void checkArgument(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }
}
