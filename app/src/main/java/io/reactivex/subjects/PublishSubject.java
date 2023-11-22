package io.reactivex.subjects;

import androidx.view.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.Observer;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class PublishSubject<T> extends Subject<T> {
    Throwable PlaceComponentResult;
    final AtomicReference<PublishDisposable<T>[]> getAuthRequestContext = new AtomicReference<>(BuiltInFictitiousFunctionClassFactory);
    static final PublishDisposable[] MyBillsEntityDataFactory = new PublishDisposable[0];
    static final PublishDisposable[] BuiltInFictitiousFunctionClassFactory = new PublishDisposable[0];

    @CheckReturnValue
    public static <T> PublishSubject<T> PlaceComponentResult() {
        return new PublishSubject<>();
    }

    PublishSubject() {
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        PublishDisposable<T> publishDisposable = new PublishDisposable<>(observer, this);
        observer.onSubscribe(publishDisposable);
        if (PlaceComponentResult(publishDisposable)) {
            if (publishDisposable.isDisposed()) {
                MyBillsEntityDataFactory(publishDisposable);
                return;
            }
            return;
        }
        Throwable th = this.PlaceComponentResult;
        if (th != null) {
            observer.onError(th);
        } else {
            observer.onComplete();
        }
    }

    private boolean PlaceComponentResult(PublishDisposable<T> publishDisposable) {
        PublishDisposable<T>[] publishDisposableArr;
        PublishDisposable[] publishDisposableArr2;
        do {
            publishDisposableArr = this.getAuthRequestContext.get();
            if (publishDisposableArr == MyBillsEntityDataFactory) {
                return false;
            }
            int length = publishDisposableArr.length;
            publishDisposableArr2 = new PublishDisposable[length + 1];
            System.arraycopy(publishDisposableArr, 0, publishDisposableArr2, 0, length);
            publishDisposableArr2[length] = publishDisposable;
        } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext, publishDisposableArr, publishDisposableArr2));
        return true;
    }

    final void MyBillsEntityDataFactory(PublishDisposable<T> publishDisposable) {
        PublishDisposable<T>[] publishDisposableArr;
        PublishDisposable[] publishDisposableArr2;
        do {
            publishDisposableArr = this.getAuthRequestContext.get();
            if (publishDisposableArr == MyBillsEntityDataFactory || publishDisposableArr == BuiltInFictitiousFunctionClassFactory) {
                return;
            }
            int length = publishDisposableArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    i = -1;
                    break;
                } else if (publishDisposableArr[i] == publishDisposable) {
                    break;
                } else {
                    i++;
                }
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                publishDisposableArr2 = BuiltInFictitiousFunctionClassFactory;
            } else {
                PublishDisposable[] publishDisposableArr3 = new PublishDisposable[length - 1];
                System.arraycopy(publishDisposableArr, 0, publishDisposableArr3, 0, i);
                System.arraycopy(publishDisposableArr, i + 1, publishDisposableArr3, i, (length - i) - 1);
                publishDisposableArr2 = publishDisposableArr3;
            }
        } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext, publishDisposableArr, publishDisposableArr2));
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable disposable) {
        if (this.getAuthRequestContext.get() == MyBillsEntityDataFactory) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.Observer
    public final void onNext(T t) {
        ObjectHelper.PlaceComponentResult(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        for (PublishDisposable<T> publishDisposable : this.getAuthRequestContext.get()) {
            publishDisposable.onNext(t);
        }
    }

    @Override // io.reactivex.Observer
    public final void onError(Throwable th) {
        ObjectHelper.PlaceComponentResult(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        PublishDisposable<T>[] publishDisposableArr = this.getAuthRequestContext.get();
        PublishDisposable<T>[] publishDisposableArr2 = MyBillsEntityDataFactory;
        if (publishDisposableArr == publishDisposableArr2) {
            RxJavaPlugins.PlaceComponentResult(th);
            return;
        }
        this.PlaceComponentResult = th;
        for (PublishDisposable<T> publishDisposable : this.getAuthRequestContext.getAndSet(publishDisposableArr2)) {
            publishDisposable.onError(th);
        }
    }

    @Override // io.reactivex.Observer
    public final void onComplete() {
        PublishDisposable<T>[] publishDisposableArr = this.getAuthRequestContext.get();
        PublishDisposable<T>[] publishDisposableArr2 = MyBillsEntityDataFactory;
        if (publishDisposableArr == publishDisposableArr2) {
            return;
        }
        for (PublishDisposable<T> publishDisposable : this.getAuthRequestContext.getAndSet(publishDisposableArr2)) {
            publishDisposable.onComplete();
        }
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return this.getAuthRequestContext.get().length != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class PublishDisposable<T> extends AtomicBoolean implements Disposable {
        private static final long serialVersionUID = 3562861878281475070L;
        final Observer<? super T> downstream;
        final PublishSubject<T> parent;

        PublishDisposable(Observer<? super T> observer, PublishSubject<T> publishSubject) {
            this.downstream = observer;
            this.parent = publishSubject;
        }

        public final void onNext(T t) {
            if (get()) {
                return;
            }
            this.downstream.onNext(t);
        }

        public final void onError(Throwable th) {
            if (get()) {
                RxJavaPlugins.PlaceComponentResult(th);
            } else {
                this.downstream.onError(th);
            }
        }

        public final void onComplete() {
            if (get()) {
                return;
            }
            this.downstream.onComplete();
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            if (compareAndSet(false, true)) {
                this.parent.MyBillsEntityDataFactory(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return get();
        }
    }
}
