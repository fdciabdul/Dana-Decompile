package id.dana.investment.model;

import id.dana.data.globalnetwork.constants.GlobalNetworkConstants;
import id.dana.domain.investment.model.MultiCurrencyMoneyView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/domain/investment/model/MultiCurrencyMoneyView;", "Lid/dana/investment/model/MultiCurrencyMoneyViewModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/domain/investment/model/MultiCurrencyMoneyView;)Lid/dana/investment/model/MultiCurrencyMoneyViewModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MultiCurrencyMoneyViewModelKt {
    public static final MultiCurrencyMoneyViewModel KClassImpl$Data$declaredNonStaticMembers$2(MultiCurrencyMoneyView multiCurrencyMoneyView) {
        Intrinsics.checkNotNullParameter(multiCurrencyMoneyView, "");
        Long amount = multiCurrencyMoneyView.getAmount();
        Long cent = multiCurrencyMoneyView.getCent();
        Long centFactor = multiCurrencyMoneyView.getCentFactor();
        String currency = multiCurrencyMoneyView.getCurrency();
        String currencyCode = multiCurrencyMoneyView.getCurrencyCode();
        if (currencyCode == null) {
            currencyCode = GlobalNetworkConstants.IDR_CURRENCY;
        }
        return new MultiCurrencyMoneyViewModel(amount, cent, centFactor, currency, currencyCode, multiCurrencyMoneyView.getCurrencyValue());
    }
}
