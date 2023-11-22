package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;

/* loaded from: classes3.dex */
public final class CompletableOnErrorComplete extends Completable {
    final CompletableSource BuiltInFictitiousFunctionClassFactory;
    final Predicate<? super Throwable> PlaceComponentResult;

    public CompletableOnErrorComplete(CompletableSource completableSource, Predicate<? super Throwable> predicate) {
        this.BuiltInFictitiousFunctionClassFactory = completableSource;
        this.PlaceComponentResult = predicate;
    }

    @Override // io.reactivex.Completable
    public final void MyBillsEntityDataFactory(CompletableObserver completableObserver) {
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(new OnError(completableObserver));
    }

    /* loaded from: classes6.dex */
    final class OnError implements CompletableObserver {
        private final CompletableObserver PlaceComponentResult;

        OnError(CompletableObserver completableObserver) {
            this.PlaceComponentResult = completableObserver;
        }

        @Override // io.reactivex.CompletableObserver
        public final void onComplete() {
            this.PlaceComponentResult.onComplete();
        }

        @Override // io.reactivex.CompletableObserver
        public final void onError(Throwable th) {
            try {
                if (CompletableOnErrorComplete.this.PlaceComponentResult.test(th)) {
                    this.PlaceComponentResult.onComplete();
                } else {
                    this.PlaceComponentResult.onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.MyBillsEntityDataFactory(th2);
                this.PlaceComponentResult.onError(new CompositeException(th, th2));
            }
        }

        @Override // io.reactivex.CompletableObserver
        public final void onSubscribe(Disposable disposable) {
            this.PlaceComponentResult.onSubscribe(disposable);
        }
    }
}
