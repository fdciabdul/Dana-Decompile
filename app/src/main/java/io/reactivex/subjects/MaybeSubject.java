package io.reactivex.subjects;

import androidx.view.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes9.dex */
public final class MaybeSubject<T> extends Maybe<T> implements MaybeObserver<T> {
    static final MaybeDisposable[] KClassImpl$Data$declaredNonStaticMembers$2 = new MaybeDisposable[0];
    static final MaybeDisposable[] MyBillsEntityDataFactory = new MaybeDisposable[0];
    Throwable PlaceComponentResult;
    T getErrorConfigVersion;
    final AtomicBoolean getAuthRequestContext = new AtomicBoolean();
    final AtomicReference<MaybeDisposable<T>[]> BuiltInFictitiousFunctionClassFactory = new AtomicReference<>(KClassImpl$Data$declaredNonStaticMembers$2);

    MaybeSubject() {
    }

    @Override // io.reactivex.MaybeObserver
    public final void onSubscribe(Disposable disposable) {
        if (this.BuiltInFictitiousFunctionClassFactory.get() == MyBillsEntityDataFactory) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.MaybeObserver
    public final void onSuccess(T t) {
        ObjectHelper.PlaceComponentResult(t, "onSuccess called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.getAuthRequestContext.compareAndSet(false, true)) {
            this.getErrorConfigVersion = t;
            for (MaybeDisposable<T> maybeDisposable : this.BuiltInFictitiousFunctionClassFactory.getAndSet(MyBillsEntityDataFactory)) {
                maybeDisposable.downstream.onSuccess(t);
            }
        }
    }

    @Override // io.reactivex.MaybeObserver
    public final void onError(Throwable th) {
        ObjectHelper.PlaceComponentResult(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.getAuthRequestContext.compareAndSet(false, true)) {
            this.PlaceComponentResult = th;
            for (MaybeDisposable<T> maybeDisposable : this.BuiltInFictitiousFunctionClassFactory.getAndSet(MyBillsEntityDataFactory)) {
                maybeDisposable.downstream.onError(th);
            }
            return;
        }
        RxJavaPlugins.PlaceComponentResult(th);
    }

    @Override // io.reactivex.MaybeObserver
    public final void onComplete() {
        if (this.getAuthRequestContext.compareAndSet(false, true)) {
            for (MaybeDisposable<T> maybeDisposable : this.BuiltInFictitiousFunctionClassFactory.getAndSet(MyBillsEntityDataFactory)) {
                maybeDisposable.downstream.onComplete();
            }
        }
    }

    @Override // io.reactivex.Maybe
    public final void MyBillsEntityDataFactory(MaybeObserver<? super T> maybeObserver) {
        MaybeDisposable<T> maybeDisposable = new MaybeDisposable<>(maybeObserver, this);
        maybeObserver.onSubscribe(maybeDisposable);
        if (MyBillsEntityDataFactory(maybeDisposable)) {
            if (maybeDisposable.isDisposed()) {
                PlaceComponentResult(maybeDisposable);
                return;
            }
            return;
        }
        Throwable th = this.PlaceComponentResult;
        if (th != null) {
            maybeObserver.onError(th);
            return;
        }
        Object obj = (T) this.getErrorConfigVersion;
        if (obj == null) {
            maybeObserver.onComplete();
        } else {
            maybeObserver.onSuccess(obj);
        }
    }

    private boolean MyBillsEntityDataFactory(MaybeDisposable<T> maybeDisposable) {
        MaybeDisposable<T>[] maybeDisposableArr;
        MaybeDisposable[] maybeDisposableArr2;
        do {
            maybeDisposableArr = this.BuiltInFictitiousFunctionClassFactory.get();
            if (maybeDisposableArr == MyBillsEntityDataFactory) {
                return false;
            }
            int length = maybeDisposableArr.length;
            maybeDisposableArr2 = new MaybeDisposable[length + 1];
            System.arraycopy(maybeDisposableArr, 0, maybeDisposableArr2, 0, length);
            maybeDisposableArr2[length] = maybeDisposable;
        } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, maybeDisposableArr, maybeDisposableArr2));
        return true;
    }

    final void PlaceComponentResult(MaybeDisposable<T> maybeDisposable) {
        MaybeDisposable<T>[] maybeDisposableArr;
        MaybeDisposable[] maybeDisposableArr2;
        do {
            maybeDisposableArr = this.BuiltInFictitiousFunctionClassFactory.get();
            int length = maybeDisposableArr.length;
            if (length == 0) {
                return;
            }
            int i = 0;
            while (true) {
                if (i >= length) {
                    i = -1;
                    break;
                } else if (maybeDisposableArr[i] == maybeDisposable) {
                    break;
                } else {
                    i++;
                }
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                maybeDisposableArr2 = KClassImpl$Data$declaredNonStaticMembers$2;
            } else {
                MaybeDisposable[] maybeDisposableArr3 = new MaybeDisposable[length - 1];
                System.arraycopy(maybeDisposableArr, 0, maybeDisposableArr3, 0, i);
                System.arraycopy(maybeDisposableArr, i + 1, maybeDisposableArr3, i, (length - i) - 1);
                maybeDisposableArr2 = maybeDisposableArr3;
            }
        } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, maybeDisposableArr, maybeDisposableArr2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class MaybeDisposable<T> extends AtomicReference<MaybeSubject<T>> implements Disposable {
        private static final long serialVersionUID = -7650903191002190468L;
        final MaybeObserver<? super T> downstream;

        MaybeDisposable(MaybeObserver<? super T> maybeObserver, MaybeSubject<T> maybeSubject) {
            this.downstream = maybeObserver;
            lazySet(maybeSubject);
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            MaybeSubject<T> andSet = getAndSet(null);
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
