package id.dana.data.sendmoney.model;

import id.dana.domain.sendmoney.model.EWalletInnovConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/sendmoney/model/EWalletInnovConfigResult;", "Lid/dana/domain/sendmoney/model/EWalletInnovConfig;", "toEWalletInovConfig", "(Lid/dana/data/sendmoney/model/EWalletInnovConfigResult;)Lid/dana/domain/sendmoney/model/EWalletInnovConfig;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class EWalletInnovConfigResultKt {
    public static final EWalletInnovConfig toEWalletInovConfig(EWalletInnovConfigResult eWalletInnovConfigResult) {
        Intrinsics.checkNotNullParameter(eWalletInnovConfigResult, "");
        return new EWalletInnovConfig(eWalletInnovConfigResult.getClientId(), eWalletInnovConfigResult.getRedirectUrlDev(), eWalletInnovConfigResult.getRedirectUrlProd(), eWalletInnovConfigResult.getScopes(), eWalletInnovConfigResult.getAgreed(), "production");
    }
}
