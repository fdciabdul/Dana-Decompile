package io.reactivex.subjects;

import androidx.view.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes6.dex */
public final class CompletableSubject extends Completable implements CompletableObserver {
    static final CompletableDisposable[] PlaceComponentResult = new CompletableDisposable[0];
    static final CompletableDisposable[] getAuthRequestContext = new CompletableDisposable[0];
    Throwable BuiltInFictitiousFunctionClassFactory;
    final AtomicBoolean KClassImpl$Data$declaredNonStaticMembers$2 = new AtomicBoolean();
    final AtomicReference<CompletableDisposable[]> MyBillsEntityDataFactory = new AtomicReference<>(PlaceComponentResult);

    @CheckReturnValue
    public static CompletableSubject BuiltInFictitiousFunctionClassFactory() {
        return new CompletableSubject();
    }

    CompletableSubject() {
    }

    @Override // io.reactivex.CompletableObserver
    public final void onSubscribe(Disposable disposable) {
        if (this.MyBillsEntityDataFactory.get() == getAuthRequestContext) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.CompletableObserver
    public final void onError(Throwable th) {
        ObjectHelper.PlaceComponentResult(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.KClassImpl$Data$declaredNonStaticMembers$2.compareAndSet(false, true)) {
            this.BuiltInFictitiousFunctionClassFactory = th;
            for (CompletableDisposable completableDisposable : this.MyBillsEntityDataFactory.getAndSet(getAuthRequestContext)) {
                completableDisposable.downstream.onError(th);
            }
            return;
        }
        RxJavaPlugins.PlaceComponentResult(th);
    }

    @Override // io.reactivex.CompletableObserver
    public final void onComplete() {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2.compareAndSet(false, true)) {
            for (CompletableDisposable completableDisposable : this.MyBillsEntityDataFactory.getAndSet(getAuthRequestContext)) {
                completableDisposable.downstream.onComplete();
            }
        }
    }

    @Override // io.reactivex.Completable
    public final void MyBillsEntityDataFactory(CompletableObserver completableObserver) {
        CompletableDisposable completableDisposable = new CompletableDisposable(completableObserver, this);
        completableObserver.onSubscribe(completableDisposable);
        if (getAuthRequestContext(completableDisposable)) {
            if (completableDisposable.isDisposed()) {
                MyBillsEntityDataFactory(completableDisposable);
                return;
            }
            return;
        }
        Throwable th = this.BuiltInFictitiousFunctionClassFactory;
        if (th != null) {
            completableObserver.onError(th);
        } else {
            completableObserver.onComplete();
        }
    }

    private boolean getAuthRequestContext(CompletableDisposable completableDisposable) {
        CompletableDisposable[] completableDisposableArr;
        CompletableDisposable[] completableDisposableArr2;
        do {
            completableDisposableArr = this.MyBillsEntityDataFactory.get();
            if (completableDisposableArr == getAuthRequestContext) {
                return false;
            }
            int length = completableDisposableArr.length;
            completableDisposableArr2 = new CompletableDisposable[length + 1];
            System.arraycopy(completableDisposableArr, 0, completableDisposableArr2, 0, length);
            completableDisposableArr2[length] = completableDisposable;
        } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory, completableDisposableArr, completableDisposableArr2));
        return true;
    }

    final void MyBillsEntityDataFactory(CompletableDisposable completableDisposable) {
        CompletableDisposable[] completableDisposableArr;
        CompletableDisposable[] completableDisposableArr2;
        do {
            completableDisposableArr = this.MyBillsEntityDataFactory.get();
            int length = completableDisposableArr.length;
            if (length == 0) {
                return;
            }
            int i = 0;
            while (true) {
                if (i >= length) {
                    i = -1;
                    break;
                } else if (completableDisposableArr[i] == completableDisposable) {
                    break;
                } else {
                    i++;
                }
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                completableDisposableArr2 = PlaceComponentResult;
            } else {
                CompletableDisposable[] completableDisposableArr3 = new CompletableDisposable[length - 1];
                System.arraycopy(completableDisposableArr, 0, completableDisposableArr3, 0, i);
                System.arraycopy(completableDisposableArr, i + 1, completableDisposableArr3, i, (length - i) - 1);
                completableDisposableArr2 = completableDisposableArr3;
            }
        } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory, completableDisposableArr, completableDisposableArr2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class CompletableDisposable extends AtomicReference<CompletableSubject> implements Disposable {
        private static final long serialVersionUID = -7650903191002190468L;
        final CompletableObserver downstream;

        CompletableDisposable(CompletableObserver completableObserver, CompletableSubject completableSubject) {
            this.downstream = completableObserver;
            lazySet(completableSubject);
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            CompletableSubject andSet = getAndSet(null);
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
