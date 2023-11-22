package io.reactivex.internal.operators.flowable;

import androidx.view.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.processors.UnicastProcessor;
import io.reactivex.subscribers.DisposableSubscriber;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class FlowableWindowBoundarySelector<T, B, V> extends AbstractFlowableWithUpstream<T, Flowable<T>> {
    final Function<? super B, ? extends Publisher<V>> KClassImpl$Data$declaredNonStaticMembers$2;
    final Publisher<B> MyBillsEntityDataFactory;
    final int getAuthRequestContext;

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super Flowable<T>> subscriber) {
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(new WindowBoundaryMainSubscriber(new SerializedSubscriber(subscriber), this.MyBillsEntityDataFactory, this.KClassImpl$Data$declaredNonStaticMembers$2, this.getAuthRequestContext));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class WindowBoundaryMainSubscriber<T, B, V> extends QueueDrainSubscriber<T, Object, Flowable<T>> implements Subscription {
        final CompositeDisposable BuiltInFictitiousFunctionClassFactory;
        final Publisher<B> KClassImpl$Data$declaredNonStaticMembers$2;
        final AtomicReference<Disposable> MyBillsEntityDataFactory;
        final AtomicBoolean NetworkUserEntityData$$ExternalSyntheticLambda0;
        final Function<? super B, ? extends Publisher<V>> PlaceComponentResult;
        final int getAuthRequestContext;
        final AtomicLong getErrorConfigVersion;
        final List<UnicastProcessor<T>> lookAheadTest;
        Subscription scheduleImpl;

        @Override // io.reactivex.internal.subscribers.QueueDrainSubscriber, io.reactivex.internal.util.QueueDrain
        public final boolean PlaceComponentResult(Subscriber<? super Flowable<T>> subscriber, Object obj) {
            return false;
        }

        WindowBoundaryMainSubscriber(Subscriber<? super Flowable<T>> subscriber, Publisher<B> publisher, Function<? super B, ? extends Publisher<V>> function, int i) {
            super(subscriber, new MpscLinkedQueue());
            this.MyBillsEntityDataFactory = new AtomicReference<>();
            AtomicLong atomicLong = new AtomicLong();
            this.getErrorConfigVersion = atomicLong;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new AtomicBoolean();
            this.KClassImpl$Data$declaredNonStaticMembers$2 = publisher;
            this.PlaceComponentResult = function;
            this.getAuthRequestContext = i;
            this.BuiltInFictitiousFunctionClassFactory = new CompositeDisposable();
            this.lookAheadTest = new ArrayList();
            atomicLong.lazySet(1L);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.scheduleImpl, subscription)) {
                this.scheduleImpl = subscription;
                this.newProxyInstance.onSubscribe(this);
                if (this.NetworkUserEntityData$$ExternalSyntheticLambda0.get()) {
                    return;
                }
                OperatorWindowBoundaryOpenSubscriber operatorWindowBoundaryOpenSubscriber = new OperatorWindowBoundaryOpenSubscriber(this);
                if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory, null, operatorWindowBoundaryOpenSubscriber)) {
                    subscription.request(LongCompanionObject.MAX_VALUE);
                    this.KClassImpl$Data$declaredNonStaticMembers$2.subscribe(operatorWindowBoundaryOpenSubscriber);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda1) {
                return;
            }
            if (moveToNextValue()) {
                Iterator<UnicastProcessor<T>> it = this.lookAheadTest.iterator();
                while (it.hasNext()) {
                    it.next().onNext(t);
                }
                if (this.isLayoutRequested.addAndGet(-1) == 0) {
                    return;
                }
            } else {
                this.PrepareContext.offer(NotificationLite.next(t));
                if (!lookAheadTest()) {
                    return;
                }
            }
            MyBillsEntityDataFactory();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda1) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = th;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
            if (lookAheadTest()) {
                MyBillsEntityDataFactory();
            }
            if (this.getErrorConfigVersion.decrementAndGet() == 0) {
                this.BuiltInFictitiousFunctionClassFactory.dispose();
            }
            this.newProxyInstance.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda1) {
                return;
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
            if (lookAheadTest()) {
                MyBillsEntityDataFactory();
            }
            if (this.getErrorConfigVersion.decrementAndGet() == 0) {
                this.BuiltInFictitiousFunctionClassFactory.dispose();
            }
            this.newProxyInstance.onComplete();
        }

        final void MyBillsEntityDataFactory(Throwable th) {
            this.scheduleImpl.cancel();
            this.BuiltInFictitiousFunctionClassFactory.dispose();
            DisposableHelper.dispose(this.MyBillsEntityDataFactory);
            this.newProxyInstance.onError(th);
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda0.compareAndSet(false, true)) {
                DisposableHelper.dispose(this.MyBillsEntityDataFactory);
                if (this.getErrorConfigVersion.decrementAndGet() == 0) {
                    this.scheduleImpl.cancel();
                }
            }
        }

        final void MyBillsEntityDataFactory() {
            SimpleQueue simpleQueue = this.PrepareContext;
            Subscriber<? super V> subscriber = this.newProxyInstance;
            List<UnicastProcessor<T>> list = this.lookAheadTest;
            int i = 1;
            while (true) {
                boolean z = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                Object poll = simpleQueue.poll();
                boolean z2 = poll == null;
                if (z && z2) {
                    this.BuiltInFictitiousFunctionClassFactory.dispose();
                    DisposableHelper.dispose(this.MyBillsEntityDataFactory);
                    Throwable th = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                    if (th != null) {
                        Iterator<UnicastProcessor<T>> it = list.iterator();
                        while (it.hasNext()) {
                            it.next().onError(th);
                        }
                    } else {
                        Iterator<UnicastProcessor<T>> it2 = list.iterator();
                        while (it2.hasNext()) {
                            it2.next().onComplete();
                        }
                    }
                    list.clear();
                    return;
                } else if (!z2) {
                    if (poll instanceof WindowOperation) {
                        WindowOperation windowOperation = (WindowOperation) poll;
                        if (windowOperation.PlaceComponentResult != null) {
                            if (list.remove(windowOperation.PlaceComponentResult)) {
                                windowOperation.PlaceComponentResult.onComplete();
                                if (this.getErrorConfigVersion.decrementAndGet() == 0) {
                                    this.BuiltInFictitiousFunctionClassFactory.dispose();
                                    DisposableHelper.dispose(this.MyBillsEntityDataFactory);
                                    return;
                                }
                            } else {
                                continue;
                            }
                        } else if (!this.NetworkUserEntityData$$ExternalSyntheticLambda0.get()) {
                            UnicastProcessor<T> MyBillsEntityDataFactory = UnicastProcessor.MyBillsEntityDataFactory(this.getAuthRequestContext);
                            long j = this.NetworkUserEntityData$$ExternalSyntheticLambda7.get();
                            if (j != 0) {
                                list.add(MyBillsEntityDataFactory);
                                subscriber.onNext(MyBillsEntityDataFactory);
                                if (j != LongCompanionObject.MAX_VALUE) {
                                    this.NetworkUserEntityData$$ExternalSyntheticLambda7.addAndGet(-1L);
                                }
                                try {
                                    Publisher publisher = (Publisher) ObjectHelper.PlaceComponentResult(this.PlaceComponentResult.apply((B) windowOperation.KClassImpl$Data$declaredNonStaticMembers$2), "The publisher supplied is null");
                                    OperatorWindowBoundaryCloseSubscriber operatorWindowBoundaryCloseSubscriber = new OperatorWindowBoundaryCloseSubscriber(this, MyBillsEntityDataFactory);
                                    if (this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(operatorWindowBoundaryCloseSubscriber)) {
                                        this.getErrorConfigVersion.getAndIncrement();
                                        publisher.subscribe(operatorWindowBoundaryCloseSubscriber);
                                    }
                                } catch (Throwable th2) {
                                    cancel();
                                    subscriber.onError(th2);
                                }
                            } else {
                                cancel();
                                subscriber.onError(new MissingBackpressureException("Could not deliver new window due to lack of requests"));
                            }
                        }
                    } else {
                        Iterator<UnicastProcessor<T>> it3 = list.iterator();
                        while (it3.hasNext()) {
                            it3.next().onNext((T) NotificationLite.getValue(poll));
                        }
                    }
                } else {
                    i = this.isLayoutRequested.addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
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
    public static final class WindowOperation<T, B> {
        final B KClassImpl$Data$declaredNonStaticMembers$2;
        final UnicastProcessor<T> PlaceComponentResult;

        WindowOperation(UnicastProcessor<T> unicastProcessor, B b) {
            this.PlaceComponentResult = unicastProcessor;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = b;
        }
    }

    /* loaded from: classes9.dex */
    static final class OperatorWindowBoundaryOpenSubscriber<T, B> extends DisposableSubscriber<B> {
        final WindowBoundaryMainSubscriber<T, B, ?> BuiltInFictitiousFunctionClassFactory;

        OperatorWindowBoundaryOpenSubscriber(WindowBoundaryMainSubscriber<T, B, ?> windowBoundaryMainSubscriber) {
            this.BuiltInFictitiousFunctionClassFactory = windowBoundaryMainSubscriber;
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(B b) {
            WindowBoundaryMainSubscriber<T, B, ?> windowBoundaryMainSubscriber = this.BuiltInFictitiousFunctionClassFactory;
            windowBoundaryMainSubscriber.PrepareContext.offer(new WindowOperation(null, b));
            if (windowBoundaryMainSubscriber.lookAheadTest()) {
                windowBoundaryMainSubscriber.MyBillsEntityDataFactory();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            this.BuiltInFictitiousFunctionClassFactory.onComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class OperatorWindowBoundaryCloseSubscriber<T, V> extends DisposableSubscriber<V> {
        boolean MyBillsEntityDataFactory;
        final WindowBoundaryMainSubscriber<T, ?, V> PlaceComponentResult;
        final UnicastProcessor<T> getAuthRequestContext;

        OperatorWindowBoundaryCloseSubscriber(WindowBoundaryMainSubscriber<T, ?, V> windowBoundaryMainSubscriber, UnicastProcessor<T> unicastProcessor) {
            this.PlaceComponentResult = windowBoundaryMainSubscriber;
            this.getAuthRequestContext = unicastProcessor;
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            if (this.MyBillsEntityDataFactory) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            this.MyBillsEntityDataFactory = true;
            this.PlaceComponentResult.MyBillsEntityDataFactory(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            if (this.MyBillsEntityDataFactory) {
                return;
            }
            this.MyBillsEntityDataFactory = true;
            WindowBoundaryMainSubscriber<T, ?, V> windowBoundaryMainSubscriber = this.PlaceComponentResult;
            windowBoundaryMainSubscriber.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(this);
            windowBoundaryMainSubscriber.PrepareContext.offer(new WindowOperation(this.getAuthRequestContext, null));
            if (windowBoundaryMainSubscriber.lookAheadTest()) {
                windowBoundaryMainSubscriber.MyBillsEntityDataFactory();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(V v) {
            dispose();
            onComplete();
        }
    }
}
