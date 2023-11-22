package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Notification;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class FlowableDematerialize<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final Function<? super T, ? extends Notification<R>> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super R> subscriber) {
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(new DematerializeSubscriber(subscriber, this.KClassImpl$Data$declaredNonStaticMembers$2));
    }

    /* loaded from: classes9.dex */
    static final class DematerializeSubscriber<T, R> implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super R> BuiltInFictitiousFunctionClassFactory;
        final Function<? super T, ? extends Notification<R>> KClassImpl$Data$declaredNonStaticMembers$2;
        boolean MyBillsEntityDataFactory;
        Subscription PlaceComponentResult;

        DematerializeSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends Notification<R>> function) {
            this.BuiltInFictitiousFunctionClassFactory = subscriber;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = function;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.PlaceComponentResult, subscription)) {
                this.PlaceComponentResult = subscription;
                this.BuiltInFictitiousFunctionClassFactory.onSubscribe(this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            Object obj = (Object) false;
            if (this.MyBillsEntityDataFactory) {
                if (t instanceof Notification) {
                    Notification notification = (Notification) t;
                    if (notification.PlaceComponentResult()) {
                        Object obj2 = notification.MyBillsEntityDataFactory;
                        Throwable th = obj;
                        if (NotificationLite.isError(obj2)) {
                            th = NotificationLite.getError(obj2);
                        }
                        RxJavaPlugins.PlaceComponentResult(th);
                        return;
                    }
                    return;
                }
                return;
            }
            try {
                Notification notification2 = (Notification) ObjectHelper.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.apply(t), "The selector returned a null Notification");
                if (notification2.PlaceComponentResult()) {
                    this.PlaceComponentResult.cancel();
                    Object obj3 = notification2.MyBillsEntityDataFactory;
                    Throwable th2 = obj;
                    if (NotificationLite.isError(obj3)) {
                        th2 = NotificationLite.getError(obj3);
                    }
                    onError(th2);
                } else if (notification2.KClassImpl$Data$declaredNonStaticMembers$2()) {
                    this.PlaceComponentResult.cancel();
                    onComplete();
                } else {
                    Subscriber<? super R> subscriber = this.BuiltInFictitiousFunctionClassFactory;
                    Object obj4 = notification2.MyBillsEntityDataFactory;
                    boolean z = obj;
                    if (obj4 != null) {
                        z = obj;
                        if (!NotificationLite.isError(obj4)) {
                            z = (Object) notification2.MyBillsEntityDataFactory;
                        }
                    }
                    subscriber.onNext((Object) z);
                }
            } catch (Throwable th3) {
                Exceptions.MyBillsEntityDataFactory(th3);
                this.PlaceComponentResult.cancel();
                onError(th3);
            }
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

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            this.PlaceComponentResult.request(j);
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.PlaceComponentResult.cancel();
        }
    }
}
