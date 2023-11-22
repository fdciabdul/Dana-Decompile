package com.jakewharton.rxbinding2.widget;

import android.widget.TextSwitcher;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.functions.Consumer;

/* loaded from: classes8.dex */
public final class RxTextSwitcher {
    public static Consumer<? super CharSequence> text(final TextSwitcher textSwitcher) {
        Preconditions.checkNotNull(textSwitcher, "view == null");
        return new Consumer<CharSequence>() { // from class: com.jakewharton.rxbinding2.widget.RxTextSwitcher.1
            @Override // io.reactivex.functions.Consumer
            public final void accept(CharSequence charSequence) {
                textSwitcher.setText(charSequence);
            }
        };
    }

    public static Consumer<? super CharSequence> currentText(final TextSwitcher textSwitcher) {
        Preconditions.checkNotNull(textSwitcher, "view == null");
        return new Consumer<CharSequence>() { // from class: com.jakewharton.rxbinding2.widget.RxTextSwitcher.2
            @Override // io.reactivex.functions.Consumer
            public final void accept(CharSequence charSequence) {
                textSwitcher.setCurrentText(charSequence);
            }
        };
    }

    private RxTextSwitcher() {
        throw new AssertionError("No instances.");
    }
}
