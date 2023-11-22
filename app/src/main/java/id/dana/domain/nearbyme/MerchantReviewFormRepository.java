package id.dana.domain.nearbyme;

import id.dana.contract.deeplink.path.FeatureParams;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u0006J\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0007H&¢\u0006\u0004\b\f\u0010\rø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/domain/nearbyme/MerchantReviewFormRepository;", "", "", FeatureParams.SHOP_ID, "", "getDismissedMerchantReview", "(Ljava/lang/String;)Z", "", "getLastShownMerchantReviewShown", "()J", "saveDismissedMerchantReview", "lastTimeMerchantReviewShown", "saveLastTimeMerchantReviewShown", "(J)Z"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface MerchantReviewFormRepository {
    boolean getDismissedMerchantReview(String shopId);

    long getLastShownMerchantReviewShown();

    boolean saveDismissedMerchantReview(String shopId);

    boolean saveLastTimeMerchantReviewShown(long lastTimeMerchantReviewShown);
}
