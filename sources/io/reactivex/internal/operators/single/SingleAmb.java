package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes9.dex */
public final class SingleAmb<T> extends Single<T> {
    private final Iterable<? extends SingleSource<? extends T>> BuiltInFictitiousFunctionClassFactory;
    private final SingleSource<? extends T>[] getAuthRequestContext;

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super T> singleObserver) {
        int length;
        SingleSource<? extends T>[] singleSourceArr = this.getAuthRequestContext;
        if (singleSourceArr == null) {
            singleSourceArr = new SingleSource[8];
            try {
                length = 0;
                for (SingleSource<? extends T> singleSource : this.BuiltInFictitiousFunctionClassFactory) {
                    if (singleSource == null) {
                        EmptyDisposable.error(new NullPointerException("One of the sources is null"), singleObserver);
                        return;
                    }
                    if (length == singleSourceArr.length) {
                        SingleSource<? extends T>[] singleSourceArr2 = new SingleSource[(length >> 2) + length];
                        System.arraycopy(singleSourceArr, 0, singleSourceArr2, 0, length);
                        singleSourceArr = singleSourceArr2;
                    }
                    singleSourceArr[length] = singleSource;
                    length++;
                }
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                EmptyDisposable.error(th, singleObserver);
                return;
            }
        } else {
            length = singleSourceArr.length;
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        singleObserver.onSubscribe(compositeDisposable);
        for (int i = 0; i < length; i++) {
            SingleSource<? extends T> singleSource2 = singleSourceArr[i];
            if (compositeDisposable.isDisposed()) {
                return;
            }
            if (singleSource2 == null) {
                compositeDisposable.dispose();
                NullPointerException nullPointerException = new NullPointerException("One of the sources is null");
                if (atomicBoolean.compareAndSet(false, true)) {
                    singleObserver.onError(nullPointerException);
                    return;
                } else {
                    RxJavaPlugins.PlaceComponentResult(nullPointerException);
                    return;
                }
            }
            singleSource2.MyBillsEntityDataFactory(new AmbSingleObserver(singleObserver, compositeDisposable, atomicBoolean));
        }
    }

    /* loaded from: classes9.dex */
    static final class AmbSingleObserver<T> implements SingleObserver<T> {
        final CompositeDisposable BuiltInFictitiousFunctionClassFactory;
        final AtomicBoolean KClassImpl$Data$declaredNonStaticMembers$2;
        Disposable MyBillsEntityDataFactory;
        final SingleObserver<? super T> getAuthRequestContext;

        AmbSingleObserver(SingleObserver<? super T> singleObserver, CompositeDisposable compositeDisposable, AtomicBoolean atomicBoolean) {
            this.getAuthRequestContext = singleObserver;
            this.BuiltInFictitiousFunctionClassFactory = compositeDisposable;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = atomicBoolean;
        }

        @Override // io.reactivex.SingleObserver
        public final void onSubscribe(Disposable disposable) {
            this.MyBillsEntityDataFactory = disposable;
            this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(disposable);
        }

        @Override // io.reactivex.SingleObserver
        public final void onSuccess(T t) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2.compareAndSet(false, true)) {
                this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory);
                this.BuiltInFictitiousFunctionClassFactory.dispose();
                this.getAuthRequestContext.onSuccess(t);
            }
        }

        @Override // io.reactivex.SingleObserver
        public final void onError(Throwable th) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2.compareAndSet(false, true)) {
                this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory);
                this.BuiltInFictitiousFunctionClassFactory.dispose();
                this.getAuthRequestContext.onError(th);
                return;
            }
            RxJavaPlugins.PlaceComponentResult(th);
        }
    }
}
