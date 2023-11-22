package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes9.dex */
public final class SingleEquals<T> extends Single<Boolean> {
    final SingleSource<? extends T> BuiltInFictitiousFunctionClassFactory;
    final SingleSource<? extends T> getAuthRequestContext;

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super Boolean> singleObserver) {
        AtomicInteger atomicInteger = new AtomicInteger();
        Object[] objArr = {null, null};
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        singleObserver.onSubscribe(compositeDisposable);
        this.getAuthRequestContext.MyBillsEntityDataFactory(new InnerObserver(0, compositeDisposable, objArr, singleObserver, atomicInteger));
        this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(new InnerObserver(1, compositeDisposable, objArr, singleObserver, atomicInteger));
    }

    /* loaded from: classes9.dex */
    static class InnerObserver<T> implements SingleObserver<T> {
        final SingleObserver<? super Boolean> BuiltInFictitiousFunctionClassFactory;
        final AtomicInteger KClassImpl$Data$declaredNonStaticMembers$2;
        final Object[] MyBillsEntityDataFactory;
        final int PlaceComponentResult;
        final CompositeDisposable getAuthRequestContext;

        InnerObserver(int i, CompositeDisposable compositeDisposable, Object[] objArr, SingleObserver<? super Boolean> singleObserver, AtomicInteger atomicInteger) {
            this.PlaceComponentResult = i;
            this.getAuthRequestContext = compositeDisposable;
            this.MyBillsEntityDataFactory = objArr;
            this.BuiltInFictitiousFunctionClassFactory = singleObserver;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = atomicInteger;
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable disposable) {
            this.getAuthRequestContext.getAuthRequestContext(disposable);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T t) {
            this.MyBillsEntityDataFactory[this.PlaceComponentResult] = t;
            if (this.KClassImpl$Data$declaredNonStaticMembers$2.incrementAndGet() == 2) {
                SingleObserver<? super Boolean> singleObserver = this.BuiltInFictitiousFunctionClassFactory;
                Object[] objArr = this.MyBillsEntityDataFactory;
                singleObserver.onSuccess(Boolean.valueOf(ObjectHelper.getAuthRequestContext(objArr[0], objArr[1])));
            }
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            int i;
            do {
                i = this.KClassImpl$Data$declaredNonStaticMembers$2.get();
                if (i >= 2) {
                    RxJavaPlugins.PlaceComponentResult(th);
                    return;
                }
            } while (!this.KClassImpl$Data$declaredNonStaticMembers$2.compareAndSet(i, 2));
            this.getAuthRequestContext.dispose();
            this.BuiltInFictitiousFunctionClassFactory.onError(th);
        }
    }
}
