package com.alibaba.griver.ui.blur;

/* loaded from: classes6.dex */
public final class Helper {
    public static boolean hasZero(int... iArr) {
        for (int i : iArr) {
            if (i == 0) {
                return true;
            }
        }
        return false;
    }
}
