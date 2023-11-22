package com.jakewharton.rxbinding2.view;

import android.view.View;
import android.view.ViewGroup;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

/* loaded from: classes8.dex */
final class ViewGroupHierarchyChangeEventObservable extends Observable<ViewGroupHierarchyChangeEvent> {
    private final ViewGroup viewGroup;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewGroupHierarchyChangeEventObservable(ViewGroup viewGroup) {
        this.viewGroup = viewGroup;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super ViewGroupHierarchyChangeEvent> observer) {
        if (Preconditions.checkMainThread(observer)) {
            Listener listener = new Listener(this.viewGroup, observer);
            observer.onSubscribe(listener);
            this.viewGroup.setOnHierarchyChangeListener(listener);
        }
    }

    /* loaded from: classes8.dex */
    static final class Listener extends MainThreadDisposable implements ViewGroup.OnHierarchyChangeListener {
        private final Observer<? super ViewGroupHierarchyChangeEvent> observer;
        private final ViewGroup viewGroup;

        Listener(ViewGroup viewGroup, Observer<? super ViewGroupHierarchyChangeEvent> observer) {
            this.viewGroup = viewGroup;
            this.observer = observer;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public final void onChildViewAdded(View view, View view2) {
            if (isDisposed()) {
                return;
            }
            this.observer.onNext(ViewGroupHierarchyChildViewAddEvent.create(this.viewGroup, view2));
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public final void onChildViewRemoved(View view, View view2) {
            if (isDisposed()) {
                return;
            }
            this.observer.onNext(ViewGroupHierarchyChildViewRemoveEvent.create(this.viewGroup, view2));
        }

        @Override // io.reactivex.android.MainThreadDisposable
        public final void onDispose() {
            this.viewGroup.setOnHierarchyChangeListener(null);
        }
    }
}
