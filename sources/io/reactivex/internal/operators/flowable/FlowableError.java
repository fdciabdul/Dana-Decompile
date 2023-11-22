package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;

/* loaded from: classes3.dex */
public final class FlowableError<T> extends Flowable<T> {
    final Callable<? extends Throwable> MyBillsEntityDataFactory;

    public FlowableError(Callable<? extends Throwable> callable) {
        this.MyBillsEntityDataFactory = callable;
    }

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super T> subscriber) {
        try {
            th = (Throwable) ObjectHelper.PlaceComponentResult(this.MyBillsEntityDataFactory.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th) {
            th = th;
            Exceptions.MyBillsEntityDataFactory(th);
        }
        EmptySubscription.error(th, subscriber);
    }
}
