package io.reactivex.internal.operators.observable;

import androidx.view.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.HasUpstreamObservableSource;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservablePublish<T> extends ConnectableObservable<T> implements HasUpstreamObservableSource<T>, ObservablePublishClassic<T> {
    final ObservableSource<T> KClassImpl$Data$declaredNonStaticMembers$2;
    final ObservableSource<T> MyBillsEntityDataFactory;
    final AtomicReference<PublishObserver<T>> PlaceComponentResult;

    public static <T> ConnectableObservable<T> PlaceComponentResult(ObservableSource<T> observableSource) {
        AtomicReference atomicReference = new AtomicReference();
        return RxJavaPlugins.getAuthRequestContext(new ObservablePublish(new PublishSource(atomicReference), observableSource, atomicReference));
    }

    private ObservablePublish(ObservableSource<T> observableSource, ObservableSource<T> observableSource2, AtomicReference<PublishObserver<T>> atomicReference) {
        this.MyBillsEntityDataFactory = observableSource;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = observableSource2;
        this.PlaceComponentResult = atomicReference;
    }

    @Override // io.reactivex.internal.operators.observable.ObservablePublishClassic
    public final ObservableSource<T> getAuthRequestContext() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        this.MyBillsEntityDataFactory.subscribe(observer);
    }

    @Override // io.reactivex.observables.ConnectableObservable
    public final void MyBillsEntityDataFactory(Consumer<? super Disposable> consumer) {
        PublishObserver<T> publishObserver;
        while (true) {
            publishObserver = this.PlaceComponentResult.get();
            if (publishObserver != null && !publishObserver.isDisposed()) {
                break;
            }
            PublishObserver<T> publishObserver2 = new PublishObserver<>(this.PlaceComponentResult);
            if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, publishObserver, publishObserver2)) {
                publishObserver = publishObserver2;
                break;
            }
        }
        boolean z = false;
        if (!publishObserver.KClassImpl$Data$declaredNonStaticMembers$2.get() && publishObserver.KClassImpl$Data$declaredNonStaticMembers$2.compareAndSet(false, true)) {
            z = true;
        }
        try {
            consumer.accept(publishObserver);
            if (z) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.subscribe(publishObserver);
            }
        } catch (Throwable th) {
            Exceptions.MyBillsEntityDataFactory(th);
            throw ExceptionHelper.MyBillsEntityDataFactory(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class PublishObserver<T> implements Observer<T>, Disposable {
        static final InnerDisposable[] MyBillsEntityDataFactory = new InnerDisposable[0];
        static final InnerDisposable[] PlaceComponentResult = new InnerDisposable[0];
        final AtomicReference<PublishObserver<T>> BuiltInFictitiousFunctionClassFactory;
        final AtomicReference<Disposable> getErrorConfigVersion = new AtomicReference<>();
        final AtomicReference<InnerDisposable<T>[]> getAuthRequestContext = new AtomicReference<>(MyBillsEntityDataFactory);
        final AtomicBoolean KClassImpl$Data$declaredNonStaticMembers$2 = new AtomicBoolean();

        PublishObserver(AtomicReference<PublishObserver<T>> atomicReference) {
            this.BuiltInFictitiousFunctionClassFactory = atomicReference;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            AtomicReference<InnerDisposable<T>[]> atomicReference = this.getAuthRequestContext;
            InnerDisposable<T>[] innerDisposableArr = PlaceComponentResult;
            if (atomicReference.getAndSet(innerDisposableArr) != innerDisposableArr) {
                LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, this, null);
                DisposableHelper.dispose(this.getErrorConfigVersion);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.getAuthRequestContext.get() == PlaceComponentResult;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.getErrorConfigVersion, disposable);
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            for (InnerDisposable<T> innerDisposable : this.getAuthRequestContext.get()) {
                innerDisposable.child.onNext(t);
            }
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, this, null);
            InnerDisposable<T>[] andSet = this.getAuthRequestContext.getAndSet(PlaceComponentResult);
            if (andSet.length != 0) {
                for (InnerDisposable<T> innerDisposable : andSet) {
                    innerDisposable.child.onError(th);
                }
                return;
            }
            RxJavaPlugins.PlaceComponentResult(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, this, null);
            for (InnerDisposable<T> innerDisposable : this.getAuthRequestContext.getAndSet(PlaceComponentResult)) {
                innerDisposable.child.onComplete();
            }
        }

        final boolean KClassImpl$Data$declaredNonStaticMembers$2(InnerDisposable<T> innerDisposable) {
            InnerDisposable<T>[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = this.getAuthRequestContext.get();
                if (innerDisposableArr == PlaceComponentResult) {
                    return false;
                }
                int length = innerDisposableArr.length;
                innerDisposableArr2 = new InnerDisposable[length + 1];
                System.arraycopy(innerDisposableArr, 0, innerDisposableArr2, 0, length);
                innerDisposableArr2[length] = innerDisposable;
            } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext, innerDisposableArr, innerDisposableArr2));
            return true;
        }

        final void PlaceComponentResult(InnerDisposable<T> innerDisposable) {
            InnerDisposable<T>[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = this.getAuthRequestContext.get();
                int length = innerDisposableArr.length;
                if (length == 0) {
                    return;
                }
                int i = 0;
                while (true) {
                    if (i >= length) {
                        i = -1;
                        break;
                    } else if (innerDisposableArr[i].equals(innerDisposable)) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    innerDisposableArr2 = MyBillsEntityDataFactory;
                } else {
                    InnerDisposable[] innerDisposableArr3 = new InnerDisposable[length - 1];
                    System.arraycopy(innerDisposableArr, 0, innerDisposableArr3, 0, i);
                    System.arraycopy(innerDisposableArr, i + 1, innerDisposableArr3, i, (length - i) - 1);
                    innerDisposableArr2 = innerDisposableArr3;
                }
            } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext, innerDisposableArr, innerDisposableArr2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class InnerDisposable<T> extends AtomicReference<Object> implements Disposable {
        private static final long serialVersionUID = -1100270633763673112L;
        final Observer<? super T> child;

        InnerDisposable(Observer<? super T> observer) {
            this.child = observer;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return get() == this;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            Object andSet = getAndSet(this);
            if (andSet == null || andSet == this) {
                return;
            }
            ((PublishObserver) andSet).PlaceComponentResult(this);
        }

        final void setParent(PublishObserver<T> publishObserver) {
            if (compareAndSet(null, publishObserver)) {
                return;
            }
            publishObserver.PlaceComponentResult(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class PublishSource<T> implements ObservableSource<T> {
        private final AtomicReference<PublishObserver<T>> MyBillsEntityDataFactory;

        PublishSource(AtomicReference<PublishObserver<T>> atomicReference) {
            this.MyBillsEntityDataFactory = atomicReference;
        }

        @Override // io.reactivex.ObservableSource
        public final void subscribe(Observer<? super T> observer) {
            InnerDisposable innerDisposable = new InnerDisposable(observer);
            observer.onSubscribe(innerDisposable);
            while (true) {
                PublishObserver<T> publishObserver = this.MyBillsEntityDataFactory.get();
                if (publishObserver == null || publishObserver.isDisposed()) {
                    PublishObserver<T> publishObserver2 = new PublishObserver<>(this.MyBillsEntityDataFactory);
                    if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory, publishObserver, publishObserver2)) {
                        publishObserver = publishObserver2;
                    } else {
                        continue;
                    }
                }
                if (publishObserver.KClassImpl$Data$declaredNonStaticMembers$2(innerDisposable)) {
                    innerDisposable.setParent(publishObserver);
                    return;
                }
            }
        }
    }
}
