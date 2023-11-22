package io.opentelemetry.instrumentation.api.internal;

import java.util.Locale;
import javax.annotation.Nullable;

/* loaded from: classes6.dex */
public final class ConfigPropertiesUtil {
    public static boolean getBoolean(String str, boolean z) {
        String string = getString(str);
        return string != null ? Boolean.parseBoolean(string) : z;
    }

    @Nullable
    public static String getString(String str) {
        String property = System.getProperty(str);
        return property != null ? property : System.getenv(toEnvVarName(str));
    }

    private static String toEnvVarName(String str) {
        return str.toUpperCase(Locale.ROOT).replace('-', '_').replace('.', '_');
    }

    private ConfigPropertiesUtil() {
    }
}
