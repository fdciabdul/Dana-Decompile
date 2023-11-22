package com.alibaba.griver.ui.tabbar;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;

/* loaded from: classes6.dex */
public class TabStateListDrawable extends StateListDrawable {

    /* renamed from: a  reason: collision with root package name */
    private Drawable f6763a;
    private Drawable b;

    public void addCheckedState(Drawable drawable) {
        addState(new int[]{16842919}, drawable);
        addState(new int[]{16842913}, drawable);
        this.b = drawable;
        Drawable drawable2 = this.f6763a;
        if (drawable2 != null) {
            addNormalState(drawable2);
        }
    }

    public void addNormalState(Drawable drawable) {
        synchronized (this) {
            if (this.b == null) {
                this.f6763a = drawable;
            } else {
                addState(new int[0], drawable);
            }
        }
    }
}
