package com.jakewharton.rxbinding2.widget;

import android.widget.CheckedTextView;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.functions.Consumer;

/* loaded from: classes8.dex */
public final class RxCheckedTextView {
    public static Consumer<? super Boolean> check(final CheckedTextView checkedTextView) {
        Preconditions.checkNotNull(checkedTextView, "view == null");
        return new Consumer<Boolean>() { // from class: com.jakewharton.rxbinding2.widget.RxCheckedTextView.1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Boolean bool) {
                checkedTextView.setChecked(bool.booleanValue());
            }
        };
    }

    private RxCheckedTextView() {
        throw new AssertionError("No instances.");
    }
}
