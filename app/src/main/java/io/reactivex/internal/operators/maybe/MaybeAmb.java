package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes9.dex */
public final class MaybeAmb<T> extends Maybe<T> {
    private final MaybeSource<? extends T>[] BuiltInFictitiousFunctionClassFactory;
    private final Iterable<? extends MaybeSource<? extends T>> PlaceComponentResult;

    @Override // io.reactivex.Maybe
    public final void MyBillsEntityDataFactory(MaybeObserver<? super T> maybeObserver) {
        int length;
        MaybeSource<? extends T>[] maybeSourceArr = this.BuiltInFictitiousFunctionClassFactory;
        if (maybeSourceArr == null) {
            maybeSourceArr = new MaybeSource[8];
            try {
                length = 0;
                for (MaybeSource<? extends T> maybeSource : this.PlaceComponentResult) {
                    if (maybeSource == null) {
                        EmptyDisposable.error(new NullPointerException("One of the sources is null"), maybeObserver);
                        return;
                    }
                    if (length == maybeSourceArr.length) {
                        MaybeSource<? extends T>[] maybeSourceArr2 = new MaybeSource[(length >> 2) + length];
                        System.arraycopy(maybeSourceArr, 0, maybeSourceArr2, 0, length);
                        maybeSourceArr = maybeSourceArr2;
                    }
                    maybeSourceArr[length] = maybeSource;
                    length++;
                }
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                EmptyDisposable.error(th, maybeObserver);
                return;
            }
        } else {
            length = maybeSourceArr.length;
        }
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        maybeObserver.onSubscribe(compositeDisposable);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        for (int i = 0; i < length; i++) {
            MaybeSource<? extends T> maybeSource2 = maybeSourceArr[i];
            if (compositeDisposable.isDisposed()) {
                return;
            }
            if (maybeSource2 == null) {
                compositeDisposable.dispose();
                NullPointerException nullPointerException = new NullPointerException("One of the MaybeSources is null");
                if (atomicBoolean.compareAndSet(false, true)) {
                    maybeObserver.onError(nullPointerException);
                    return;
                } else {
                    RxJavaPlugins.PlaceComponentResult(nullPointerException);
                    return;
                }
            }
            maybeSource2.PlaceComponentResult(new AmbMaybeObserver(maybeObserver, compositeDisposable, atomicBoolean));
        }
        if (length == 0) {
            maybeObserver.onComplete();
        }
    }

    /* loaded from: classes9.dex */
    static final class AmbMaybeObserver<T> implements MaybeObserver<T> {
        final MaybeObserver<? super T> BuiltInFictitiousFunctionClassFactory;
        final CompositeDisposable KClassImpl$Data$declaredNonStaticMembers$2;
        final AtomicBoolean MyBillsEntityDataFactory;
        Disposable getAuthRequestContext;

        AmbMaybeObserver(MaybeObserver<? super T> maybeObserver, CompositeDisposable compositeDisposable, AtomicBoolean atomicBoolean) {
            this.BuiltInFictitiousFunctionClassFactory = maybeObserver;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = compositeDisposable;
            this.MyBillsEntityDataFactory = atomicBoolean;
        }

        @Override // io.reactivex.MaybeObserver
        public final void onSubscribe(Disposable disposable) {
            this.getAuthRequestContext = disposable;
            this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(disposable);
        }

        @Override // io.reactivex.MaybeObserver
        public final void onSuccess(T t) {
            if (this.MyBillsEntityDataFactory.compareAndSet(false, true)) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(this.getAuthRequestContext);
                this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
                this.BuiltInFictitiousFunctionClassFactory.onSuccess(t);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public final void onError(Throwable th) {
            if (this.MyBillsEntityDataFactory.compareAndSet(false, true)) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(this.getAuthRequestContext);
                this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
                this.BuiltInFictitiousFunctionClassFactory.onError(th);
                return;
            }
            RxJavaPlugins.PlaceComponentResult(th);
        }

        @Override // io.reactivex.MaybeObserver
        public final void onComplete() {
            if (this.MyBillsEntityDataFactory.compareAndSet(false, true)) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(this.getAuthRequestContext);
                this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
                this.BuiltInFictitiousFunctionClassFactory.onComplete();
            }
        }
    }
}
