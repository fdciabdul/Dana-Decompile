package io.reactivex.disposables;

import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
final class SubscriptionDisposable extends ReferenceDisposable<Subscription> {
    private static final long serialVersionUID = -707001650852963139L;

    SubscriptionDisposable(Subscription subscription) {
        super(subscription);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.reactivex.disposables.ReferenceDisposable
    public final void onDisposed(Subscription subscription) {
        subscription.cancel();
    }
}
