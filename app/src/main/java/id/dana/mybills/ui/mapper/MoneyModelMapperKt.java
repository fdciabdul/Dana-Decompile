package id.dana.mybills.ui.mapper;

import id.dana.core.ui.model.CurrencyAmountModel;
import id.dana.domain.user.CurrencyAmount;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/domain/user/CurrencyAmount;", "Lid/dana/core/ui/model/CurrencyAmountModel;", "MyBillsEntityDataFactory", "(Lid/dana/domain/user/CurrencyAmount;)Lid/dana/core/ui/model/CurrencyAmountModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MoneyModelMapperKt {
    public static final CurrencyAmountModel MyBillsEntityDataFactory(CurrencyAmount currencyAmount) {
        Intrinsics.checkNotNullParameter(currencyAmount, "");
        String currency = currencyAmount.getCurrency();
        String amount = currencyAmount.getAmount();
        boolean isPlaceholder = currencyAmount.isPlaceholder();
        Intrinsics.checkNotNullExpressionValue(amount, "");
        Intrinsics.checkNotNullExpressionValue(currency, "");
        return new CurrencyAmountModel(amount, currency, isPlaceholder);
    }
}
