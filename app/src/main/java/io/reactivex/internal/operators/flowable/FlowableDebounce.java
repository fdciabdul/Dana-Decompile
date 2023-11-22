package io.reactivex.internal.operators.flowable;

import androidx.view.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subscribers.DisposableSubscriber;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class FlowableDebounce<T, U> extends AbstractFlowableWithUpstream<T, T> {
    final Function<? super T, ? extends Publisher<U>> getAuthRequestContext;

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super T> subscriber) {
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(new DebounceSubscriber(new SerializedSubscriber(subscriber), this.getAuthRequestContext));
    }

    /* loaded from: classes9.dex */
    static final class DebounceSubscriber<T, U> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 6725975399620862591L;
        final Function<? super T, ? extends Publisher<U>> debounceSelector;
        final AtomicReference<Disposable> debouncer = new AtomicReference<>();
        boolean done;
        final Subscriber<? super T> downstream;
        volatile long index;
        Subscription upstream;

        DebounceSubscriber(Subscriber<? super T> subscriber, Function<? super T, ? extends Publisher<U>> function) {
            this.downstream = subscriber;
            this.debounceSelector = function;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                subscription.request(LongCompanionObject.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (this.done) {
                return;
            }
            long j = this.index + 1;
            this.index = j;
            Disposable disposable = this.debouncer.get();
            if (disposable != null) {
                disposable.dispose();
            }
            try {
                Publisher publisher = (Publisher) ObjectHelper.PlaceComponentResult(this.debounceSelector.apply(t), "The publisher supplied is null");
                DebounceInnerSubscriber debounceInnerSubscriber = new DebounceInnerSubscriber(this, j, t);
                if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.debouncer, disposable, debounceInnerSubscriber)) {
                    publisher.subscribe(debounceInnerSubscriber);
                }
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                cancel();
                this.downstream.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            DisposableHelper.dispose(this.debouncer);
            this.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            Disposable disposable = this.debouncer.get();
            if (DisposableHelper.isDisposed(disposable)) {
                return;
            }
            DebounceInnerSubscriber debounceInnerSubscriber = (DebounceInnerSubscriber) disposable;
            if (debounceInnerSubscriber != null && debounceInnerSubscriber.KClassImpl$Data$declaredNonStaticMembers$2.compareAndSet(false, true)) {
                debounceInnerSubscriber.BuiltInFictitiousFunctionClassFactory.emit(debounceInnerSubscriber.MyBillsEntityDataFactory, debounceInnerSubscriber.PlaceComponentResult);
            }
            DisposableHelper.dispose(this.debouncer);
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.getAuthRequestContext(this, j);
            }
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.upstream.cancel();
            DisposableHelper.dispose(this.debouncer);
        }

        final void emit(long j, T t) {
            if (j == this.index) {
                if (get() != 0) {
                    this.downstream.onNext(t);
                    BackpressureHelper.PlaceComponentResult(this, 1L);
                    return;
                }
                cancel();
                this.downstream.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
            }
        }

        /* loaded from: classes9.dex */
        static final class DebounceInnerSubscriber<T, U> extends DisposableSubscriber<U> {
            final DebounceSubscriber<T, U> BuiltInFictitiousFunctionClassFactory;
            final AtomicBoolean KClassImpl$Data$declaredNonStaticMembers$2 = new AtomicBoolean();
            final long MyBillsEntityDataFactory;
            final T PlaceComponentResult;
            boolean getAuthRequestContext;

            DebounceInnerSubscriber(DebounceSubscriber<T, U> debounceSubscriber, long j, T t) {
                this.BuiltInFictitiousFunctionClassFactory = debounceSubscriber;
                this.MyBillsEntityDataFactory = j;
                this.PlaceComponentResult = t;
            }

            @Override // org.reactivestreams.Subscriber
            public final void onNext(U u) {
                if (this.getAuthRequestContext) {
                    return;
                }
                this.getAuthRequestContext = true;
                dispose();
                if (this.KClassImpl$Data$declaredNonStaticMembers$2.compareAndSet(false, true)) {
                    this.BuiltInFictitiousFunctionClassFactory.emit(this.MyBillsEntityDataFactory, this.PlaceComponentResult);
                }
            }

            @Override // org.reactivestreams.Subscriber
            public final void onError(Throwable th) {
                if (this.getAuthRequestContext) {
                    RxJavaPlugins.PlaceComponentResult(th);
                    return;
                }
                this.getAuthRequestContext = true;
                this.BuiltInFictitiousFunctionClassFactory.onError(th);
            }

            @Override // org.reactivestreams.Subscriber
            public final void onComplete() {
                if (this.getAuthRequestContext) {
                    return;
                }
                this.getAuthRequestContext = true;
                if (this.KClassImpl$Data$declaredNonStaticMembers$2.compareAndSet(false, true)) {
                    this.BuiltInFictitiousFunctionClassFactory.emit(this.MyBillsEntityDataFactory, this.PlaceComponentResult);
                }
            }
        }
    }
}
