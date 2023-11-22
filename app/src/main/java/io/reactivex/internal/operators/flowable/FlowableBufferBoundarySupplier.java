package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.QueueDrain;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subscribers.DisposableSubscriber;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class FlowableBufferBoundarySupplier<T, U extends Collection<? super T>, B> extends AbstractFlowableWithUpstream<T, U> {
    final Callable<U> MyBillsEntityDataFactory;
    final Callable<? extends Publisher<B>> getAuthRequestContext;

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super U> subscriber) {
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(new BufferBoundarySupplierSubscriber(new SerializedSubscriber(subscriber), this.MyBillsEntityDataFactory, this.getAuthRequestContext));
    }

    /* loaded from: classes9.dex */
    static final class BufferBoundarySupplierSubscriber<T, U extends Collection<? super T>, B> extends QueueDrainSubscriber<T, U, U> implements FlowableSubscriber<T>, Subscription, Disposable {
        final Callable<U> BuiltInFictitiousFunctionClassFactory;
        Subscription KClassImpl$Data$declaredNonStaticMembers$2;
        final Callable<? extends Publisher<B>> MyBillsEntityDataFactory;
        final AtomicReference<Disposable> PlaceComponentResult;
        U getAuthRequestContext;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.internal.subscribers.QueueDrainSubscriber, io.reactivex.internal.util.QueueDrain
        public final /* bridge */ /* synthetic */ boolean PlaceComponentResult(Subscriber subscriber, Object obj) {
            return PlaceComponentResult((Collection) obj);
        }

        BufferBoundarySupplierSubscriber(Subscriber<? super U> subscriber, Callable<U> callable, Callable<? extends Publisher<B>> callable2) {
            super(subscriber, new MpscLinkedQueue());
            this.PlaceComponentResult = new AtomicReference<>();
            this.BuiltInFictitiousFunctionClassFactory = callable;
            this.MyBillsEntityDataFactory = callable2;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.KClassImpl$Data$declaredNonStaticMembers$2, subscription)) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = subscription;
                Subscriber<? super V> subscriber = this.newProxyInstance;
                try {
                    this.getAuthRequestContext = (U) ObjectHelper.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.call(), "The buffer supplied is null");
                    try {
                        Publisher publisher = (Publisher) ObjectHelper.PlaceComponentResult(this.MyBillsEntityDataFactory.call(), "The boundary publisher supplied is null");
                        BufferBoundarySubscriber bufferBoundarySubscriber = new BufferBoundarySubscriber(this);
                        this.PlaceComponentResult.set(bufferBoundarySubscriber);
                        subscriber.onSubscribe(this);
                        if (this.GetContactSyncConfig) {
                            return;
                        }
                        subscription.request(LongCompanionObject.MAX_VALUE);
                        publisher.subscribe(bufferBoundarySubscriber);
                    } catch (Throwable th) {
                        Exceptions.MyBillsEntityDataFactory(th);
                        this.GetContactSyncConfig = true;
                        subscription.cancel();
                        EmptySubscription.error(th, subscriber);
                    }
                } catch (Throwable th2) {
                    Exceptions.MyBillsEntityDataFactory(th2);
                    this.GetContactSyncConfig = true;
                    subscription.cancel();
                    EmptySubscription.error(th2, subscriber);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            synchronized (this) {
                U u = this.getAuthRequestContext;
                if (u == null) {
                    return;
                }
                u.add(t);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            cancel();
            this.newProxyInstance.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            synchronized (this) {
                U u = this.getAuthRequestContext;
                if (u == null) {
                    return;
                }
                this.getAuthRequestContext = null;
                this.PrepareContext.offer(u);
                this.NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
                if (lookAheadTest()) {
                    QueueDrainHelper.KClassImpl$Data$declaredNonStaticMembers$2((SimplePlainQueue) this.PrepareContext, (Subscriber) this.newProxyInstance, false, (Disposable) this, (QueueDrain) this);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            if (this.GetContactSyncConfig) {
                return;
            }
            this.GetContactSyncConfig = true;
            this.KClassImpl$Data$declaredNonStaticMembers$2.cancel();
            DisposableHelper.dispose(this.PlaceComponentResult);
            if (lookAheadTest()) {
                this.PrepareContext.clear();
            }
        }

        final void KClassImpl$Data$declaredNonStaticMembers$2() {
            try {
                U u = (U) ObjectHelper.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.call(), "The buffer supplied is null");
                try {
                    Publisher publisher = (Publisher) ObjectHelper.PlaceComponentResult(this.MyBillsEntityDataFactory.call(), "The boundary publisher supplied is null");
                    BufferBoundarySubscriber bufferBoundarySubscriber = new BufferBoundarySubscriber(this);
                    if (DisposableHelper.replace(this.PlaceComponentResult, bufferBoundarySubscriber)) {
                        synchronized (this) {
                            U u2 = this.getAuthRequestContext;
                            if (u2 == null) {
                                return;
                            }
                            this.getAuthRequestContext = u;
                            publisher.subscribe(bufferBoundarySubscriber);
                            PlaceComponentResult((BufferBoundarySupplierSubscriber<T, U, B>) u2, (Disposable) this);
                        }
                    }
                } catch (Throwable th) {
                    Exceptions.MyBillsEntityDataFactory(th);
                    this.GetContactSyncConfig = true;
                    this.KClassImpl$Data$declaredNonStaticMembers$2.cancel();
                    this.newProxyInstance.onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.MyBillsEntityDataFactory(th2);
                cancel();
                this.newProxyInstance.onError(th2);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.KClassImpl$Data$declaredNonStaticMembers$2.cancel();
            DisposableHelper.dispose(this.PlaceComponentResult);
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.PlaceComponentResult.get() == DisposableHelper.DISPOSED;
        }

        private boolean PlaceComponentResult(U u) {
            this.newProxyInstance.onNext(u);
            return true;
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda7, j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class BufferBoundarySubscriber<T, U extends Collection<? super T>, B> extends DisposableSubscriber<B> {
        boolean PlaceComponentResult;
        final BufferBoundarySupplierSubscriber<T, U, B> getAuthRequestContext;

        BufferBoundarySubscriber(BufferBoundarySupplierSubscriber<T, U, B> bufferBoundarySupplierSubscriber) {
            this.getAuthRequestContext = bufferBoundarySupplierSubscriber;
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(B b) {
            if (this.PlaceComponentResult) {
                return;
            }
            this.PlaceComponentResult = true;
            dispose();
            this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            if (this.PlaceComponentResult) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            this.PlaceComponentResult = true;
            this.getAuthRequestContext.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            if (this.PlaceComponentResult) {
                return;
            }
            this.PlaceComponentResult = true;
            this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }
}
