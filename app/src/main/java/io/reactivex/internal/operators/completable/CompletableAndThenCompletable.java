package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes6.dex */
public final class CompletableAndThenCompletable extends Completable {
    final CompletableSource KClassImpl$Data$declaredNonStaticMembers$2;
    final CompletableSource PlaceComponentResult;

    public CompletableAndThenCompletable(CompletableSource completableSource, CompletableSource completableSource2) {
        this.PlaceComponentResult = completableSource;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = completableSource2;
    }

    @Override // io.reactivex.Completable
    public final void MyBillsEntityDataFactory(CompletableObserver completableObserver) {
        this.PlaceComponentResult.getAuthRequestContext(new SourceObserver(completableObserver, this.KClassImpl$Data$declaredNonStaticMembers$2));
    }

    /* loaded from: classes6.dex */
    static final class SourceObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
        private static final long serialVersionUID = -4101678820158072998L;
        final CompletableObserver actualObserver;
        final CompletableSource next;

        SourceObserver(CompletableObserver completableObserver, CompletableSource completableSource) {
            this.actualObserver = completableObserver;
            this.next = completableSource;
        }

        @Override // io.reactivex.CompletableObserver
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.actualObserver.onSubscribe(this);
            }
        }

        @Override // io.reactivex.CompletableObserver
        public final void onError(Throwable th) {
            this.actualObserver.onError(th);
        }

        @Override // io.reactivex.CompletableObserver
        public final void onComplete() {
            this.next.getAuthRequestContext(new NextObserver(this, this.actualObserver));
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }
    }

    /* loaded from: classes6.dex */
    static final class NextObserver implements CompletableObserver {
        final CompletableObserver KClassImpl$Data$declaredNonStaticMembers$2;
        final AtomicReference<Disposable> PlaceComponentResult;

        NextObserver(AtomicReference<Disposable> atomicReference, CompletableObserver completableObserver) {
            this.PlaceComponentResult = atomicReference;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = completableObserver;
        }

        @Override // io.reactivex.CompletableObserver
        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.replace(this.PlaceComponentResult, disposable);
        }

        @Override // io.reactivex.CompletableObserver
        public final void onComplete() {
            this.KClassImpl$Data$declaredNonStaticMembers$2.onComplete();
        }

        @Override // io.reactivex.CompletableObserver
        public final void onError(Throwable th) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.onError(th);
        }
    }
}
