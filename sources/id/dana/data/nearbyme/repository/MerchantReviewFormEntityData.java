package id.dana.data.nearbyme.repository;

import id.dana.contract.deeplink.path.FeatureParams;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\bH&¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0005H&¢\u0006\u0004\b\u0010\u0010\u0011ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/nearbyme/repository/MerchantReviewFormEntityData;", "", "", FeatureParams.SHOP_ID, "phoneNumber", "", "getDismissedMerchantReview", "(Ljava/lang/String;Ljava/lang/String;)Z", "", "getLastTimeMerchantReviewShown", "(Ljava/lang/String;)J", "lastTimeMerchantReviewShown", "", "saveLastTimeMerchantReviewShown", "(Ljava/lang/String;J)V", "isDismissed", "setDismissedMerchantReview", "(Ljava/lang/String;Ljava/lang/String;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface MerchantReviewFormEntityData {
    boolean getDismissedMerchantReview(String shopId, String phoneNumber);

    long getLastTimeMerchantReviewShown(String phoneNumber);

    void saveLastTimeMerchantReviewShown(String phoneNumber, long lastTimeMerchantReviewShown);

    void setDismissedMerchantReview(String shopId, String phoneNumber, boolean isDismissed);
}
