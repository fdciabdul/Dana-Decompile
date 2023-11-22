package id.dana.data.config.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.config.source.amcs.result.SplitBillConfigResult;
import id.dana.domain.featureconfig.model.SplitBillConfig;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class SplitBillConfigMapper extends BaseMapper<SplitBillConfigResult, SplitBillConfig> {
    @Inject
    public SplitBillConfigMapper() {
    }

    @Override // id.dana.data.base.BaseMapper
    public SplitBillConfig map(SplitBillConfigResult splitBillConfigResult) {
        return new SplitBillConfig(splitBillConfigResult.isFeatureEnable(), splitBillConfigResult.getMaxRecipient());
    }
}
