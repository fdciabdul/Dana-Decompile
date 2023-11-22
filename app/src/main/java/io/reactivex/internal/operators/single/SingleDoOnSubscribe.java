package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes9.dex */
public final class SingleDoOnSubscribe<T> extends Single<T> {
    final Consumer<? super Disposable> BuiltInFictitiousFunctionClassFactory;
    final SingleSource<T> PlaceComponentResult;

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super T> singleObserver) {
        this.PlaceComponentResult.MyBillsEntityDataFactory(new DoOnSubscribeSingleObserver(singleObserver, this.BuiltInFictitiousFunctionClassFactory));
    }

    /* loaded from: classes9.dex */
    static final class DoOnSubscribeSingleObserver<T> implements SingleObserver<T> {
        final SingleObserver<? super T> KClassImpl$Data$declaredNonStaticMembers$2;
        boolean MyBillsEntityDataFactory;
        final Consumer<? super Disposable> getAuthRequestContext;

        DoOnSubscribeSingleObserver(SingleObserver<? super T> singleObserver, Consumer<? super Disposable> consumer) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = singleObserver;
            this.getAuthRequestContext = consumer;
        }

        @Override // io.reactivex.SingleObserver
        public final void onSubscribe(Disposable disposable) {
            try {
                this.getAuthRequestContext.accept(disposable);
                this.KClassImpl$Data$declaredNonStaticMembers$2.onSubscribe(disposable);
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                this.MyBillsEntityDataFactory = true;
                disposable.dispose();
                EmptyDisposable.error(th, this.KClassImpl$Data$declaredNonStaticMembers$2);
            }
        }

        @Override // io.reactivex.SingleObserver
        public final void onSuccess(T t) {
            if (this.MyBillsEntityDataFactory) {
                return;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.onSuccess(t);
        }

        @Override // io.reactivex.SingleObserver
        public final void onError(Throwable th) {
            if (this.MyBillsEntityDataFactory) {
                RxJavaPlugins.PlaceComponentResult(th);
            } else {
                this.KClassImpl$Data$declaredNonStaticMembers$2.onError(th);
            }
        }
    }
}
