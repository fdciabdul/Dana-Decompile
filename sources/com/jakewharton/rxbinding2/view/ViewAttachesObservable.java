package com.jakewharton.rxbinding2.view;

import android.view.View;
import com.jakewharton.rxbinding2.internal.Notification;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

/* loaded from: classes8.dex */
final class ViewAttachesObservable extends Observable<Object> {
    private final boolean callOnAttach;
    private final View view;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewAttachesObservable(View view, boolean z) {
        this.view = view;
        this.callOnAttach = z;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super Object> observer) {
        if (Preconditions.checkMainThread(observer)) {
            Listener listener = new Listener(this.view, this.callOnAttach, observer);
            observer.onSubscribe(listener);
            this.view.addOnAttachStateChangeListener(listener);
        }
    }

    /* loaded from: classes8.dex */
    static final class Listener extends MainThreadDisposable implements View.OnAttachStateChangeListener {
        private final boolean callOnAttach;
        private final Observer<? super Object> observer;
        private final View view;

        Listener(View view, boolean z, Observer<? super Object> observer) {
            this.view = view;
            this.callOnAttach = z;
            this.observer = observer;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
            if (!this.callOnAttach || isDisposed()) {
                return;
            }
            this.observer.onNext(Notification.INSTANCE);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
            if (this.callOnAttach || isDisposed()) {
                return;
            }
            this.observer.onNext(Notification.INSTANCE);
        }

        @Override // io.reactivex.android.MainThreadDisposable
        public final void onDispose() {
            this.view.removeOnAttachStateChangeListener(this);
        }
    }
}
