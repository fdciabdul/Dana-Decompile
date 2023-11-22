package com.alibaba.ariver.app.ui.tabbar;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import com.fullstory.instrumentation.FSDraw;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes6.dex */
public class TabStateListDrawable extends StateListDrawable implements FSDraw {

    /* renamed from: a  reason: collision with root package name */
    private Drawable f5988a;
    private Drawable b;

    public void fsSuperDraw_c9b34d9b58e860f1f1d01e399a325c9b(Canvas canvas) {
        if (InstrumentInjector.isRecordingDraw(this, canvas)) {
            return;
        }
        super.draw(canvas);
    }

    public void addCheckedState(Drawable drawable) {
        addState(new int[]{16842919}, drawable);
        addState(new int[]{16842913}, drawable);
        this.b = drawable;
        Drawable drawable2 = this.f5988a;
        if (drawable2 != null) {
            addNormalState(drawable2);
        }
    }

    public void addNormalState(Drawable drawable) {
        synchronized (this) {
            if (this.b == null) {
                this.f5988a = drawable;
            } else {
                addState(new int[0], drawable);
            }
        }
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable;
        if (this.b == null && (drawable = this.f5988a) != null) {
            drawable.draw(canvas);
        } else {
            fsSuperDraw_c9b34d9b58e860f1f1d01e399a325c9b(canvas);
        }
    }
}
