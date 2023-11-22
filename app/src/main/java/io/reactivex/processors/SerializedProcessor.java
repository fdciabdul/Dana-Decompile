package io.reactivex.processors;

import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes6.dex */
public final class SerializedProcessor<T> extends FlowableProcessor<T> {
    volatile boolean BuiltInFictitiousFunctionClassFactory;
    boolean KClassImpl$Data$declaredNonStaticMembers$2;
    final FlowableProcessor<T> MyBillsEntityDataFactory;
    AppendOnlyLinkedArrayList<Object> getAuthRequestContext;

    public SerializedProcessor(FlowableProcessor<T> flowableProcessor) {
        this.MyBillsEntityDataFactory = flowableProcessor;
    }

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super T> subscriber) {
        this.MyBillsEntityDataFactory.subscribe(subscriber);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        boolean z = true;
        if (!this.BuiltInFictitiousFunctionClassFactory) {
            synchronized (this) {
                if (!this.BuiltInFictitiousFunctionClassFactory) {
                    if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.getAuthRequestContext;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>();
                            this.getAuthRequestContext = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.getAuthRequestContext(NotificationLite.subscription(subscription));
                        return;
                    }
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                    z = false;
                }
            }
        }
        if (z) {
            subscription.cancel();
            return;
        }
        this.MyBillsEntityDataFactory.onSubscribe(subscription);
        PlaceComponentResult();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(T t) {
        if (this.BuiltInFictitiousFunctionClassFactory) {
            return;
        }
        synchronized (this) {
            if (this.BuiltInFictitiousFunctionClassFactory) {
                return;
            }
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.getAuthRequestContext;
                if (appendOnlyLinkedArrayList == null) {
                    appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>();
                    this.getAuthRequestContext = appendOnlyLinkedArrayList;
                }
                appendOnlyLinkedArrayList.getAuthRequestContext(NotificationLite.next(t));
                return;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            this.MyBillsEntityDataFactory.onNext(t);
            PlaceComponentResult();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.BuiltInFictitiousFunctionClassFactory) {
            RxJavaPlugins.PlaceComponentResult(th);
            return;
        }
        synchronized (this) {
            boolean z = false;
            if (this.BuiltInFictitiousFunctionClassFactory) {
                z = true;
            } else {
                this.BuiltInFictitiousFunctionClassFactory = true;
                if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                    AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.getAuthRequestContext;
                    if (appendOnlyLinkedArrayList == null) {
                        appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>();
                        this.getAuthRequestContext = appendOnlyLinkedArrayList;
                    }
                    appendOnlyLinkedArrayList.PlaceComponentResult[0] = NotificationLite.error(th);
                    return;
                }
                this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            }
            if (z) {
                RxJavaPlugins.PlaceComponentResult(th);
            } else {
                this.MyBillsEntityDataFactory.onError(th);
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        if (this.BuiltInFictitiousFunctionClassFactory) {
            return;
        }
        synchronized (this) {
            if (this.BuiltInFictitiousFunctionClassFactory) {
                return;
            }
            this.BuiltInFictitiousFunctionClassFactory = true;
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.getAuthRequestContext;
                if (appendOnlyLinkedArrayList == null) {
                    appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>();
                    this.getAuthRequestContext = appendOnlyLinkedArrayList;
                }
                appendOnlyLinkedArrayList.getAuthRequestContext(NotificationLite.complete());
                return;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            this.MyBillsEntityDataFactory.onComplete();
        }
    }

    private void PlaceComponentResult() {
        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
        while (true) {
            synchronized (this) {
                appendOnlyLinkedArrayList = this.getAuthRequestContext;
                if (appendOnlyLinkedArrayList == null) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
                    return;
                }
                this.getAuthRequestContext = null;
            }
            appendOnlyLinkedArrayList.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory);
        }
    }
}
