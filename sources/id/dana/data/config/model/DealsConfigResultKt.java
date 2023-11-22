package id.dana.data.config.model;

import id.dana.domain.featureconfig.model.DealsConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/config/model/DealsConfigResult;", "Lid/dana/domain/featureconfig/model/DealsConfig;", "toDealsConfig", "(Lid/dana/data/config/model/DealsConfigResult;)Lid/dana/domain/featureconfig/model/DealsConfig;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DealsConfigResultKt {
    public static final DealsConfig toDealsConfig(DealsConfigResult dealsConfigResult) {
        Intrinsics.checkNotNullParameter(dealsConfigResult, "");
        String danaDealsUrl = dealsConfigResult.getDanaDealsUrl();
        return new DealsConfig(danaDealsUrl != null ? danaDealsUrl : "");
    }
}
