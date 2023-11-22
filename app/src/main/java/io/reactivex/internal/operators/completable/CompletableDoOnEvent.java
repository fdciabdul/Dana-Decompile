package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;

/* loaded from: classes9.dex */
public final class CompletableDoOnEvent extends Completable {
    final CompletableSource PlaceComponentResult;
    final Consumer<? super Throwable> getAuthRequestContext;

    @Override // io.reactivex.Completable
    public final void MyBillsEntityDataFactory(CompletableObserver completableObserver) {
        this.PlaceComponentResult.getAuthRequestContext(new DoOnEvent(completableObserver));
    }

    /* loaded from: classes9.dex */
    final class DoOnEvent implements CompletableObserver {
        private final CompletableObserver MyBillsEntityDataFactory;

        DoOnEvent(CompletableObserver completableObserver) {
            this.MyBillsEntityDataFactory = completableObserver;
        }

        @Override // io.reactivex.CompletableObserver
        public final void onComplete() {
            try {
                CompletableDoOnEvent.this.getAuthRequestContext.accept(null);
                this.MyBillsEntityDataFactory.onComplete();
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                this.MyBillsEntityDataFactory.onError(th);
            }
        }

        @Override // io.reactivex.CompletableObserver
        public final void onError(Throwable th) {
            try {
                CompletableDoOnEvent.this.getAuthRequestContext.accept(th);
            } catch (Throwable th2) {
                Exceptions.MyBillsEntityDataFactory(th2);
                th = new CompositeException(th, th2);
            }
            this.MyBillsEntityDataFactory.onError(th);
        }

        @Override // io.reactivex.CompletableObserver
        public final void onSubscribe(Disposable disposable) {
            this.MyBillsEntityDataFactory.onSubscribe(disposable);
        }
    }
}
