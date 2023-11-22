package id.dana.data.investment.repository.source.network.response;

import id.dana.domain.investment.model.InvestmentUnitInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/investment/repository/source/network/response/InvestmentUnitResult;", "Lid/dana/domain/investment/model/InvestmentUnitInfo;", "PlaceComponentResult", "(Lid/dana/data/investment/repository/source/network/response/InvestmentUnitResult;)Lid/dana/domain/investment/model/InvestmentUnitInfo;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class InvestmentUnitResultKt {
    public static final InvestmentUnitInfo PlaceComponentResult(InvestmentUnitResult investmentUnitResult) {
        Intrinsics.checkNotNullParameter(investmentUnitResult, "");
        return new InvestmentUnitInfo(investmentUnitResult.getType(), investmentUnitResult.getUnit(), investmentUnitResult.getUnitValue());
    }
}
