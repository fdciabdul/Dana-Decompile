package id.dana.domain.referral;

import id.dana.domain.referral.model.ReferralDialogLimitCache;
import io.reactivex.Observable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Lid/dana/domain/referral/ReferralEngagementDialogRepository;", "", "getDialogDailyLimitCache", "Lio/reactivex/Observable;", "Lid/dana/domain/referral/model/ReferralDialogLimitCache;", "saveDialogDailyLimit", "", "lastTimeShown", "", "dialogCount", "", "domain_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ReferralEngagementDialogRepository {
    Observable<ReferralDialogLimitCache> getDialogDailyLimitCache();

    Observable<Boolean> saveDialogDailyLimit(long lastTimeShown, int dialogCount);

    /* renamed from: id.dana.domain.referral.ReferralEngagementDialogRepository$-CC  reason: invalid class name */
    /* loaded from: classes4.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ Observable saveDialogDailyLimit$default(ReferralEngagementDialogRepository referralEngagementDialogRepository, long j, int i, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    i = 1;
                }
                return referralEngagementDialogRepository.saveDialogDailyLimit(j, i);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: saveDialogDailyLimit");
        }
    }
}
