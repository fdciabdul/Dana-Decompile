package io.reactivex.parallel;

import io.reactivex.internal.subscriptions.EmptySubscription;
import org.reactivestreams.Subscriber;

/* loaded from: classes9.dex */
public abstract class ParallelFlowable<T> {
    public abstract int getAuthRequestContext();

    public abstract void getAuthRequestContext(Subscriber<? super T>[] subscriberArr);

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean MyBillsEntityDataFactory(Subscriber<?>[] subscriberArr) {
        int authRequestContext = getAuthRequestContext();
        if (subscriberArr.length != authRequestContext) {
            StringBuilder sb = new StringBuilder();
            sb.append("parallelism = ");
            sb.append(authRequestContext);
            sb.append(", subscribers = ");
            sb.append(subscriberArr.length);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(sb.toString());
            for (Subscriber<?> subscriber : subscriberArr) {
                EmptySubscription.error(illegalArgumentException, subscriber);
            }
            return false;
        }
        return true;
    }
}
