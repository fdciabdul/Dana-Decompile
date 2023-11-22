package id.dana.data.referral.source;

import id.dana.data.referral.source.local.model.ReferralEngagementDialogCacheEntity;
import id.dana.data.referral.source.network.result.ReferralConsultRpcResult;
import id.dana.data.referral.source.network.result.ReferralStatusConsultRpcResult;
import id.dana.data.referral.source.network.result.ReferralVerifyRpcResult;
import io.reactivex.Observable;
import java.util.List;

/* loaded from: classes2.dex */
public interface ReferralEntityData {
    Observable<ReferralConsultRpcResult> consult();

    Observable<List<ReferralEngagementDialogCacheEntity>> getDialogCaches();

    Observable<Boolean> saveReferralEngagementDialogCache(List<ReferralEngagementDialogCacheEntity> list);

    Observable<ReferralStatusConsultRpcResult> statusConsult();

    Observable<ReferralVerifyRpcResult> verify(String str, String str2);
}
