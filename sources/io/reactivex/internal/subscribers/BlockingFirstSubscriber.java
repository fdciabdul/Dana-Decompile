package io.reactivex.internal.subscribers;

import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes9.dex */
public final class BlockingFirstSubscriber<T> extends BlockingBaseSubscriber<T> {
    @Override // org.reactivestreams.Subscriber
    public final void onNext(T t) {
        if (this.PlaceComponentResult == null) {
            this.PlaceComponentResult = t;
            this.getAuthRequestContext.cancel();
            countDown();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.PlaceComponentResult == null) {
            this.MyBillsEntityDataFactory = th;
        } else {
            RxJavaPlugins.PlaceComponentResult(th);
        }
        countDown();
    }
}
