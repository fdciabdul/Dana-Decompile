package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes9.dex */
public final class SingleDoAfterTerminate<T> extends Single<T> {
    final Action BuiltInFictitiousFunctionClassFactory;
    final SingleSource<T> getAuthRequestContext;

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super T> singleObserver) {
        this.getAuthRequestContext.MyBillsEntityDataFactory(new DoAfterTerminateObserver(singleObserver, this.BuiltInFictitiousFunctionClassFactory));
    }

    /* loaded from: classes9.dex */
    static final class DoAfterTerminateObserver<T> implements SingleObserver<T>, Disposable {
        final SingleObserver<? super T> KClassImpl$Data$declaredNonStaticMembers$2;
        Disposable MyBillsEntityDataFactory;
        final Action PlaceComponentResult;

        DoAfterTerminateObserver(SingleObserver<? super T> singleObserver, Action action) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = singleObserver;
            this.PlaceComponentResult = action;
        }

        @Override // io.reactivex.SingleObserver
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.MyBillsEntityDataFactory, disposable)) {
                this.MyBillsEntityDataFactory = disposable;
                this.KClassImpl$Data$declaredNonStaticMembers$2.onSubscribe(this);
            }
        }

        @Override // io.reactivex.SingleObserver
        public final void onSuccess(T t) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.onSuccess(t);
            try {
                this.PlaceComponentResult.run();
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                RxJavaPlugins.PlaceComponentResult(th);
            }
        }

        @Override // io.reactivex.SingleObserver
        public final void onError(Throwable th) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.onError(th);
            try {
                this.PlaceComponentResult.run();
            } catch (Throwable th2) {
                Exceptions.MyBillsEntityDataFactory(th2);
                RxJavaPlugins.PlaceComponentResult(th2);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.MyBillsEntityDataFactory.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.MyBillsEntityDataFactory.isDisposed();
        }
    }
}
