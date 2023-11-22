package io.reactivex.internal.operators.flowable;

import androidx.view.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.Scheduler;
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
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class FlowableBufferTimed<T, U extends Collection<? super T>> extends AbstractFlowableWithUpstream<T, U> {
    final boolean KClassImpl$Data$declaredNonStaticMembers$2;
    final int MyBillsEntityDataFactory;
    final long NetworkUserEntityData$$ExternalSyntheticLambda0;
    final Callable<U> getAuthRequestContext;
    final long getErrorConfigVersion;
    final TimeUnit lookAheadTest;
    final Scheduler moveToNextValue;

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super U> subscriber) {
        if (this.getErrorConfigVersion == this.NetworkUserEntityData$$ExternalSyntheticLambda0 && this.MyBillsEntityDataFactory == Integer.MAX_VALUE) {
            this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(new BufferExactUnboundedSubscriber(new SerializedSubscriber(subscriber), this.getAuthRequestContext, this.getErrorConfigVersion, this.lookAheadTest, this.moveToNextValue));
            return;
        }
        Scheduler.Worker createWorker = this.moveToNextValue.createWorker();
        if (this.getErrorConfigVersion == this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(new BufferExactBoundedSubscriber(new SerializedSubscriber(subscriber), this.getAuthRequestContext, this.getErrorConfigVersion, this.lookAheadTest, this.MyBillsEntityDataFactory, this.KClassImpl$Data$declaredNonStaticMembers$2, createWorker));
        } else {
            this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(new BufferSkipBoundedSubscriber(new SerializedSubscriber(subscriber), this.getAuthRequestContext, this.getErrorConfigVersion, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.lookAheadTest, createWorker));
        }
    }

    /* loaded from: classes9.dex */
    static final class BufferExactUnboundedSubscriber<T, U extends Collection<? super T>> extends QueueDrainSubscriber<T, U, U> implements Subscription, Runnable, Disposable {
        final Callable<U> BuiltInFictitiousFunctionClassFactory;
        U KClassImpl$Data$declaredNonStaticMembers$2;
        final Scheduler MyBillsEntityDataFactory;
        final long PlaceComponentResult;
        final AtomicReference<Disposable> getAuthRequestContext;
        final TimeUnit getErrorConfigVersion;
        Subscription moveToNextValue;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.internal.subscribers.QueueDrainSubscriber, io.reactivex.internal.util.QueueDrain
        public final /* synthetic */ boolean PlaceComponentResult(Subscriber subscriber, Object obj) {
            return BuiltInFictitiousFunctionClassFactory((BufferExactUnboundedSubscriber<T, U>) ((Collection) obj));
        }

        BufferExactUnboundedSubscriber(Subscriber<? super U> subscriber, Callable<U> callable, long j, TimeUnit timeUnit, Scheduler scheduler) {
            super(subscriber, new MpscLinkedQueue());
            this.getAuthRequestContext = new AtomicReference<>();
            this.BuiltInFictitiousFunctionClassFactory = callable;
            this.PlaceComponentResult = j;
            this.getErrorConfigVersion = timeUnit;
            this.MyBillsEntityDataFactory = scheduler;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.moveToNextValue, subscription)) {
                this.moveToNextValue = subscription;
                try {
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = (U) ObjectHelper.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.call(), "The supplied buffer is null");
                    this.newProxyInstance.onSubscribe(this);
                    if (this.GetContactSyncConfig) {
                        return;
                    }
                    subscription.request(LongCompanionObject.MAX_VALUE);
                    Scheduler scheduler = this.MyBillsEntityDataFactory;
                    long j = this.PlaceComponentResult;
                    Disposable schedulePeriodicallyDirect = scheduler.schedulePeriodicallyDirect(this, j, j, this.getErrorConfigVersion);
                    if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext, null, schedulePeriodicallyDirect)) {
                        return;
                    }
                    schedulePeriodicallyDirect.dispose();
                } catch (Throwable th) {
                    Exceptions.MyBillsEntityDataFactory(th);
                    cancel();
                    EmptySubscription.error(th, this.newProxyInstance);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            synchronized (this) {
                U u = this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (u != null) {
                    u.add(t);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            DisposableHelper.dispose(this.getAuthRequestContext);
            synchronized (this) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
            }
            this.newProxyInstance.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            DisposableHelper.dispose(this.getAuthRequestContext);
            synchronized (this) {
                U u = this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (u == null) {
                    return;
                }
                this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
                this.PrepareContext.offer(u);
                this.NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
                if (lookAheadTest()) {
                    QueueDrainHelper.KClassImpl$Data$declaredNonStaticMembers$2((SimplePlainQueue) this.PrepareContext, (Subscriber) this.newProxyInstance, false, (Disposable) null, (QueueDrain) this);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.GetContactSyncConfig = true;
            this.moveToNextValue.cancel();
            DisposableHelper.dispose(this.getAuthRequestContext);
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                U u = (U) ObjectHelper.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.call(), "The supplied buffer is null");
                synchronized (this) {
                    U u2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (u2 == null) {
                        return;
                    }
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = u;
                    PlaceComponentResult((BufferExactUnboundedSubscriber<T, U>) u2, (Disposable) this);
                }
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                cancel();
                this.newProxyInstance.onError(th);
            }
        }

        private boolean BuiltInFictitiousFunctionClassFactory(U u) {
            this.newProxyInstance.onNext(u);
            return true;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            cancel();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.getAuthRequestContext.get() == DisposableHelper.DISPOSED;
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda7, j);
            }
        }
    }

    /* loaded from: classes9.dex */
    static final class BufferSkipBoundedSubscriber<T, U extends Collection<? super T>> extends QueueDrainSubscriber<T, U, U> implements Subscription, Runnable {
        final Callable<U> BuiltInFictitiousFunctionClassFactory;
        final TimeUnit KClassImpl$Data$declaredNonStaticMembers$2;
        final long MyBillsEntityDataFactory;
        final long PlaceComponentResult;
        final List<U> getAuthRequestContext;
        Subscription getErrorConfigVersion;
        final Scheduler.Worker moveToNextValue;

        @Override // io.reactivex.internal.subscribers.QueueDrainSubscriber, io.reactivex.internal.util.QueueDrain
        public final /* synthetic */ boolean PlaceComponentResult(Subscriber subscriber, Object obj) {
            return KClassImpl$Data$declaredNonStaticMembers$2(subscriber, (Collection) obj);
        }

        BufferSkipBoundedSubscriber(Subscriber<? super U> subscriber, Callable<U> callable, long j, long j2, TimeUnit timeUnit, Scheduler.Worker worker) {
            super(subscriber, new MpscLinkedQueue());
            this.BuiltInFictitiousFunctionClassFactory = callable;
            this.MyBillsEntityDataFactory = j;
            this.PlaceComponentResult = j2;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = timeUnit;
            this.moveToNextValue = worker;
            this.getAuthRequestContext = new LinkedList();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.getErrorConfigVersion, subscription)) {
                this.getErrorConfigVersion = subscription;
                try {
                    Collection collection = (Collection) ObjectHelper.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.call(), "The supplied buffer is null");
                    this.getAuthRequestContext.add(collection);
                    this.newProxyInstance.onSubscribe(this);
                    subscription.request(LongCompanionObject.MAX_VALUE);
                    Scheduler.Worker worker = this.moveToNextValue;
                    long j = this.PlaceComponentResult;
                    worker.schedulePeriodically(this, j, j, this.KClassImpl$Data$declaredNonStaticMembers$2);
                    this.moveToNextValue.schedule(new RemoveFromBuffer(collection), this.MyBillsEntityDataFactory, this.KClassImpl$Data$declaredNonStaticMembers$2);
                } catch (Throwable th) {
                    Exceptions.MyBillsEntityDataFactory(th);
                    this.moveToNextValue.dispose();
                    subscription.cancel();
                    EmptySubscription.error(th, this.newProxyInstance);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            synchronized (this) {
                Iterator<U> it = this.getAuthRequestContext.iterator();
                while (it.hasNext()) {
                    it.next().add(t);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
            this.moveToNextValue.dispose();
            synchronized (this) {
                this.getAuthRequestContext.clear();
            }
            this.newProxyInstance.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            ArrayList arrayList;
            synchronized (this) {
                arrayList = new ArrayList(this.getAuthRequestContext);
                this.getAuthRequestContext.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.PrepareContext.offer((Collection) it.next());
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
            if (lookAheadTest()) {
                QueueDrainHelper.KClassImpl$Data$declaredNonStaticMembers$2((SimplePlainQueue) this.PrepareContext, (Subscriber) this.newProxyInstance, false, (Disposable) this.moveToNextValue, (QueueDrain) this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.GetContactSyncConfig = true;
            this.getErrorConfigVersion.cancel();
            this.moveToNextValue.dispose();
            synchronized (this) {
                this.getAuthRequestContext.clear();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            if (this.GetContactSyncConfig) {
                return;
            }
            try {
                Collection collection = (Collection) ObjectHelper.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.call(), "The supplied buffer is null");
                synchronized (this) {
                    if (this.GetContactSyncConfig) {
                        return;
                    }
                    this.getAuthRequestContext.add(collection);
                    this.moveToNextValue.schedule(new RemoveFromBuffer(collection), this.MyBillsEntityDataFactory, this.KClassImpl$Data$declaredNonStaticMembers$2);
                }
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                cancel();
                this.newProxyInstance.onError(th);
            }
        }

        private static boolean KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super U> subscriber, U u) {
            subscriber.onNext(u);
            return true;
        }

        /* loaded from: classes9.dex */
        final class RemoveFromBuffer implements Runnable {
            private final U PlaceComponentResult;

            RemoveFromBuffer(U u) {
                this.PlaceComponentResult = u;
            }

            @Override // java.lang.Runnable
            public final void run() {
                synchronized (BufferSkipBoundedSubscriber.this) {
                    BufferSkipBoundedSubscriber.this.getAuthRequestContext.remove(this.PlaceComponentResult);
                }
                BufferSkipBoundedSubscriber bufferSkipBoundedSubscriber = BufferSkipBoundedSubscriber.this;
                bufferSkipBoundedSubscriber.KClassImpl$Data$declaredNonStaticMembers$2((BufferSkipBoundedSubscriber) this.PlaceComponentResult, (Disposable) bufferSkipBoundedSubscriber.moveToNextValue);
            }
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda7, j);
            }
        }
    }

    /* loaded from: classes9.dex */
    static final class BufferExactBoundedSubscriber<T, U extends Collection<? super T>> extends QueueDrainSubscriber<T, U, U> implements Subscription, Runnable, Disposable {
        long BuiltInFictitiousFunctionClassFactory;
        U KClassImpl$Data$declaredNonStaticMembers$2;
        final Callable<U> MyBillsEntityDataFactory;
        final long NetworkUserEntityData$$ExternalSyntheticLambda0;
        long PlaceComponentResult;
        final int getAuthRequestContext;
        Subscription getErrorConfigVersion;
        final Scheduler.Worker initRecordTimeStamp;
        final boolean lookAheadTest;
        Disposable moveToNextValue;
        final TimeUnit scheduleImpl;

        @Override // io.reactivex.internal.subscribers.QueueDrainSubscriber, io.reactivex.internal.util.QueueDrain
        public final /* synthetic */ boolean PlaceComponentResult(Subscriber subscriber, Object obj) {
            return MyBillsEntityDataFactory(subscriber, (Collection) obj);
        }

        BufferExactBoundedSubscriber(Subscriber<? super U> subscriber, Callable<U> callable, long j, TimeUnit timeUnit, int i, boolean z, Scheduler.Worker worker) {
            super(subscriber, new MpscLinkedQueue());
            this.MyBillsEntityDataFactory = callable;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = j;
            this.scheduleImpl = timeUnit;
            this.getAuthRequestContext = i;
            this.lookAheadTest = z;
            this.initRecordTimeStamp = worker;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.getErrorConfigVersion, subscription)) {
                this.getErrorConfigVersion = subscription;
                try {
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = (U) ObjectHelper.PlaceComponentResult(this.MyBillsEntityDataFactory.call(), "The supplied buffer is null");
                    this.newProxyInstance.onSubscribe(this);
                    Scheduler.Worker worker = this.initRecordTimeStamp;
                    long j = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    this.moveToNextValue = worker.schedulePeriodically(this, j, j, this.scheduleImpl);
                    subscription.request(LongCompanionObject.MAX_VALUE);
                } catch (Throwable th) {
                    Exceptions.MyBillsEntityDataFactory(th);
                    this.initRecordTimeStamp.dispose();
                    subscription.cancel();
                    EmptySubscription.error(th, this.newProxyInstance);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            synchronized (this) {
                U u = this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (u == null) {
                    return;
                }
                u.add(t);
                if (u.size() < this.getAuthRequestContext) {
                    return;
                }
                this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
                this.PlaceComponentResult++;
                if (this.lookAheadTest) {
                    this.moveToNextValue.dispose();
                }
                KClassImpl$Data$declaredNonStaticMembers$2(u, this);
                try {
                    U u2 = (U) ObjectHelper.PlaceComponentResult(this.MyBillsEntityDataFactory.call(), "The supplied buffer is null");
                    synchronized (this) {
                        this.KClassImpl$Data$declaredNonStaticMembers$2 = u2;
                        this.BuiltInFictitiousFunctionClassFactory++;
                    }
                    if (this.lookAheadTest) {
                        Scheduler.Worker worker = this.initRecordTimeStamp;
                        long j = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                        this.moveToNextValue = worker.schedulePeriodically(this, j, j, this.scheduleImpl);
                    }
                } catch (Throwable th) {
                    Exceptions.MyBillsEntityDataFactory(th);
                    cancel();
                    this.newProxyInstance.onError(th);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            synchronized (this) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
            }
            this.newProxyInstance.onError(th);
            this.initRecordTimeStamp.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            U u;
            synchronized (this) {
                u = this.KClassImpl$Data$declaredNonStaticMembers$2;
                this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
            }
            if (u != null) {
                this.PrepareContext.offer(u);
                this.NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
                if (lookAheadTest()) {
                    QueueDrainHelper.KClassImpl$Data$declaredNonStaticMembers$2((SimplePlainQueue) this.PrepareContext, (Subscriber) this.newProxyInstance, false, (Disposable) this, (QueueDrain) this);
                }
                this.initRecordTimeStamp.dispose();
            }
        }

        private static boolean MyBillsEntityDataFactory(Subscriber<? super U> subscriber, U u) {
            subscriber.onNext(u);
            return true;
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            if (this.GetContactSyncConfig) {
                return;
            }
            this.GetContactSyncConfig = true;
            dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            synchronized (this) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
            }
            this.getErrorConfigVersion.cancel();
            this.initRecordTimeStamp.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.initRecordTimeStamp.isDisposed();
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                U u = (U) ObjectHelper.PlaceComponentResult(this.MyBillsEntityDataFactory.call(), "The supplied buffer is null");
                synchronized (this) {
                    U u2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (u2 != null && this.PlaceComponentResult == this.BuiltInFictitiousFunctionClassFactory) {
                        this.KClassImpl$Data$declaredNonStaticMembers$2 = u;
                        KClassImpl$Data$declaredNonStaticMembers$2(u2, this);
                    }
                }
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                cancel();
                this.newProxyInstance.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda7, j);
            }
        }
    }
}
