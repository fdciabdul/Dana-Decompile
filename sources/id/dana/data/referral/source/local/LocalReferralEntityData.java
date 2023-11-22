package id.dana.data.referral.source.local;

import id.dana.data.referral.source.ReferralEntityData;
import id.dana.data.referral.source.local.model.ReferralEngagementDialogCacheEntity;
import id.dana.data.referral.source.network.result.ReferralConsultRpcResult;
import id.dana.data.referral.source.network.result.ReferralStatusConsultRpcResult;
import id.dana.data.referral.source.network.result.ReferralVerifyRpcResult;
import id.dana.riskChallenges.ui.missedCallOtp.PhoneStateReceiver;
import id.dana.utils.exception.CallableReturnNullError;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0005J#\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0005J)\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017"}, d2 = {"Lid/dana/data/referral/source/local/LocalReferralEntityData;", "Lid/dana/data/referral/source/ReferralEntityData;", "Lio/reactivex/Observable;", "Lid/dana/data/referral/source/network/result/ReferralConsultRpcResult;", "consult", "()Lio/reactivex/Observable;", "", "Lid/dana/data/referral/source/local/model/ReferralEngagementDialogCacheEntity;", "getDialogCaches", "referralEngagementDialogCacheEntity", "", "saveReferralEngagementDialogCache", "(Ljava/util/List;)Lio/reactivex/Observable;", "Lid/dana/data/referral/source/network/result/ReferralStatusConsultRpcResult;", "statusConsult", "", "referralCode", "cityName", "Lid/dana/data/referral/source/network/result/ReferralVerifyRpcResult;", PhoneStateReceiver.VERIFY, "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/data/referral/source/local/ReferralEngagementPreference;", "referralEngagementPreference", "Lid/dana/data/referral/source/local/ReferralEngagementPreference;", "<init>", "(Lid/dana/data/referral/source/local/ReferralEngagementPreference;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LocalReferralEntityData implements ReferralEntityData {
    private final ReferralEngagementPreference referralEngagementPreference;

    @Inject
    public LocalReferralEntityData(ReferralEngagementPreference referralEngagementPreference) {
        Intrinsics.checkNotNullParameter(referralEngagementPreference, "");
        this.referralEngagementPreference = referralEngagementPreference;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.referral.source.ReferralEntityData
    public final Observable<ReferralConsultRpcResult> consult() {
        ?? r1 = 0;
        throw new NotImplementedError(r1, 1, r1);
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.referral.source.ReferralEntityData
    public final Observable<ReferralVerifyRpcResult> verify(String referralCode, String cityName) {
        ?? r3 = 0;
        throw new NotImplementedError(r3, 1, r3);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.referral.source.ReferralEntityData
    public final Observable<ReferralStatusConsultRpcResult> statusConsult() {
        ?? r1 = 0;
        throw new NotImplementedError(r1, 1, r1);
    }

    @Override // id.dana.data.referral.source.ReferralEntityData
    public final Observable<Boolean> saveReferralEngagementDialogCache(final List<ReferralEngagementDialogCacheEntity> referralEngagementDialogCacheEntity) {
        Intrinsics.checkNotNullParameter(referralEngagementDialogCacheEntity, "");
        Observable<Boolean> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.referral.source.local.LocalReferralEntityData$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Boolean m1786saveReferralEngagementDialogCache$lambda0;
                m1786saveReferralEngagementDialogCache$lambda0 = LocalReferralEntityData.m1786saveReferralEngagementDialogCache$lambda0(LocalReferralEntityData.this, referralEngagementDialogCacheEntity);
                return m1786saveReferralEngagementDialogCache$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: saveReferralEngagementDialogCache$lambda-0  reason: not valid java name */
    public static final Boolean m1786saveReferralEngagementDialogCache$lambda0(LocalReferralEntityData localReferralEntityData, List list) {
        Intrinsics.checkNotNullParameter(localReferralEntityData, "");
        Intrinsics.checkNotNullParameter(list, "");
        localReferralEntityData.referralEngagementPreference.saveDialogCache(list);
        return Boolean.TRUE;
    }

    @Override // id.dana.data.referral.source.ReferralEntityData
    public final Observable<List<ReferralEngagementDialogCacheEntity>> getDialogCaches() {
        Observable<List<ReferralEngagementDialogCacheEntity>> onErrorReturnItem = Observable.fromCallable(new Callable() { // from class: id.dana.data.referral.source.local.LocalReferralEntityData$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                List m1785getDialogCaches$lambda1;
                m1785getDialogCaches$lambda1 = LocalReferralEntityData.m1785getDialogCaches$lambda1(LocalReferralEntityData.this);
                return m1785getDialogCaches$lambda1;
            }
        }).onErrorReturnItem(new ArrayList());
        Intrinsics.checkNotNullExpressionValue(onErrorReturnItem, "");
        return onErrorReturnItem;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getDialogCaches$lambda-1  reason: not valid java name */
    public static final List m1785getDialogCaches$lambda1(LocalReferralEntityData localReferralEntityData) {
        Intrinsics.checkNotNullParameter(localReferralEntityData, "");
        List<ReferralEngagementDialogCacheEntity> dialogCaches = localReferralEntityData.referralEngagementPreference.getDialogCaches();
        if (dialogCaches != null) {
            return dialogCaches;
        }
        throw new CallableReturnNullError("LocalReferralEntityData#getDialogCaches");
    }
}
