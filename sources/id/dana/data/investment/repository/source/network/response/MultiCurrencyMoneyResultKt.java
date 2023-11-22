package id.dana.data.investment.repository.source.network.response;

import id.dana.domain.investment.model.MultiCurrencyMoneyView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/investment/repository/source/network/response/MultiCurrencyMoneyResult;", "Lid/dana/domain/investment/model/MultiCurrencyMoneyView;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/data/investment/repository/source/network/response/MultiCurrencyMoneyResult;)Lid/dana/domain/investment/model/MultiCurrencyMoneyView;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MultiCurrencyMoneyResultKt {
    public static final MultiCurrencyMoneyView KClassImpl$Data$declaredNonStaticMembers$2(MultiCurrencyMoneyResult multiCurrencyMoneyResult) {
        Intrinsics.checkNotNullParameter(multiCurrencyMoneyResult, "");
        return new MultiCurrencyMoneyView(multiCurrencyMoneyResult.getAmount(), multiCurrencyMoneyResult.getCent(), multiCurrencyMoneyResult.getCentFactor(), multiCurrencyMoneyResult.getCurrency(), multiCurrencyMoneyResult.getCurrencyCode(), multiCurrencyMoneyResult.getCurrencyValue());
    }
}
