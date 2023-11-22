package id.dana.data.config.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.config.source.amcs.result.PromoCenterConfigResult;
import id.dana.domain.featureconfig.model.PromoCenterConfig;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class PromoCenterConfigMapper extends BaseMapper<PromoCenterConfigResult, PromoCenterConfig> {
    @Inject
    public PromoCenterConfigMapper() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public PromoCenterConfig map(PromoCenterConfigResult promoCenterConfigResult) {
        if (promoCenterConfigResult != null) {
            PromoCenterConfig promoCenterConfig = new PromoCenterConfig();
            promoCenterConfig.isFeatureEnable = promoCenterConfigResult.isEnable;
            promoCenterConfig.title = promoCenterConfigResult.title;
            promoCenterConfig.description = promoCenterConfigResult.description;
            promoCenterConfig.buttonIconUrl = promoCenterConfigResult.buttonIconUrl;
            promoCenterConfig.buttonTitle = promoCenterConfigResult.buttonTitle;
            promoCenterConfig.isRedirectNative = promoCenterConfigResult.isRedirectNative;
            promoCenterConfig.redirectUrl = promoCenterConfigResult.redirectUrl;
            return promoCenterConfig;
        }
        return null;
    }
}
