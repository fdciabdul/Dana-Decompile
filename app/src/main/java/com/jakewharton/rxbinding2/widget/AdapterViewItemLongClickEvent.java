package com.jakewharton.rxbinding2.widget;

import android.view.View;
import android.widget.AdapterView;

/* loaded from: classes8.dex */
public abstract class AdapterViewItemLongClickEvent {
    public abstract View clickedView();

    public abstract long id();

    public abstract int position();

    public abstract AdapterView<?> view();

    public static AdapterViewItemLongClickEvent create(AdapterView<?> adapterView, View view, int i, long j) {
        return new AutoValue_AdapterViewItemLongClickEvent(adapterView, view, i, j);
    }
}
