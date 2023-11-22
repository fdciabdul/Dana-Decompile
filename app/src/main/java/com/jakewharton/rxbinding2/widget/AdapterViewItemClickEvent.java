package com.jakewharton.rxbinding2.widget;

import android.view.View;
import android.widget.AdapterView;

/* loaded from: classes8.dex */
public abstract class AdapterViewItemClickEvent {
    public abstract View clickedView();

    public abstract long id();

    public abstract int position();

    public abstract AdapterView<?> view();

    public static AdapterViewItemClickEvent create(AdapterView<?> adapterView, View view, int i, long j) {
        return new AutoValue_AdapterViewItemClickEvent(adapterView, view, i, j);
    }
}
