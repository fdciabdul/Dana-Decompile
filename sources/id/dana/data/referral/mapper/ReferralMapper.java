package id.dana.data.referral.mapper;

import id.dana.data.BaseMapper;
import id.dana.data.model.CurrencyAmountResult;
import id.dana.data.referral.source.local.model.ReferralEngagementDialogCacheEntity;
import id.dana.data.referral.source.network.result.ReferralConsultRpcResult;
import id.dana.data.referral.source.network.result.ReferralStatusConsultRpcResult;
import id.dana.data.referral.source.network.result.ReferralVerifyRpcResult;
import id.dana.domain.referral.model.ReferralConsultResponse;
import id.dana.domain.referral.model.ReferralEngagementDialogCache;
import id.dana.domain.referral.model.ReferralStatusConsultResponse;
import id.dana.domain.referral.model.VerifyReferralCodeResponse;
import id.dana.domain.user.CurrencyAmount;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class ReferralMapper {
    @Inject
    public ReferralMapper() {
    }

    public ReferralConsultResponse transform(ReferralConsultRpcResult referralConsultRpcResult) {
        if (referralConsultRpcResult != null) {
            ReferralConsultResponse referralConsultResponse = new ReferralConsultResponse(referralConsultRpcResult.enabled, transform(referralConsultRpcResult.prizeAmount), referralConsultRpcResult.referralCode);
            BaseMapper.transform(referralConsultResponse, referralConsultRpcResult);
            return referralConsultResponse;
        }
        return null;
    }

    private CurrencyAmount transform(CurrencyAmountResult currencyAmountResult) {
        if (currencyAmountResult != null) {
            return new CurrencyAmount(currencyAmountResult.getAmount(), currencyAmountResult.getCurrency());
        }
        return null;
    }

    public VerifyReferralCodeResponse transform(ReferralVerifyRpcResult referralVerifyRpcResult) {
        VerifyReferralCodeResponse verifyReferralCodeResponse = new VerifyReferralCodeResponse();
        verifyReferralCodeResponse.setValid(referralVerifyRpcResult.valid);
        BaseMapper.transform(verifyReferralCodeResponse, referralVerifyRpcResult);
        return verifyReferralCodeResponse;
    }

    public ReferralStatusConsultResponse transform(ReferralStatusConsultRpcResult referralStatusConsultRpcResult) {
        if (referralStatusConsultRpcResult != null) {
            ReferralStatusConsultResponse referralStatusConsultResponse = new ReferralStatusConsultResponse();
            referralStatusConsultResponse.setReferredNextTask(referralStatusConsultRpcResult.referredNextTask);
            referralStatusConsultResponse.setNextTaskRedirectUrl(referralStatusConsultRpcResult.urlNextTask);
            BaseMapper.transform(referralStatusConsultResponse, referralStatusConsultRpcResult);
            return referralStatusConsultResponse;
        }
        return null;
    }

    public List<ReferralEngagementDialogCache> transform(List<ReferralEngagementDialogCacheEntity> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<ReferralEngagementDialogCacheEntity> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toReferralEngagementDialogCache());
        }
        return arrayList;
    }

    public List<ReferralEngagementDialogCacheEntity> toDialogCacheEntities(List<ReferralEngagementDialogCache> list) {
        ArrayList arrayList = new ArrayList();
        for (ReferralEngagementDialogCache referralEngagementDialogCache : list) {
            arrayList.add(new ReferralEngagementDialogCacheEntity(referralEngagementDialogCache.getScenario(), referralEngagementDialogCache.getShowHomeReferralPopup(), referralEngagementDialogCache.getShowPopUpTimerSeed()));
        }
        return arrayList;
    }
}
