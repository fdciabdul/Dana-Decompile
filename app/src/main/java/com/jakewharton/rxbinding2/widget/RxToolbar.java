package com.jakewharton.rxbinding2.widget;

import android.view.MenuItem;
import android.widget.Toolbar;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/* loaded from: classes8.dex */
public final class RxToolbar {
    public static Observable<MenuItem> itemClicks(Toolbar toolbar) {
        Preconditions.checkNotNull(toolbar, "view == null");
        return new ToolbarItemClickObservable(toolbar);
    }

    public static Observable<Object> navigationClicks(Toolbar toolbar) {
        Preconditions.checkNotNull(toolbar, "view == null");
        return new ToolbarNavigationClickObservable(toolbar);
    }

    public static Consumer<? super CharSequence> title(final Toolbar toolbar) {
        Preconditions.checkNotNull(toolbar, "view == null");
        return new Consumer<CharSequence>() { // from class: com.jakewharton.rxbinding2.widget.RxToolbar.1
            @Override // io.reactivex.functions.Consumer
            public final void accept(CharSequence charSequence) {
                toolbar.setTitle(charSequence);
            }
        };
    }

    public static Consumer<? super Integer> titleRes(final Toolbar toolbar) {
        Preconditions.checkNotNull(toolbar, "view == null");
        return new Consumer<Integer>() { // from class: com.jakewharton.rxbinding2.widget.RxToolbar.2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Integer num) {
                toolbar.setTitle(num.intValue());
            }
        };
    }

    public static Consumer<? super CharSequence> subtitle(final Toolbar toolbar) {
        Preconditions.checkNotNull(toolbar, "view == null");
        return new Consumer<CharSequence>() { // from class: com.jakewharton.rxbinding2.widget.RxToolbar.3
            @Override // io.reactivex.functions.Consumer
            public final void accept(CharSequence charSequence) {
                toolbar.setSubtitle(charSequence);
            }
        };
    }

    public static Consumer<? super Integer> subtitleRes(final Toolbar toolbar) {
        Preconditions.checkNotNull(toolbar, "view == null");
        return new Consumer<Integer>() { // from class: com.jakewharton.rxbinding2.widget.RxToolbar.4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Integer num) {
                toolbar.setSubtitle(num.intValue());
            }
        };
    }

    private RxToolbar() {
        throw new AssertionError("No instances.");
    }
}
