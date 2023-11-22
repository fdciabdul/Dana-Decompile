package com.jakewharton.rxbinding2.view;

import android.view.ViewGroup;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;

/* loaded from: classes8.dex */
public final class RxViewGroup {
    public static Observable<ViewGroupHierarchyChangeEvent> changeEvents(ViewGroup viewGroup) {
        Preconditions.checkNotNull(viewGroup, "viewGroup == null");
        return new ViewGroupHierarchyChangeEventObservable(viewGroup);
    }

    private RxViewGroup() {
        throw new AssertionError("No instances.");
    }
}
