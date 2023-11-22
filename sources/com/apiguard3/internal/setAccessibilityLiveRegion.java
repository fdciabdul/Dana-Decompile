package com.apiguard3.internal;

/* loaded from: classes7.dex */
public final class setAccessibilityLiveRegion extends setHovered {
    public static final setAccessibilityLiveRegion getSharedInstance = new setAccessibilityLiveRegion();
    private static int AGState = 1;
    private static int valueOf = (AGState + 37) % 128;

    @Deprecated
    public setAccessibilityLiveRegion() {
    }

    public final int hashCode() {
        valueOf = (AGState + 105) % 128;
        int hashCode = setAccessibilityLiveRegion.class.hashCode();
        int i = valueOf + 65;
        AGState = i % 128;
        if (i % 2 != 0) {
            return hashCode;
        }
        throw new ArithmeticException();
    }

    public final boolean equals(Object obj) {
        int i = (AGState + 87) % 128;
        valueOf = i;
        if (this != obj) {
            if ((obj instanceof setAccessibilityLiveRegion ? (char) 16 : 'L') == 'L') {
                return false;
            }
        }
        AGState = (i + 121) % 128;
        return true;
    }
}
