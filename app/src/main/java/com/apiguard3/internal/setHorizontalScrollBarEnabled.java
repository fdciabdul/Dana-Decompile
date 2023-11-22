package com.apiguard3.internal;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

/* loaded from: classes7.dex */
final class setHorizontalScrollBarEnabled extends setVerticalFadingEdgeEnabled {
    private static Class AGState = null;
    private static int getSharedInstance = 1;
    private static int valueOf;
    private final Object values = getSharedInstance();
    private final Field APIGuard = AGState();

    @Override // com.apiguard3.internal.setVerticalFadingEdgeEnabled
    public final void valueOf(AccessibleObject accessibleObject) {
        int i = valueOf + 19;
        getSharedInstance = i % 128;
        if (!(i % 2 != 0)) {
            AGState(accessibleObject);
            throw new NullPointerException();
        } else if ((!AGState(accessibleObject)) == true) {
            valueOf = (getSharedInstance + 125) % 128;
            try {
                accessibleObject.setAccessible(true);
            } catch (SecurityException e) {
                StringBuilder sb = new StringBuilder("Gson couldn't modify fields for ");
                sb.append(accessibleObject);
                sb.append("\nand sun.misc.Unsafe not found.\nEither write a custom type adapter, or make fields accessible, or include sun.misc.Unsafe.");
                throw new setDefaultFocusHighlightEnabled(sb.toString(), e);
            }
        }
    }

    private boolean AGState(AccessibleObject accessibleObject) {
        int i = (getSharedInstance + 43) % 128;
        valueOf = i;
        if (!(this.values == null)) {
            if ((this.APIGuard != null ? '6' : 'U') == '6') {
                getSharedInstance = (i + 11) % 128;
                try {
                    AGState.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE).invoke(this.values, accessibleObject, Long.valueOf(((Long) AGState.getMethod("objectFieldOffset", Field.class).invoke(this.values, this.APIGuard)).longValue()), Boolean.TRUE);
                    return true;
                } catch (Exception unused) {
                }
            }
        }
        return false;
    }

    private static Object getSharedInstance() {
        int i = valueOf + 49;
        getSharedInstance = i % 128;
        try {
            Class<?> cls = (i % 2 == 0 ? 'O' : (char) 15) != 15 ? Class.forName("sun.misc.Unsafe") : Class.forName("sun.misc.Unsafe");
            AGState = cls;
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception unused) {
            return null;
        }
    }

    private static Field AGState() {
        getSharedInstance = (valueOf + 113) % 128;
        try {
            Field declaredField = AccessibleObject.class.getDeclaredField("override");
            int i = valueOf + 125;
            getSharedInstance = i % 128;
            if (i % 2 != 0) {
                return declaredField;
            }
            throw new NullPointerException();
        } catch (Exception unused) {
            return null;
        }
    }
}
