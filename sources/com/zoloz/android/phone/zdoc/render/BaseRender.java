package com.zoloz.android.phone.zdoc.render;

import android.view.View;

/* loaded from: classes8.dex */
public abstract class BaseRender {
    protected View view;

    protected abstract void renderBg();

    protected abstract void renderColor();

    protected abstract void renderLabel();

    public BaseRender(View view) {
        this.view = view;
    }

    public void render() {
        if (this.view == null) {
            return;
        }
        renderBg();
        renderLabel();
        renderColor();
    }
}
