package io.reactivex.subjects;

import androidx.view.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes9.dex */
public final class SingleSubject<T> extends Single<T> implements SingleObserver<T> {
    Throwable BuiltInFictitiousFunctionClassFactory;
    T NetworkUserEntityData$$ExternalSyntheticLambda0;
    static final SingleDisposable[] getAuthRequestContext = new SingleDisposable[0];
    static final SingleDisposable[] KClassImpl$Data$declaredNonStaticMembers$2 = new SingleDisposable[0];
    final AtomicBoolean MyBillsEntityDataFactory = new AtomicBoolean();
    final AtomicReference<SingleDisposable<T>[]> PlaceComponentResult = new AtomicReference<>(getAuthRequestContext);

    SingleSubject() {
    }

    @Override // io.reactivex.SingleObserver
    public final void onSubscribe(Disposable disposable) {
        if (this.PlaceComponentResult.get() == KClassImpl$Data$declaredNonStaticMembers$2) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.SingleObserver
    public final void onSuccess(T t) {
        ObjectHelper.PlaceComponentResult(t, "onSuccess called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.MyBillsEntityDataFactory.compareAndSet(false, true)) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = t;
            for (SingleDisposable<T> singleDisposable : this.PlaceComponentResult.getAndSet(KClassImpl$Data$declaredNonStaticMembers$2)) {
                singleDisposable.downstream.onSuccess(t);
            }
        }
    }

    @Override // io.reactivex.SingleObserver
    public final void onError(Throwable th) {
        ObjectHelper.PlaceComponentResult(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.MyBillsEntityDataFactory.compareAndSet(false, true)) {
            this.BuiltInFictitiousFunctionClassFactory = th;
            for (SingleDisposable<T> singleDisposable : this.PlaceComponentResult.getAndSet(KClassImpl$Data$declaredNonStaticMembers$2)) {
                singleDisposable.downstream.onError(th);
            }
            return;
        }
        RxJavaPlugins.PlaceComponentResult(th);
    }

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super T> singleObserver) {
        SingleDisposable<T> singleDisposable = new SingleDisposable<>(singleObserver, this);
        singleObserver.onSubscribe(singleDisposable);
        if (getAuthRequestContext(singleDisposable)) {
            if (singleDisposable.isDisposed()) {
                PlaceComponentResult(singleDisposable);
                return;
            }
            return;
        }
        Throwable th = this.BuiltInFictitiousFunctionClassFactory;
        if (th != null) {
            singleObserver.onError(th);
        } else {
            singleObserver.onSuccess((T) this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        }
    }

    private boolean getAuthRequestContext(SingleDisposable<T> singleDisposable) {
        SingleDisposable<T>[] singleDisposableArr;
        SingleDisposable[] singleDisposableArr2;
        do {
            singleDisposableArr = this.PlaceComponentResult.get();
            if (singleDisposableArr == KClassImpl$Data$declaredNonStaticMembers$2) {
                return false;
            }
            int length = singleDisposableArr.length;
            singleDisposableArr2 = new SingleDisposable[length + 1];
            System.arraycopy(singleDisposableArr, 0, singleDisposableArr2, 0, length);
            singleDisposableArr2[length] = singleDisposable;
        } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, singleDisposableArr, singleDisposableArr2));
        return true;
    }

    final void PlaceComponentResult(SingleDisposable<T> singleDisposable) {
        SingleDisposable<T>[] singleDisposableArr;
        SingleDisposable[] singleDisposableArr2;
        do {
            singleDisposableArr = this.PlaceComponentResult.get();
            int length = singleDisposableArr.length;
            if (length == 0) {
                return;
            }
            int i = 0;
            while (true) {
                if (i >= length) {
                    i = -1;
                    break;
                } else if (singleDisposableArr[i] == singleDisposable) {
                    break;
                } else {
                    i++;
                }
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                singleDisposableArr2 = getAuthRequestContext;
            } else {
                SingleDisposable[] singleDisposableArr3 = new SingleDisposable[length - 1];
                System.arraycopy(singleDisposableArr, 0, singleDisposableArr3, 0, i);
                System.arraycopy(singleDisposableArr, i + 1, singleDisposableArr3, i, (length - i) - 1);
                singleDisposableArr2 = singleDisposableArr3;
            }
        } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, singleDisposableArr, singleDisposableArr2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class SingleDisposable<T> extends AtomicReference<SingleSubject<T>> implements Disposable {
        private static final long serialVersionUID = -7650903191002190468L;
        final SingleObserver<? super T> downstream;

        SingleDisposable(SingleObserver<? super T> singleObserver, SingleSubject<T> singleSubject) {
            this.downstream = singleObserver;
            lazySet(singleSubject);
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            SingleSubject<T> andSet = getAndSet(null);
            if (andSet != null) {
                andSet.PlaceComponentResult(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return get() == null;
        }
    }
}
