package com.apiguard3.internal;

import java.lang.reflect.AccessibleObject;

/* loaded from: classes7.dex */
public abstract class setVerticalFadingEdgeEnabled {
    private static final setVerticalFadingEdgeEnabled AGState;
    private static int valueOf = 0;
    private static int values = 1;

    public abstract void valueOf(AccessibleObject accessibleObject);

    static {
        setVerticalFadingEdgeEnabled sethorizontalscrollbarenabled;
        if (setPivotY.AGState() < 9) {
            sethorizontalscrollbarenabled = new setOutlineAmbientShadowColor();
            valueOf = (values + 47) % 128;
        } else {
            sethorizontalscrollbarenabled = new setHorizontalScrollBarEnabled();
        }
        AGState = sethorizontalscrollbarenabled;
        int i = values + 61;
        valueOf = i % 128;
        if (i % 2 != 0) {
            throw new NullPointerException();
        }
    }

    public static setVerticalFadingEdgeEnabled values() {
        int i = values;
        valueOf = (i + 87) % 128;
        setVerticalFadingEdgeEnabled setverticalfadingedgeenabled = AGState;
        valueOf = (i + 83) % 128;
        return setverticalfadingedgeenabled;
    }
}
