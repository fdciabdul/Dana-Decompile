package io.reactivex.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes6.dex */
public final class SerializedSubscriber<T> implements FlowableSubscriber<T>, Subscription {
    final Subscriber<? super T> BuiltInFictitiousFunctionClassFactory;
    AppendOnlyLinkedArrayList<Object> KClassImpl$Data$declaredNonStaticMembers$2;
    final boolean MyBillsEntityDataFactory;
    boolean PlaceComponentResult;
    volatile boolean getAuthRequestContext;
    Subscription getErrorConfigVersion;

    public SerializedSubscriber(Subscriber<? super T> subscriber) {
        this(subscriber, (byte) 0);
    }

    private SerializedSubscriber(Subscriber<? super T> subscriber, byte b) {
        this.BuiltInFictitiousFunctionClassFactory = subscriber;
        this.MyBillsEntityDataFactory = false;
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.getErrorConfigVersion, subscription)) {
            this.getErrorConfigVersion = subscription;
            this.BuiltInFictitiousFunctionClassFactory.onSubscribe(this);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(T t) {
        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
        if (this.getAuthRequestContext) {
            return;
        }
        if (t == null) {
            this.getErrorConfigVersion.cancel();
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        synchronized (this) {
            if (this.getAuthRequestContext) {
                return;
            }
            if (this.PlaceComponentResult) {
                AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (appendOnlyLinkedArrayList2 == null) {
                    appendOnlyLinkedArrayList2 = new AppendOnlyLinkedArrayList<>();
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = appendOnlyLinkedArrayList2;
                }
                appendOnlyLinkedArrayList2.getAuthRequestContext(NotificationLite.next(t));
                return;
            }
            this.PlaceComponentResult = true;
            this.BuiltInFictitiousFunctionClassFactory.onNext(t);
            do {
                synchronized (this) {
                    appendOnlyLinkedArrayList = this.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (appendOnlyLinkedArrayList == null) {
                        this.PlaceComponentResult = false;
                        return;
                    }
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
                }
            } while (!appendOnlyLinkedArrayList.BuiltInFictitiousFunctionClassFactory((Subscriber<? super T>) this.BuiltInFictitiousFunctionClassFactory));
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.getAuthRequestContext) {
            RxJavaPlugins.PlaceComponentResult(th);
            return;
        }
        synchronized (this) {
            boolean z = false;
            if (this.getAuthRequestContext) {
                z = true;
            } else if (this.PlaceComponentResult) {
                this.getAuthRequestContext = true;
                AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (appendOnlyLinkedArrayList == null) {
                    appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>();
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = appendOnlyLinkedArrayList;
                }
                Object error = NotificationLite.error(th);
                if (this.MyBillsEntityDataFactory) {
                    appendOnlyLinkedArrayList.getAuthRequestContext(error);
                } else {
                    appendOnlyLinkedArrayList.PlaceComponentResult[0] = error;
                }
                return;
            } else {
                this.getAuthRequestContext = true;
                this.PlaceComponentResult = true;
            }
            if (z) {
                RxJavaPlugins.PlaceComponentResult(th);
            } else {
                this.BuiltInFictitiousFunctionClassFactory.onError(th);
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        if (this.getAuthRequestContext) {
            return;
        }
        synchronized (this) {
            if (this.getAuthRequestContext) {
                return;
            }
            if (this.PlaceComponentResult) {
                AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (appendOnlyLinkedArrayList == null) {
                    appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>();
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = appendOnlyLinkedArrayList;
                }
                appendOnlyLinkedArrayList.getAuthRequestContext(NotificationLite.complete());
                return;
            }
            this.getAuthRequestContext = true;
            this.PlaceComponentResult = true;
            this.BuiltInFictitiousFunctionClassFactory.onComplete();
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        this.getErrorConfigVersion.request(j);
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        this.getErrorConfigVersion.cancel();
    }
}
