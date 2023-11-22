package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.ResettableConnectable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class FlowableRefCount<T> extends Flowable<T> {
    RefConnection BuiltInFictitiousFunctionClassFactory;
    final ConnectableFlowable<T> KClassImpl$Data$declaredNonStaticMembers$2;
    final Scheduler MyBillsEntityDataFactory;
    final TimeUnit NetworkUserEntityData$$ExternalSyntheticLambda0;
    final int getAuthRequestContext;
    final long lookAheadTest;

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super T> subscriber) {
        RefConnection refConnection;
        boolean z;
        synchronized (this) {
            refConnection = this.BuiltInFictitiousFunctionClassFactory;
            if (refConnection == null) {
                refConnection = new RefConnection(this);
                this.BuiltInFictitiousFunctionClassFactory = refConnection;
            }
            long j = refConnection.subscriberCount;
            if (j == 0 && refConnection.timer != null) {
                refConnection.timer.dispose();
            }
            long j2 = j + 1;
            refConnection.subscriberCount = j2;
            z = true;
            if (refConnection.connected || j2 != this.getAuthRequestContext) {
                z = false;
            } else {
                refConnection.connected = true;
            }
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(new RefCountSubscriber(subscriber, this, refConnection));
        if (z) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(refConnection);
        }
    }

    final void MyBillsEntityDataFactory(RefConnection refConnection) {
        synchronized (this) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 instanceof FlowablePublishClassic) {
                RefConnection refConnection2 = this.BuiltInFictitiousFunctionClassFactory;
                if (refConnection2 != null && refConnection2 == refConnection) {
                    this.BuiltInFictitiousFunctionClassFactory = null;
                    if (refConnection.timer != null) {
                        refConnection.timer.dispose();
                        refConnection.timer = null;
                    }
                }
                long j = refConnection.subscriberCount - 1;
                refConnection.subscriberCount = j;
                if (j == 0) {
                    PlaceComponentResult(refConnection);
                }
            } else {
                RefConnection refConnection3 = this.BuiltInFictitiousFunctionClassFactory;
                if (refConnection3 != null && refConnection3 == refConnection) {
                    if (refConnection.timer != null) {
                        refConnection.timer.dispose();
                        refConnection.timer = null;
                    }
                    long j2 = refConnection.subscriberCount - 1;
                    refConnection.subscriberCount = j2;
                    if (j2 == 0) {
                        this.BuiltInFictitiousFunctionClassFactory = null;
                        PlaceComponentResult(refConnection);
                    }
                }
            }
        }
    }

    private void PlaceComponentResult(RefConnection refConnection) {
        ConnectableFlowable<T> connectableFlowable = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (connectableFlowable instanceof Disposable) {
            ((Disposable) connectableFlowable).dispose();
        } else if (connectableFlowable instanceof ResettableConnectable) {
            ((ResettableConnectable) connectableFlowable).MyBillsEntityDataFactory(refConnection.get());
        }
    }

    final void KClassImpl$Data$declaredNonStaticMembers$2(RefConnection refConnection) {
        synchronized (this) {
            if (refConnection.subscriberCount == 0 && refConnection == this.BuiltInFictitiousFunctionClassFactory) {
                this.BuiltInFictitiousFunctionClassFactory = null;
                Disposable disposable = refConnection.get();
                DisposableHelper.dispose(refConnection);
                ConnectableFlowable<T> connectableFlowable = this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (connectableFlowable instanceof Disposable) {
                    ((Disposable) connectableFlowable).dispose();
                } else if (connectableFlowable instanceof ResettableConnectable) {
                    if (disposable == null) {
                        refConnection.disconnectedEarly = true;
                    } else {
                        ((ResettableConnectable) connectableFlowable).MyBillsEntityDataFactory(disposable);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class RefConnection extends AtomicReference<Disposable> implements Runnable, Consumer<Disposable> {
        private static final long serialVersionUID = -4552101107598366241L;
        boolean connected;
        boolean disconnectedEarly;
        final FlowableRefCount<?> parent;
        long subscriberCount;
        Disposable timer;

        RefConnection(FlowableRefCount<?> flowableRefCount) {
            this.parent = flowableRefCount;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.parent.KClassImpl$Data$declaredNonStaticMembers$2(this);
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Disposable disposable) throws Exception {
            DisposableHelper.replace(this, disposable);
            synchronized (this.parent) {
                if (this.disconnectedEarly) {
                    ((ResettableConnectable) this.parent.KClassImpl$Data$declaredNonStaticMembers$2).MyBillsEntityDataFactory(disposable);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    static final class RefCountSubscriber<T> extends AtomicBoolean implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -7419642935409022375L;
        final RefConnection connection;
        final Subscriber<? super T> downstream;
        final FlowableRefCount<T> parent;
        Subscription upstream;

        RefCountSubscriber(Subscriber<? super T> subscriber, FlowableRefCount<T> flowableRefCount, RefConnection refConnection) {
            this.downstream = subscriber;
            this.parent = flowableRefCount;
            this.connection = refConnection;
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            if (compareAndSet(false, true)) {
                this.parent.MyBillsEntityDataFactory(this.connection);
                this.downstream.onError(th);
                return;
            }
            RxJavaPlugins.PlaceComponentResult(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            if (compareAndSet(false, true)) {
                this.parent.MyBillsEntityDataFactory(this.connection);
                this.downstream.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            this.upstream.request(j);
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.upstream.cancel();
            if (compareAndSet(false, true)) {
                FlowableRefCount<T> flowableRefCount = this.parent;
                RefConnection refConnection = this.connection;
                synchronized (flowableRefCount) {
                    RefConnection refConnection2 = flowableRefCount.BuiltInFictitiousFunctionClassFactory;
                    if (refConnection2 == null || refConnection2 != refConnection) {
                        return;
                    }
                    long j = refConnection.subscriberCount - 1;
                    refConnection.subscriberCount = j;
                    if (j == 0 && refConnection.connected) {
                        if (flowableRefCount.lookAheadTest == 0) {
                            flowableRefCount.KClassImpl$Data$declaredNonStaticMembers$2(refConnection);
                            return;
                        }
                        SequentialDisposable sequentialDisposable = new SequentialDisposable();
                        refConnection.timer = sequentialDisposable;
                        sequentialDisposable.replace(flowableRefCount.MyBillsEntityDataFactory.scheduleDirect(refConnection, flowableRefCount.lookAheadTest, flowableRefCount.NetworkUserEntityData$$ExternalSyntheticLambda0));
                    }
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
            }
        }
    }
}
