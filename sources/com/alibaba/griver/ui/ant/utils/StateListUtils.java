package com.alibaba.griver.ui.ant.utils;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;

/* loaded from: classes6.dex */
public class StateListUtils {
    public static StateListDrawable getStateListDrawable(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable == null) {
            return null;
        }
        if (drawable2 == null) {
            drawable2 = drawable;
        }
        if (drawable3 == null) {
            drawable3 = drawable;
        }
        if (drawable4 == null) {
            drawable4 = drawable;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, drawable2);
        stateListDrawable.addState(new int[]{-16842910}, drawable3);
        stateListDrawable.addState(new int[]{16842913}, drawable4);
        stateListDrawable.addState(new int[0], drawable);
        return stateListDrawable;
    }

    public static ColorStateList getColorStateList(int i, int i2, int i3) {
        if (i == 0) {
            return null;
        }
        if (i2 == 0) {
            i2 = i;
        }
        if (i3 == 0) {
            i3 = i;
        }
        return new ColorStateList(new int[][]{new int[]{16842919}, new int[]{-16842910}, new int[0]}, new int[]{i2, i3, i});
    }
}
