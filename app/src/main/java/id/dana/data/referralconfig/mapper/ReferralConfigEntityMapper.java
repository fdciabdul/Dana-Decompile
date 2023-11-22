package id.dana.data.referralconfig.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.referralconfig.model.ReferralConfigEntity;
import id.dana.domain.referralconfig.model.ReferralConfig;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class ReferralConfigEntityMapper extends BaseMapper<ReferralConfigEntity, ReferralConfig> {
    @Inject
    public ReferralConfigEntityMapper() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public ReferralConfig map(ReferralConfigEntity referralConfigEntity) {
        ReferralConfig referralConfig = new ReferralConfig();
        if (referralConfigEntity != null) {
            referralConfig.setEnabled(referralConfigEntity.isEnable());
            referralConfig.setHowToUrl(referralConfigEntity.getHowToUrl());
            referralConfig.setTitle(referralConfigEntity.getTitle());
        }
        return referralConfig;
    }
}
