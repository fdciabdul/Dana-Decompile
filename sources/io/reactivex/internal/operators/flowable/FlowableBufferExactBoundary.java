package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.QueueDrain;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.subscribers.DisposableSubscriber;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.Collection;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class FlowableBufferExactBoundary<T, U extends Collection<? super T>, B> extends AbstractFlowableWithUpstream<T, U> {
    final Publisher<B> KClassImpl$Data$declaredNonStaticMembers$2;
    final Callable<U> MyBillsEntityDataFactory;

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super U> subscriber) {
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(new BufferExactBoundarySubscriber(new SerializedSubscriber(subscriber), this.MyBillsEntityDataFactory, this.KClassImpl$Data$declaredNonStaticMembers$2));
    }

    /* loaded from: classes9.dex */
    static final class BufferExactBoundarySubscriber<T, U extends Collection<? super T>, B> extends QueueDrainSubscriber<T, U, U> implements FlowableSubscriber<T>, Subscription, Disposable {
        U BuiltInFictitiousFunctionClassFactory;
        Subscription KClassImpl$Data$declaredNonStaticMembers$2;
        final Publisher<B> MyBillsEntityDataFactory;
        Disposable PlaceComponentResult;
        final Callable<U> getAuthRequestContext;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.internal.subscribers.QueueDrainSubscriber, io.reactivex.internal.util.QueueDrain
        public final /* synthetic */ boolean PlaceComponentResult(Subscriber subscriber, Object obj) {
            return getAuthRequestContext((Collection) obj);
        }

        BufferExactBoundarySubscriber(Subscriber<? super U> subscriber, Callable<U> callable, Publisher<B> publisher) {
            super(subscriber, new MpscLinkedQueue());
            this.getAuthRequestContext = callable;
            this.MyBillsEntityDataFactory = publisher;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.KClassImpl$Data$declaredNonStaticMembers$2, subscription)) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = subscription;
                try {
                    this.BuiltInFictitiousFunctionClassFactory = (U) ObjectHelper.PlaceComponentResult(this.getAuthRequestContext.call(), "The buffer supplied is null");
                    BufferBoundarySubscriber bufferBoundarySubscriber = new BufferBoundarySubscriber(this);
                    this.PlaceComponentResult = bufferBoundarySubscriber;
                    this.newProxyInstance.onSubscribe(this);
                    if (this.GetContactSyncConfig) {
                        return;
                    }
                    subscription.request(LongCompanionObject.MAX_VALUE);
                    this.MyBillsEntityDataFactory.subscribe(bufferBoundarySubscriber);
                } catch (Throwable th) {
                    Exceptions.MyBillsEntityDataFactory(th);
                    this.GetContactSyncConfig = true;
                    subscription.cancel();
                    EmptySubscription.error(th, this.newProxyInstance);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            synchronized (this) {
                U u = this.BuiltInFictitiousFunctionClassFactory;
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
                U u = this.BuiltInFictitiousFunctionClassFactory;
                if (u == null) {
                    return;
                }
                this.BuiltInFictitiousFunctionClassFactory = null;
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
            this.PlaceComponentResult.dispose();
            this.KClassImpl$Data$declaredNonStaticMembers$2.cancel();
            if (lookAheadTest()) {
                this.PrepareContext.clear();
            }
        }

        final void getAuthRequestContext() {
            try {
                U u = (U) ObjectHelper.PlaceComponentResult(this.getAuthRequestContext.call(), "The buffer supplied is null");
                synchronized (this) {
                    U u2 = this.BuiltInFictitiousFunctionClassFactory;
                    if (u2 == null) {
                        return;
                    }
                    this.BuiltInFictitiousFunctionClassFactory = u;
                    PlaceComponentResult((BufferExactBoundarySubscriber<T, U, B>) u2, (Disposable) this);
                }
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                cancel();
                this.newProxyInstance.onError(th);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            cancel();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.GetContactSyncConfig;
        }

        private boolean getAuthRequestContext(U u) {
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

    /* loaded from: classes9.dex */
    static final class BufferBoundarySubscriber<T, U extends Collection<? super T>, B> extends DisposableSubscriber<B> {
        final BufferExactBoundarySubscriber<T, U, B> getAuthRequestContext;

        BufferBoundarySubscriber(BufferExactBoundarySubscriber<T, U, B> bufferExactBoundarySubscriber) {
            this.getAuthRequestContext = bufferExactBoundarySubscriber;
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(B b) {
            this.getAuthRequestContext.getAuthRequestContext();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            this.getAuthRequestContext.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            this.getAuthRequestContext.onComplete();
        }
    }
}
