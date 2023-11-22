package io.reactivex.internal.subscriptions;

import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class BooleanSubscription extends AtomicBoolean implements Subscription {
    private static final long serialVersionUID = -8127758972444290902L;

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        SubscriptionHelper.validate(j);
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        lazySet(true);
    }

    public final boolean isCancelled() {
        return get();
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BooleanSubscription(cancelled=");
        sb.append(get());
        sb.append(")");
        return sb.toString();
    }
}
