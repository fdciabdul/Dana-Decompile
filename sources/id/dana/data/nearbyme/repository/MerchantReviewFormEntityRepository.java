package id.dana.data.nearbyme.repository;

import id.dana.contract.deeplink.path.FeatureParams;
import id.dana.data.account.repository.source.preference.PreferenceAccountEntityData;
import id.dana.data.nearbyme.repository.source.local.PreferenceMerchantReviewFormEntityData;
import id.dana.domain.nearbyme.MerchantReviewFormRepository;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0006J\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0015\u001a\u00020\u00028CX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018"}, d2 = {"Lid/dana/data/nearbyme/repository/MerchantReviewFormEntityRepository;", "Lid/dana/domain/nearbyme/MerchantReviewFormRepository;", "", FeatureParams.SHOP_ID, "", "getDismissedMerchantReview", "(Ljava/lang/String;)Z", "", "getLastShownMerchantReviewShown", "()J", "saveDismissedMerchantReview", "lastTimeMerchantReviewShown", "saveLastTimeMerchantReviewShown", "(J)Z", "Lid/dana/data/nearbyme/repository/source/local/PreferenceMerchantReviewFormEntityData;", "merchantReviewEntityData", "Lid/dana/data/nearbyme/repository/source/local/PreferenceMerchantReviewFormEntityData;", "phoneNumber$delegate", "Lkotlin/Lazy;", "getPhoneNumber", "()Ljava/lang/String;", "phoneNumber", "Lid/dana/data/account/repository/source/preference/PreferenceAccountEntityData;", "preferenceAccountEntityData", "Lid/dana/data/account/repository/source/preference/PreferenceAccountEntityData;", "<init>", "(Lid/dana/data/nearbyme/repository/source/local/PreferenceMerchantReviewFormEntityData;Lid/dana/data/account/repository/source/preference/PreferenceAccountEntityData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MerchantReviewFormEntityRepository implements MerchantReviewFormRepository {
    private final PreferenceMerchantReviewFormEntityData merchantReviewEntityData;

    /* renamed from: phoneNumber$delegate  reason: from kotlin metadata */
    private final Lazy phoneNumber;
    private final PreferenceAccountEntityData preferenceAccountEntityData;

    @Inject
    public MerchantReviewFormEntityRepository(PreferenceMerchantReviewFormEntityData preferenceMerchantReviewFormEntityData, PreferenceAccountEntityData preferenceAccountEntityData) {
        Intrinsics.checkNotNullParameter(preferenceMerchantReviewFormEntityData, "");
        Intrinsics.checkNotNullParameter(preferenceAccountEntityData, "");
        this.merchantReviewEntityData = preferenceMerchantReviewFormEntityData;
        this.preferenceAccountEntityData = preferenceAccountEntityData;
        this.phoneNumber = LazyKt.lazy(new MerchantReviewFormEntityRepository$phoneNumber$2(this));
    }

    @JvmName(name = "getPhoneNumber")
    private final String getPhoneNumber() {
        Object value = this.phoneNumber.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "");
        return (String) value;
    }

    @Override // id.dana.domain.nearbyme.MerchantReviewFormRepository
    public final long getLastShownMerchantReviewShown() {
        return this.merchantReviewEntityData.getLastTimeMerchantReviewShown(getPhoneNumber());
    }

    @Override // id.dana.domain.nearbyme.MerchantReviewFormRepository
    public final boolean saveLastTimeMerchantReviewShown(long lastTimeMerchantReviewShown) {
        this.merchantReviewEntityData.saveLastTimeMerchantReviewShown(getPhoneNumber(), lastTimeMerchantReviewShown);
        return true;
    }

    @Override // id.dana.domain.nearbyme.MerchantReviewFormRepository
    public final boolean saveDismissedMerchantReview(String shopId) {
        Intrinsics.checkNotNullParameter(shopId, "");
        this.merchantReviewEntityData.setDismissedMerchantReview(shopId, getPhoneNumber(), true);
        return true;
    }

    @Override // id.dana.domain.nearbyme.MerchantReviewFormRepository
    public final boolean getDismissedMerchantReview(String shopId) {
        Intrinsics.checkNotNullParameter(shopId, "");
        return this.merchantReviewEntityData.getDismissedMerchantReview(shopId, getPhoneNumber());
    }
}
