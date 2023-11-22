package com.apiguard3.internal;

import id.dana.cashier.view.InputCardNumberView;
import java.util.Map;
import java.util.Set;

/* loaded from: classes7.dex */
public final class setImportantForAccessibility extends setHovered {
    private static int AGState = 1;
    private static int APIGuard;
    private final setX<String, setHovered> values = new setX<>();

    public final void values(String str, setHovered sethovered) {
        int i = APIGuard;
        AGState = (i + 63) % 128;
        setX<String, setHovered> setx = this.values;
        if (sethovered == null) {
            AGState = (i + 49) % 128;
            sethovered = setAccessibilityLiveRegion.getSharedInstance;
        }
        setx.put(str, sethovered);
    }

    public final Set<Map.Entry<String, setHovered>> updateKernel() {
        int i = APIGuard + 87;
        AGState = i % 128;
        if ((i % 2 == 0 ? '1' : 'O') != '1') {
            return this.values.entrySet();
        }
        this.values.entrySet();
        throw new ArithmeticException();
    }

    public final boolean equals(Object obj) {
        int i = AGState + 123;
        int i2 = i % 128;
        APIGuard = i2;
        int i3 = i % 2;
        if (i3 != 0) {
            throw null;
        }
        if (!(obj == this)) {
            if (obj instanceof setImportantForAccessibility) {
                APIGuard = i2;
                setX<String, setHovered> setx = ((setImportantForAccessibility) obj).values;
                if (i3 != 0) {
                    setx.equals(this.values);
                    throw new ArithmeticException();
                } else if (!setx.equals(this.values)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        AGState = (APIGuard + 1) % 128;
        int hashCode = this.values.hashCode();
        int i = AGState + 95;
        APIGuard = i % 128;
        if ((i % 2 != 0 ? InputCardNumberView.DIVIDER : 'E') == 'E') {
            return hashCode;
        }
        throw new NullPointerException();
    }
}
