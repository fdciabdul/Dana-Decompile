package io.reactivex.internal.subscribers;

/* loaded from: classes9.dex */
public final class BlockingLastSubscriber<T> extends BlockingBaseSubscriber<T> {
    @Override // org.reactivestreams.Subscriber
    public final void onNext(T t) {
        this.PlaceComponentResult = t;
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        this.PlaceComponentResult = null;
        this.MyBillsEntityDataFactory = th;
        countDown();
    }
}
