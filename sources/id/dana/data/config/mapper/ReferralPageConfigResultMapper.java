package id.dana.data.config.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.config.source.amcs.result.ReferralPageConfigResult;
import id.dana.domain.featureconfig.model.ReferralPageConfig;
import javax.inject.Inject;

/* loaded from: classes8.dex */
public class ReferralPageConfigResultMapper extends BaseMapper<ReferralPageConfigResult, ReferralPageConfig> {
    @Inject
    public ReferralPageConfigResultMapper() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public ReferralPageConfig map(ReferralPageConfigResult referralPageConfigResult) {
        return tranform(referralPageConfigResult);
    }

    private ReferralPageConfig tranform(ReferralPageConfigResult referralPageConfigResult) {
        if (referralPageConfigResult != null) {
            ReferralPageConfig referralPageConfig = new ReferralPageConfig();
            referralPageConfig.setReferralDescription(referralPageConfigResult.getReferralDescription());
            referralPageConfig.setReferralEmptyImageUrl(referralPageConfigResult.getReferralEmptyImageUrl());
            referralPageConfig.setReferralImageUrl(referralPageConfigResult.getReferralImageUrl());
            referralPageConfig.setReferralTncDescription(referralPageConfigResult.getReferralTncDescription());
            referralPageConfig.setReferralTncUrl(referralPageConfigResult.getReferralTncUrl());
            return referralPageConfig;
        }
        return null;
    }
}
