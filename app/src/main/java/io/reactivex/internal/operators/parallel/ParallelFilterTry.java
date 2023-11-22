package io.reactivex.internal.operators.parallel;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFailureHandling;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class ParallelFilterTry<T> extends ParallelFlowable<T> {
    final Predicate<? super T> KClassImpl$Data$declaredNonStaticMembers$2;
    final ParallelFlowable<T> PlaceComponentResult;
    final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> getAuthRequestContext;

    @Override // io.reactivex.parallel.ParallelFlowable
    public final void getAuthRequestContext(Subscriber<? super T>[] subscriberArr) {
        if (MyBillsEntityDataFactory(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber<? super T>[] subscriberArr2 = new Subscriber[length];
            for (int i = 0; i < length; i++) {
                Subscriber<? super T> subscriber = subscriberArr[i];
                if (subscriber instanceof ConditionalSubscriber) {
                    subscriberArr2[i] = new ParallelFilterConditionalSubscriber((ConditionalSubscriber) subscriber, this.KClassImpl$Data$declaredNonStaticMembers$2, this.getAuthRequestContext);
                } else {
                    subscriberArr2[i] = new ParallelFilterSubscriber(subscriber, this.KClassImpl$Data$declaredNonStaticMembers$2, this.getAuthRequestContext);
                }
            }
            this.PlaceComponentResult.getAuthRequestContext(subscriberArr2);
        }
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public final int getAuthRequestContext() {
        return this.PlaceComponentResult.getAuthRequestContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static abstract class BaseFilterSubscriber<T> implements ConditionalSubscriber<T>, Subscription {
        final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> KClassImpl$Data$declaredNonStaticMembers$2;
        final Predicate<? super T> MyBillsEntityDataFactory;
        boolean PlaceComponentResult;
        Subscription getAuthRequestContext;

        BaseFilterSubscriber(Predicate<? super T> predicate, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
            this.MyBillsEntityDataFactory = predicate;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = biFunction;
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            this.getAuthRequestContext.request(j);
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.getAuthRequestContext.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (tryOnNext(t) || this.PlaceComponentResult) {
                return;
            }
            this.getAuthRequestContext.request(1L);
        }
    }

    /* loaded from: classes9.dex */
    static final class ParallelFilterSubscriber<T> extends BaseFilterSubscriber<T> {
        final Subscriber<? super T> BuiltInFictitiousFunctionClassFactory;

        ParallelFilterSubscriber(Subscriber<? super T> subscriber, Predicate<? super T> predicate, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
            super(predicate, biFunction);
            this.BuiltInFictitiousFunctionClassFactory = subscriber;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.getAuthRequestContext, subscription)) {
                this.getAuthRequestContext = subscription;
                this.BuiltInFictitiousFunctionClassFactory.onSubscribe(this);
            }
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public final boolean tryOnNext(T t) {
            int i;
            if (!this.PlaceComponentResult) {
                long j = 0;
                do {
                    try {
                        if (this.MyBillsEntityDataFactory.test(t)) {
                            this.BuiltInFictitiousFunctionClassFactory.onNext(t);
                            return true;
                        }
                        return false;
                    } catch (Throwable th) {
                        Exceptions.MyBillsEntityDataFactory(th);
                        try {
                            j++;
                            i = AnonymousClass1.MyBillsEntityDataFactory[((ParallelFailureHandling) ObjectHelper.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.apply(Long.valueOf(j), th), "The errorHandler returned a null item")).ordinal()];
                        } catch (Throwable th2) {
                            Exceptions.MyBillsEntityDataFactory(th2);
                            cancel();
                            onError(new CompositeException(th, th2));
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
            return false;
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            if (this.PlaceComponentResult) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            this.PlaceComponentResult = true;
            this.BuiltInFictitiousFunctionClassFactory.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            if (this.PlaceComponentResult) {
                return;
            }
            this.PlaceComponentResult = true;
            this.BuiltInFictitiousFunctionClassFactory.onComplete();
        }
    }

    /* renamed from: io.reactivex.internal.operators.parallel.ParallelFilterTry$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] MyBillsEntityDataFactory;

        static {
            int[] iArr = new int[ParallelFailureHandling.values().length];
            MyBillsEntityDataFactory = iArr;
            try {
                iArr[ParallelFailureHandling.RETRY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                MyBillsEntityDataFactory[ParallelFailureHandling.SKIP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                MyBillsEntityDataFactory[ParallelFailureHandling.STOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes9.dex */
    static final class ParallelFilterConditionalSubscriber<T> extends BaseFilterSubscriber<T> {
        final ConditionalSubscriber<? super T> BuiltInFictitiousFunctionClassFactory;

        ParallelFilterConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Predicate<? super T> predicate, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
            super(predicate, biFunction);
            this.BuiltInFictitiousFunctionClassFactory = conditionalSubscriber;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.getAuthRequestContext, subscription)) {
                this.getAuthRequestContext = subscription;
                this.BuiltInFictitiousFunctionClassFactory.onSubscribe(this);
            }
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public final boolean tryOnNext(T t) {
            int i;
            if (!this.PlaceComponentResult) {
                long j = 0;
                do {
                    try {
                        return this.MyBillsEntityDataFactory.test(t) && this.BuiltInFictitiousFunctionClassFactory.tryOnNext(t);
                    } catch (Throwable th) {
                        Exceptions.MyBillsEntityDataFactory(th);
                        try {
                            j++;
                            i = AnonymousClass1.MyBillsEntityDataFactory[((ParallelFailureHandling) ObjectHelper.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.apply(Long.valueOf(j), th), "The errorHandler returned a null item")).ordinal()];
                        } catch (Throwable th2) {
                            Exceptions.MyBillsEntityDataFactory(th2);
                            cancel();
                            onError(new CompositeException(th, th2));
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
            return false;
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            if (this.PlaceComponentResult) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            this.PlaceComponentResult = true;
            this.BuiltInFictitiousFunctionClassFactory.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            if (this.PlaceComponentResult) {
                return;
            }
            this.PlaceComponentResult = true;
            this.BuiltInFictitiousFunctionClassFactory.onComplete();
        }
    }
}
