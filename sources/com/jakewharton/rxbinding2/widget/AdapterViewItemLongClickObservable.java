package com.jakewharton.rxbinding2.widget;

import android.view.View;
import android.widget.AdapterView;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import java.util.concurrent.Callable;

/* loaded from: classes8.dex */
final class AdapterViewItemLongClickObservable extends Observable<Integer> {
    private final Callable<Boolean> handled;
    private final AdapterView<?> view;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdapterViewItemLongClickObservable(AdapterView<?> adapterView, Callable<Boolean> callable) {
        this.view = adapterView;
        this.handled = callable;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super Integer> observer) {
        if (Preconditions.checkMainThread(observer)) {
            Listener listener = new Listener(this.view, observer, this.handled);
            observer.onSubscribe(listener);
            this.view.setOnItemLongClickListener(listener);
        }
    }

    /* loaded from: classes8.dex */
    static final class Listener extends MainThreadDisposable implements AdapterView.OnItemLongClickListener {
        private final Callable<Boolean> handled;
        private final Observer<? super Integer> observer;
        private final AdapterView<?> view;

        Listener(AdapterView<?> adapterView, Observer<? super Integer> observer, Callable<Boolean> callable) {
            this.view = adapterView;
            this.observer = observer;
            this.handled = callable;
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (isDisposed()) {
                return false;
            }
            try {
                if (this.handled.call().booleanValue()) {
                    this.observer.onNext(Integer.valueOf(i));
                    return true;
                }
                return false;
            } catch (Exception e) {
                this.observer.onError(e);
                dispose();
                return false;
            }
        }

        @Override // io.reactivex.android.MainThreadDisposable
        public final void onDispose() {
            this.view.setOnItemLongClickListener(null);
        }
    }
}
