package id.dana.data.referral.source.local;

import id.dana.data.referral.source.ReferralEngagementEntityData;
import id.dana.data.referral.source.local.model.ReferralDialogDailyLimitEntity;
import id.dana.utils.exception.CallableReturnNullError;
import io.reactivex.Observable;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/data/referral/source/local/LocalReferralEngagementEntityData;", "Lid/dana/data/referral/source/ReferralEngagementEntityData;", "Lio/reactivex/Observable;", "Lid/dana/data/referral/source/local/model/ReferralDialogDailyLimitEntity;", "getReferralDialogDailyLimitCache", "()Lio/reactivex/Observable;", "referralDialogDailyLimitEntity", "", "saveReferralDialogDailyLimit", "(Lid/dana/data/referral/source/local/model/ReferralDialogDailyLimitEntity;)Lio/reactivex/Observable;", "Lid/dana/data/referral/source/local/ReferralEngagementPreference;", "referralEngagementPreference", "Lid/dana/data/referral/source/local/ReferralEngagementPreference;", "<init>", "(Lid/dana/data/referral/source/local/ReferralEngagementPreference;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LocalReferralEngagementEntityData implements ReferralEngagementEntityData {
    private final ReferralEngagementPreference referralEngagementPreference;

    @Inject
    public LocalReferralEngagementEntityData(ReferralEngagementPreference referralEngagementPreference) {
        Intrinsics.checkNotNullParameter(referralEngagementPreference, "");
        this.referralEngagementPreference = referralEngagementPreference;
    }

    @Override // id.dana.data.referral.source.ReferralEngagementEntityData
    public final Observable<Boolean> saveReferralDialogDailyLimit(final ReferralDialogDailyLimitEntity referralDialogDailyLimitEntity) {
        Intrinsics.checkNotNullParameter(referralDialogDailyLimitEntity, "");
        Observable<Boolean> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.referral.source.local.LocalReferralEngagementEntityData$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Boolean m1783saveReferralDialogDailyLimit$lambda0;
                m1783saveReferralDialogDailyLimit$lambda0 = LocalReferralEngagementEntityData.m1783saveReferralDialogDailyLimit$lambda0(LocalReferralEngagementEntityData.this, referralDialogDailyLimitEntity);
                return m1783saveReferralDialogDailyLimit$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: saveReferralDialogDailyLimit$lambda-0  reason: not valid java name */
    public static final Boolean m1783saveReferralDialogDailyLimit$lambda0(LocalReferralEngagementEntityData localReferralEngagementEntityData, ReferralDialogDailyLimitEntity referralDialogDailyLimitEntity) {
        Intrinsics.checkNotNullParameter(localReferralEngagementEntityData, "");
        Intrinsics.checkNotNullParameter(referralDialogDailyLimitEntity, "");
        localReferralEngagementEntityData.referralEngagementPreference.saveDailyLimit(referralDialogDailyLimitEntity);
        return Boolean.TRUE;
    }

    @Override // id.dana.data.referral.source.ReferralEngagementEntityData
    public final Observable<ReferralDialogDailyLimitEntity> getReferralDialogDailyLimitCache() {
        Observable<ReferralDialogDailyLimitEntity> onErrorReturnItem = Observable.fromCallable(new Callable() { // from class: id.dana.data.referral.source.local.LocalReferralEngagementEntityData$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                ReferralDialogDailyLimitEntity m1782getReferralDialogDailyLimitCache$lambda1;
                m1782getReferralDialogDailyLimitCache$lambda1 = LocalReferralEngagementEntityData.m1782getReferralDialogDailyLimitCache$lambda1(LocalReferralEngagementEntityData.this);
                return m1782getReferralDialogDailyLimitCache$lambda1;
            }
        }).onErrorReturnItem(new ReferralDialogDailyLimitEntity(0L, 0, 3, null));
        Intrinsics.checkNotNullExpressionValue(onErrorReturnItem, "");
        return onErrorReturnItem;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getReferralDialogDailyLimitCache$lambda-1  reason: not valid java name */
    public static final ReferralDialogDailyLimitEntity m1782getReferralDialogDailyLimitCache$lambda1(LocalReferralEngagementEntityData localReferralEngagementEntityData) {
        Intrinsics.checkNotNullParameter(localReferralEngagementEntityData, "");
        ReferralDialogDailyLimitEntity dailyLimitCache = localReferralEngagementEntityData.referralEngagementPreference.getDailyLimitCache();
        if (dailyLimitCache != null) {
            return dailyLimitCache;
        }
        throw new CallableReturnNullError("LocalReferralEngagementEntityData#getReferralDialogDailyLimitCache");
    }
}
