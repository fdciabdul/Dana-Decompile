package com.apiguard3.internal;

import java.lang.reflect.AccessibleObject;
import kotlin.text.Typography;

/* loaded from: classes7.dex */
final class setOutlineAmbientShadowColor extends setVerticalFadingEdgeEnabled {
    private static int AGState = 0;
    private static int values = 1;

    @Override // com.apiguard3.internal.setVerticalFadingEdgeEnabled
    public final void valueOf(AccessibleObject accessibleObject) {
        int i = values + 109;
        AGState = i % 128;
        accessibleObject.setAccessible((i % 2 != 0 ? Typography.amp : (char) 3) == 3);
    }
}
