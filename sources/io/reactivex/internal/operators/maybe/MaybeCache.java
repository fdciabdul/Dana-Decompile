package io.reactivex.internal.operators.maybe;

import androidx.view.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes9.dex */
public final class MaybeCache<T> extends Maybe<T> implements MaybeObserver<T> {
    final AtomicReference<CacheDisposable<T>[]> KClassImpl$Data$declaredNonStaticMembers$2;
    Throwable MyBillsEntityDataFactory;
    T NetworkUserEntityData$$ExternalSyntheticLambda0;
    final AtomicReference<MaybeSource<T>> PlaceComponentResult;
    static final CacheDisposable[] getAuthRequestContext = new CacheDisposable[0];
    static final CacheDisposable[] BuiltInFictitiousFunctionClassFactory = new CacheDisposable[0];

    @Override // io.reactivex.MaybeObserver
    public final void onSubscribe(Disposable disposable) {
    }

    @Override // io.reactivex.Maybe
    public final void MyBillsEntityDataFactory(MaybeObserver<? super T> maybeObserver) {
        CacheDisposable<T> cacheDisposable = new CacheDisposable<>(maybeObserver, this);
        maybeObserver.onSubscribe(cacheDisposable);
        if (KClassImpl$Data$declaredNonStaticMembers$2(cacheDisposable)) {
            if (cacheDisposable.isDisposed()) {
                MyBillsEntityDataFactory(cacheDisposable);
                return;
            }
            MaybeSource<T> andSet = this.PlaceComponentResult.getAndSet(null);
            if (andSet != null) {
                andSet.PlaceComponentResult(this);
            }
        } else if (cacheDisposable.isDisposed()) {
        } else {
            Throwable th = this.MyBillsEntityDataFactory;
            if (th != null) {
                maybeObserver.onError(th);
                return;
            }
            Object obj = (T) this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (obj != null) {
                maybeObserver.onSuccess(obj);
            } else {
                maybeObserver.onComplete();
            }
        }
    }

    @Override // io.reactivex.MaybeObserver
    public final void onSuccess(T t) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = t;
        for (CacheDisposable<T> cacheDisposable : this.KClassImpl$Data$declaredNonStaticMembers$2.getAndSet(BuiltInFictitiousFunctionClassFactory)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.downstream.onSuccess(t);
            }
        }
    }

    @Override // io.reactivex.MaybeObserver
    public final void onError(Throwable th) {
        this.MyBillsEntityDataFactory = th;
        for (CacheDisposable<T> cacheDisposable : this.KClassImpl$Data$declaredNonStaticMembers$2.getAndSet(BuiltInFictitiousFunctionClassFactory)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.downstream.onError(th);
            }
        }
    }

    @Override // io.reactivex.MaybeObserver
    public final void onComplete() {
        for (CacheDisposable<T> cacheDisposable : this.KClassImpl$Data$declaredNonStaticMembers$2.getAndSet(BuiltInFictitiousFunctionClassFactory)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.downstream.onComplete();
            }
        }
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2(CacheDisposable<T> cacheDisposable) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = this.KClassImpl$Data$declaredNonStaticMembers$2.get();
            if (cacheDisposableArr == BuiltInFictitiousFunctionClassFactory) {
                return false;
            }
            int length = cacheDisposableArr.length;
            cacheDisposableArr2 = new CacheDisposable[length + 1];
            System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr2, 0, length);
            cacheDisposableArr2[length] = cacheDisposable;
        } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2, cacheDisposableArr, cacheDisposableArr2));
        return true;
    }

    final void MyBillsEntityDataFactory(CacheDisposable<T> cacheDisposable) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = this.KClassImpl$Data$declaredNonStaticMembers$2.get();
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
                cacheDisposableArr2 = getAuthRequestContext;
            } else {
                CacheDisposable[] cacheDisposableArr3 = new CacheDisposable[length - 1];
                System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr3, 0, i);
                System.arraycopy(cacheDisposableArr, i + 1, cacheDisposableArr3, i, (length - i) - 1);
                cacheDisposableArr2 = cacheDisposableArr3;
            }
        } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2, cacheDisposableArr, cacheDisposableArr2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class CacheDisposable<T> extends AtomicReference<MaybeCache<T>> implements Disposable {
        private static final long serialVersionUID = -5791853038359966195L;
        final MaybeObserver<? super T> downstream;

        CacheDisposable(MaybeObserver<? super T> maybeObserver, MaybeCache<T> maybeCache) {
            super(maybeCache);
            this.downstream = maybeObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            MaybeCache<T> andSet = getAndSet(null);
            if (andSet != null) {
                andSet.MyBillsEntityDataFactory(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return get() == null;
        }
    }
}
