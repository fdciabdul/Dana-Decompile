package com.google.android.gms.maps.model;

/* loaded from: classes7.dex */
public final class Dash extends PatternItem {
    public final float length;

    public Dash(float f) {
        super(0, Float.valueOf(Math.max(f, 0.0f)));
        this.length = Math.max(f, 0.0f);
    }

    @Override // com.google.android.gms.maps.model.PatternItem
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[Dash: length=");
        sb.append(this.length);
        sb.append("]");
        return sb.toString();
    }
}
