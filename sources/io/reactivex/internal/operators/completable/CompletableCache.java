package io.reactivex.internal.operators.completable;

import androidx.view.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes9.dex */
public final class CompletableCache extends Completable implements CompletableObserver {
    final AtomicBoolean BuiltInFictitiousFunctionClassFactory;
    Throwable KClassImpl$Data$declaredNonStaticMembers$2;
    final AtomicReference<InnerCompletableCache[]> MyBillsEntityDataFactory;
    final CompletableSource lookAheadTest;
    static final InnerCompletableCache[] getAuthRequestContext = new InnerCompletableCache[0];
    static final InnerCompletableCache[] PlaceComponentResult = new InnerCompletableCache[0];

    @Override // io.reactivex.CompletableObserver
    public final void onSubscribe(Disposable disposable) {
    }

    @Override // io.reactivex.Completable
    public final void MyBillsEntityDataFactory(CompletableObserver completableObserver) {
        InnerCompletableCache innerCompletableCache = new InnerCompletableCache(completableObserver);
        completableObserver.onSubscribe(innerCompletableCache);
        if (MyBillsEntityDataFactory(innerCompletableCache)) {
            if (innerCompletableCache.isDisposed()) {
                PlaceComponentResult(innerCompletableCache);
            }
            if (this.BuiltInFictitiousFunctionClassFactory.compareAndSet(false, true)) {
                this.lookAheadTest.getAuthRequestContext(this);
                return;
            }
            return;
        }
        Throwable th = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (th != null) {
            completableObserver.onError(th);
        } else {
            completableObserver.onComplete();
        }
    }

    @Override // io.reactivex.CompletableObserver
    public final void onError(Throwable th) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = th;
        for (InnerCompletableCache innerCompletableCache : this.MyBillsEntityDataFactory.getAndSet(PlaceComponentResult)) {
            if (!innerCompletableCache.get()) {
                innerCompletableCache.downstream.onError(th);
            }
        }
    }

    @Override // io.reactivex.CompletableObserver
    public final void onComplete() {
        for (InnerCompletableCache innerCompletableCache : this.MyBillsEntityDataFactory.getAndSet(PlaceComponentResult)) {
            if (!innerCompletableCache.get()) {
                innerCompletableCache.downstream.onComplete();
            }
        }
    }

    private boolean MyBillsEntityDataFactory(InnerCompletableCache innerCompletableCache) {
        InnerCompletableCache[] innerCompletableCacheArr;
        InnerCompletableCache[] innerCompletableCacheArr2;
        do {
            innerCompletableCacheArr = this.MyBillsEntityDataFactory.get();
            if (innerCompletableCacheArr == PlaceComponentResult) {
                return false;
            }
            int length = innerCompletableCacheArr.length;
            innerCompletableCacheArr2 = new InnerCompletableCache[length + 1];
            System.arraycopy(innerCompletableCacheArr, 0, innerCompletableCacheArr2, 0, length);
            innerCompletableCacheArr2[length] = innerCompletableCache;
        } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory, innerCompletableCacheArr, innerCompletableCacheArr2));
        return true;
    }

    final void PlaceComponentResult(InnerCompletableCache innerCompletableCache) {
        InnerCompletableCache[] innerCompletableCacheArr;
        InnerCompletableCache[] innerCompletableCacheArr2;
        do {
            innerCompletableCacheArr = this.MyBillsEntityDataFactory.get();
            int length = innerCompletableCacheArr.length;
            if (length == 0) {
                return;
            }
            int i = 0;
            while (true) {
                if (i >= length) {
                    i = -1;
                    break;
                } else if (innerCompletableCacheArr[i] == innerCompletableCache) {
                    break;
                } else {
                    i++;
                }
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                innerCompletableCacheArr2 = getAuthRequestContext;
            } else {
                InnerCompletableCache[] innerCompletableCacheArr3 = new InnerCompletableCache[length - 1];
                System.arraycopy(innerCompletableCacheArr, 0, innerCompletableCacheArr3, 0, i);
                System.arraycopy(innerCompletableCacheArr, i + 1, innerCompletableCacheArr3, i, (length - i) - 1);
                innerCompletableCacheArr2 = innerCompletableCacheArr3;
            }
        } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory, innerCompletableCacheArr, innerCompletableCacheArr2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public final class InnerCompletableCache extends AtomicBoolean implements Disposable {
        private static final long serialVersionUID = 8943152917179642732L;
        final CompletableObserver downstream;

        InnerCompletableCache(CompletableObserver completableObserver) {
            this.downstream = completableObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return get();
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            if (compareAndSet(false, true)) {
                CompletableCache.this.PlaceComponentResult(this);
            }
        }
    }
}
