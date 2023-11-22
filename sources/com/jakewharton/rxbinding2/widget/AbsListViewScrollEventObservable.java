package com.jakewharton.rxbinding2.widget;

import android.widget.AbsListView;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

/* loaded from: classes8.dex */
final class AbsListViewScrollEventObservable extends Observable<AbsListViewScrollEvent> {
    private final AbsListView view;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbsListViewScrollEventObservable(AbsListView absListView) {
        this.view = absListView;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super AbsListViewScrollEvent> observer) {
        if (Preconditions.checkMainThread(observer)) {
            Listener listener = new Listener(this.view, observer);
            observer.onSubscribe(listener);
            this.view.setOnScrollListener(listener);
        }
    }

    /* loaded from: classes8.dex */
    static final class Listener extends MainThreadDisposable implements AbsListView.OnScrollListener {
        private int currentScrollState = 0;
        private final Observer<? super AbsListViewScrollEvent> observer;
        private final AbsListView view;

        Listener(AbsListView absListView, Observer<? super AbsListViewScrollEvent> observer) {
            this.view = absListView;
            this.observer = observer;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public final void onScrollStateChanged(AbsListView absListView, int i) {
            this.currentScrollState = i;
            if (isDisposed()) {
                return;
            }
            AbsListView absListView2 = this.view;
            this.observer.onNext(AbsListViewScrollEvent.create(absListView2, i, absListView2.getFirstVisiblePosition(), this.view.getChildCount(), this.view.getCount()));
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (isDisposed()) {
                return;
            }
            this.observer.onNext(AbsListViewScrollEvent.create(this.view, this.currentScrollState, i, i2, i3));
        }

        @Override // io.reactivex.android.MainThreadDisposable
        public final void onDispose() {
            this.view.setOnScrollListener(null);
        }
    }
}
