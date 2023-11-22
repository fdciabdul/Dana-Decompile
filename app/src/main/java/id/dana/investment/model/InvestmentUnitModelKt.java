package id.dana.investment.model;

import id.dana.domain.investment.model.InvestmentUnitInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/domain/investment/model/InvestmentUnitInfo;", "Lid/dana/investment/model/InvestmentUnitModel;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/domain/investment/model/InvestmentUnitInfo;)Lid/dana/investment/model/InvestmentUnitModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InvestmentUnitModelKt {
    public static final InvestmentUnitModel BuiltInFictitiousFunctionClassFactory(InvestmentUnitInfo investmentUnitInfo) {
        Intrinsics.checkNotNullParameter(investmentUnitInfo, "");
        return new InvestmentUnitModel(investmentUnitInfo.getType(), investmentUnitInfo.getUnit(), investmentUnitInfo.getUnitValue());
    }
}
