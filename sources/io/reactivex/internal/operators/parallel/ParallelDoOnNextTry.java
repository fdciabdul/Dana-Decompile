package io.reactivex.internal.operators.parallel;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFailureHandling;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class ParallelDoOnNextTry<T> extends ParallelFlowable<T> {
    final Consumer<? super T> KClassImpl$Data$declaredNonStaticMembers$2;
    final ParallelFlowable<T> MyBillsEntityDataFactory;
    final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> PlaceComponentResult;

    @Override // io.reactivex.parallel.ParallelFlowable
    public final void getAuthRequestContext(Subscriber<? super T>[] subscriberArr) {
        if (MyBillsEntityDataFactory(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber<? super T>[] subscriberArr2 = new Subscriber[length];
            for (int i = 0; i < length; i++) {
                Subscriber<? super T> subscriber = subscriberArr[i];
                if (subscriber instanceof ConditionalSubscriber) {
                    subscriberArr2[i] = new ParallelDoOnNextConditionalSubscriber((ConditionalSubscriber) subscriber, this.KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult);
                } else {
                    subscriberArr2[i] = new ParallelDoOnNextSubscriber(subscriber, this.KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult);
                }
            }
            this.MyBillsEntityDataFactory.getAuthRequestContext(subscriberArr2);
        }
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public final int getAuthRequestContext() {
        return this.MyBillsEntityDataFactory.getAuthRequestContext();
    }

    /* loaded from: classes9.dex */
    static final class ParallelDoOnNextSubscriber<T> implements ConditionalSubscriber<T>, Subscription {
        Subscription BuiltInFictitiousFunctionClassFactory;
        final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> KClassImpl$Data$declaredNonStaticMembers$2;
        boolean MyBillsEntityDataFactory;
        final Consumer<? super T> PlaceComponentResult;
        final Subscriber<? super T> getAuthRequestContext;

        ParallelDoOnNextSubscriber(Subscriber<? super T> subscriber, Consumer<? super T> consumer, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
            this.getAuthRequestContext = subscriber;
            this.PlaceComponentResult = consumer;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = biFunction;
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            this.BuiltInFictitiousFunctionClassFactory.request(j);
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.BuiltInFictitiousFunctionClassFactory.cancel();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.BuiltInFictitiousFunctionClassFactory, subscription)) {
                this.BuiltInFictitiousFunctionClassFactory = subscription;
                this.getAuthRequestContext.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (tryOnNext(t)) {
                return;
            }
            this.BuiltInFictitiousFunctionClassFactory.request(1L);
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public final boolean tryOnNext(T t) {
            int i;
            if (this.MyBillsEntityDataFactory) {
                return false;
            }
            long j = 0;
            do {
                try {
                    this.PlaceComponentResult.accept(t);
                    this.getAuthRequestContext.onNext(t);
                    return true;
                } catch (Throwable th) {
                    Exceptions.MyBillsEntityDataFactory(th);
                    try {
                        j++;
                        i = AnonymousClass1.BuiltInFictitiousFunctionClassFactory[((ParallelFailureHandling) ObjectHelper.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.apply(Long.valueOf(j), th), "The errorHandler returned a null item")).ordinal()];
                    } catch (Throwable th2) {
                        Exceptions.MyBillsEntityDataFactory(th2);
                        cancel();
                        onError(new CompositeException(th, th2));
                        return false;
                    }
                }
            } while (i == 1);
            if (i != 2) {
                if (i == 3) {
                    cancel();
                    onComplete();
                } else {
                    cancel();
                    onError(th);
                    return false;
                }
            }
            return false;
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            if (this.MyBillsEntityDataFactory) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            this.MyBillsEntityDataFactory = true;
            this.getAuthRequestContext.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            if (this.MyBillsEntityDataFactory) {
                return;
            }
            this.MyBillsEntityDataFactory = true;
            this.getAuthRequestContext.onComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.reactivex.internal.operators.parallel.ParallelDoOnNextTry$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] BuiltInFictitiousFunctionClassFactory;

        static {
            int[] iArr = new int[ParallelFailureHandling.values().length];
            BuiltInFictitiousFunctionClassFactory = iArr;
            try {
                iArr[ParallelFailureHandling.RETRY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[ParallelFailureHandling.SKIP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[ParallelFailureHandling.STOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes9.dex */
    static final class ParallelDoOnNextConditionalSubscriber<T> implements ConditionalSubscriber<T>, Subscription {
        final ConditionalSubscriber<? super T> BuiltInFictitiousFunctionClassFactory;
        Subscription KClassImpl$Data$declaredNonStaticMembers$2;
        boolean MyBillsEntityDataFactory;
        final Consumer<? super T> PlaceComponentResult;
        final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> getAuthRequestContext;

        ParallelDoOnNextConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Consumer<? super T> consumer, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
            this.BuiltInFictitiousFunctionClassFactory = conditionalSubscriber;
            this.PlaceComponentResult = consumer;
            this.getAuthRequestContext = biFunction;
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.request(j);
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.KClassImpl$Data$declaredNonStaticMembers$2.cancel();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.KClassImpl$Data$declaredNonStaticMembers$2, subscription)) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = subscription;
                this.BuiltInFictitiousFunctionClassFactory.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (tryOnNext(t) || this.MyBillsEntityDataFactory) {
                return;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.request(1L);
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public final boolean tryOnNext(T t) {
            int i;
            if (this.MyBillsEntityDataFactory) {
                return false;
            }
            long j = 0;
            do {
                try {
                    this.PlaceComponentResult.accept(t);
                    return this.BuiltInFictitiousFunctionClassFactory.tryOnNext(t);
                } catch (Throwable th) {
                    Exceptions.MyBillsEntityDataFactory(th);
                    try {
                        j++;
                        i = AnonymousClass1.BuiltInFictitiousFunctionClassFactory[((ParallelFailureHandling) ObjectHelper.PlaceComponentResult(this.getAuthRequestContext.apply(Long.valueOf(j), th), "The errorHandler returned a null item")).ordinal()];
                    } catch (Throwable th2) {
                        Exceptions.MyBillsEntityDataFactory(th2);
                        cancel();
                        onError(new CompositeException(th, th2));
                        return false;
                    }
                }
            } while (i == 1);
            if (i != 2) {
                if (i == 3) {
                    cancel();
                    onComplete();
                } else {
                    cancel();
                    onError(th);
                    return false;
                }
            }
            return false;
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            if (this.MyBillsEntityDataFactory) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            this.MyBillsEntityDataFactory = true;
            this.BuiltInFictitiousFunctionClassFactory.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            if (this.MyBillsEntityDataFactory) {
                return;
            }
            this.MyBillsEntityDataFactory = true;
            this.BuiltInFictitiousFunctionClassFactory.onComplete();
        }
    }
}
