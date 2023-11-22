package id.dana.data.config.source.amcs.result;

import id.dana.domain.featureconfig.model.CashierPaymentAutorouteConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/config/source/amcs/result/CashierPaymentAutorouteConfigResult;", "Lid/dana/domain/featureconfig/model/CashierPaymentAutorouteConfig;", "toCashierPaymentAutorouteConfig", "(Lid/dana/data/config/source/amcs/result/CashierPaymentAutorouteConfigResult;)Lid/dana/domain/featureconfig/model/CashierPaymentAutorouteConfig;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierPaymentAutorouteConfigResultKt {
    public static final CashierPaymentAutorouteConfig toCashierPaymentAutorouteConfig(CashierPaymentAutorouteConfigResult cashierPaymentAutorouteConfigResult) {
        Intrinsics.checkNotNullParameter(cashierPaymentAutorouteConfigResult, "");
        return new CashierPaymentAutorouteConfig(cashierPaymentAutorouteConfigResult.getCooldownPeriod());
    }
}
