package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;

/* loaded from: classes9.dex */
public final class MaybeDoOnTerminate<T> extends Maybe<T> {
    final Action BuiltInFictitiousFunctionClassFactory;
    final MaybeSource<T> MyBillsEntityDataFactory;

    @Override // io.reactivex.Maybe
    public final void MyBillsEntityDataFactory(MaybeObserver<? super T> maybeObserver) {
        this.MyBillsEntityDataFactory.PlaceComponentResult(new DoOnTerminate(maybeObserver));
    }

    /* loaded from: classes9.dex */
    final class DoOnTerminate implements MaybeObserver<T> {
        final MaybeObserver<? super T> KClassImpl$Data$declaredNonStaticMembers$2;

        DoOnTerminate(MaybeObserver<? super T> maybeObserver) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = maybeObserver;
        }

        @Override // io.reactivex.MaybeObserver
        public final void onSubscribe(Disposable disposable) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.onSubscribe(disposable);
        }

        @Override // io.reactivex.MaybeObserver
        public final void onSuccess(T t) {
            try {
                MaybeDoOnTerminate.this.BuiltInFictitiousFunctionClassFactory.run();
                this.KClassImpl$Data$declaredNonStaticMembers$2.onSuccess(t);
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                this.KClassImpl$Data$declaredNonStaticMembers$2.onError(th);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public final void onError(Throwable th) {
            try {
                MaybeDoOnTerminate.this.BuiltInFictitiousFunctionClassFactory.run();
            } catch (Throwable th2) {
                Exceptions.MyBillsEntityDataFactory(th2);
                th = new CompositeException(th, th2);
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public final void onComplete() {
            try {
                MaybeDoOnTerminate.this.BuiltInFictitiousFunctionClassFactory.run();
                this.KClassImpl$Data$declaredNonStaticMembers$2.onComplete();
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                this.KClassImpl$Data$declaredNonStaticMembers$2.onError(th);
            }
        }
    }
}
