package io.reactivex.internal.operators.parallel;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFailureHandling;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class ParallelMapTry<T, R> extends ParallelFlowable<R> {
    final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> KClassImpl$Data$declaredNonStaticMembers$2;
    final ParallelFlowable<T> MyBillsEntityDataFactory;
    final Function<? super T, ? extends R> getAuthRequestContext;

    @Override // io.reactivex.parallel.ParallelFlowable
    public final void getAuthRequestContext(Subscriber<? super R>[] subscriberArr) {
        if (MyBillsEntityDataFactory(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber<? super T>[] subscriberArr2 = new Subscriber[length];
            for (int i = 0; i < length; i++) {
                Subscriber<? super R> subscriber = subscriberArr[i];
                if (subscriber instanceof ConditionalSubscriber) {
                    subscriberArr2[i] = new ParallelMapTryConditionalSubscriber((ConditionalSubscriber) subscriber, this.getAuthRequestContext, this.KClassImpl$Data$declaredNonStaticMembers$2);
                } else {
                    subscriberArr2[i] = new ParallelMapTrySubscriber(subscriber, this.getAuthRequestContext, this.KClassImpl$Data$declaredNonStaticMembers$2);
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
    static final class ParallelMapTrySubscriber<T, R> implements ConditionalSubscriber<T>, Subscription {
        Subscription BuiltInFictitiousFunctionClassFactory;
        final Subscriber<? super R> KClassImpl$Data$declaredNonStaticMembers$2;
        final Function<? super T, ? extends R> MyBillsEntityDataFactory;
        final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> PlaceComponentResult;
        boolean getAuthRequestContext;

        ParallelMapTrySubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends R> function, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = subscriber;
            this.MyBillsEntityDataFactory = function;
            this.PlaceComponentResult = biFunction;
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
                this.KClassImpl$Data$declaredNonStaticMembers$2.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (tryOnNext(t) || this.getAuthRequestContext) {
                return;
            }
            this.BuiltInFictitiousFunctionClassFactory.request(1L);
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public final boolean tryOnNext(T t) {
            int i;
            if (this.getAuthRequestContext) {
                return false;
            }
            long j = 0;
            do {
                try {
                    this.KClassImpl$Data$declaredNonStaticMembers$2.onNext(ObjectHelper.PlaceComponentResult(this.MyBillsEntityDataFactory.apply(t), "The mapper returned a null value"));
                    return true;
                } catch (Throwable th) {
                    Exceptions.MyBillsEntityDataFactory(th);
                    try {
                        j++;
                        i = AnonymousClass1.PlaceComponentResult[((ParallelFailureHandling) ObjectHelper.PlaceComponentResult(this.PlaceComponentResult.apply(Long.valueOf(j), th), "The errorHandler returned a null item")).ordinal()];
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
            if (this.getAuthRequestContext) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            this.getAuthRequestContext = true;
            this.KClassImpl$Data$declaredNonStaticMembers$2.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            if (this.getAuthRequestContext) {
                return;
            }
            this.getAuthRequestContext = true;
            this.KClassImpl$Data$declaredNonStaticMembers$2.onComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.reactivex.internal.operators.parallel.ParallelMapTry$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] PlaceComponentResult;

        static {
            int[] iArr = new int[ParallelFailureHandling.values().length];
            PlaceComponentResult = iArr;
            try {
                iArr[ParallelFailureHandling.RETRY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                PlaceComponentResult[ParallelFailureHandling.SKIP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                PlaceComponentResult[ParallelFailureHandling.STOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes9.dex */
    static final class ParallelMapTryConditionalSubscriber<T, R> implements ConditionalSubscriber<T>, Subscription {
        final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> BuiltInFictitiousFunctionClassFactory;
        boolean KClassImpl$Data$declaredNonStaticMembers$2;
        final Function<? super T, ? extends R> MyBillsEntityDataFactory;
        final ConditionalSubscriber<? super R> PlaceComponentResult;
        Subscription getAuthRequestContext;

        ParallelMapTryConditionalSubscriber(ConditionalSubscriber<? super R> conditionalSubscriber, Function<? super T, ? extends R> function, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
            this.PlaceComponentResult = conditionalSubscriber;
            this.MyBillsEntityDataFactory = function;
            this.BuiltInFictitiousFunctionClassFactory = biFunction;
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            this.getAuthRequestContext.request(j);
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.getAuthRequestContext.cancel();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.getAuthRequestContext, subscription)) {
                this.getAuthRequestContext = subscription;
                this.PlaceComponentResult.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (tryOnNext(t) || this.KClassImpl$Data$declaredNonStaticMembers$2) {
                return;
            }
            this.getAuthRequestContext.request(1L);
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public final boolean tryOnNext(T t) {
            int i;
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                return false;
            }
            long j = 0;
            do {
                try {
                    return this.PlaceComponentResult.tryOnNext(ObjectHelper.PlaceComponentResult(this.MyBillsEntityDataFactory.apply(t), "The mapper returned a null value"));
                } catch (Throwable th) {
                    Exceptions.MyBillsEntityDataFactory(th);
                    try {
                        j++;
                        i = AnonymousClass1.PlaceComponentResult[((ParallelFailureHandling) ObjectHelper.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.apply(Long.valueOf(j), th), "The errorHandler returned a null item")).ordinal()];
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
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            this.PlaceComponentResult.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                return;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            this.PlaceComponentResult.onComplete();
        }
    }
}
