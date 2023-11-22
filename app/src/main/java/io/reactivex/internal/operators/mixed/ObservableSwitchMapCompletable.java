package io.reactivex.internal.operators.mixed;

import androidx.view.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableSwitchMapCompletable<T> extends Completable {
    final Observable<T> BuiltInFictitiousFunctionClassFactory;
    final boolean MyBillsEntityDataFactory;
    final Function<? super T, ? extends CompletableSource> getAuthRequestContext;

    public ObservableSwitchMapCompletable(Observable<T> observable, Function<? super T, ? extends CompletableSource> function, boolean z) {
        this.BuiltInFictitiousFunctionClassFactory = observable;
        this.getAuthRequestContext = function;
        this.MyBillsEntityDataFactory = z;
    }

    @Override // io.reactivex.Completable
    public final void MyBillsEntityDataFactory(CompletableObserver completableObserver) {
        if (ScalarXMapZHelper.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory, this.getAuthRequestContext, completableObserver)) {
            return;
        }
        this.BuiltInFictitiousFunctionClassFactory.subscribe(new SwitchMapCompletableObserver(completableObserver, this.getAuthRequestContext, this.MyBillsEntityDataFactory));
    }

    /* loaded from: classes9.dex */
    static final class SwitchMapCompletableObserver<T> implements Observer<T>, Disposable {
        static final SwitchMapInnerObserver getAuthRequestContext = new SwitchMapInnerObserver(null);
        volatile boolean BuiltInFictitiousFunctionClassFactory;
        final boolean KClassImpl$Data$declaredNonStaticMembers$2;
        final CompletableObserver PlaceComponentResult;
        final Function<? super T, ? extends CompletableSource> lookAheadTest;
        Disposable moveToNextValue;
        final AtomicThrowable MyBillsEntityDataFactory = new AtomicThrowable();
        final AtomicReference<SwitchMapInnerObserver> getErrorConfigVersion = new AtomicReference<>();

        SwitchMapCompletableObserver(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function, boolean z) {
            this.PlaceComponentResult = completableObserver;
            this.lookAheadTest = function;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.moveToNextValue, disposable)) {
                this.moveToNextValue = disposable;
                this.PlaceComponentResult.onSubscribe(this);
            }
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            SwitchMapInnerObserver switchMapInnerObserver;
            try {
                CompletableSource completableSource = (CompletableSource) ObjectHelper.PlaceComponentResult(this.lookAheadTest.apply(t), "The mapper returned a null CompletableSource");
                SwitchMapInnerObserver switchMapInnerObserver2 = new SwitchMapInnerObserver(this);
                do {
                    switchMapInnerObserver = this.getErrorConfigVersion.get();
                    if (switchMapInnerObserver == getAuthRequestContext) {
                        return;
                    }
                } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.getErrorConfigVersion, switchMapInnerObserver, switchMapInnerObserver2));
                if (switchMapInnerObserver != null) {
                    switchMapInnerObserver.dispose();
                }
                completableSource.getAuthRequestContext(switchMapInnerObserver2);
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                this.moveToNextValue.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            if (this.MyBillsEntityDataFactory.addThrowable(th)) {
                if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                    onComplete();
                    return;
                }
                AtomicReference<SwitchMapInnerObserver> atomicReference = this.getErrorConfigVersion;
                SwitchMapInnerObserver switchMapInnerObserver = getAuthRequestContext;
                SwitchMapInnerObserver andSet = atomicReference.getAndSet(switchMapInnerObserver);
                if (andSet != null && andSet != switchMapInnerObserver) {
                    andSet.dispose();
                }
                Throwable terminate = this.MyBillsEntityDataFactory.terminate();
                if (terminate != ExceptionHelper.KClassImpl$Data$declaredNonStaticMembers$2) {
                    this.PlaceComponentResult.onError(terminate);
                    return;
                }
                return;
            }
            RxJavaPlugins.PlaceComponentResult(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            this.BuiltInFictitiousFunctionClassFactory = true;
            if (this.getErrorConfigVersion.get() == null) {
                Throwable terminate = this.MyBillsEntityDataFactory.terminate();
                if (terminate == null) {
                    this.PlaceComponentResult.onComplete();
                } else {
                    this.PlaceComponentResult.onError(terminate);
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.moveToNextValue.dispose();
            AtomicReference<SwitchMapInnerObserver> atomicReference = this.getErrorConfigVersion;
            SwitchMapInnerObserver switchMapInnerObserver = getAuthRequestContext;
            SwitchMapInnerObserver andSet = atomicReference.getAndSet(switchMapInnerObserver);
            if (andSet == null || andSet == switchMapInnerObserver) {
                return;
            }
            andSet.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.getErrorConfigVersion.get() == getAuthRequestContext;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes9.dex */
        public static final class SwitchMapInnerObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = -8003404460084760287L;
            final SwitchMapCompletableObserver<?> parent;

            SwitchMapInnerObserver(SwitchMapCompletableObserver<?> switchMapCompletableObserver) {
                this.parent = switchMapCompletableObserver;
            }

            @Override // io.reactivex.CompletableObserver
            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            @Override // io.reactivex.CompletableObserver
            public final void onError(Throwable th) {
                SwitchMapCompletableObserver<?> switchMapCompletableObserver = this.parent;
                if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(switchMapCompletableObserver.getErrorConfigVersion, this, null) && switchMapCompletableObserver.MyBillsEntityDataFactory.addThrowable(th)) {
                    if (switchMapCompletableObserver.KClassImpl$Data$declaredNonStaticMembers$2) {
                        if (switchMapCompletableObserver.BuiltInFictitiousFunctionClassFactory) {
                            switchMapCompletableObserver.PlaceComponentResult.onError(switchMapCompletableObserver.MyBillsEntityDataFactory.terminate());
                            return;
                        }
                        return;
                    }
                    switchMapCompletableObserver.dispose();
                    Throwable terminate = switchMapCompletableObserver.MyBillsEntityDataFactory.terminate();
                    if (terminate != ExceptionHelper.KClassImpl$Data$declaredNonStaticMembers$2) {
                        switchMapCompletableObserver.PlaceComponentResult.onError(terminate);
                        return;
                    }
                    return;
                }
                RxJavaPlugins.PlaceComponentResult(th);
            }

            @Override // io.reactivex.CompletableObserver
            public final void onComplete() {
                SwitchMapCompletableObserver<?> switchMapCompletableObserver = this.parent;
                if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(switchMapCompletableObserver.getErrorConfigVersion, this, null) && switchMapCompletableObserver.BuiltInFictitiousFunctionClassFactory) {
                    Throwable terminate = switchMapCompletableObserver.MyBillsEntityDataFactory.terminate();
                    if (terminate == null) {
                        switchMapCompletableObserver.PlaceComponentResult.onComplete();
                    } else {
                        switchMapCompletableObserver.PlaceComponentResult.onError(terminate);
                    }
                }
            }

            final void dispose() {
                DisposableHelper.dispose(this);
            }
        }
    }
}
