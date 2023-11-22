package id.dana.mybills.domain.model;

import id.dana.mybills.data.model.response.ProviderRuleResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/mybills/data/model/response/ProviderRuleResult;", "Lid/dana/mybills/domain/model/ProviderRuleInfo;", "toProviderRuleInfo", "(Lid/dana/mybills/data/model/response/ProviderRuleResult;)Lid/dana/mybills/domain/model/ProviderRuleInfo;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ProviderRuleInfoKt {
    public static final ProviderRuleInfo toProviderRuleInfo(ProviderRuleResult providerRuleResult) {
        Intrinsics.checkNotNullParameter(providerRuleResult, "");
        return new ProviderRuleInfo(providerRuleResult.getProviderId(), providerRuleResult.getPattern());
    }
}
