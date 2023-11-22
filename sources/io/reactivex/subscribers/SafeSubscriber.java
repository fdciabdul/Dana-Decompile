package io.reactivex.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class SafeSubscriber<T> implements FlowableSubscriber<T>, Subscription {
    final Subscriber<? super T> BuiltInFictitiousFunctionClassFactory;
    boolean MyBillsEntityDataFactory;
    Subscription getAuthRequestContext;

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.getAuthRequestContext, subscription)) {
            this.getAuthRequestContext = subscription;
            try {
                this.BuiltInFictitiousFunctionClassFactory.onSubscribe(this);
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                this.MyBillsEntityDataFactory = true;
                try {
                    subscription.cancel();
                    RxJavaPlugins.PlaceComponentResult(th);
                } catch (Throwable th2) {
                    Exceptions.MyBillsEntityDataFactory(th2);
                    RxJavaPlugins.PlaceComponentResult(new CompositeException(th, th2));
                }
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(T t) {
        if (this.MyBillsEntityDataFactory) {
            return;
        }
        if (this.getAuthRequestContext == null) {
            this.MyBillsEntityDataFactory = true;
            NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
            try {
                this.BuiltInFictitiousFunctionClassFactory.onSubscribe(EmptySubscription.INSTANCE);
                try {
                    this.BuiltInFictitiousFunctionClassFactory.onError(nullPointerException);
                } catch (Throwable th) {
                    Exceptions.MyBillsEntityDataFactory(th);
                    RxJavaPlugins.PlaceComponentResult(new CompositeException(nullPointerException, th));
                }
            } catch (Throwable th2) {
                Exceptions.MyBillsEntityDataFactory(th2);
                RxJavaPlugins.PlaceComponentResult(new CompositeException(nullPointerException, th2));
            }
        } else if (t == null) {
            NullPointerException nullPointerException2 = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            try {
                this.getAuthRequestContext.cancel();
                onError(nullPointerException2);
            } catch (Throwable th3) {
                Exceptions.MyBillsEntityDataFactory(th3);
                onError(new CompositeException(nullPointerException2, th3));
            }
        } else {
            try {
                this.BuiltInFictitiousFunctionClassFactory.onNext(t);
            } catch (Throwable th4) {
                Exceptions.MyBillsEntityDataFactory(th4);
                try {
                    this.getAuthRequestContext.cancel();
                    onError(th4);
                } catch (Throwable th5) {
                    Exceptions.MyBillsEntityDataFactory(th5);
                    onError(new CompositeException(th4, th5));
                }
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.MyBillsEntityDataFactory) {
            RxJavaPlugins.PlaceComponentResult(th);
            return;
        }
        this.MyBillsEntityDataFactory = true;
        if (this.getAuthRequestContext == null) {
            NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
            try {
                this.BuiltInFictitiousFunctionClassFactory.onSubscribe(EmptySubscription.INSTANCE);
                try {
                    this.BuiltInFictitiousFunctionClassFactory.onError(new CompositeException(th, nullPointerException));
                    return;
                } catch (Throwable th2) {
                    Exceptions.MyBillsEntityDataFactory(th2);
                    RxJavaPlugins.PlaceComponentResult(new CompositeException(th, nullPointerException, th2));
                    return;
                }
            } catch (Throwable th3) {
                Exceptions.MyBillsEntityDataFactory(th3);
                RxJavaPlugins.PlaceComponentResult(new CompositeException(th, nullPointerException, th3));
                return;
            }
        }
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        try {
            this.BuiltInFictitiousFunctionClassFactory.onError(th);
        } catch (Throwable th4) {
            Exceptions.MyBillsEntityDataFactory(th4);
            RxJavaPlugins.PlaceComponentResult(new CompositeException(th, th4));
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        if (this.MyBillsEntityDataFactory) {
            return;
        }
        this.MyBillsEntityDataFactory = true;
        if (this.getAuthRequestContext != null) {
            try {
                this.BuiltInFictitiousFunctionClassFactory.onComplete();
                return;
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
        }
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.BuiltInFictitiousFunctionClassFactory.onSubscribe(EmptySubscription.INSTANCE);
            try {
                this.BuiltInFictitiousFunctionClassFactory.onError(nullPointerException);
            } catch (Throwable th2) {
                Exceptions.MyBillsEntityDataFactory(th2);
                RxJavaPlugins.PlaceComponentResult(new CompositeException(nullPointerException, th2));
            }
        } catch (Throwable th3) {
            Exceptions.MyBillsEntityDataFactory(th3);
            RxJavaPlugins.PlaceComponentResult(new CompositeException(nullPointerException, th3));
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        try {
            this.getAuthRequestContext.request(j);
        } catch (Throwable th) {
            Exceptions.MyBillsEntityDataFactory(th);
            try {
                this.getAuthRequestContext.cancel();
                RxJavaPlugins.PlaceComponentResult(th);
            } catch (Throwable th2) {
                Exceptions.MyBillsEntityDataFactory(th2);
                RxJavaPlugins.PlaceComponentResult(new CompositeException(th, th2));
            }
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        try {
            this.getAuthRequestContext.cancel();
        } catch (Throwable th) {
            Exceptions.MyBillsEntityDataFactory(th);
            RxJavaPlugins.PlaceComponentResult(th);
        }
    }
}
