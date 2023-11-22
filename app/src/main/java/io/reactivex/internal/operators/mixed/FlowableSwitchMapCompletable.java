package io.reactivex.internal.operators.mixed;

import androidx.view.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class FlowableSwitchMapCompletable<T> extends Completable {
    final Flowable<T> BuiltInFictitiousFunctionClassFactory;
    final Function<? super T, ? extends CompletableSource> KClassImpl$Data$declaredNonStaticMembers$2;
    final boolean getAuthRequestContext;

    @Override // io.reactivex.Completable
    public final void MyBillsEntityDataFactory(CompletableObserver completableObserver) {
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(new SwitchMapCompletableObserver(completableObserver, this.KClassImpl$Data$declaredNonStaticMembers$2, this.getAuthRequestContext));
    }

    /* loaded from: classes9.dex */
    static final class SwitchMapCompletableObserver<T> implements FlowableSubscriber<T>, Disposable {
        static final SwitchMapInnerObserver PlaceComponentResult = new SwitchMapInnerObserver(null);
        final boolean KClassImpl$Data$declaredNonStaticMembers$2;
        volatile boolean MyBillsEntityDataFactory;
        Subscription NetworkUserEntityData$$ExternalSyntheticLambda0;
        final CompletableObserver getAuthRequestContext;
        final Function<? super T, ? extends CompletableSource> moveToNextValue;
        final AtomicThrowable BuiltInFictitiousFunctionClassFactory = new AtomicThrowable();
        final AtomicReference<SwitchMapInnerObserver> scheduleImpl = new AtomicReference<>();

        SwitchMapCompletableObserver(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function, boolean z) {
            this.getAuthRequestContext = completableObserver;
            this.moveToNextValue = function;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.NetworkUserEntityData$$ExternalSyntheticLambda0, subscription)) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = subscription;
                this.getAuthRequestContext.onSubscribe(this);
                subscription.request(LongCompanionObject.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            SwitchMapInnerObserver switchMapInnerObserver;
            try {
                CompletableSource completableSource = (CompletableSource) ObjectHelper.PlaceComponentResult(this.moveToNextValue.apply(t), "The mapper returned a null CompletableSource");
                SwitchMapInnerObserver switchMapInnerObserver2 = new SwitchMapInnerObserver(this);
                do {
                    switchMapInnerObserver = this.scheduleImpl.get();
                    if (switchMapInnerObserver == PlaceComponentResult) {
                        return;
                    }
                } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.scheduleImpl, switchMapInnerObserver, switchMapInnerObserver2));
                if (switchMapInnerObserver != null) {
                    switchMapInnerObserver.dispose();
                }
                completableSource.getAuthRequestContext(switchMapInnerObserver2);
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.cancel();
                onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            if (this.BuiltInFictitiousFunctionClassFactory.addThrowable(th)) {
                if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                    onComplete();
                    return;
                }
                AtomicReference<SwitchMapInnerObserver> atomicReference = this.scheduleImpl;
                SwitchMapInnerObserver switchMapInnerObserver = PlaceComponentResult;
                SwitchMapInnerObserver andSet = atomicReference.getAndSet(switchMapInnerObserver);
                if (andSet != null && andSet != switchMapInnerObserver) {
                    andSet.dispose();
                }
                Throwable terminate = this.BuiltInFictitiousFunctionClassFactory.terminate();
                if (terminate != ExceptionHelper.KClassImpl$Data$declaredNonStaticMembers$2) {
                    this.getAuthRequestContext.onError(terminate);
                    return;
                }
                return;
            }
            RxJavaPlugins.PlaceComponentResult(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            this.MyBillsEntityDataFactory = true;
            if (this.scheduleImpl.get() == null) {
                Throwable terminate = this.BuiltInFictitiousFunctionClassFactory.terminate();
                if (terminate == null) {
                    this.getAuthRequestContext.onComplete();
                } else {
                    this.getAuthRequestContext.onError(terminate);
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.cancel();
            AtomicReference<SwitchMapInnerObserver> atomicReference = this.scheduleImpl;
            SwitchMapInnerObserver switchMapInnerObserver = PlaceComponentResult;
            SwitchMapInnerObserver andSet = atomicReference.getAndSet(switchMapInnerObserver);
            if (andSet == null || andSet == switchMapInnerObserver) {
                return;
            }
            andSet.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.scheduleImpl.get() == PlaceComponentResult;
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
                if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(switchMapCompletableObserver.scheduleImpl, this, null) && switchMapCompletableObserver.BuiltInFictitiousFunctionClassFactory.addThrowable(th)) {
                    if (switchMapCompletableObserver.KClassImpl$Data$declaredNonStaticMembers$2) {
                        if (switchMapCompletableObserver.MyBillsEntityDataFactory) {
                            switchMapCompletableObserver.getAuthRequestContext.onError(switchMapCompletableObserver.BuiltInFictitiousFunctionClassFactory.terminate());
                            return;
                        }
                        return;
                    }
                    switchMapCompletableObserver.dispose();
                    Throwable terminate = switchMapCompletableObserver.BuiltInFictitiousFunctionClassFactory.terminate();
                    if (terminate != ExceptionHelper.KClassImpl$Data$declaredNonStaticMembers$2) {
                        switchMapCompletableObserver.getAuthRequestContext.onError(terminate);
                        return;
                    }
                    return;
                }
                RxJavaPlugins.PlaceComponentResult(th);
            }

            @Override // io.reactivex.CompletableObserver
            public final void onComplete() {
                SwitchMapCompletableObserver<?> switchMapCompletableObserver = this.parent;
                if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(switchMapCompletableObserver.scheduleImpl, this, null) && switchMapCompletableObserver.MyBillsEntityDataFactory) {
                    Throwable terminate = switchMapCompletableObserver.BuiltInFictitiousFunctionClassFactory.terminate();
                    if (terminate == null) {
                        switchMapCompletableObserver.getAuthRequestContext.onComplete();
                    } else {
                        switchMapCompletableObserver.getAuthRequestContext.onError(terminate);
                    }
                }
            }

            final void dispose() {
                DisposableHelper.dispose(this);
            }
        }
    }
}
