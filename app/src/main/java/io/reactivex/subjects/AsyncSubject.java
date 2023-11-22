package io.reactivex.subjects;

import androidx.view.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes9.dex */
public final class AsyncSubject<T> extends Subject<T> {
    Throwable MyBillsEntityDataFactory;
    final AtomicReference<AsyncDisposable<T>[]> PlaceComponentResult = new AtomicReference<>(KClassImpl$Data$declaredNonStaticMembers$2);
    T getAuthRequestContext;
    static final AsyncDisposable[] KClassImpl$Data$declaredNonStaticMembers$2 = new AsyncDisposable[0];
    static final AsyncDisposable[] BuiltInFictitiousFunctionClassFactory = new AsyncDisposable[0];

    AsyncSubject() {
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable disposable) {
        if (this.PlaceComponentResult.get() == BuiltInFictitiousFunctionClassFactory) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.Observer
    public final void onNext(T t) {
        ObjectHelper.PlaceComponentResult(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.PlaceComponentResult.get() == BuiltInFictitiousFunctionClassFactory) {
            return;
        }
        this.getAuthRequestContext = t;
    }

    @Override // io.reactivex.Observer
    public final void onError(Throwable th) {
        ObjectHelper.PlaceComponentResult(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        AsyncDisposable<T>[] asyncDisposableArr = this.PlaceComponentResult.get();
        AsyncDisposable<T>[] asyncDisposableArr2 = BuiltInFictitiousFunctionClassFactory;
        if (asyncDisposableArr == asyncDisposableArr2) {
            RxJavaPlugins.PlaceComponentResult(th);
            return;
        }
        this.getAuthRequestContext = null;
        this.MyBillsEntityDataFactory = th;
        for (AsyncDisposable<T> asyncDisposable : this.PlaceComponentResult.getAndSet(asyncDisposableArr2)) {
            asyncDisposable.onError(th);
        }
    }

    @Override // io.reactivex.Observer
    public final void onComplete() {
        AsyncDisposable<T>[] asyncDisposableArr = this.PlaceComponentResult.get();
        AsyncDisposable<T>[] asyncDisposableArr2 = BuiltInFictitiousFunctionClassFactory;
        if (asyncDisposableArr == asyncDisposableArr2) {
            return;
        }
        T t = this.getAuthRequestContext;
        AsyncDisposable<T>[] andSet = this.PlaceComponentResult.getAndSet(asyncDisposableArr2);
        int i = 0;
        if (t == null) {
            int length = andSet.length;
            while (i < length) {
                andSet[i].onComplete();
                i++;
            }
            return;
        }
        int length2 = andSet.length;
        while (i < length2) {
            andSet[i].complete(t);
            i++;
        }
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        AsyncDisposable<T> asyncDisposable = new AsyncDisposable<>(observer, this);
        observer.onSubscribe(asyncDisposable);
        if (MyBillsEntityDataFactory(asyncDisposable)) {
            if (asyncDisposable.isDisposed()) {
                BuiltInFictitiousFunctionClassFactory(asyncDisposable);
                return;
            }
            return;
        }
        Throwable th = this.MyBillsEntityDataFactory;
        if (th != null) {
            observer.onError(th);
            return;
        }
        T t = this.getAuthRequestContext;
        if (t != null) {
            asyncDisposable.complete(t);
        } else {
            asyncDisposable.onComplete();
        }
    }

    private boolean MyBillsEntityDataFactory(AsyncDisposable<T> asyncDisposable) {
        AsyncDisposable<T>[] asyncDisposableArr;
        AsyncDisposable[] asyncDisposableArr2;
        do {
            asyncDisposableArr = this.PlaceComponentResult.get();
            if (asyncDisposableArr == BuiltInFictitiousFunctionClassFactory) {
                return false;
            }
            int length = asyncDisposableArr.length;
            asyncDisposableArr2 = new AsyncDisposable[length + 1];
            System.arraycopy(asyncDisposableArr, 0, asyncDisposableArr2, 0, length);
            asyncDisposableArr2[length] = asyncDisposable;
        } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, asyncDisposableArr, asyncDisposableArr2));
        return true;
    }

    final void BuiltInFictitiousFunctionClassFactory(AsyncDisposable<T> asyncDisposable) {
        AsyncDisposable<T>[] asyncDisposableArr;
        AsyncDisposable[] asyncDisposableArr2;
        do {
            asyncDisposableArr = this.PlaceComponentResult.get();
            int length = asyncDisposableArr.length;
            if (length == 0) {
                return;
            }
            int i = 0;
            while (true) {
                if (i >= length) {
                    i = -1;
                    break;
                } else if (asyncDisposableArr[i] == asyncDisposable) {
                    break;
                } else {
                    i++;
                }
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                asyncDisposableArr2 = KClassImpl$Data$declaredNonStaticMembers$2;
            } else {
                AsyncDisposable[] asyncDisposableArr3 = new AsyncDisposable[length - 1];
                System.arraycopy(asyncDisposableArr, 0, asyncDisposableArr3, 0, i);
                System.arraycopy(asyncDisposableArr, i + 1, asyncDisposableArr3, i, (length - i) - 1);
                asyncDisposableArr2 = asyncDisposableArr3;
            }
        } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, asyncDisposableArr, asyncDisposableArr2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class AsyncDisposable<T> extends DeferredScalarDisposable<T> {
        private static final long serialVersionUID = 5629876084736248016L;
        final AsyncSubject<T> parent;

        AsyncDisposable(Observer<? super T> observer, AsyncSubject<T> asyncSubject) {
            super(observer);
            this.parent = asyncSubject;
        }

        @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.disposables.Disposable
        public final void dispose() {
            if (super.tryDispose()) {
                this.parent.BuiltInFictitiousFunctionClassFactory(this);
            }
        }

        final void onComplete() {
            if (isDisposed()) {
                return;
            }
            this.downstream.onComplete();
        }

        final void onError(Throwable th) {
            if (isDisposed()) {
                RxJavaPlugins.PlaceComponentResult(th);
            } else {
                this.downstream.onError(th);
            }
        }
    }
}
