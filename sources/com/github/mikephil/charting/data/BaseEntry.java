package com.github.mikephil.charting.data;

import android.graphics.drawable.Drawable;

/* loaded from: classes3.dex */
public abstract class BaseEntry {
    public Object KClassImpl$Data$declaredNonStaticMembers$2;
    private float getAuthRequestContext;
    public Drawable lookAheadTest;

    public BaseEntry() {
        this.getAuthRequestContext = 0.0f;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        this.lookAheadTest = null;
    }

    public BaseEntry(float f) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        this.lookAheadTest = null;
        this.getAuthRequestContext = f;
    }

    public BaseEntry(float f, Object obj) {
        this(f);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = obj;
    }

    public float getAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    public final void PlaceComponentResult(float f) {
        this.getAuthRequestContext = f;
    }
}
