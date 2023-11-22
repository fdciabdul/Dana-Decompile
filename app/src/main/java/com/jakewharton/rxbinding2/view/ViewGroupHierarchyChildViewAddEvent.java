package com.jakewharton.rxbinding2.view;

import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes8.dex */
public abstract class ViewGroupHierarchyChildViewAddEvent extends ViewGroupHierarchyChangeEvent {
    public static ViewGroupHierarchyChildViewAddEvent create(ViewGroup viewGroup, View view) {
        return new AutoValue_ViewGroupHierarchyChildViewAddEvent(viewGroup, view);
    }
}
