package com.github.mikephil.charting.components;

import android.graphics.Canvas;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;

/* loaded from: classes3.dex */
public interface IMarker {
    void draw(Canvas canvas, float f, float f2);

    void refreshContent(Entry entry, Highlight highlight);
}
