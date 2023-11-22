package com.jakewharton.rxbinding2.widget;

import android.view.KeyEvent;
import android.widget.TextView;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import io.reactivex.functions.Predicate;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class TextViewEditorActionObservable extends Observable<Integer> {
    private final Predicate<? super Integer> handled;
    private final TextView view;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TextViewEditorActionObservable(TextView textView, Predicate<? super Integer> predicate) {
        this.view = textView;
        this.handled = predicate;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super Integer> observer) {
        if (Preconditions.checkMainThread(observer)) {
            Listener listener = new Listener(this.view, observer, this.handled);
            observer.onSubscribe(listener);
            this.view.setOnEditorActionListener(listener);
        }
    }

    /* loaded from: classes8.dex */
    static final class Listener extends MainThreadDisposable implements TextView.OnEditorActionListener {
        private final Predicate<? super Integer> handled;
        private final Observer<? super Integer> observer;
        private final TextView view;

        Listener(TextView textView, Observer<? super Integer> observer, Predicate<? super Integer> predicate) {
            this.view = textView;
            this.observer = observer;
            this.handled = predicate;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            try {
                if (isDisposed() || !this.handled.test(Integer.valueOf(i))) {
                    return false;
                }
                this.observer.onNext(Integer.valueOf(i));
                return true;
            } catch (Exception e) {
                this.observer.onError(e);
                dispose();
                return false;
            }
        }

        @Override // io.reactivex.android.MainThreadDisposable
        public final void onDispose() {
            this.view.setOnEditorActionListener(null);
        }
    }
}
