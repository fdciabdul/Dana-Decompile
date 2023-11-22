package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes9.dex */
public final class CompletableAmb extends Completable {
    private final Iterable<? extends CompletableSource> MyBillsEntityDataFactory;
    private final CompletableSource[] PlaceComponentResult;

    @Override // io.reactivex.Completable
    public final void MyBillsEntityDataFactory(CompletableObserver completableObserver) {
        int length;
        CompletableSource[] completableSourceArr = this.PlaceComponentResult;
        if (completableSourceArr == null) {
            completableSourceArr = new CompletableSource[8];
            try {
                length = 0;
                for (CompletableSource completableSource : this.MyBillsEntityDataFactory) {
                    if (completableSource == null) {
                        EmptyDisposable.error(new NullPointerException("One of the sources is null"), completableObserver);
                        return;
                    }
                    if (length == completableSourceArr.length) {
                        CompletableSource[] completableSourceArr2 = new CompletableSource[(length >> 2) + length];
                        System.arraycopy(completableSourceArr, 0, completableSourceArr2, 0, length);
                        completableSourceArr = completableSourceArr2;
                    }
                    completableSourceArr[length] = completableSource;
                    length++;
                }
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                EmptyDisposable.error(th, completableObserver);
                return;
            }
        } else {
            length = completableSourceArr.length;
        }
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        completableObserver.onSubscribe(compositeDisposable);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        for (int i = 0; i < length; i++) {
            CompletableSource completableSource2 = completableSourceArr[i];
            if (compositeDisposable.isDisposed()) {
                return;
            }
            if (completableSource2 == null) {
                Throwable nullPointerException = new NullPointerException("One of the sources is null");
                if (atomicBoolean.compareAndSet(false, true)) {
                    compositeDisposable.dispose();
                    completableObserver.onError(nullPointerException);
                    return;
                }
                RxJavaPlugins.PlaceComponentResult(nullPointerException);
                return;
            }
            completableSource2.getAuthRequestContext(new Amb(atomicBoolean, compositeDisposable, completableObserver));
        }
        if (length == 0) {
            completableObserver.onComplete();
        }
    }

    /* loaded from: classes9.dex */
    static final class Amb implements CompletableObserver {
        final AtomicBoolean BuiltInFictitiousFunctionClassFactory;
        final CompletableObserver KClassImpl$Data$declaredNonStaticMembers$2;
        Disposable MyBillsEntityDataFactory;
        final CompositeDisposable PlaceComponentResult;

        Amb(AtomicBoolean atomicBoolean, CompositeDisposable compositeDisposable, CompletableObserver completableObserver) {
            this.BuiltInFictitiousFunctionClassFactory = atomicBoolean;
            this.PlaceComponentResult = compositeDisposable;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = completableObserver;
        }

        @Override // io.reactivex.CompletableObserver
        public final void onComplete() {
            if (this.BuiltInFictitiousFunctionClassFactory.compareAndSet(false, true)) {
                this.PlaceComponentResult.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory);
                this.PlaceComponentResult.dispose();
                this.KClassImpl$Data$declaredNonStaticMembers$2.onComplete();
            }
        }

        @Override // io.reactivex.CompletableObserver
        public final void onError(Throwable th) {
            if (this.BuiltInFictitiousFunctionClassFactory.compareAndSet(false, true)) {
                this.PlaceComponentResult.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory);
                this.PlaceComponentResult.dispose();
                this.KClassImpl$Data$declaredNonStaticMembers$2.onError(th);
                return;
            }
            RxJavaPlugins.PlaceComponentResult(th);
        }

        @Override // io.reactivex.CompletableObserver
        public final void onSubscribe(Disposable disposable) {
            this.MyBillsEntityDataFactory = disposable;
            this.PlaceComponentResult.getAuthRequestContext(disposable);
        }
    }
}
