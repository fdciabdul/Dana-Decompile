package id.dana.domain.nearbyme.interactor;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/domain/nearbyme/interactor/ReviewableMerchantNotFound;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ReviewableMerchantNotFound extends Throwable {
    public ReviewableMerchantNotFound() {
        super("Reviewable merchant not found because merchant form with currentShopId has been dismissed or empty");
    }
}
