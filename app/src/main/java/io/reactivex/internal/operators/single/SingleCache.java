package io.reactivex.internal.operators.single;

import androidx.view.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes9.dex */
public final class SingleCache<T> extends Single<T> implements SingleObserver<T> {
    static final CacheDisposable[] BuiltInFictitiousFunctionClassFactory = new CacheDisposable[0];
    static final CacheDisposable[] getAuthRequestContext = new CacheDisposable[0];
    Throwable KClassImpl$Data$declaredNonStaticMembers$2;
    final SingleSource<? extends T> MyBillsEntityDataFactory;
    T NetworkUserEntityData$$ExternalSyntheticLambda0;
    final AtomicReference<CacheDisposable<T>[]> PlaceComponentResult;
    final AtomicInteger moveToNextValue;

    @Override // io.reactivex.SingleObserver
    public final void onSubscribe(Disposable disposable) {
    }

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super T> singleObserver) {
        CacheDisposable<T> cacheDisposable = new CacheDisposable<>(singleObserver, this);
        singleObserver.onSubscribe(cacheDisposable);
        if (KClassImpl$Data$declaredNonStaticMembers$2(cacheDisposable)) {
            if (cacheDisposable.isDisposed()) {
                PlaceComponentResult(cacheDisposable);
            }
            if (this.moveToNextValue.getAndIncrement() == 0) {
                this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(this);
                return;
            }
            return;
        }
        Throwable th = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (th != null) {
            singleObserver.onError(th);
        } else {
            singleObserver.onSuccess((T) this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        }
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2(CacheDisposable<T> cacheDisposable) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = this.PlaceComponentResult.get();
            if (cacheDisposableArr == getAuthRequestContext) {
                return false;
            }
            int length = cacheDisposableArr.length;
            cacheDisposableArr2 = new CacheDisposable[length + 1];
            System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr2, 0, length);
            cacheDisposableArr2[length] = cacheDisposable;
        } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, cacheDisposableArr, cacheDisposableArr2));
        return true;
    }

    final void PlaceComponentResult(CacheDisposable<T> cacheDisposable) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = this.PlaceComponentResult.get();
            int length = cacheDisposableArr.length;
            if (length == 0) {
                return;
            }
            int i = 0;
            while (true) {
                if (i >= length) {
                    i = -1;
                    break;
                } else if (cacheDisposableArr[i] == cacheDisposable) {
                    break;
                } else {
                    i++;
                }
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                cacheDisposableArr2 = BuiltInFictitiousFunctionClassFactory;
            } else {
                CacheDisposable[] cacheDisposableArr3 = new CacheDisposable[length - 1];
                System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr3, 0, i);
                System.arraycopy(cacheDisposableArr, i + 1, cacheDisposableArr3, i, (length - i) - 1);
                cacheDisposableArr2 = cacheDisposableArr3;
            }
        } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, cacheDisposableArr, cacheDisposableArr2));
    }

    @Override // io.reactivex.SingleObserver
    public final void onSuccess(T t) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = t;
        for (CacheDisposable<T> cacheDisposable : this.PlaceComponentResult.getAndSet(getAuthRequestContext)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.downstream.onSuccess(t);
            }
        }
    }

    @Override // io.reactivex.SingleObserver
    public final void onError(Throwable th) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = th;
        for (CacheDisposable<T> cacheDisposable : this.PlaceComponentResult.getAndSet(getAuthRequestContext)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.downstream.onError(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class CacheDisposable<T> extends AtomicBoolean implements Disposable {
        private static final long serialVersionUID = 7514387411091976596L;
        final SingleObserver<? super T> downstream;
        final SingleCache<T> parent;

        CacheDisposable(SingleObserver<? super T> singleObserver, SingleCache<T> singleCache) {
            this.downstream = singleObserver;
            this.parent = singleCache;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return get();
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            if (compareAndSet(false, true)) {
                this.parent.PlaceComponentResult(this);
            }
        }
    }
}
