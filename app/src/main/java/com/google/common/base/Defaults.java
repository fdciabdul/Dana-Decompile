package com.google.common.base;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes7.dex */
public final class Defaults {
    private static final Double DOUBLE_DEFAULT = Double.valueOf((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    private static final Float FLOAT_DEFAULT = Float.valueOf(0.0f);

    private Defaults() {
    }

    @CheckForNull
    public static <T> T defaultValue(Class<T> cls) {
        Preconditions.checkNotNull(cls);
        if (cls.isPrimitive()) {
            if (cls == Boolean.TYPE) {
                return (T) Boolean.FALSE;
            }
            if (cls == Character.TYPE) {
                return (T) (char) 0;
            }
            if (cls == Byte.TYPE) {
                return (T) (byte) 0;
            }
            if (cls == Short.TYPE) {
                return (T) (short) 0;
            }
            if (cls == Integer.TYPE) {
                return (T) 0;
            }
            if (cls == Long.TYPE) {
                return (T) 0L;
            }
            if (cls == Float.TYPE) {
                return (T) FLOAT_DEFAULT;
            }
            if (cls == Double.TYPE) {
                return (T) DOUBLE_DEFAULT;
            }
            return null;
        }
        return null;
    }
}
