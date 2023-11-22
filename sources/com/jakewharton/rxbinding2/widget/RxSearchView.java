package com.jakewharton.rxbinding2.widget;

import android.widget.SearchView;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.functions.Consumer;

/* loaded from: classes8.dex */
public final class RxSearchView {
    public static InitialValueObservable<SearchViewQueryTextEvent> queryTextChangeEvents(SearchView searchView) {
        Preconditions.checkNotNull(searchView, "view == null");
        return new SearchViewQueryTextChangeEventsObservable(searchView);
    }

    public static InitialValueObservable<CharSequence> queryTextChanges(SearchView searchView) {
        Preconditions.checkNotNull(searchView, "view == null");
        return new SearchViewQueryTextChangesObservable(searchView);
    }

    public static Consumer<? super CharSequence> query(final SearchView searchView, final boolean z) {
        Preconditions.checkNotNull(searchView, "view == null");
        return new Consumer<CharSequence>() { // from class: com.jakewharton.rxbinding2.widget.RxSearchView.1
            @Override // io.reactivex.functions.Consumer
            public final void accept(CharSequence charSequence) {
                searchView.setQuery(charSequence, z);
            }
        };
    }

    private RxSearchView() {
        throw new AssertionError("No instances.");
    }
}
