package id.dana.data.referral.source;

import id.dana.data.referral.source.local.model.ReferralDialogDailyLimitEntity;
import io.reactivex.Observable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\u0006\u0010\u0006\u001a\u00020\u0003H&¢\u0006\u0004\b\b\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/referral/source/ReferralEngagementEntityData;", "", "Lio/reactivex/Observable;", "Lid/dana/data/referral/source/local/model/ReferralDialogDailyLimitEntity;", "getReferralDialogDailyLimitCache", "()Lio/reactivex/Observable;", "referralDialogDailyLimitEntity", "", "saveReferralDialogDailyLimit", "(Lid/dana/data/referral/source/local/model/ReferralDialogDailyLimitEntity;)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ReferralEngagementEntityData {
    Observable<ReferralDialogDailyLimitEntity> getReferralDialogDailyLimitCache();

    Observable<Boolean> saveReferralDialogDailyLimit(ReferralDialogDailyLimitEntity referralDialogDailyLimitEntity);
}
