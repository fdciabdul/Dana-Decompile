package id.dana.data.referral;

import id.dana.data.referral.mapper.ReferralEngagementMapperKt;
import id.dana.data.referral.source.ReferralEngagementEntityData;
import id.dana.data.referral.source.ReferralEngagementEntityDataFactory;
import id.dana.data.referral.source.local.model.ReferralDialogDailyLimitEntity;
import id.dana.domain.referral.ReferralEngagementDialogRepository;
import id.dana.domain.referral.model.ReferralDialogLimitCache;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/data/referral/ReferralEngagementEntityRepository;", "Lid/dana/domain/referral/ReferralEngagementDialogRepository;", "Lid/dana/data/referral/source/ReferralEngagementEntityData;", "createLocalReferralData", "()Lid/dana/data/referral/source/ReferralEngagementEntityData;", "Lio/reactivex/Observable;", "Lid/dana/domain/referral/model/ReferralDialogLimitCache;", "getDialogDailyLimitCache", "()Lio/reactivex/Observable;", "", "lastTimeShown", "", "dialogCount", "", "saveDialogDailyLimit", "(JI)Lio/reactivex/Observable;", "Lid/dana/data/referral/source/ReferralEngagementEntityDataFactory;", "referralEngagementEntityDataFactory", "Lid/dana/data/referral/source/ReferralEngagementEntityDataFactory;", "<init>", "(Lid/dana/data/referral/source/ReferralEngagementEntityDataFactory;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ReferralEngagementEntityRepository implements ReferralEngagementDialogRepository {
    private final ReferralEngagementEntityDataFactory referralEngagementEntityDataFactory;

    @Inject
    public ReferralEngagementEntityRepository(ReferralEngagementEntityDataFactory referralEngagementEntityDataFactory) {
        Intrinsics.checkNotNullParameter(referralEngagementEntityDataFactory, "");
        this.referralEngagementEntityDataFactory = referralEngagementEntityDataFactory;
    }

    @Override // id.dana.domain.referral.ReferralEngagementDialogRepository
    public final Observable<Boolean> saveDialogDailyLimit(long lastTimeShown, int dialogCount) {
        return createLocalReferralData().saveReferralDialogDailyLimit(new ReferralDialogDailyLimitEntity(lastTimeShown, dialogCount));
    }

    @Override // id.dana.domain.referral.ReferralEngagementDialogRepository
    public final Observable<ReferralDialogLimitCache> getDialogDailyLimitCache() {
        Observable map = createLocalReferralData().getReferralDialogDailyLimitCache().map(new Function() { // from class: id.dana.data.referral.ReferralEngagementEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ReferralEngagementMapperKt.toReferralDialogLimitCache((ReferralDialogDailyLimitEntity) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    private final ReferralEngagementEntityData createLocalReferralData() {
        return this.referralEngagementEntityDataFactory.createData2("local");
    }
}
