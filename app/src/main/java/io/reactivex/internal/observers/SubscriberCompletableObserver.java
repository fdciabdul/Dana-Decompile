package io.reactivex.internal.observers;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class SubscriberCompletableObserver<T> implements CompletableObserver, Subscription {
    final Subscriber<? super T> KClassImpl$Data$declaredNonStaticMembers$2;
    Disposable getAuthRequestContext;

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
    }

    public SubscriberCompletableObserver(Subscriber<? super T> subscriber) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = subscriber;
    }

    @Override // io.reactivex.CompletableObserver
    public final void onComplete() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.onComplete();
    }

    @Override // io.reactivex.CompletableObserver
    public final void onError(Throwable th) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.onError(th);
    }

    @Override // io.reactivex.CompletableObserver
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.getAuthRequestContext, disposable)) {
            this.getAuthRequestContext = disposable;
            this.KClassImpl$Data$declaredNonStaticMembers$2.onSubscribe(this);
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        this.getAuthRequestContext.dispose();
    }
}
